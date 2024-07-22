import React, {useEffect,useState} from "react";
import Button from "react-bootstrap/Button";
import Form from 'react-bootstrap/Form';
import ListGroup from 'react-bootstrap/ListGroup';
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

const NuevoPedidoPage = () => {

  const [productos, setProductos] = useState([]);
  const [vendedores, setVendedores] = useState([]);
  const [tiendas, setTiendas] = useState([]);

  const handleSubmit = (event)=>{
    event.preventDefault();
    const form = event.currentTarget;

    const data = new FormData(event.target);
    const val = Object.fromEntries(data.entries());
    console.log({val});

  }

  useEffect(() => {
    fetch("http://localhost:8080/products")
      .then((res) => res.json())
      .then((results) => {
        setProductos(results);
        console.log(results);
        
      });
  }, []);

  useEffect(() => {
    fetch("http://localhost:8080/vendedores")
      .then((res) => res.json())
      .then((results) => {
        setVendedores(results);
        console.log(results);
        
      });
  }, []);

  useEffect(() => {
    fetch("http://localhost:8080/tiendas")
      .then((res) => res.json())
      .then((results) => {
        setTiendas(results);
        console.log(results);
        
      });
  }, []);


  return (
    <div>
      <div>
        <h1>Nuevo Pedido</h1>
      </div>
      <div>
        <Link to="/">Ver pedidos</Link>

        <Form onSubmit={handleSubmit}>
          <Form.Label>Vendedor</Form.Label>
          <Form.Select id='vendedorSelect' name="vendedorSelect"aria-label="Default select example">
          {
              vendedores.length>0 &&
              vendedores.map((vendedor)=>(
                <option value={vendedor.id} key={vendedor.id}>{vendedor.nombre}</option>
              ))
            }
          </Form.Select>

          <Form.Label>Tienda</Form.Label>
          <Form.Select id='tiendaSelect' name="tiendaSelect" aria-label="Default select example">
            {
              tiendas.length>0 &&
              tiendas.map((tienda)=>(
                <option value={tienda.id} key={tienda.id}>{tienda.nombre}</option>
              ))
            }
            
          </Form.Select>

          <Form.Label>Productos</Form.Label>
          <ListGroup as="ul" >
            {productos.length>0 &&
              productos.map((producto)=>(

                <ListGroup.Item key={producto.id} as="li">
                  Hawa: {producto.hawa} 
                  --- Precio: ${producto.precio}
                   --- Descuento: {producto.descuento}%
                   --- Stock: {producto.stock}
                   </ListGroup.Item>
              ))
              
             
            }
        
    </ListGroup>
    <Button type="submit">Submit form</Button>
        </Form>
      </div>
    </div>
  );
};

export default NuevoPedidoPage;
