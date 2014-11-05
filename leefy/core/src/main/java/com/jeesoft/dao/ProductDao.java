package com.jeesoft.dao;

import com.jeesoft.model.Product;


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
	
	

}
