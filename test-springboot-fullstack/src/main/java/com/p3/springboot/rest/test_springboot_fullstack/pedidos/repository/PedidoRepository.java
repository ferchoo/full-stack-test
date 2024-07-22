package com.p3.springboot.rest.test_springboot_fullstack.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p3.springboot.rest.test_springboot_fullstack.pedidos.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido,Integer> {

}
