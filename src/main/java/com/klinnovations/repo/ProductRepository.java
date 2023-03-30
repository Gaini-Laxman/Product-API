package com.klinnovations.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klinnovations.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	public Optional<Product>findByPname(String pname);
		
	
	
}
