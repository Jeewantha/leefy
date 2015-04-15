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
