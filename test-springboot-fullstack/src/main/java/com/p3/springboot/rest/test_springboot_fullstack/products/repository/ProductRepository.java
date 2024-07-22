package com.p3.springboot.rest.test_springboot_fullstack.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.p3.springboot.rest.test_springboot_fullstack.products.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
	//Como se esta hablando de objetos se tiene que usar tal cual el nombre de la tabla
    @Query(value="SELECT * FROM producto WHERE hawa = :hawaProduct", nativeQuery=true)
    public Product getProductByHawa(@Param("hawaProduct")String hawaProduct);
}
