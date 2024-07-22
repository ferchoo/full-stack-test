import React, { useEffect, useState } from "react";
import Table from "react-bootstrap/Table";
import { useDispatch, useSelector } from "react-redux";
import { addPedidos } from "../redux/slices/PedidosSlice";
import Modal from "react-bootstrap/Modal";

import DetallesPedido from "./DetallesPedido";

const TablePedido = () => {
  const [show, setShow] = useState(false);
  const [detallePedido, setDetallePedido] = useState(null);
  const handleClose = () => {
    setShow(false);
  };

  const handleShow = (pedido) => {
    setShow(true);
    setDetallePedido(pedido);
  };

  const updateDetallePedidoStatus = (newStatus)=>{
    
    setDetallePedido({...detallePedido,statusPedido:newStatus});
  }

  const dispatch = useDispatch();
  const pedidos = useSelector((state) => state.Pedidos);

  useEffect(() => {
    fetch("http://localhost:8080/pedidos")
      .then((res) => res.json())
      .then((results) => {
        console.log(results);
        dispatch(addPedidos(results));
      });
  }, []);

  return (
    <div>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>#</th>
            <th>Fecha</th>
            <th>Tienda</th>
            <th>Vendedor</th>
            <th>Cliente</th>
            <th>Status</th>
            <th>Acción</th>
          </tr>
        </thead>
        <tbody>
          {pedidos && pedidos.length > 0 ? (
            pedidos.map((pedido) => (
              <tr key={pedido.id}>
                <td>{pedido.id}</td>
                <td>{pedido.fechaCreacion}</td>
                <td>{pedido.tienda.nombre}</td>
                <td>{pedido.vendedor.nombre}</td>
                <td>{pedido.cliente.nombre}</td>
                <td>
                  {pedido.statusPedido === 0
                    ? "pendiente"
                    : pedido.statusPedido === 1
                    ? "entregado"
                    : pedido.statusPedido === 2
                    ? "cancelado"
                    : "---Status no reconocido---"}
                </td>
                <td>
                  <button onClick={() => handleShow(pedido)}>Detalle</button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td>No hay pedidos</td>
            </tr>
          )}
        </tbody>
      </Table>

      <Modal show={show} onHide={handleClose}>
        {detallePedido != null && (
         <DetallesPedido detallePedido={detallePedido} updateDetallePedidoStatus={updateDetallePedidoStatus} ></DetallesPedido>
        )}
      </Modal>
    </div>
  );
};

export default TablePedido;
