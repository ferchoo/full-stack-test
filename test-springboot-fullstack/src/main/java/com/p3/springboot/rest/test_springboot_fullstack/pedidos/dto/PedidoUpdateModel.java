package com.p3.springboot.rest.test_springboot_fullstack.pedidos.dto;


import java.util.List;

import com.p3.springboot.rest.test_springboot_fullstack.productospedido.entity.ProductoPedido;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class PedidoUpdateModel {
	
	
	@NotNull
	private Byte statusPedido;
	
	

	public PedidoUpdateModel(@NotNull Byte statusPedido) {
		super();
		this.statusPedido = statusPedido;
	}
	
	

	public PedidoUpdateModel() {
		super();
	}



	public Byte getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(Byte statusPedido) {
		this.statusPedido = statusPedido;
	}



	@Override
	public String toString() {
		return "PedidoUpdateModel [statusPedido=" + statusPedido + "]";
	}	
	
	
	
	
	
}
