package org.openuniquesolution.invoice.model;

import java.util.Map;

import org.openuniquesolution.invoice.tax.TaxCalculator;
import org.openuniquesolution.invoice.tax.TaxCalculatorInterface;

public class Order {

	private  StringBuilder outputBuilder;
	private float nonTaxAmount = 0;
	private float totalAmount = 0;
	private TaxCalculatorInterface taxCalculator;
	private Map<String, Float> taxes;
	
	
	
	public Order() {
		this.outputBuilder = new StringBuilder();
		this.taxCalculator = new TaxCalculator();
	}

	public Order(TaxCalculatorInterface taxCalculator) {
		this.outputBuilder = new StringBuilder();
		this.taxCalculator = taxCalculator;
	}

	private  void taxCalculator(Item item) {
		this.taxes = taxCalculator.calculateTax(item);
	}
	
	private void amountCalculator(Item item) {
		this.nonTaxAmount = (item.getRate() * item.getQuantity()) + this.nonTaxAmount;
	}


	public void addItem(Item item) {
		amountCalculator(item);
		taxCalculator(item);
		addInoutputBuilder(item);
	}
	
	private void addInoutputBuilder(Item item) {
		this.outputBuilder.append(item.getProduct().getProductName() + "   |");
		this.outputBuilder.append(item.getQuantity()+ "   |");
		this.outputBuilder.append(item.getRate()+ "   |");
		this.outputBuilder.append(item.getQuantity() * item.getRate());
		this.outputBuilder.append("\n");
	}

	public StringBuilder getOutputBuilder() {
		return outputBuilder;
	}

	public void setOutputBuilder(StringBuilder outputBuilder) {
		this.outputBuilder = outputBuilder;
	}

	public float getNonTaxAmount() {
		return nonTaxAmount;
	}

	public void setNonTaxAmount(float nonTaxAmount) {
		this.nonTaxAmount = nonTaxAmount;
	}
	
	public TaxCalculatorInterface getTaxCalculator() {
		return taxCalculator;
	}

	public void setTaxCalculator(TaxCalculatorInterface taxCalculator) {
		this.taxCalculator = taxCalculator;
	}

	public Map<String, Float> getTaxes() {
		return taxes;
	}

	public void setTaxes(Map<String, Float> taxes) {
		this.taxes = taxes;
	}

	public float getTotalAmount() {
		for(float val : this.taxes.values()) {
			this.totalAmount = totalAmount + val;
		}
		this.totalAmount = this.totalAmount + this.nonTaxAmount;
		
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
}
