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
package com.jeesoft.web;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.jeesoft.api.dto.LoginStatus;
import com.jeesoft.common.constants.LeefyErrorConstants;
import com.jeesoft.web.util.PropertyReader;

/**
 * The Class LoginFailureHandler.
 */
public class LoginFailureHandler implements AuthenticationFailureHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.web.authentication.AuthenticationFailureHandler
	 * #onAuthenticationFailure(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse,
	 * org.springframework.security.core.AuthenticationException)
	 */
	@Override
	public final void onAuthenticationFailure(final HttpServletRequest request, final HttpServletResponse response,
			final AuthenticationException auth) throws IOException, ServletException {

		ObjectMapper mapper = new ObjectMapper();
		LoginStatus status = new LoginStatus(false, false, null, PropertyReader.getPropertyValue(LeefyErrorConstants.ERROR_MESSAGE_PROPERTY_FILE, LeefyErrorConstants.ERROR_MESSAGE_USER_LOGIN_FAILURE_ERROR));
		OutputStream out = response.getOutputStream();
		mapper.writeValue(out, status);
	}

}
