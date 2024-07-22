package com.p3.springboot.rest.test_springboot_fullstack.tiendas.dto;

public class TiendaDto {
	private Integer id;
	private String nombre;
	
	
	
	public TiendaDto(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	
	
	public TiendaDto() {
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


	@Override
	public String toString() {
		return "TiendaDto [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
}
