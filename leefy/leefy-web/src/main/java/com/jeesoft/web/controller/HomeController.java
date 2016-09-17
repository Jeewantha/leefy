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
package com.jeesoft.web.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesoft.api.dto.UserLogin;
import com.jeesoft.api.dto.UserRegistrationForm;
import com.jeesoft.common.exception.LeefyAppException;
import com.jeesoft.common.exception.NonUniqueEmailException;
import com.jeesoft.common.exception.NonUniqueUserNameException;
import com.jeesoft.web.service.GuestUserServices;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/** The validator. */
	@Autowired
	private Validator validator;
	
	/** The gust user services. */
	@Autowired
	private GuestUserServices guestUserService;

	/** The authentication manager. */
	@Autowired
	private AuthenticationManager authenticationManager;
	
	/** The person. */
	private Map<String, String> person = new HashMap<String, String>();

	/**
	 * Simply selects the home view to render by returning its name.
	 *
	 * @return the string
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public final String home(final HttpServletRequest request) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
	    try {
            UserLogin loggedInUser = guestUserService.getAnyUser(name);
            
            if(loggedInUser != null) {
                request.setAttribute("username", name);
                request.setAttribute("email", loggedInUser.getEmail());
                //TODO set user data to profile form
            }
        } catch (LeefyAppException leefyAppException) {
            logger.error("Error loading logged in user by username.", leefyAppException);
            return "login";
        }
	    return "home";
	}

	/**
	 * Load.
	 *
	 * @param input
	 *            the input
	 * @return the map< string,? extends object>
	 */
	@RequestMapping(value = "/load", method = RequestMethod.POST)
	@ResponseBody
	public final Map<String, ? extends Object> load(final UserRegistrationForm input) {
		logger.info("Inside load");
		/*UserRegistrationForm pc = new UserRegistrationForm(1L, "Wowi", "89281932", "wo.wi@abcxyz.com");*/
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("success", Boolean.TRUE);
		/*data.put("data", pc);*/

		return data;
	}

	/**
	 * Adds the.
	 *
	 * @param input
	 *            the input
	 * @param session
	 *            the session
	 * @return the map< string,? extends object>
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
    public final Map<String, ? extends Object> addGuestUser(final UserRegistrationForm input,final HttpSession session, final HttpServletResponse response, final HttpServletRequest request) {
        Map<String, Object> returnedData = new HashMap<String, Object>();
        try {
            Set<ConstraintViolation<UserRegistrationForm>> failures = validator.validate(input);
            Boolean isNoFailures = failures.isEmpty();
            Boolean isEmailExist  = guestUserService.isEmailExist(input.getEmail());
            Boolean isUsernameExist = guestUserService.isUsernameExist(input.getUsername());
            returnedData.put("success", Boolean.FALSE);

            if (!isNoFailures || (isUsernameExist || isEmailExist)) {
                returnedData.put("errorMessage", isUsernameExist ? "Username is exist." : isEmailExist ? "Email is exist." : "");
                returnedData.put("errors", validationMessages(failures));
            } else {
                UserLogin guestUser = new UserLogin();
                guestUser.setUsername(input.getUsername());
                guestUser.setEmail(input.getEmail());
                guestUser.setPassword(input.getPassword());
                try {
                    guestUserService.createSystemUser(guestUser);
                    returnedData.put("success", Boolean.TRUE);
                    authenticateUserAndSetSession(input, request);
                } catch (NonUniqueEmailException | NonUniqueUserNameException exception) {
                    logger.error(exception.getMessage());
                    returnedData.put("errorMessage", exception.getMessage());
                }
            }
        } catch (LeefyAppException leefyAppException) {
            logger.error(leefyAppException.getErrorCode(), leefyAppException);
            returnedData.put("errorMessage", "Adding user failed");
        }
        return returnedData;
    }

	/**
	 * Gets the json data.
	 *
	 * @param input
	 *            the input
	 * @return the json data
	 */
	@RequestMapping(value = "/extractJson", method = RequestMethod.GET)
	@ResponseBody
	public final Map<String, String> getJsonData(@RequestParam("input") final String input) {
		logger.info("Calling extractJson");
		person.put("name", "Simba");
		person.put("website", "http://www.tanbh.net");
		person.put("hobby", input);
		return person;
	}

	private Map<String, String> validationMessages(final Set<ConstraintViolation<UserRegistrationForm>> failures) {
		Map<String, String> failureMessages = new HashMap<String, String>();
		for (ConstraintViolation<UserRegistrationForm> failure : failures) {
			failureMessages.put(failure.getPropertyPath().toString(), failure.getMessage());
		}
		return failureMessages;
	}
	
	private void authenticateUserAndSetSession(UserRegistrationForm userRegistrationForm, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userRegistrationForm.getUsername(), userRegistrationForm.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
    }
}
