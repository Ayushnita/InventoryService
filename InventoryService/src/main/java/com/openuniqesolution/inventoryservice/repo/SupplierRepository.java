package com.openuniqesolution.inventoryservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openuniqesolution.inventoryservice.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer>{
	
}
