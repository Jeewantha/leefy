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
 * Admin class to hold dynamic session attributes of a student member.
 * 
 * @author Jeewantha Samaraweera
 * @since alpha
 */
public class StudentDetails extends UserInfo {
    
    /** long attribute for holding serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** key to hold string admissionNo. */
    private static final String ADMISSION_NO = "admissionNo=";
    
    /** holds the admissionNo of the Student. */
    private String admissionNo;
    
    /**
     * StudentDetails Constructor.
     * 
     * @param userName - userName of the student.
     * @param password - password of the student.
     * @param userRole - password of the student.
     * @param userRoleIdval - user userRoleId.
     * @param admissionNoVal - password of the student.
     * @param isActive - password of the student.
     * @param accountNonLocked - whether account is lock.
     * @param grantedAuthority - List of user roles.
     */
    public StudentDetails(String userName, String password, String userRole, int userRoleIdval, String admissionNoVal,
            boolean isActive, boolean accountNonLocked, List<GrantedAuthority> grantedAuthority) {

        super(userName, password, userRole, userRoleIdval, isActive, accountNonLocked, grantedAuthority);
        
        admissionNo = admissionNoVal;
        
    }
    
    /**
     * return admissionNo of the Student.
     * 
     * @return the admissionNo
     */
    public String getAdmissionNo() {

        return admissionNo;
    }
    
    /**
     * set admissionNo of the student.
     * 
     * @param admissionNoVal the admissionNo to set
     */
    public void setAdmissionNo(String admissionNoVal) {

        this.admissionNo = admissionNoVal;
    }
    
    /**
     * method is to clear Student related dynamic attributes.
     */
    @Override
    public void clear() {

    }
    
    /**
     * admission No for the Student.
     * 
     * @return admissionNo - admissionNo.
     */
    @Override
    public String getUserLevelIdentifier() {

        return admissionNo;
    }
    
    /**
     * Returns a string representation of the object.
     * 
     * @return - the current object details.
     */
    @Override
    public String toString() {

        return ADMISSION_NO + this.admissionNo;
    }
    
}
