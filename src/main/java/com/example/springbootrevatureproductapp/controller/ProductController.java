package com.example.springbootrevatureproductapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrevatureproductapp.model.Product;
import com.example.springbootrevatureproductapp.service.ProductService;

@RestController
@RequestMapping("product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	
	@Autowired
	ProductService productServ;
	
	
//	
//	Get Methods
//	
	@GetMapping()
	public List<Product> getProducts(@RequestParam(required = false) String productName){
		if(productName == null) {
			return productServ.getProducts();			
		} else {
			return productServ.getProductByName(productName);
		}
				
	}
	
	@GetMapping("{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable("productId") int productId) {
		
		if(productServ.isProductExist(productId)) {
			return new ResponseEntity<>(productServ.getProduct(productId), HttpStatus.FOUND);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/searchProductName/{productName}")
	public List<Product> getProductByName(@PathVariable("productName") String productName){
		return productServ.getProductByName(productName);
	}
	
	@GetMapping("/searchByPrice")
	public List<Product> getProductByPriceRange(@RequestParam int min, int max){
		return productServ.getProductByPriceRange(min, max);
	}
	
	@GetMapping("searchProductNameAndPrice")
	public List<Product> getProductBybNameAndPrice(@RequestParam String productName, int min, int max){
		return productServ.getProductByNameAndPriceRange(productName, min, max);
	}
	
	@GetMapping("searchProductNamePriceQuantity")
	public List<Product> getProductByNamePriceQuantity(@RequestParam String productName, int min, int max, int quantity){
		return productServ.getByNamePriceAndQuantity(productName, min, max, quantity);
	}
	
	
	
	
//	
//	Save and update Methods
//	
	@PostMapping()
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {
		
		if(productServ.isProductExist(product.getProductId())) {
			return new ResponseEntity<>("Product with id: " + product.getProductId() + " already exists", HttpStatus.CONFLICT);
		} else {
			productServ.addProduct(product);
			return new ResponseEntity<>("Product has been added successfully", HttpStatus.CREATED);
		}
	}
	
	@PutMapping()
	public ResponseEntity<String> updateProduct(@RequestBody Product product) {
		if(productServ.isProductExist(product.getProductId())) {
			productServ.updateProduct(product);
			return new ResponseEntity<>("Product with id: " + product.getProductId() + " was updated", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Product with id: " + product.getProductId() + " was not found", HttpStatus.NO_CONTENT);
		}
	}
	
	
	
	
	
//	
//	Delete method
//	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") int productId){
		if(productServ.isProductExist(productId)) {
			productServ.deleteProduct(productId);
			return new ResponseEntity<>("product was deleted successfully", HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>("Product with product id: " + productId + " does not exist", HttpStatus.OK);
		}
	}

}
