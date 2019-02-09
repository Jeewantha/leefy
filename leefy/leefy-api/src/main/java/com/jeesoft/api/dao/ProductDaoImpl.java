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
package com.jeesoft.api.dao;

import java.util.ArrayList;
import java.util.List;

import com.jeesoft.api.dto.Product;

/**
 * Implementation for ProductDao
 * 
 * @author Jeewantha Samaraweera
 */
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {

	/**
	 * Gets the product.
	 *
	 * @param id
	 *            the id
	 * @return the product
	 */
	public Product getProduct(final String id) {
		// Create some fake product and return
		Product product = new Product();
		product.setId(id);
		product.setName("MAC Book Air");
		product.setType("Electronics");
		return product;
	}

	/**
	 * Save product.
	 *
	 * @param product
	 *            the product
	 * @return the product
	 */
	public Product saveProduct(final Product product) {
		// saved product
		product.setId("456");
		return product;
	}

	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 */
	public final List<Product> getAllProducts() {

		List<Product> products = new ArrayList<Product>();

		Product product = new Product();
		product.setName("MAC Book Air");
		product.setType("Electronics");
		products.add(product);
		return products;
	}
	
	
/*    *//** String constant for holding respective query name. *//*
    private static final String GET_USER_ROLE_BY_ROLE_NAME = "getUserRoleByRoleName";

    *//**
     * {@inheritDoc}
     *//*
    @SuppressWarnings("unchecked")
    public UserRole getUserRoleByRoleName(String role) throws LeefyAppException {
        UserRole userRole = null;
        
        try {
            List<UserRole> userRoleList = (List<UserRole>) getHibernateTemplate().findByNamedQuery(GET_USER_ROLE_BY_ROLE_NAME, role);

            if (userRoleList != null && !userRoleList.isEmpty()) {
                userRole = userRoleList.get(0);
            }
        } catch (DataAccessException e) {
            throw new LeefyAppException(LeefyConstants.HIBERNATE_INVALID_ADD_OPERATION, e);
        }
        return userRole;
    }*/
}
