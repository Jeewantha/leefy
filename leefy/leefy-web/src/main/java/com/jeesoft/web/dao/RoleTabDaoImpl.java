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

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;

import com.jeesoft.api.dao.BaseDaoImpl;
import com.jeesoft.api.dto.RoleTab;
import com.jeesoft.api.dto.Tab;
import com.jeesoft.api.dto.UserRole;
import com.jeesoft.common.constants.LeefyConstant;
import com.jeesoft.common.exception.LeefyAppException;

/**
 * This class provides persistence layer functionality for the RoleTab object.
 * 
 * @author Jeewantha Samaraweera
 */
public class RoleTabDaoImpl extends BaseDaoImpl<RoleTab> implements RoleTabDao {
    
    /** The constant for String "getRoleTabsByUserRole". */
    private static final String GET_ROLE_TABS_BY_USER_ROLE = "getRoleTabsByUserRole";
    
    /** The constant for String "getRoleTabsByUserRole". */
    private static final String GET_TABS_BY_USER_ROLE = "getTabsByUserRole";
    
    /**
     * Logger to log the exceptions.
     */
    private static final Logger LOG = Logger.getLogger(RoleTabDaoImpl.class);
    
    /**
     * Delete Roletabs by role.
     * 
     * @param userRole - userRole of the records.
     * @throws LeefyAppException - The exception details that occurred when deleting the RoleTabs By user
     *         Role.
     */
    public void deleteRoleTabsByUserRole(UserRole userRole) throws LeefyAppException {

        try {
            
            getHibernateTemplate().deleteAll(getRoleTabsByUserRole(userRole));
            
        } catch (DataAccessException e) {
            LOG.error(LeefyConstant.ERROR_OCCURED_WHILE_SEARCHING_THE_OBJECT + e.toString());
            throw new LeefyAppException(LeefyConstant.DB_CONNECTION_ERROR, e);
        }
        
    }
    
    /**
     * get tabs by role.
     * 
     * @param userRole - userRole of the records.
     * @return list of tabs.
     * @throws LeefyAppException - The exception details that occurred when deleting the RoleTabs By user
     *         Role.
     */
    @SuppressWarnings("unchecked")
    public List<RoleTab> getRoleTabsByUserRole(UserRole userRole) throws LeefyAppException {

        try {
            
            return (List<RoleTab>) getHibernateTemplate().findByNamedQuery(GET_ROLE_TABS_BY_USER_ROLE, userRole);
            
        } catch (DataAccessException e) {
            LOG.error(LeefyConstant.ERROR_OCCURED_WHILE_SEARCHING_THE_OBJECT + e.toString());
            throw new LeefyAppException(LeefyConstant.DB_CONNECTION_ERROR, e);
        }
    }
    
    /**
     * get Tabs by role.
     * 
     * @param userRole - userRole of the records.
     * @return list of tabs.
     * @throws LeefyAppException - The exception details that occurred when deleting the RolePrivileges By
     *         user Role.
     */
    @SuppressWarnings("unchecked")
    public List<Tab> getTabsByUserRole(UserRole userRole) throws LeefyAppException {

        try {
            
            return (List<Tab>) getHibernateTemplate().findByNamedQuery(GET_TABS_BY_USER_ROLE, userRole);
            
        } catch (DataAccessException e) {
            LOG.error(LeefyConstant.ERROR_OCCURED_WHILE_SEARCHING_THE_OBJECT + e.toString());
            throw new LeefyAppException(LeefyConstant.DB_CONNECTION_ERROR, e);
        }
    }
}
