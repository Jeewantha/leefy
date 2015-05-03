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
 * The Class LoginStatus.
 */
public class LoginStatus {

	/** The success. */
	private final boolean success;

	/** The logged in. */
	private final boolean loggedIn;

	/** The username. */
	private final String username;

	/** The error message. */
	private final String errorMessage;

	/**
	 * Instantiates a new login status.
	 *
	 * @param success
	 *            the success
	 * @param loggedIn
	 *            the logged in
	 * @param username
	 *            the username
	 * @param errorMessage
	 *            the error message
	 */
	public LoginStatus(final boolean success, final boolean loggedIn, 
			final String username, final String errorMessage) {
		this.success = success;
		this.loggedIn = loggedIn;
		this.username = username;
		this.errorMessage = errorMessage;
	}

	/**
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	public final String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Checks if is logged in.
	 *
	 * @return true, if is logged in
	 */
	public final boolean isLoggedIn() {
		return loggedIn;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public final String getUsername() {
		return username;
	}

	/**
	 * Checks if is success.
	 *
	 * @return true, if is success
	 */
	public final boolean isSuccess() {
		return success;
	}
}
