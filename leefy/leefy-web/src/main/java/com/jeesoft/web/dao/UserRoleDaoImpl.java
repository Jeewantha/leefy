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

import org.springframework.dao.DataAccessException;

import com.jeesoft.api.dao.BaseDaoImpl;
import com.jeesoft.api.dto.UserRole;
import com.jeesoft.common.constants.LeefyConstant;
import com.jeesoft.common.exception.LeefyAppException;

/**
 * Implementation for UserRoleDao.
 * 
 * @author Jeewantha Samaraweera
 */
public class UserRoleDaoImpl extends BaseDaoImpl<UserRole> implements UserRoleDao {
    
    /** String constant for holding respective query name. */
    private static final String GET_USER_ROLE_BY_ROLE_NAME = "getUserRoleByRoleName";
    
    /**
     * Retrieve user role role with the rolename.
     * 
     * @param role The user role name of the user role.
     * @return userRole the user with the user role name "role".
     * @throws LeefyAppException SMS Exceptions.
     */
    @SuppressWarnings("unchecked")
    public UserRole getUserRoleByRoleName(String role) throws LeefyAppException {

        List<UserRole> userRoleList = null;
        UserRole userRole = null;
        
        try {
            userRoleList = (List<UserRole>) getHibernateTemplate().findByNamedQuery(GET_USER_ROLE_BY_ROLE_NAME, role);
            if (userRoleList != null && !userRoleList.isEmpty()) {
                userRole = userRoleList.get(0);
            }
        } catch (DataAccessException e) {
            throw new LeefyAppException(LeefyConstant.HIBERNATE_INVALID_ADD_OPERATION, e);
        }
        
        return userRole;
    }
}
