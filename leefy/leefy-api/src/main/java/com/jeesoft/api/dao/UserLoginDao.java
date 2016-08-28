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

import java.util.List;

import com.jeesoft.api.dao.BaseDao;
import com.jeesoft.api.dto.UserLogin;
import com.jeesoft.common.exception.LeefyAppException;


/**
 * This interface provides persistence layer functionality for the UserLogin object.
 * 
 * @author Jeewantha Samaraweera
 */
public interface UserLoginDao extends BaseDao<UserLogin> {
    
    /**
     * Retrieve the user login by passing the user's username.This returns any user with the user name passed.
     * 
     * @param userName - String
     * @return UserLogin object.
     * @throws LeefyAppException throws when fails to process.
     */
    UserLogin getAnyUserByName(String userName) throws LeefyAppException;
    
    /**
     * Retrieve the user login by passing the user's email. This returns any user with the email passed.
     * 
     * @param email - String
     * @return UserLogin object.
     * @throws LeefyAppException throws when fails to process.
     */
    UserLogin getAnyUserByEmail(String email) throws LeefyAppException;
    
    /**
     * Get the user with provided username or email address.
     * 
     * @param username the username provided
     * @param email the email provided
     * @return If no users found, will return an empty list.
     * @throws LeefyAppException throws when fails to process.
     */
    List<UserLogin> getAnyUsersByUsernameOrEmail(String username, String email) throws LeefyAppException;
    
    /**
     * Retrieve the user login by passing the user's username.
     * 
     * @param userName - String
     * @return UserLogin object.
     * @throws LeefyAppException throws when fails to process.
     */
    UserLogin getUserLoginByName(String userName) throws LeefyAppException;
    
    /**
     * search system user by user name.
     * 
     * @param userLogin - UserLogin
     * @return {@link List} list of user login objects.
     * @throws LeefyAppException when fails.
     */
    List<UserLogin> searchSystemUserByUserName(UserLogin userLogin) throws LeefyAppException;
    
    /**
     * search system user by user name and role.
     * 
     * @param userLogin - UserLogin
     * @return {@link List} list of user login objects.
     * @throws LeefyAppException when fails.
     */
    List<UserLogin> searchSystemUserByUserNameAndRole(UserLogin userLogin) throws LeefyAppException;
    
    /**
     * Retrieve all the available list of UserLogin by user role.
     * 
     * @param userRoleIdList - list of role id
     * @return list of UserLogin.
     * @throws LeefyAppException - throw detailed exception.
     */
    List<UserLogin> getUserLoginListByUserRole(List<Integer> userRoleIdList) throws LeefyAppException;
    
    /**
     * Check if the username or email exist.
     * 
     * @param username - the username to be checked.
     * @param email - the email to be checked.
     * @return
     * @throws LeefyAppException - throws detailed exception if fails.
     */
    Boolean isUsernameOrEmailExist(String username, String email) throws LeefyAppException;
}
