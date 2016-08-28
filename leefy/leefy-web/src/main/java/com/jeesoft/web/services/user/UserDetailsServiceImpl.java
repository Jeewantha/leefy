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

package com.jeesoft.web.services.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.jeesoft.api.dao.UserDao;
import com.jeesoft.api.dto.UserLogin;
import com.jeesoft.common.exception.LeefyAppException;


/**
 * UserDetailService implementation for user authentication.
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    
    /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    
    /** string constant for holding error massage user not found. */
    private static final String USER_NOT_FOUND = "user not found";
    
    /** holds userDao for the UserDetailService. */
    private UserDao userDao;
    
    /** holds userService for the UserDetailService. */
    private UserService userService;
    
    /**
     * Sets an instance of setUserService.
     * 
     * @param userServiceObj object to set
     */
    public void setUserService(UserService userServiceObj) {

        this.userService = userServiceObj;
    }
    
    /**
     * Method is to load the user by name.
     * Will return null if 
     * 
     * @param userName - userName.
     * @return UserDetail for respective userName.
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userName) {

        UserLogin userLogin = userDao.getAnyUserLoginByName(userName);
        if (userLogin == null) {
            throw new UsernameNotFoundException(USER_NOT_FOUND);
        }
        try {
            return userService.buildUserFromUserEntity(userLogin);
        } catch (LeefyAppException exception) {
            logger.error("User authentication failed. Please login again.", exception);
            return null;
        }
    }
    
    /**
     * set User Dao for the UserDetailsService.
     * 
     * @param userDaoVal the userDao to set
     */
    public void setUserDao(UserDao userDaoVal) {

        this.userDao = userDaoVal;
    }
    
}
