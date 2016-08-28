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

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;

import com.jeesoft.api.dao.BaseDaoImpl;
import com.jeesoft.api.dto.Privilege;
import com.jeesoft.api.dto.PrivilegeDependency;
import com.jeesoft.api.dto.Tab;
import com.jeesoft.common.constants.LeefyConstants;
import com.jeesoft.common.exception.LeefyAppException;

/**
 * This class provides persistence layer functionality for the PrivilegeDependency object.
 * 
 * @author Jeewantha Samaraweera
 */
public class PrivilegeDependencyDaoImpl extends BaseDaoImpl<PrivilegeDependency> implements PrivilegeDependencyDao {
    
    /** string constant for hold `privilegeIdList`. */
    private static final String PRIVILEGE_ID_LIST = "privilegeIdList";
    
    /**
     * Logger to log the exceptions.
     */
    private static final Logger LOG = Logger.getLogger(RoleTabDaoImpl.class);
    
    /** The constant for String "getDependenciesList". */
    private static final String GET_DEPENDENCIES_LIST = "getDependenciesList";
    
    /** The constant for String "getDependenciesTabList". */
    private static final String GET_DEPENDENCIES_TAB_LIST = "getDependenciesTabList";
    
    /**
     * get Dependencies privilege ID list.
     * 
     * @param privilegeIdList - privilege IDs list.
     * @return list of dependencies IDs.
     * @throws LeefyAppException when fails.
     */
    @SuppressWarnings("unchecked")
    public List<Privilege> getDependenciesList(List<Integer> privilegeIdList) throws LeefyAppException {

        try {
            
            return (List<Privilege>) getHibernateTemplate().findByNamedQueryAndNamedParam(GET_DEPENDENCIES_LIST,
                    new String[] { PRIVILEGE_ID_LIST }, new Object[] { privilegeIdList });
            
        } catch (DataAccessException e) {
            LOG.error(LeefyConstants.ERROR_OCCURED_WHILE_SEARCHING_THE_OBJECT + e.toString());
            throw new LeefyAppException(LeefyConstants.DB_CONNECTION_ERROR, e);
        }
    }
    
    /**
     * get Dependencies tab ID list.
     * 
     * @param privilegeIdList - privilege IDs list.
     * @return list of dependencies IDs.
     * @throws LeefyAppException when fails.
     */
    @SuppressWarnings("unchecked")
    public List<Tab> getDependenciesTabIdList(List<Integer> privilegeIdList) throws LeefyAppException {

        try {
            
            return (List<Tab>) getHibernateTemplate().findByNamedQueryAndNamedParam(GET_DEPENDENCIES_TAB_LIST,
                    new String[] { PRIVILEGE_ID_LIST }, new Object[] { privilegeIdList });
            
        } catch (DataAccessException e) {
            LOG.error(LeefyConstants.ERROR_OCCURED_WHILE_SEARCHING_THE_OBJECT + e.toString());
            throw new LeefyAppException(LeefyConstants.DB_CONNECTION_ERROR, e);
        }
    }
    
}
