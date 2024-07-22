package com.p3.springboot.rest.test_springboot_fullstack.tiendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p3.springboot.rest.test_springboot_fullstack.tiendas.entity.Tienda;

public interface TiendaRepository extends JpaRepository<Tienda, Integer> {

}
