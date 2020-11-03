package com.openuniqesolution.inventoryservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Category which you are trying to save does not exist")
public class CategoryNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3188888564054102172L;

}
