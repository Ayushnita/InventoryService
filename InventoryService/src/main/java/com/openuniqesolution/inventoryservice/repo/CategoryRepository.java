package com.openuniqesolution.inventoryservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openuniqesolution.inventoryservice.model.ProductCategory;

@Repository
public interface CategoryRepository extends JpaRepository<ProductCategory, Integer>{

}
