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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesoft.model.PersonalContact;

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

	/** The person. */
	private Map<String, String> person = new HashMap<String, String>();

	/**
	 * Simply selects the home view to render by returning its name.
	 *
	 * @return the string
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public final String home() {
		logger.info("Welcome home!");
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
	public final Map<String, ? extends Object> load(final PersonalContact input) {
		logger.info("Inside load");
		PersonalContact pc = new PersonalContact(1L, "Wowi", "89281932", "wo.wi@abcxyz.com");
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("success", Boolean.TRUE);
		data.put("data", pc);

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
	public  final Map<String, ? extends Object> add(final PersonalContact input, final HttpSession session) {
		logger.info("Inside add");

		Map<String, Object> data = new HashMap<String, Object>();

		Set<ConstraintViolation<PersonalContact>> failures = validator.validate(input);
		if (!failures.isEmpty()) {
			// response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			data.put("success", Boolean.FALSE);
			data.put("errors", validationMessages(failures));
			data.put("errorMessage", "Add Failed!");
		} else {
			session.setAttribute(input.getName(), input);
			data.put("success", Boolean.TRUE);
		}

		return data;
	}

	// public @ResponseBody Map<String, String> getJsonData() {
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

	/**
	 * Validation messages.
	 *
	 * @param failures
	 *            the failures
	 * @return the map
	 */
	private Map<String, String> validationMessages(final Set<ConstraintViolation<PersonalContact>> failures) {
		Map<String, String> failureMessages = new HashMap<String, String>();
		for (ConstraintViolation<PersonalContact> failure : failures) {
			failureMessages.put(failure.getPropertyPath().toString(), failure.getMessage());
		}
		return failureMessages;
	}
}
