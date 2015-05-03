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

package com.jeesoft.api.dto;

import java.util.Set;

/**
 * This class is to associates properties of UserRole.
 * 
 * @author Jeewantha Samaraweera
 * @since alpha
 */
public class UserRole extends BaseDomain {
    
    /** auto-serial no. */
    private static final long serialVersionUID = 1L;
    
    /**
     * Holds userRoleId.
     */
    private int userRoleId;
    
    /**
     * Holds role.
     */
    private String role;
    
    /**
     * Holds description.
     */
    private String description;
    
    /**
     * holds the status whether a user is System User role or not.
     */
    private boolean isSystemRole;
    
    /**
     * Holds roleTabs related to this UserRole.
     */
    private Set<RoleTab> roleTabs;
    
    /**
     * @return the userRoleId
     */
    public int getUserRoleId() {

        return userRoleId;
    }
    
    /**
     * @param intUserRoleId the userRoleId to set
     */
    public void setUserRoleId(int intUserRoleId) {

        this.userRoleId = intUserRoleId;
    }
    
    /**
     * @return the isSystemRole
     */
    public boolean getIsSystemRole() {

        return isSystemRole;
    }
    
    /**
     * @param isSystemRoleVal the isSystemRole to set
     */
    public void setIsSystemRole(boolean isSystemRoleVal) {

        this.isSystemRole = isSystemRoleVal;
    }
    
    /**
     * @return the role
     */
    public String getRole() {

        return role;
    }
    
    /**
     * set the userRole of the userRole.
     * 
     * @param strRole the role to set
     */
    public void setRole(String strRole) {

        this.role = strRole;
    }
    
    /**
     * get the userLoginId of the userRole.
     * 
     * @return the Description
     */
    public String getDescription() {

        return description;
    }
    
    /**
     * set the Description of the userRole.
     * 
     * @param strDescription the description to set
     */
    public void setDescription(String strDescription) {

        this.description = strDescription;
    }
    
    /**
     * get the RoleTabs of the userRole.
     * 
     * @return the RoleTabSet
     */
    public Set<RoleTab> getRoleTabs() {

        return roleTabs;
    }
    
    /**
     * set the RoleTabs of this userRole.
     * 
     * @param roleTabSet the description to set
     */
    public void setRoleTabs(Set<RoleTab> roleTabSet) {

        this.roleTabs = roleTabSet;
    }
    
    /**
     * overridden toString method to represent the UserRole object.
     * 
     * @return String representation of the UserRole.
     */
    @Override
    public String toString() {

        return getRole();
    }
    
}
