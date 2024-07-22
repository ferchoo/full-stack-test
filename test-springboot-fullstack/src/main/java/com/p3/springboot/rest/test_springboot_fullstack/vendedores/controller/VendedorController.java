package com.p3.springboot.rest.test_springboot_fullstack.vendedores.controller;

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
import com.p3.springboot.rest.test_springboot_fullstack.vendedores.dto.VendedorDto;
import com.p3.springboot.rest.test_springboot_fullstack.vendedores.entity.Vendedor;
import com.p3.springboot.rest.test_springboot_fullstack.vendedores.service.VendedorService;

@RestController
@CrossOrigin("http://localhost:3000")
public class VendedorController {
	
	@Autowired
	private VendedorService vendedorService;
	
	@RequestMapping("/vendedores/{id}")
	public Optional<Vendedor> retrieveVendedorByIdentifier(@PathVariable("id") Integer id){
		Optional<Vendedor> vendedor = vendedorService.findById(id);
		System.out.println(vendedor);
		return vendedor;
	
}
	@GetMapping("/vendedores")
	public ResponseEntity<List<VendedorDto>> retrieveAllProducts(){
		List<VendedorDto> vendedores = vendedorService.findAll();
		return new ResponseEntity<>(vendedores,HttpStatus.OK);
	}
	

}
