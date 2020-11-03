package com.openuniqesolution.inventoryservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductCategory {
	
	@Id
	private int categoryId;
	private String categoryName;
	private String discription;
	
	
	
	public ProductCategory() {
	}
	public ProductCategory(int categoryId, String categoryName, String discription) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.discription = discription;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
	
	
}
