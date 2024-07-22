package com.p3.springboot.rest.test_springboot_fullstack.products.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.p3.springboot.rest.test_springboot_fullstack.products.dto.ProductDto;
import com.p3.springboot.rest.test_springboot_fullstack.products.entity.*;
import com.p3.springboot.rest.test_springboot_fullstack.products.repository.ProductRepository;
import com.p3.springboot.rest.test_springboot_fullstack.products.services.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	//public ResponseEntity<T>
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> retrieveAllProducts(){
		List<ProductDto> products = productService.findAll();
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/products/{identifier}")
	public ResponseEntity<ProductDto> retrieveProductByIdentifier(@PathVariable("identifier") String identifier){
		ProductDto product = productService.findByHawa(identifier);
		System.out.println(product);
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	
}
