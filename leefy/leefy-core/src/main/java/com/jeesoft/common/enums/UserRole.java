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

package com.jeesoft.common.enums;

/**
 * This represents the enum file which defines user roles.
 * 
 * @author Jeewantha Samaraweera
 * @since alpha
 */
public enum UserRole {
    
    /** User role is ROLE_ADMIN and user role id is 1. */
    ROLE_ADMIN(1),
    /** User role is ROLE_TEACHER and user role id is 2. */
    ROLE_TEACHER(2),
    /** User role is ROLE_STUDENT and user role id is 3. */
    ROLE_STUDENT(3),
    /** User role is ROLE_CLERICALSTAFF and user role id is 4. */
    ROLE_CLERICALSTAFF(4),
    /** User role is ROLE_PARENT and user role id is 5. */
    ROLE_PARENT(5);
    
    /** Holds user role id. */
    private int userRoleId;
    
    /**
     * Enum constructor with parameter user role id.
     * 
     * @param intUserRoleId - type integer.
     */
    UserRole(int intUserRoleId) {
    
        this.userRoleId = intUserRoleId;
    }
    
    /**
     * Get the userRoleId.
     * 
     * @return userRoleId.
     */
    public int getUserRoleId() {
    
        return userRoleId;
    }
    
}
