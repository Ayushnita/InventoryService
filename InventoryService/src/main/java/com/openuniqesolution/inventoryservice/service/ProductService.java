package com.openuniqesolution.inventoryservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openuniqesolution.inventoryservice.exception.CategoryNotFoundException;
import com.openuniqesolution.inventoryservice.model.Product;
import com.openuniqesolution.inventoryservice.model.ProductCategory;
import com.openuniqesolution.inventoryservice.repo.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository prodRepo;
	
	@Autowired
	CategoryService categoryService;
	
	public List<Product> getProductByName(String name) {
		return prodRepo.findByName(name);
	}

	public Optional<Product> getProductById(int id) {
		return prodRepo.findById(id);
	}

	public List<Product> getAllProduct() {
		return prodRepo.findAll();
	}

	public void saveProduct(Product product) throws CategoryNotFoundException {
		ProductCategory categoryId = product.getCategoryId();
		if(!categoryService.categoryExist(categoryId)) {
			throw new CategoryNotFoundException();
		}
		prodRepo.save(product);
	}

	public void updateProduct(Product prod) throws CategoryNotFoundException{
		ProductCategory categoryId = prod.getCategoryId();
		if(!categoryService.categoryExist(categoryId)) {
			throw new CategoryNotFoundException();
		}
		prodRepo.save(prod);
	}

	public void deleteProduct(int id) {
		prodRepo.deleteById(id);
	}

	public boolean exist(Product prod) {
		return prodRepo.existsById(prod.getProductId());
	}

}
