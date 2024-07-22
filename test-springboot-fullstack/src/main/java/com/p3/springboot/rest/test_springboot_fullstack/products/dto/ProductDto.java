package com.p3.springboot.rest.test_springboot_fullstack.products.dto;

public class ProductDto {
	
	private Integer id;
	private String hawa;
	private Integer precio;
	private Integer stock;	
	private Integer descuento;
	
	
	
	public ProductDto(Integer id, String hawa, Integer precio, Integer stock, Integer descuento) {
		super();
		this.id = id;
		this.hawa = hawa;
		this.precio = precio;
		this.stock = stock;
		this.descuento = descuento;
	}
	
	
	
	public ProductDto() {
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



	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", hawa=" + hawa + ", precio=" + precio + ", stock=" + stock + ", descuento="
				+ descuento + "]";
	}
	
	
	
	
	
}
