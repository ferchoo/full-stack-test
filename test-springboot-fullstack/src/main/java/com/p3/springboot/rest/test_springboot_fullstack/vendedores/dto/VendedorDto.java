package com.p3.springboot.rest.test_springboot_fullstack.vendedores.dto;

public class VendedorDto {
	private Integer id;
	private String nombre;
	private String apellido;
	
	
	public VendedorDto(Integer id, String nombre, String apellido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}
		
	
	public VendedorDto() {
		super();
	}




	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	@Override
	public String toString() {
		return "VendedorDto [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	
}
