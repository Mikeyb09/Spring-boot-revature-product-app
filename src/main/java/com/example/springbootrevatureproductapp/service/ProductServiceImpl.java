package com.example.springbootrevatureproductapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootrevatureproductapp.dao.ProductDao;
import com.example.springbootrevatureproductapp.model.Product;

@Service(value="serviceImplementation")
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;
	
	@Override
	@Transactional(timeout = 30000, propagation=Propagation.NEVER, isolation=Isolation.READ_COMMITTED)
	public void addProduct(Product product) {
		if(product.getPrice() > 0) {
			productDao.save(product);			
		}
	}

	@Override
	@Transactional(timeout = 30000, propagation=Propagation.NEVER, isolation=Isolation.READ_UNCOMMITTED)
	public void updateProduct(Product product) {
		if(product.getPrice() > 0) {
			productDao.save(product);			
		}
		
	}

	@Override
	@Transactional
	public List<Product> getProducts() {
		return productDao.findAll();		
	}

	@Override
	@Transactional
	public void deleteProduct(int productId) {
		productDao.deleteById(productId);		
	}

	@Override
	@Transactional
	public Product getProduct(int productId) {
		return productDao.findById(productId).get();
	}

	@Override
	@Transactional
	public boolean isProductExist(int productId) {
		return productDao.existsById(productId);
	}

	@Override
	@Transactional
	public List<Product> getProductByName(String productName) {
		return productDao.findByProductName(productName);
	}

	@Override
	@Transactional
	public List<Product> getProductByPriceRange(int lower, int upper) {
		return productDao.findByPriceBetween(lower, upper);
	}

	@Override
	public List<Product> getProductByNameAndPriceRange(String name, int lower, int upper) {
		return productDao.findByProductNameAndPriceBetween(name, lower, upper);
	}

	@Override
	public List<Product> getByNamePriceAndQuantity(String name, int lower, int upper, int quantity) {
		return productDao.findByProductNameAndPriceBetweenAndQuantityOnHandGreaterThan(name, lower, upper, quantity);
	}
	
	

}
