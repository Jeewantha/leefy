package com.jeesoft.services.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeesoft.dao.ProductDao;
import com.jeesoft.model.Product;
import com.jeesoft.services.ProductService;

public class ProductServiceImpl implements ProductService {

	Logger logger = Logger.getLogger(ProductServiceImpl.class);
	@Autowired
	ProductDao prodcutDao;

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Product getProduct(String id) {

		logger.info("Getting the product with Id: " + id + "for user :"+username);
		
		return prodcutDao.getProduct(id);
	}

	public Product saveProduct(Product product) {
		return prodcutDao.saveProduct(product);

	}

	public String getUsername(String name) {
		String userStr = "User's username is: " + name + " ,Name is "
				+ username;
		System.out.println(userStr);
		return userStr;
	}

}
