package com.p3.springboot.rest.test_springboot_fullstack.clientes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.p3.springboot.rest.test_springboot_fullstack.cliente.dto.ClienteDto;
import com.p3.springboot.rest.test_springboot_fullstack.cliente.services.ClienteService;
import com.p3.springboot.rest.test_springboot_fullstack.clientes.entity.Cliente;
import com.p3.springboot.rest.test_springboot_fullstack.products.dto.ProductDto;


@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping("/clientes/{id}")
	public Optional<Cliente> retrieveClienteByIdentifier(@PathVariable("id") Integer id){
		Optional<Cliente> cliente = clienteService.findById(id);
		System.out.println(cliente);
		return cliente;
	
}
	@GetMapping("/clientes")
	public ResponseEntity<List<ClienteDto>> retrieveAllProducts(){
		List<ClienteDto> clientes = clienteService.findAll();
		return new ResponseEntity<>(clientes,HttpStatus.OK);
	}
	
}


