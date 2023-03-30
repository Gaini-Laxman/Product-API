package com.klinnovations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.klinnovations.model.Product;
import com.klinnovations.productservice.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService ps;
	
	@GetMapping("/products")
	public List<Product>findAll(){
		return ps.findAll();	
	}
	@GetMapping("/product/{name}")
	public ResponseEntity <Product> findByName(@PathVariable String name) {
		return new ResponseEntity<Product>(ps.findByName(name), HttpStatus.OK);
	}
	@PostMapping("/save")
	public ResponseEntity <Product> createProduct(@RequestBody Product p){
		  return new ResponseEntity<Product>(ps.saveProduct(p), HttpStatus.CREATED);
	}
	@PutMapping("/update/{pid}")
  public ResponseEntity <Product> updateProduct(@PathVariable int pid,@RequestBody Product pr){
	  return new ResponseEntity<Product>(ps.updateProduct(pid, pr), HttpStatus.CREATED);
	  
  }
	@DeleteMapping("/delete/{pid}")
	public ResponseEntity<String> deleteProduct(@PathVariable int pid){
		return new ResponseEntity<String>(ps.deleteProduct(pid),HttpStatus.OK);
		
	}
	
	
}
