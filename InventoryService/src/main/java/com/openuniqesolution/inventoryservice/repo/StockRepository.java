package com.openuniqesolution.inventoryservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openuniqesolution.inventoryservice.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{

}
