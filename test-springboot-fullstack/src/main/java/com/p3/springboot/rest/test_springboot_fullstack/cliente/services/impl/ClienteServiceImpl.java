package com.p3.springboot.rest.test_springboot_fullstack.cliente.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.p3.springboot.rest.test_springboot_fullstack.cliente.dto.ClienteDto;
import com.p3.springboot.rest.test_springboot_fullstack.cliente.services.ClienteService;
import com.p3.springboot.rest.test_springboot_fullstack.clientes.entity.Cliente;
import com.p3.springboot.rest.test_springboot_fullstack.clientes.repository.ClienteRepository;
import com.p3.springboot.rest.test_springboot_fullstack.products.dto.ProductDto;
import com.p3.springboot.rest.test_springboot_fullstack.products.entity.Product;
import com.p3.springboot.rest.test_springboot_fullstack.products.exception.ProductNotFoundException;

@Component
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Optional<Cliente> findById(Integer id) {
		
		Optional<Cliente> cliente= clienteRepository.findById(id);
		
		
		if(cliente.isEmpty()) {
			throw new ProductNotFoundException("id: "+id);
		}
		
		return cliente;
	}

	@Override
	public List<ClienteDto> findAll() {
		List<Cliente> clientes = clienteRepository.findAll();
		
	
		return clientes.stream().map((cliente)->modelMapper.map(cliente,ClienteDto.class))
		.collect(Collectors.toList());
	}
	
}
