package org.openuniquesolution.invoice.model;

public class Item {

	private float quantity;
	private float  rate;
	private Product product;
	
	
	public Item(float quantity, float rate, Product product) {
		super();
		this.quantity = quantity;
		this.rate = rate;
		this.product = product;
	}
	
	
	public Item(String item) {
		this.quantity = Float.parseFloat(item.split(" ")[0]);
		this.rate = Float.parseFloat(item.split("@")[1]);
		String product_String = item.split("@")[0];
		this.product = new Product(product_String);
	}


	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
