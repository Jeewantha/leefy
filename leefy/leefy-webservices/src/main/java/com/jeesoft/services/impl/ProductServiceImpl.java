/*******************************************************************************
 * 	
 * 	Leefy is a simple social network to narrow the gap between people speaking different
 * 	languages and to aid the language learning process.
 *     Copyright (C) 2015  Jeewantha Samaraweera
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *     
 *******************************************************************************/
package com.jeesoft.services.impl;

import java.util.List;

import javax.ws.rs.core.HttpHeaders;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeesoft.api.dao.ProductDao;
import com.jeesoft.api.dto.Product;
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

	@Override
	public List<Product> getAllProducts(HttpHeaders httpHeaders) {

		logger.info("Getting the all products");
		
		return prodcutDao.getAllProducts();
	}

}
