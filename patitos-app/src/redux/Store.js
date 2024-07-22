import { configureStore } from "@reduxjs/toolkit";

import PedidoReducer from './slices/PedidosSlice'

export const Store = configureStore({
    reducer:{
        "Pedidos": PedidoReducer
    }
})