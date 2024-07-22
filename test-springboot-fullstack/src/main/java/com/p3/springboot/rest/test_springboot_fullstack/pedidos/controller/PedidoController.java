package com.p3.springboot.rest.test_springboot_fullstack.pedidos.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.p3.springboot.rest.test_springboot_fullstack.pedidos.dto.PedidoPostModel;
import com.p3.springboot.rest.test_springboot_fullstack.pedidos.dto.PedidoResponseModel;
import com.p3.springboot.rest.test_springboot_fullstack.pedidos.dto.PedidoUpdateModel;
import com.p3.springboot.rest.test_springboot_fullstack.pedidos.entity.Pedido;
import com.p3.springboot.rest.test_springboot_fullstack.pedidos.service.PedidosService;


import jakarta.validation.Valid;


@RestController
@CrossOrigin("http://localhost:3000") //aqui iria el endpoint del front (acepta incoming del front)
public class PedidoController {
	
	@Autowired
	private PedidosService pedidosService;
	
	@RequestMapping("/pedidos/{id}")
	public Optional<Pedido> retrieveClienteByIdentifier(@PathVariable("id") Integer id){
		Optional<Pedido> pedido = pedidosService.findPedidoById(id);
		System.out.println(pedido);
		return pedido;
	
	}
	
	@GetMapping("/pedidos")
	public ResponseEntity<List<Pedido>> retrieveAllProducts(){
		List<Pedido> pedidos = pedidosService.findAll();
		return new ResponseEntity<>(pedidos,HttpStatus.OK);
	}
	
	@PostMapping("/pedidos")
	public PedidoResponseModel createPedido(@Valid @RequestBody PedidoPostModel postPedidoModel){
		return pedidosService.savePedido(postPedidoModel);
		
	}
	
	
	@PostMapping("/pedidos/status/{id}")
	public PedidoResponseModel updateStatus(@PathVariable("id") Integer id,@Valid @RequestBody PedidoUpdateModel updatePedidoModel){
		return pedidosService.updateStatusPedido(id,updatePedidoModel);
		
	}

}
