package com.p3.springboot.rest.test_springboot_fullstack.pedidos.dto;


import java.util.List;

import com.p3.springboot.rest.test_springboot_fullstack.productospedido.entity.ProductoPedido;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class PedidoPostModel {
	
	
	@NotEmpty
	private String ipCliente;
	
	@NotNull
	private Integer idTienda;

	@NotNull
	private Integer idCliente;
	
	@NotNull
	private Integer idVendedor;
	
	private List<ProductoPedido> productosPedido;
	
	

	public PedidoPostModel(@NotEmpty String ipCliente, @NotNull Integer idTienda, @NotNull Integer idCliente,
			@NotNull Integer idVendedor, List<ProductoPedido> productosPedido) {
		super();
		this.ipCliente = ipCliente;
		this.idTienda = idTienda;
		this.idCliente = idCliente;
		this.idVendedor = idVendedor;
		this.productosPedido = productosPedido;
	}
	
	

	public PedidoPostModel() {
		super();
	}



	public String getIpCliente() {
		return ipCliente;
	}

	public void setIpCliente(String ipCliente) {
		this.ipCliente = ipCliente;
	}

	public Integer getIdTienda() {
		return idTienda;
	}

	public void setIdTienda(Integer idTienda) {
		this.idTienda = idTienda;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(Integer idVendedor) {
		this.idVendedor = idVendedor;
	}

	public List<ProductoPedido> getProductosPedido() {
		return productosPedido;
	}

	public void setProductosPedido(List<ProductoPedido> productosPedido) {
		this.productosPedido = productosPedido;
	}
	
	
	
	
	
	
}
