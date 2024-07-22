package com.p3.springboot.rest.test_springboot_fullstack.tiendas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.p3.springboot.rest.test_springboot_fullstack.cliente.dto.ClienteDto;
import com.p3.springboot.rest.test_springboot_fullstack.tiendas.dto.TiendaDto;
import com.p3.springboot.rest.test_springboot_fullstack.tiendas.entity.Tienda;
import com.p3.springboot.rest.test_springboot_fullstack.tiendas.service.TiendaService;

@RestController
@CrossOrigin("http://localhost:3000")
public class TiendaController {
	@Autowired
	private TiendaService tiendaService;
	
	@RequestMapping("/tiendas/{id}")
	public Optional<Tienda> retrieveTiendaByIdentifier(@PathVariable("id") Integer id){
		Optional<Tienda> tienda = tiendaService.findById(id);
		System.out.println(tienda);
		return tienda;
	
}
	@GetMapping("/tiendas")
	public ResponseEntity<List<TiendaDto>> retrieveAllProducts(){
		List<TiendaDto> tiendas = tiendaService.findAll();
		return new ResponseEntity<>(tiendas,HttpStatus.OK);
	}
}
