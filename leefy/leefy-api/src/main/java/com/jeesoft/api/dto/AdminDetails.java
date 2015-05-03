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
 * Admin class to hold dynamic session attributes of a staff member.
 * 
 * @author Jeewantha Samaraweera
 * @since alpha
 */
public class AdminDetails extends UserInfo {

	/** String attribute for registration no. */
	private static final String REGISTRATION_NO = ", registrationNo=";

	/** String attribute for staff member id. */
	private static final String STAFF_MEMBER_ID = ", searchStaffMemberId=";

	/** String attribute for student id. */
	private static final String STUDENT_ID = "AdminDetails-->searchStudentId=";

	/** long attribute for holding serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** holds studentId return from student search. */
	private int searchStudentId;

	/** holds staffMemberId return from staff search. */
	private int searchStaffMemberId;

	/** holds the registrationNo of the staff member. */
	private String registrationNo;

	/**
	 * Instantiates a new admin details.
	 * 
	 * @param userName
	 *            the user name
	 * @param password
	 *            the password
	 * @param userRole
	 *            the user role
	 * @param userRoleIdval
	 *            - user userRoleId.
	 * @param registrationNoVal
	 *            the registration no val
	 * @param isActive
	 *            the is active
	 * @param accountNonLocked
	 *            the account non locked
	 * @param grantedAuthority
	 *            the granted authority
	 */
	public AdminDetails(final String userName, final String password, final String userRole, final int userRoleIdval,
			final String registrationNoVal, final boolean isActive, final boolean accountNonLocked,
			final List<GrantedAuthority> grantedAuthority) {

		super(userName, password, userRole, userRoleIdval, isActive, accountNonLocked, grantedAuthority);

		registrationNo = registrationNoVal;
	}

	/**
	 * Returns the details for the AdminDetails object.
	 * 
	 * @return - the AdminDetails object details.
	 */
	@Override
	public final String toString() {

		return STUDENT_ID + searchStudentId + STAFF_MEMBER_ID + searchStaffMemberId + REGISTRATION_NO + registrationNo;
	}

	/**
	 * return searchStudentId of the Student.
	 * 
	 * @return the searchStudentId
	 */
	public final int getSearchStudentId() {

		return searchStudentId;
	}

	/**
	 * Setter method for searchStudentId.
	 * 
	 * @param searchStudentIdVal
	 *            the searchStudentId to set
	 */
	public final void setSearchStudentId(final int searchStudentIdVal) {

		this.searchStudentId = searchStudentIdVal;
	}

	/**
	 * return searchStaffMemberId of the Student.
	 * 
	 * @return the searchStaffMemberId
	 */
	public final int getSearchStaffMemberId() {

		return searchStaffMemberId;
	}

	/**
	 * Setter method for searchStaffMemberId.
	 * 
	 * @param searchStaffMemberIdVal
	 *            the searchStaffMemberId to set
	 */
	public final void setSearchStaffMemberId(final int searchStaffMemberIdVal) {

		this.searchStaffMemberId = searchStaffMemberIdVal;
	}

	/**
	 * return registrationNo of the Student.
	 * 
	 * @return the registrationNo
	 */
	public final String getRegistrationNo() {

		return registrationNo;
	}

	/**
	 * Setter method for registrationNo.
	 * 
	 * @param registrationNoVal
	 *            the registrationNo to set
	 */
	public final void setRegistrationNo(final String registrationNoVal) {

		this.registrationNo = registrationNoVal;
	}

	/**
	 * method is to clear Student related dynamic attributes.
	 */
	@Override
	public final void clear() {

		searchStaffMemberId = 0;
		searchStudentId = 0;

	}

	/**
	 * registrationNo for the admin user.
	 * 
	 * @return registrationNo - registrationNo.
	 */
	@Override
	public final String getUserLevelIdentifier() {

		return registrationNo;
	}

}
