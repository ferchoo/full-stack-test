package com.p3.springboot.rest.test_springboot_fullstack.productospedido.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.p3.springboot.rest.test_springboot_fullstack.pedidos.entity.Pedido;
import com.p3.springboot.rest.test_springboot_fullstack.products.entity.Product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="productoPedido")
public class ProductoPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="cantidad", nullable=false)
	private Integer cantidad;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idProducto",
    referencedColumnName = "id")
	private Product producto;
	
	@JsonIgnore
	@Column(name="idPedido")
	@JoinColumn(name = "idPedido",
            referencedColumnName = "id")
	private Integer idPedido;
	
	
	

	public ProductoPedido(Integer id, Integer cantidad, Product producto, Integer idPedido) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.producto = producto;
		this.idPedido = idPedido;
	}
	
	

	public ProductoPedido() {
		super();
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Product getProducto() {
		return producto;
	}

	public void setProducto(Product producto) {
		this.producto = producto;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	
	
	
	
	
	
}
