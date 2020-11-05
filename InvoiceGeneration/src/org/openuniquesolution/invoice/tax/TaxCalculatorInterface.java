package org.openuniquesolution.invoice.tax;

import java.util.Map;

import org.openuniquesolution.invoice.model.Item;

public interface TaxCalculatorInterface {
	public Map<String, Float> calculateTax(Item item);
}