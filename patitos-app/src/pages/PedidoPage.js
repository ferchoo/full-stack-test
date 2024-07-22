import React,{useState} from 'react'

import {BrowserRouter as Router, Routes, Route, Link} from 'react-router-dom'
import TablePedido from '../components/TablePedido';

const PedidoPage = () => {


 
  return (
    <div>
    <div>
        <h1>Pedidos</h1>
    </div>
    <div>
    <Link to="/nuevoPedido">Nuevo Pedido</Link>
    <TablePedido></TablePedido>
    
     
    
    </div>
   
    </div>
  )
}

export default PedidoPage