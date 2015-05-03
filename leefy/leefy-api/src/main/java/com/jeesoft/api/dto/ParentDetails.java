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

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

/**
 * Parent class to hold dynamic session attributes of a Parent role.
 * 
 * @author Jeewantha Samaraweera
 * @since alpha
 */
public class ParentDetails extends UserInfo {
    
    /** long attribute for holding serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** holds the admissionNo of the Student. */
    private String nicNo;
    
    /**
     * ParentDetail Constructor.
     * 
     * @param userName - userName of the parent.
     * @param password - password of the parent.
     * @param userRole - role of the parent.
     * @param userRoleIdval - user userRoleId of the parent.
     * @param nicNoArg - NIC number of the parent.
     * @param isActive - activation status of the parent.
     * @param accountNonLocked - whether account is lock.
     * @param grantedAuthority - List of user roles.
     */
    public ParentDetails(String userName, String password, String userRole, int userRoleIdval, String nicNoArg,
            boolean isActive, boolean accountNonLocked, List<GrantedAuthority> grantedAuthority) {

        super(userName, password, userRole, userRoleIdval, isActive, accountNonLocked, grantedAuthority);
        
        nicNo = nicNoArg;
        
    }
    
    /**
     * method is to clear Parent related dynamic attributes.
     */
    @Override
    public void clear() {

    }
    
    /**
     * NIC No for the Student.
     * 
     * @return NIC No.
     */
    @Override
    public String getUserLevelIdentifier() {

        return nicNo;
    }
    
    /**
     * return NIC no of the Parent.
     * 
     * @return the NIC number
     */
    public String getNicNo() {

        return nicNo;
    }
    
    /**
     * set NIC no of the parent.
     * 
     * @param nicNoArg the NIC no to set
     */
    public void setNicNo(String nicNoArg) {

        this.nicNo = nicNoArg;
    }
    
    /**
     * Returns a string representation of the object.
     * 
     * @return - the current object details.
     */
    @Override
    public String toString() {

        return "ParentDetails [nicNo=" + nicNo + "]";
    }
    
}
