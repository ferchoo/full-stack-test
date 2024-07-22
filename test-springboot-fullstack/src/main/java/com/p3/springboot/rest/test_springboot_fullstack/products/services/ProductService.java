package com.p3.springboot.rest.test_springboot_fullstack.products.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.p3.springboot.rest.test_springboot_fullstack.products.dto.ProductDto;

@Service
public interface ProductService {
	public List<ProductDto> findAll();
	
	public ProductDto findByHawa(String hawa);
	
	//public ProductDto addProduct(ProductDto productDto);
}
