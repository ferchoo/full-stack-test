import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Routes, Route, Link} from 'react-router-dom'
import PedidoPage from './pages/PedidoPage';
import NuevoPedidoPage from './pages/NuevoPedidoPage';

function App() {
  return (
    <div className="App">
    <Router>
        {/* <nav>
          <ul>
            <li>
              <Link to="/">Pedidos</Link>
            </li>
            <li>
              <Link to="/nuevoPedido">Nuevo Pedido</Link>
            </li>
          </ul>

        </nav> */}
        <Routes>

          <Route path="/" element={<PedidoPage/>}></Route>
          <Route path="/nuevoPedido" element={<NuevoPedidoPage/>}></Route>
        </Routes>

      </Router>

    </div>
  );
}

export default App;
