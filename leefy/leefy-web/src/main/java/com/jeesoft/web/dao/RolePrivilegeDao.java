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

import com.jeesoft.api.dao.BaseDao;
import com.jeesoft.api.dto.Privilege;
import com.jeesoft.api.dto.RolePrivilege;
import com.jeesoft.api.dto.UserRole;
import com.jeesoft.api.exception.LeefyAppException;

/**
 * This interface provides persistence layer functionality for the RolePrivilege domain object.
 * 
 * @author Jeewantha Samaraweera
 */
public interface RolePrivilegeDao extends BaseDao<RolePrivilege> {
    
    /**
     * Delete RolePrivileges by role.
     * 
     * @param userRole - userRole of the records.
     * @throws LeefyAppException - The exception details that occurred when deleting the RolePrivileges By
     *         user Role.
     */
    void deleteRolePrivilegesByUserRole(UserRole userRole) throws LeefyAppException;
    
    /**
     * get Privileges by role.
     * 
     * @param userRole - userRole of the records.
     * @return list of privileges.
     * @throws LeefyAppException - The exception details that occurred when deleting the RolePrivileges By
     *         user Role.
     */
    List<Privilege> getPrivilegesByUserRole(UserRole userRole) throws LeefyAppException;
    
    /**
     * get RolePrivileges by role.
     * 
     * @param userRole - userRole of the records.
     * @return list of privileges.
     * @throws LeefyAppException - The exception details that occurred when deleting the RolePrivileges By
     *         user Role.
     */
    List<RolePrivilege> getRolePrivilegesByUserRole(UserRole userRole) throws LeefyAppException;
}
