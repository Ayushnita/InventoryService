package com.openuniqesolution.inventoryservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openuniqesolution.inventoryservice.exception.ProductNotFoundException;
import com.openuniqesolution.inventoryservice.model.Stock;
import com.openuniqesolution.inventoryservice.repo.StockRepository;

@Service
public class StockService {

	@Autowired
	StockRepository stockRepo;
	
	@Autowired
	ProductService prodService;
	
	public List<Stock> getAllStock() {
		return stockRepo.findAll();
	}

	public Optional<Stock> getStockById(int id) {
		return stockRepo.findById(id);
	}

	public void addStock(Stock stock) throws ProductNotFoundException {
		if(!prodService.exist(stock.getProductId()))
			throw new ProductNotFoundException();
		stockRepo.save(stock);
	}

	public void updateStock(Stock stock) throws ProductNotFoundException {
		if(!prodService.exist(stock.getProductId()))
			throw new ProductNotFoundException();
		stockRepo.save(stock);
	}

	public void deleteStock(int id) {
		stockRepo.deleteById(id);
	}

}
