package com.p3.springboot.rest.test_springboot_fullstack.tiendas.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.p3.springboot.rest.test_springboot_fullstack.cliente.dto.ClienteDto;
import com.p3.springboot.rest.test_springboot_fullstack.clientes.entity.Cliente;
import com.p3.springboot.rest.test_springboot_fullstack.products.exception.ProductNotFoundException;
import com.p3.springboot.rest.test_springboot_fullstack.tiendas.dto.TiendaDto;
import com.p3.springboot.rest.test_springboot_fullstack.tiendas.entity.Tienda;
import com.p3.springboot.rest.test_springboot_fullstack.tiendas.repository.TiendaRepository;
import com.p3.springboot.rest.test_springboot_fullstack.tiendas.service.TiendaService;

@Component
public class TiendaServiceImpl implements TiendaService {
	
	@Autowired
	private TiendaRepository tiendaRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Optional<Tienda> findById(Integer id) {
		Optional<Tienda> tienda= tiendaRepository.findById(id);
		
		
		if(tienda.isEmpty()) {
			throw new ProductNotFoundException("id: "+id);
		}
		
		return tienda;
		}

	@Override
	public List<TiendaDto> findAll() {
		List<Tienda> tiendas = tiendaRepository.findAll();
		
		
		return tiendas.stream().map((tienda)->modelMapper.map(tienda,TiendaDto.class))
		.collect(Collectors.toList());
	}
	

}
