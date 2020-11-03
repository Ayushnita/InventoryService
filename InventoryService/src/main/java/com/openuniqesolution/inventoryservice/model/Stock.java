package com.openuniqesolution.inventoryservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Stock {
	
	@Id
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product productId;
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Supplier supplier;
	
	
	public Stock() {
		super();
	}

	public Stock(int id, Product productId, int quantity) {
		super();
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	

	
}
