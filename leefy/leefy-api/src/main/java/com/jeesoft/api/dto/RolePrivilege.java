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
/**
 * This class represents all properties of RolePrivilege domain object.
 * 
 * @author Jeewantha Samaraweera
 * @since alpha
 */
public class RolePrivilege extends BaseDomain {
    
    /** attribute for holding string. */
    private static final String PRIVILEGE_ID = ", privilegeId=";
    
    /** attribute for holding string. */
    private static final String ROLE_ID = ", roleId=";
    
    /** attribute for holding string. */
    private static final String ROLE_PRIVILEGE_ID = "rolePrivilegeId=";
    
    /**
     * serialVersionUID- final.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Represents the ID of a RolePrivilege.
     */
    private int rolePrivilegeId;
    
    /**
     * Represents the related user role of a RolePrivilege.
     */
    private UserRole role;
    
    /**
     * Represents the related privilege object of a RolePrivilege.
     */
    private Privilege privilege;
    
    /**
     * Default constructor.
     */
    public RolePrivilege() {

    }
    
    /**
     * Returns the ID of the RolePrivilege object.
     * 
     * @return - the ID of the RolePrivilege.
     */
    public final int getRolePrivilegeId() {

        return rolePrivilegeId;
    }
    
    /**
     * Sets the ID for this RolePrivilege with a given key.
     * 
     * @param rolePrivilegeIdObj - the ID of the RolePrivilege.
     */
    public final void setRolePrivilegeId(final int rolePrivilegeIdObj) {

        this.rolePrivilegeId = rolePrivilegeIdObj;
    }
    
    /**
     * Returns the related role of the RolePrivilege object.
     * 
     * @return - the related role of the RolePrivilege.
     */
    public final UserRole getRole() {

        return role;
    }
    
    /**
     * Sets the related user role for this RolePrivilege.
     * 
     * @param roleobj - the related user role of the RolePrivilege.
     */
    public final void setRole(final UserRole roleobj) {

        this.role = roleobj;
    }
    
    /**
     * Returns the related privilege of the RolePrivilege object.
     * 
     * @return - the related privilege of the RolePrivilege.
     */
    public final Privilege getPrivilege() {

        return privilege;
    }
    
    /**
     * Sets the related privilege object for this RolePrivilege.
     * 
     * @param privilegeObj - the related privilege object of the RolePrivilege.
     */
    public final void setPrivilege(final Privilege privilegeObj) {

        this.privilege = privilegeObj;
    }
    
    /**
     * Returns a string representation of the object.
     * 
     * @return - the current object details.
     */
    @Override
	public final String toString() {

        return ROLE_PRIVILEGE_ID + rolePrivilegeId + ROLE_ID + role.getUserRoleId() + PRIVILEGE_ID
                + privilege.getPrivilegeId();
    }
    
}
