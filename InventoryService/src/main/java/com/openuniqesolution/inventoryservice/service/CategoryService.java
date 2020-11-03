package com.openuniqesolution.inventoryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openuniqesolution.inventoryservice.model.ProductCategory;
import com.openuniqesolution.inventoryservice.repo.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepo;
	
	public List<ProductCategory> getAllCategory() {
		return categoryRepo.findAll();
	}

	public void addCategory(ProductCategory category) {
		categoryRepo.save(category);
	}

	public void updateCategory(ProductCategory category) {
		categoryRepo.save(category);
	}

	public void deleteCategory(int id) {
		categoryRepo.deleteById(id);
	}

	public boolean categoryExist(ProductCategory categoryId) {
		return categoryRepo.existsById(categoryId.getCategoryId());
	}

}
