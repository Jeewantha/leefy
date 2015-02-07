package com.jeesoft.services.impl;

import java.util.List;

import javax.ws.rs.core.HttpHeaders;

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

	public Product getProduct(HttpHeaders httpHeaders, String id) {

		String authenticationKey = null;
		
		if(httpHeaders != null){
			List<String> authHeader = httpHeaders.getRequestHeader("Authentication");
			authenticationKey = authHeader != null && !authHeader.isEmpty() ? authHeader.get(0) : null;
		}
		
		if(authenticationKey != null && !"".equals(authenticationKey)){
			
			System.out.println(authenticationKey);
		}
		
		logger.info("Getting the product with Id: " + id + "for user :"+username);
		
		return prodcutDao.getProduct(id);
	}

	public Product saveProduct(HttpHeaders httpHeaders, Product product) {
		return prodcutDao.saveProduct(product);

	}

	public String getUsername(HttpHeaders httpHeaders, String name) {
		String userStr = "User's username is: " + name + " ,Name is "
				+ username;
		System.out.println(userStr);
		return userStr;
	}

}
