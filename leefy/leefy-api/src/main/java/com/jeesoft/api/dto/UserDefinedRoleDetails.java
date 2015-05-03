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
 * UserDefinedRoleDetails class to hold dynamic session attributes of a user
 * defined role.
 * 
 * @author Jeewantha Samaraweera
 * @since alpha
 */
public class UserDefinedRoleDetails extends UserInfo {

	/** long attribute for holding serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * UserDefinedRoleDetails Constructor.
	 * 
	 * @param userName
	 *            - userName of the user defined role.
	 * @param password
	 *            - password of the user defined role.
	 * @param userRole
	 *            - role of the user defined role.
	 * @param userRoleIdval
	 *            - user userRoleId of the user defined role.
	 * @param isActive
	 *            - activation status of the user defined role.
	 * @param accountNonLocked
	 *            - whether account is lock.
	 * @param grantedAuthority
	 *            - List of user roles.
	 */
	public UserDefinedRoleDetails(final String userName, final String password, final String userRole,
			final int userRoleIdval, final boolean isActive, final boolean accountNonLocked,
			final List<GrantedAuthority> grantedAuthority) {

		super(userName, password, userRole, userRoleIdval, isActive, accountNonLocked, grantedAuthority);

	}

	/**
	 * method is to clear user defined role related dynamic attributes.
	 */
	@Override
	public void clear() {

	}

	/**
	 * Identification No for the UserDefined role.
	 * 
	 * @return "".
	 */
	@Override
	public final String getUserLevelIdentifier() {

		return "";
	}

	/**
	 * Returns a string representation of the object.
	 * 
	 * @return - the current object details.
	 */
	@Override
	public final String toString() {

		return "UserDefined Role [role=" + this.getRole() + "]";
	}

}
