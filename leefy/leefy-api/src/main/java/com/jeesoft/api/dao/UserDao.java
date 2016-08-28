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

import com.jeesoft.api.dao.BaseDao;
import com.jeesoft.api.dto.UserLogin;


/**
 * This interface provides persistence layer functionality for the User object.
 *
 * @author Jeewantha Samaraweera
 */
public interface UserDao  extends BaseDao<UserLogin> {

    /**
     * Method is to retrieve UserLogin for given userName.
     *
     * @param userName - userName
     * @return userLogin for respective userName.
     */
    UserLogin getUserLoginByName(String userName);

    /**
     * Method is to retrieve any UserLogin for given userName.
     *
     * @param userName - userName
     * @return userLogin for respective userName.
     */
    UserLogin getAnyUserLoginByName(String userName);

}
