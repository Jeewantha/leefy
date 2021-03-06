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
package com.jeesoft.web.service;

import com.jeesoft.common.exception.LeefyAppException;
import com.jeesoft.web.services.user.UserService;


/**
 * The Interface GuestUserServices.
 */
public interface GuestUserServices extends UserService{

    /**
     * Checks if a user exists with the provided username.
     * 
     * @param username the provided username
     * @return true if user exist
     * @throws LeefyAppException when fails to process
     */
    boolean isUsernameExist(String username) throws LeefyAppException;
    
    /**
     * Checks if a user exists with the provided email.
     * 
     * @param email the provided email 
     * @return true if user exist
     * @throws LeefyAppException when fails to process
     */
    boolean isEmailExist(String email) throws LeefyAppException;
}
