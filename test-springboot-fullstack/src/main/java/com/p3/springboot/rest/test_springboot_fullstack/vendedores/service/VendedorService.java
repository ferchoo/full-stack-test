package com.p3.springboot.rest.test_springboot_fullstack.vendedores.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.p3.springboot.rest.test_springboot_fullstack.cliente.dto.ClienteDto;
import com.p3.springboot.rest.test_springboot_fullstack.vendedores.dto.VendedorDto;
import com.p3.springboot.rest.test_springboot_fullstack.vendedores.entity.Vendedor;

@Service
public interface VendedorService {
	public Optional<Vendedor> findById(Integer id);
	public List<VendedorDto> findAll();
}
