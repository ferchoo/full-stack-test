import {createSlice} from "@reduxjs/toolkit"
 const PedidosSlice  =createSlice({
    name: "Pedidos",
    initialState:[],
    reducers:{
        addPedidos:(state,action) => {
            state=[...action.payload]
            return state
        },
        updateStatusPedido:(state,action)=>{
            state.map(pedido=>{
                if(pedido.id===action.payload.id){
                    pedido.statusPedido = action.payload.statusPedido
                }
            })
        },
        addPedido:(state,action)=>{
            state.push({...action.payload});
        }
    }
 })

 export const {addPedidos,updateStatusPedido,addPedido} = PedidosSlice.actions
 export default PedidosSlice.reducer