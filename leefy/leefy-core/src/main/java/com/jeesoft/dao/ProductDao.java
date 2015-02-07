package com.jeesoft.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jeesoft.model.Product;

@Component
public class ProductDao {

	
	public Product getProduct(String id) {
		// Create some fake product and return
		Product product = new Product();
		product.setId(id);
		product.setName("MAC Book Air");
		product.setType("Electronics");
		return product;
	}

	public Product saveProduct(Product product) {
		// saved product
		product.setId("456");
		return product;
	}
	
	
	public List<Product> getAllProducts() {

		List<Product> products = new ArrayList<Product>();
		
		Product product = new Product();
		product.setName("MAC Book Air");
		product.setType("Electronics");
		products.add(product);
		return products;
	}
	

}
