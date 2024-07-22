package com.p3.springboot.rest.test_springboot_fullstack.pedidos.service.impl;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.p3.springboot.rest.test_springboot_fullstack.clientes.entity.Cliente;
import com.p3.springboot.rest.test_springboot_fullstack.clientes.repository.ClienteRepository;
import com.p3.springboot.rest.test_springboot_fullstack.pedidos.dto.PedidoPostModel;
import com.p3.springboot.rest.test_springboot_fullstack.pedidos.dto.PedidoResponseModel;
import com.p3.springboot.rest.test_springboot_fullstack.pedidos.dto.PedidoUpdateModel;
import com.p3.springboot.rest.test_springboot_fullstack.pedidos.entity.Pedido;
import com.p3.springboot.rest.test_springboot_fullstack.pedidos.repository.PedidoRepository;
import com.p3.springboot.rest.test_springboot_fullstack.pedidos.service.PedidosService;
import com.p3.springboot.rest.test_springboot_fullstack.productospedido.entity.ProductoPedido;
import com.p3.springboot.rest.test_springboot_fullstack.productospedido.repository.ProductoPedidoRepository;
import com.p3.springboot.rest.test_springboot_fullstack.tiendas.entity.Tienda;
import com.p3.springboot.rest.test_springboot_fullstack.tiendas.repository.TiendaRepository;
import com.p3.springboot.rest.test_springboot_fullstack.vendedores.entity.Vendedor;
import com.p3.springboot.rest.test_springboot_fullstack.vendedores.repository.VendedorRepository;


@Component
public class PedidoServiceImpl implements PedidosService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ProductoPedidoRepository productoPedidoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	private TiendaRepository tiendaRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Optional<Pedido> findPedidoById(Integer id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		
		return pedido;
	}

	@Override
	public List<Pedido> findAll() {
		List<Pedido> pedidos = pedidoRepository.findAll();
		
;	
		return pedidos.stream().map((pedido)->modelMapper.map(pedido,Pedido.class))
				.collect(Collectors.toList());
	}

	@Override
	public PedidoResponseModel savePedido(PedidoPostModel postPedidoModel) {
		
		//1. create an entry in pedido
		//2. obtain the id from pedido
		//3. create an entry in productPedido
		//4. return PedidoResponseModel 
		
		Optional<Cliente> clienteEntity =clienteRepository.findById(postPedidoModel.getIdCliente());
		System.out.println(clienteEntity.get());
		
		Optional<Vendedor> vendedorEntity = vendedorRepository.findById(postPedidoModel.getIdVendedor());
		
		Optional<Tienda> tiendaEntity = tiendaRepository.findById(postPedidoModel.getIdTienda());
		

		 Pedido pedidoEntity = new Pedido();
		 pedidoEntity.setIpCliente(postPedidoModel.getIpCliente());
		 pedidoEntity.setStatusPedido((byte)0);
		 pedidoEntity.setCliente(clienteEntity.get());;
		 pedidoEntity.setVendedor(vendedorEntity.get());
		 pedidoEntity.setTienda(tiendaEntity.get());
		 pedidoEntity.setFechaCreacion(new Date());
		 pedidoEntity.setStatusPedido((byte)0);
		 
		pedidoRepository.saveAndFlush(pedidoEntity);
		
		
		postPedidoModel.getProductosPedido().stream().map(
				ppedido->{
					ppedido.setIdPedido(pedidoEntity.getId());
					return ppedido;}).collect(Collectors.toList());
		
	
		
		productoPedidoRepository.saveAll(postPedidoModel.getProductosPedido());
		
		pedidoEntity.setProductosPedido(postPedidoModel.getProductosPedido());
		
		
	     return modelMapper.map(pedidoEntity, PedidoResponseModel.class);

	}

	@Override
	public PedidoResponseModel updateStatusPedido(Integer id,PedidoUpdateModel updatePedidoModel) {
		
		Optional<Pedido> pedido=pedidoRepository.findById(id);
		pedido.get().setStatusPedido(updatePedidoModel.getStatusPedido());
		
		pedidoRepository.saveAndFlush(pedido.get());
		
		return modelMapper.map(pedido.get(), PedidoResponseModel.class);
	}
	
	
	

}
