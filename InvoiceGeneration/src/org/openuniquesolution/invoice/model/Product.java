package org.openuniquesolution.invoice.model;

import java.util.ArrayList;
import java.util.List;

import org.openuniquesolution.invoice.utils.ProductType;

public class Product {
	static List<String> nonVatList;
	
	static {
		nonVatList = new ArrayList<>();
		nonVatList.add("potato");
		nonVatList.add("crocin");
		nonVatList.add("chocolates");
		nonVatList.add("teddy");
		nonVatList.add("toys");
		nonVatList.add("snacks");
	}
	private String productName;
	private ProductType productType;
	private boolean isImported;
	private boolean isVatApplied;
	
	public Product(String productName, ProductType productType, boolean isImported) {
		super();
		this.productName = productName;
		this.productType = productType;
		this.isImported = isImported;
	}
	
	public Product(String product_String) {
		this.isImported = product_String.contains("imported");
		this.productName = product_String.substring(product_String.indexOf(' ') + 1);
		this.isVatApplied = !nonVatList.stream()
							.anyMatch(product_String::contains);
		this.productType = isVatApplied ? productType.VAT : ProductType.NON_VAT;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	public boolean isImported() {
		return isImported;
	}
	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}

	public boolean isVatApplied() {
		return isVatApplied;
	}

	public void setVatApplied(boolean isVatApplied) {
		this.isVatApplied = isVatApplied;
	}
	
}
