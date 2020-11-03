package com.openuniqesolution.inventoryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.openuniqesolution.inventoryservice.model.Supplier;
import com.openuniqesolution.inventoryservice.service.SuppleirService;

@RestController
@RequestMapping("/suppliers")
@Secured("ROLE_ADMIN")
public class SupplierController {

	@Autowired
	SuppleirService supplierService;
	
	
	@GetMapping
	public ResponseEntity<List<Supplier>> getAllSuppliers(){
		List<Supplier> list = supplierService.getAllSupplier();
		if(list.size() == 0) {
			return new ResponseEntity<List<Supplier>>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Supplier>>(list,HttpStatus.OK);
		}
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addSupplier(@RequestBody Supplier supplier) {
		supplierService.addSupplier(supplier);
	}
	
	@PutMapping
	@ResponseStatus
	@Secured("ROLE_SUPPLIER")
	public void updateSupplier(@RequestBody Supplier supplier) {
		supplierService.updateSupplier(supplier);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteSupplier(@PathVariable int id) {
		supplierService.deleteSupplier(id);
	}
}
