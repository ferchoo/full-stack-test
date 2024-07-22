package com.p3.springboot.rest.test_springboot_fullstack.vendedores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p3.springboot.rest.test_springboot_fullstack.vendedores.entity.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {

}
