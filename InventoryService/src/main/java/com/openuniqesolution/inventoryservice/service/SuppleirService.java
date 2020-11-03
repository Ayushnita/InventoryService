package com.openuniqesolution.inventoryservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openuniqesolution.inventoryservice.model.Supplier;
import com.openuniqesolution.inventoryservice.repo.SupplierRepository;

@Service
public class SuppleirService {

	@Autowired
	SupplierRepository supplierRepo;
	
	public List<Supplier> getAllSupplier() {
		return supplierRepo.findAll();
	}

	public void addSupplier(Supplier supplier) {
		supplierRepo.save(supplier);
	}

	public void updateSupplier(Supplier supplier) {
		supplierRepo.save(supplier);
	}

	public void deleteSupplier(int id) {
		supplierRepo.deleteById(id);
	}

}
