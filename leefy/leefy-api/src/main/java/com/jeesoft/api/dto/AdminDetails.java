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

    private static final long serialVersionUID = 4096144989138566319L;

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
			final boolean isActive, final boolean accountNonLocked,
			final List<GrantedAuthority> grantedAuthority) {

		super(userName, password, userRole, userRoleIdval, isActive, accountNonLocked, grantedAuthority);
	}
}
