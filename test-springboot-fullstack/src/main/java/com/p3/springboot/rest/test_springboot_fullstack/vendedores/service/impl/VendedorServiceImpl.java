package com.p3.springboot.rest.test_springboot_fullstack.vendedores.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.p3.springboot.rest.test_springboot_fullstack.cliente.dto.ClienteDto;
import com.p3.springboot.rest.test_springboot_fullstack.clientes.entity.Cliente;
import com.p3.springboot.rest.test_springboot_fullstack.products.exception.ProductNotFoundException;
import com.p3.springboot.rest.test_springboot_fullstack.vendedores.dto.VendedorDto;
import com.p3.springboot.rest.test_springboot_fullstack.vendedores.entity.Vendedor;
import com.p3.springboot.rest.test_springboot_fullstack.vendedores.repository.VendedorRepository;
import com.p3.springboot.rest.test_springboot_fullstack.vendedores.service.VendedorService;

@Component
public class VendedorServiceImpl implements VendedorService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private VendedorRepository vendedorRepository;

	@Override
	public Optional<Vendedor> findById(Integer id) {
		Optional<Vendedor> vendedor= vendedorRepository.findById(id);
		
		if(vendedor.isEmpty()) {
			throw new ProductNotFoundException("id: "+id);
		}
		
		return vendedor;
	}

	@Override
	public List<VendedorDto> findAll() {
		List<Vendedor> vendedores = vendedorRepository.findAll();
		
		
		return vendedores.stream().map((vendedor)->modelMapper.map(vendedor,VendedorDto.class))
		.collect(Collectors.toList());
	}

}
