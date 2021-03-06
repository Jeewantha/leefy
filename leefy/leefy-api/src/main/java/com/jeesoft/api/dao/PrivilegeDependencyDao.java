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
import com.jeesoft.api.dto.Privilege;
import com.jeesoft.api.dto.PrivilegeDependency;
import com.jeesoft.api.dto.Tab;
import com.jeesoft.common.exception.LeefyAppException;

/**
 * This interface provides persistence layer functionality for the PrivilegeDependency domain object.
 * 
 * @author Jeewantha Samaraweera
 */
public interface PrivilegeDependencyDao extends BaseDao<PrivilegeDependency> {
    
    /**
     * get Dependencies privilege ID list.
     * 
     * @param privilegeIdList - privilege IDs list.
     * @return list of dependencies IDs.
     * @throws LeefyAppException when fails.
     */
    List<Privilege> getDependenciesList(List<Integer> privilegeIdList) throws LeefyAppException;
    
    /**
     * get Dependencies tab ID list.
     * 
     * @param privilegeIdList - privilege IDs list.
     * @return list of dependencies IDs.
     * @throws LeefyAppException when fails.
     */
    List<Tab> getDependenciesTabIdList(List<Integer> privilegeIdList) throws LeefyAppException;
}
