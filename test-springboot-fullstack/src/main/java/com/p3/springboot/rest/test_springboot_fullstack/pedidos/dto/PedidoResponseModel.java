package com.p3.springboot.rest.test_springboot_fullstack.pedidos.dto;

import java.util.Date;

import com.p3.springboot.rest.test_springboot_fullstack.clientes.entity.Cliente;
import com.p3.springboot.rest.test_springboot_fullstack.tiendas.entity.Tienda;
import com.p3.springboot.rest.test_springboot_fullstack.vendedores.entity.Vendedor;

public class PedidoResponseModel {
	private Integer id;
	private Date fechaCreacion;
	private Byte statusPedido;
	private String ipCliente;
	private Tienda tienda;
	private Cliente cliente;
	private Vendedor vendedor;
	
	
	
	
	public PedidoResponseModel(Integer id, Date fechaCreacion, Byte statusPedido, String ipCliente, Tienda tienda,
			Cliente cliente, Vendedor vendedor) {
		super();
		this.id = id;
		this.fechaCreacion = fechaCreacion;
		this.statusPedido = statusPedido;
		this.ipCliente = ipCliente;
		this.tienda = tienda;
		this.cliente = cliente;
		this.vendedor = vendedor;
	}
	
	
	
	public PedidoResponseModel() {
		super();
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Byte getStatusPedido() {
		return statusPedido;
	}
	public void setStatusPedido(Byte statusPedido) {
		this.statusPedido = statusPedido;
	}
	public String getIpCliente() {
		return ipCliente;
	}
	public void setIpCliente(String ipCliente) {
		this.ipCliente = ipCliente;
	}
	public Tienda getTienda() {
		return tienda;
	}
	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	
	
	
}
