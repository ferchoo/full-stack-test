package com.p3.springboot.rest.test_springboot_fullstack.products.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.p3.springboot.rest.test_springboot_fullstack.products.dto.ProductDto;
import com.p3.springboot.rest.test_springboot_fullstack.products.entity.Product;
import com.p3.springboot.rest.test_springboot_fullstack.products.exception.ProductNotFoundException;
import com.p3.springboot.rest.test_springboot_fullstack.products.repository.ProductRepository;
import com.p3.springboot.rest.test_springboot_fullstack.products.services.ProductService;

@Component
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public List<ProductDto> findAll() {
		List<Product> products = productRepository.findAll();
	
;	
		return products.stream().map((product)->modelMapper.map(product,ProductDto.class))
				.collect(Collectors.toList());
	}


	@Override
	public ProductDto findByHawa(String hawa) {
		Product p = productRepository.getProductByHawa(hawa);
		if(p==null) {
			
			throw new ProductNotFoundException("Not found identifier:" +hawa);
		
		}
		return modelMapper.map(p, ProductDto.class);
	}


	
	
}
