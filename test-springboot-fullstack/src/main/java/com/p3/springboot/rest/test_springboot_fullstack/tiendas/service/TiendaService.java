package com.p3.springboot.rest.test_springboot_fullstack.tiendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.p3.springboot.rest.test_springboot_fullstack.cliente.dto.ClienteDto;
import com.p3.springboot.rest.test_springboot_fullstack.tiendas.dto.TiendaDto;
import com.p3.springboot.rest.test_springboot_fullstack.tiendas.entity.Tienda;

@Service
public interface TiendaService {
	public Optional<Tienda> findById(Integer id);
	public List<TiendaDto> findAll();
}
