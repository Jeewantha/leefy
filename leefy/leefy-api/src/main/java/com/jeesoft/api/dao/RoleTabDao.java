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
import com.jeesoft.api.dto.RoleTab;
import com.jeesoft.api.dto.Tab;
import com.jeesoft.api.dto.UserRole;
import com.jeesoft.common.exception.LeefyAppException;

/**
 * This interface provides persistence layer functionality for the RoleTab domain object.
 * 
 * @author Jeewantha Samaraweera
 */
public interface RoleTabDao extends BaseDao<RoleTab> {
    
    /**
     * Delete Roletabs by role.
     * 
     * @param userRole - userRole of the records.
     * @throws LeefyAppException - The exception details that occurred when deleting the Roletabs By user
     *         Role.
     */
    void deleteRoleTabsByUserRole(UserRole userRole) throws LeefyAppException;
    
    /**
     * get Roletabs by role.
     * 
     * @param userRole - userRole of the records.
     * @return list of tabs.
     * @throws LeefyAppException - The exception details that occurred when deleting the RolePrivileges By
     *         user Role.
     */
    List<RoleTab> getRoleTabsByUserRole(UserRole userRole) throws LeefyAppException;

    /**
     * get Tabs by role.
     * 
     * @param userRole - userRole of the records.
     * @return list of tabs.
     * @throws LeefyAppException - The exception details that occurred when deleting the RolePrivileges By
     *         user Role.
     */
    List<Tab> getTabsByUserRole(UserRole userRole) throws LeefyAppException;
}
