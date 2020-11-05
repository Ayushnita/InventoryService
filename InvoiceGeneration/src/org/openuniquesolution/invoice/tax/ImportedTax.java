package org.openuniquesolution.invoice.tax;

import org.openuniquesolution.invoice.model.Item;

public class ImportedTax{

	public static float calulateTax(Item item) {
		if(item.getProduct().isImported()){
			return (float) ((item.getQuantity() * item.getRate() * 2.4) /100);
		}else {
			return 0;
		}
	}

}
