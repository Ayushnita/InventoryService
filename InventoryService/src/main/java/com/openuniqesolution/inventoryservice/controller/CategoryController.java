package com.openuniqesolution.inventoryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openuniqesolution.inventoryservice.model.ProductCategory;
import com.openuniqesolution.inventoryservice.service.CategoryService;

@RestController
@RequestMapping("/categories")
@PreAuthorize("isAuthenticated()")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;

	@GetMapping
	public ResponseEntity<List<ProductCategory>> getAllCategory(){
		List<ProductCategory> list = categoryService.getAllCategory();
		
		if(list.size() == 0) {
			return new ResponseEntity<List<ProductCategory>>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<ProductCategory>>(list, HttpStatus.OK);
		}
	}
	
	@PostMapping
	public void addCategory(@RequestBody ProductCategory category) {
		categoryService.addCategory(category);
	}
	
	@PutMapping
	public void updateCategory(@RequestBody ProductCategory category) {
		categoryService.updateCategory(category);
	}
	
	/**
	 * Delete of Category happen only when there is no Product for taht category Exist.
	 * If any one ProductExist then it throw an Error ProductExistError
	 */
	@Secured("ROLE_ADMIN")
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable int id) {
		categoryService.deleteCategory(id);
	}
}
