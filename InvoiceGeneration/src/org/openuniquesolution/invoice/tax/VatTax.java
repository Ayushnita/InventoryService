package org.openuniquesolution.invoice.tax;

import org.openuniquesolution.invoice.model.Item;

public class VatTax{


	public static float calulateTax(Item item) {
		if(item.getProduct().isVatApplied()){
			return (float) ((item.getQuantity() * item.getRate() * 12.5) /100);
		}else {
			return 0;
		}
	}


}
