package com.openuniqesolution.inventoryservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.openuniqesolution.inventoryservice.exception.CategoryNotFoundException;
import com.openuniqesolution.inventoryservice.model.Product;
import com.openuniqesolution.inventoryservice.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productServie;
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> list = productServie.getAllProduct();
		if(list.size() == 0) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
		}
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<List<Product>> getProductByName(@PathVariable String name){
		List<Product> list = productServie.getProductByName(name);
		if(list.size() == 0) {
			return new ResponseEntity<List<Product>>(list, HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id){
		Optional<Product> product = productServie.getProductById(id);
		if(!product.isPresent()) {
			return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
		}
	}
	
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void saveProduct(@RequestBody Product product) throws CategoryNotFoundException {
		productServie.saveProduct(product);
	}
	
	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
	public void updateProduct(@RequestBody Product prod) throws CategoryNotFoundException {
		productServie.updateProduct(prod);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable int id) {
		productServie.deleteProduct(id);
	}
}
