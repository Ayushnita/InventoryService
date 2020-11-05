package org.openuniquesolution.invoice.tax;

import java.util.HashMap;
import java.util.Map;

import org.openuniquesolution.invoice.model.Item;

public class TaxCalculator implements TaxCalculatorInterface {
	
	Map<String, Float> taxMap = new HashMap<String, Float>();
	public TaxCalculator() {
		taxMap.put("VAT", 0f);
		taxMap.put("Aditional", 0f);
	}
	public Map<String, Float> calculateTax(Item item) {
		taxMap.put("VAT", taxMap.get("VAT") + VatTax.calulateTax(item));
		taxMap.put("Aditional", taxMap.get("Aditional") + ImportedTax.calulateTax(item));
		return this.taxMap;
	}

}
