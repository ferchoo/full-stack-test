package com.p3.springboot.rest.test_springboot_fullstack.products.entity;

import java.util.List;

import com.p3.springboot.rest.test_springboot_fullstack.pedidos.entity.Pedido;
import com.p3.springboot.rest.test_springboot_fullstack.productospedido.entity.ProductoPedido;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="producto")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="hawa", nullable=false)
	private String hawa;
	
	@Column(name="precio", nullable=false)
	private Integer precio;
	
	@Column(name="stock", nullable=false)
	private Integer stock;
	
	@Column(name="descuento", nullable=false)
	private Integer descuento;
	
	

	public Product(Integer id, String hawa, Integer precio, Integer stock, Integer descuento) {
		super();
		this.id = id;
		this.hawa = hawa;
		this.precio = precio;
		this.stock = stock;
		this.descuento = descuento;
	}

	
	
	public Product() {
		super();
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHawa() {
		return hawa;
	}

	public void setHawa(String hawa) {
		this.hawa = hawa;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getDescuento() {
		return descuento;
	}

	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}
	
	
	
}
