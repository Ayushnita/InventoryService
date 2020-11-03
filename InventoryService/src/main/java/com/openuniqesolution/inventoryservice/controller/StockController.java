package com.openuniqesolution.inventoryservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openuniqesolution.inventoryservice.exception.ProductNotFoundException;
import com.openuniqesolution.inventoryservice.model.Stock;
import com.openuniqesolution.inventoryservice.service.StockService;

@RestController
@RequestMapping("/stocks")
public class StockController {

	@Autowired
	StockService stockService;
	
	@GetMapping
	public ResponseEntity<List<Stock>> getAllStockDetails(){
		List<Stock> list = stockService.getAllStock();
		if(list.size() == 0) {
			return new ResponseEntity<List<Stock>>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Stock>>(list, HttpStatus.OK);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Stock> getStockById(@PathVariable int id){
		Optional<Stock> stockOptional = stockService.getStockById(id);
		if(stockOptional.isPresent()) {
			return new ResponseEntity<Stock>(stockOptional.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<Stock>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public void addStock(@RequestBody Stock stock) throws ProductNotFoundException {
		stockService.addStock(stock);
	}
	
	@PutMapping
	public void updateStock(@RequestBody Stock stock) throws ProductNotFoundException {
		stockService.updateStock(stock);
	}
	
	@DeleteMapping
	public void deleteStock(@PathVariable int id) {
		stockService.deleteStock(id);
	}
	
}
