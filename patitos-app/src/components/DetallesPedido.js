import React, {useEffect} from "react";
import Modal from "react-bootstrap/Modal";
import Button from "react-bootstrap/Button";
import Accordion from 'react-bootstrap/Accordion';
import { useDispatch } from "react-redux";
import { updateStatusPedido } from "../redux/slices/PedidosSlice";
const DetallesPedido = ({detallePedido,updateDetallePedidoStatus}) => {

    const dispatch = useDispatch();

    const handleStatus = async (newStatus) => {

            fetch('http://localhost:8080/pedidos/status/'+detallePedido.id,{
                headers:{
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                method: 'post',
                body: JSON.stringify({statusPedido: newStatus})
            }).then((res) => res.json())
            .then((results) => {
                console.log(results);
                if(results.id){
                    dispatch(updateStatusPedido({id:results.id,statusPedido:results.statusPedido}));
                    updateDetallePedidoStatus(results.statusPedido);
                }
              }).catch(()=>alert("Algo paso...?"));
      };
    
      
   
  return (
    <div>
      <Modal.Header closeButton>
        <Modal.Title>Pedido {detallePedido.id}</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <div>
          <p>Fecha: {detallePedido.fechaCreacion}</p>
          <p>
            Status:{" "}
            {detallePedido.statusPedido === 0
              ? "pendiente"
              : detallePedido.statusPedido === 1
              ? "entregado"
              : detallePedido.statusPedido === 2
              ? "cancelado"
              : "---Status no reconocido---"}
          </p>

          <p>Tienda: {detallePedido.tienda.nombre} </p>
          <p>
            Vendedor: {detallePedido.vendedor.nombre}{" "}
            {detallePedido.vendedor.apellido}{" "}
          </p>
          <p>
            Cliente: {detallePedido.cliente.nombre}{" "}
            {detallePedido.cliente.apellido}{" "}
          </p>
          <p>IP Cliente: {detallePedido.ipCliente} </p>

          <Accordion defaultActiveKey="0">
            <Accordion.Item eventKey="1">
              <Accordion.Header>Productos</Accordion.Header>
              <Accordion.Body>
                {detallePedido.productosPedido.length > 0
                  ? detallePedido.productosPedido.map((producto) => (
                      <p key={producto.producto.id}>
                        Cantidad: {producto.cantidad} -- Hawa:{" "}
                        {producto.producto.hawa} -- Precio Unitario: $
                        {producto.producto.precio}
                      </p>
                    ))
                  : "No hay productos en el pedido"}
              </Accordion.Body>
            </Accordion.Item>
          </Accordion>
        </div>
      </Modal.Body>
      <Modal.Footer>
        { detallePedido.statusPedido === 0 &&
        <Button variant="primary" onClick={()=>handleStatus(1)}>
          Cambiar status a Entregado
        </Button>
        }
        <Button variant="danger" onClick={()=>handleStatus(2)} >
          Cancelar Pedido
        </Button>
      </Modal.Footer>
    </div>
  );
};

export default DetallesPedido;
