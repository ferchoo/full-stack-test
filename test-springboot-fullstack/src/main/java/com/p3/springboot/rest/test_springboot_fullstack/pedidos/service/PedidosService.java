package com.p3.springboot.rest.test_springboot_fullstack.pedidos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.p3.springboot.rest.test_springboot_fullstack.pedidos.dto.PedidoPostModel;
import com.p3.springboot.rest.test_springboot_fullstack.pedidos.dto.PedidoResponseModel;
import com.p3.springboot.rest.test_springboot_fullstack.pedidos.dto.PedidoUpdateModel;
import com.p3.springboot.rest.test_springboot_fullstack.pedidos.entity.Pedido;

@Service
public interface PedidosService {
	public Optional<Pedido>findPedidoById(Integer id);
	public List<Pedido>findAll();
	public PedidoResponseModel savePedido(PedidoPostModel postPedidoModel);
	public PedidoResponseModel updateStatusPedido(Integer id,PedidoUpdateModel updatePedidoModel);
}
