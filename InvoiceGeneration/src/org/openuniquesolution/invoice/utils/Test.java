package org.openuniquesolution.invoice.utils;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openuniquesolution.invoice.model.Item;
import org.openuniquesolution.invoice.model.Order;

public class Test {


	
	public static void main(String[] args){
		Logger logger = Logger.getLogger(Test.class.getName());
		File file = new File("resources/input.txt");
		Scanner in = null;
		try {
			in = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info("Start adding Items and add a Emty Line for completing Order");
		Order order = new Order();
		Invoice invoice = new Invoice();
		String item_String = null;
		while(in.hasNextLine()) {
			item_String = in.nextLine();
			logger.log(Level.SEVERE, item_String);
			Item item = new Item(item_String);
			order.addItem(item);
		}
		invoice.dislay(order);
		in.close();
	}
}
