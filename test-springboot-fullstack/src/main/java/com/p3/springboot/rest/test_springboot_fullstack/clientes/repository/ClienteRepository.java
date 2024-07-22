package com.p3.springboot.rest.test_springboot_fullstack.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p3.springboot.rest.test_springboot_fullstack.clientes.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
