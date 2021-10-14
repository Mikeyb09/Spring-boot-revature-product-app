package com.example.springbootrevatureproductapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootrevatureproductapp.model.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	public List<Product> findByProductName(String productName);
	public List<Product> findByPriceBetween(int low, int high);
	public List<Product> findByProductNameAndPriceBetween(String name, int low, int high);
	public List<Product> findByProductNameAndPriceBetweenAndQuantityOnHandGreaterThan(String productName, int low, int high, int quantity);
	
}
