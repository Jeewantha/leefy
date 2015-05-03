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
import org.springframework.security.core.userdetails.User;

/**
 * Top Hierarchical class to hold common user details.
 * 
 * @author Jeewantha Samaraweera
 * @since alpha
 */
public abstract class UserInfo extends User {

	/**
	 * UserInfo Constructor.
	 * 
	 * @param userName
	 *            - userName of the Admin User.
	 * @param password
	 *            - password of the Admin User.
	 * @param userRoleVal
	 *            - password of the Admin User.
	 * @param userRoleIdval
	 *            - user userRoleId of the Admin User.
	 * @param isActive
	 *            - password of the Admin User.
	 * @param accountNonLocked
	 *            - whether account is locked.
	 * @param grantedAuthority
	 *            - password of the Admin User.
	 */
	public UserInfo(final String userName, final String password, final String userRoleVal, final int userRoleIdval,
			final boolean isActive, final boolean accountNonLocked, final List<GrantedAuthority> grantedAuthority) {

		super(userName, password, isActive, isActive, isActive, accountNonLocked, grantedAuthority);
		userRole = userRoleVal;
		userRoleId = userRoleIdval;
	}

	/** long attribute for holding serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** holds userId of the user. */
	private int userId;

	/** holds userRoleId of the user. */
	private int userRoleId;

	/** holds userLevel of the user. */
	private String userRole;

	/** holds defaultUserHomeUrl of the user. */
	private String defaultUserHomeUrl;

	/**
	 * return userId of the Student.
	 * 
	 * @return the userId
	 */
	public final int getUserId() {

		return userId;
	}

	/**
	 * Setter method for userId.
	 * 
	 * @param userIdVal
	 *            the userId to set
	 */
	public final void setUserId(final int userIdVal) {

		this.userId = userIdVal;
	}

	/**
	 * return userRoleId of the Student.
	 * 
	 * @return the userRoleId
	 */
	public final int getUserRoleId() {

		return userRoleId;
	}

	/**
	 * Setter method for userRoleId.
	 * 
	 * @param userRoleIdVal
	 *            the userRoleId to set
	 */
	public final void setUserRoleId(final int userRoleIdVal) {

		this.userId = userRoleIdVal;
	}

	/**
	 * return userRole of the user.
	 * 
	 * @return the userRole
	 */
	public final String getRole() {

		return userRole;
	}

	/**
	 * Setter method for userUserRole.
	 * 
	 * @param userUserRoleVal
	 *            the userLevel to set
	 */
	public final void setRole(final String userUserRoleVal) {

		this.userRole = userUserRoleVal;
	}

	/**
	 * return defaultUserHomeUrl of the user.
	 * 
	 * @return the defaultUserHomeUrl
	 */
	public final String getDefaultUserHomeUrl() {

		return defaultUserHomeUrl;
	}

	/**
	 * Setter defaultUserHomeUrl for the user.
	 * 
	 * @param defaultUserHomeUrlVal
	 *            the defaultUserHomeUrl to set
	 */
	public final void setDefaultUserHomeUrl(final String defaultUserHomeUrlVal) {

		this.defaultUserHomeUrl = defaultUserHomeUrlVal;
	}

	/**
	 * clear method is to dynamic user details.
	 */
	public abstract void clear();

	/**
	 * getUserIdentificationNo to return subjective Id of the respective users.
	 * 
	 * @return userIdentificationNo.
	 */
	public abstract String getUserLevelIdentifier();

	/**
	 * overridden toString method to represent the UserInfo object.
	 * 
	 * @return String representation of the userName.
	 */
	@Override
	public String toString() {

		return getUsername();
	}
}
