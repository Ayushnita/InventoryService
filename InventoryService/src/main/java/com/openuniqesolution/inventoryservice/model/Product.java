package com.openuniqesolution.inventoryservice.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {
	
	@Id
	private int productId;
	@ManyToOne
	@JoinColumn(name = "categoryId", nullable = false)
	private ProductCategory categoryId;
	private String name;
	private String discription;
	
	@OneToMany(mappedBy ="id")
	private List<Stock> stockList;
	
	
	
	public Product() {
		
	}

	public Product(int productId, ProductCategory categoryId, String name, String discription) {
		this.productId = productId;
		this.categoryId = categoryId;
		this.name = name;
		this.discription = discription;
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public ProductCategory getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(ProductCategory categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public List<Stock> getStockList(){
		return this.stockList;
	}
}
