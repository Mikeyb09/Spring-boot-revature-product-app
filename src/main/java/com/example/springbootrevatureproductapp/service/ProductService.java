package com.example.springbootrevatureproductapp.service;

import java.util.List;

import com.example.springbootrevatureproductapp.model.Product;

public interface ProductService {
	
	public void addProduct(Product product);
	public void updateProduct(Product product);
	public List<Product> getProducts();
	public void deleteProduct(int productId);
	public Product getProduct(int productId);
	public boolean isProductExist(int productId);
	public List<Product> getProductByName(String productName);
	public List<Product> getProductByPriceRange(int lower, int upper);
	public List<Product> getProductByNameAndPriceRange(String name, int lower, int upper);
	public List<Product> getByNamePriceAndQuantity(String name, int lower, int upper, int quantity);

}
