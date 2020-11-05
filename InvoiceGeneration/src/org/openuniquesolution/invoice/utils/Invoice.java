package org.openuniquesolution.invoice.utils;

import org.openuniquesolution.invoice.model.Order;

public class Invoice {
	StringBuilder builder = null;
	
	private void printHeader() {
		System.out.println("NAME                       | QTY | UNIT_COST | COST   ");
		System.out.println("---------------------------|-----|-----------|--------");
	}
	
	private void printFooter(Order order ) {
		System.out.println("SubTotal: " +order.getNonTaxAmount());
		System.out.println("Value Added Tax: " + order.getTaxes().get("VAT"));
		System.out.println("Additional Tax: " + order.getTaxes().get("Aditional"));
		System.out.println("Total: " + order.getTotalAmount());
	}
	
	private void printBody(Order order) {
		System.out.println(builder.toString());
	}
	
	public void dislay(Order order) {
		builder = order.getOutputBuilder();
		printHeader();
		printBody(order);
		printFooter(order);
	}

}
