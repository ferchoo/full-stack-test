package com.p3.springboot.rest.test_springboot_fullstack.cliente.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.p3.springboot.rest.test_springboot_fullstack.cliente.dto.ClienteDto;
import com.p3.springboot.rest.test_springboot_fullstack.clientes.entity.Cliente;
import com.p3.springboot.rest.test_springboot_fullstack.products.dto.ProductDto;


@Service
public interface ClienteService {
	public Optional<Cliente> findById(Integer id);
	public List<ClienteDto> findAll();
}
