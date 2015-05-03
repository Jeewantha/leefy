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
package com.jeesoft.web.dao;

import java.util.List;

import com.jeesoft.api.dao.BaseDaoImpl;
import com.jeesoft.api.dto.UserLogin;

/**
 * Implementation for UserDao.
 * 
 * @author Jeewantha Samaraweera
 */
public class UserDaoImpl extends BaseDaoImpl<UserLogin> implements UserDao {


    /** String Constant for holding respective query name. */
    private static final String GET_USER_BY_NAME = "getUserByName";

    /** String Constant for holding respective query name. */
    private static final String GET_ANY_USER_BY_NAME = "getAnyUserByName";


    /**
     * Method is to retrieve UserLogin for given userName.
     *
     * @param userName - userName
     * @return userLogin for respective userName.
     */
    @SuppressWarnings("unchecked")
    public UserLogin getUserLoginByName(String userName){

    List<UserLogin> userLoginList =
        (List<UserLogin>) getHibernateTemplate().findByNamedQuery(GET_USER_BY_NAME,
	        new Object[] { userName});

    UserLogin userLogin = null;

    if(!userLoginList.isEmpty()){
        userLogin = userLoginList.get(0);
        currentSession().update(userLogin);
    }
    return userLogin;
    }
    
    /**
     * Method is to retrieve any UserLogin for given userName.
     *
     * @param userName - userName
     * @return userLogin for respective userName.
     */
    @SuppressWarnings("unchecked")
    public UserLogin getAnyUserLoginByName(String userName){
        
        List<UserLogin> userLoginList =
            (List<UserLogin>) getHibernateTemplate().findByNamedQuery(GET_ANY_USER_BY_NAME,
		        new Object[] { userName});
        
        UserLogin userLogin = null;
        
        if(!userLoginList.isEmpty()){
            userLogin = userLoginList.get(0);
            currentSession().update(userLogin);
        }
        return userLogin;
    }



}
