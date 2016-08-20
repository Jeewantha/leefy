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
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesoft.api.dto.Country;
import com.jeesoft.common.exception.LeefyAppException;
import com.jeesoft.web.dao.CountryDao;
import com.jeesoft.web.dao.UserLoginDao;

/**
 * The Class LoginController.
 */
@Controller
public class LoginController {
	
    /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    
	@Autowired
	private UserLoginDao userLoginDao;
	
	@Autowired
	private CountryDao countryDao;

	/**
	 * Login.
	 
	 * @return the string
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public final String login(ModelMap model, HttpSession session) {
	    logger.debug("Session is going to be invaliadted :"+session.toString());
		session.invalidate();
		return "login";
	}
	/**
	 * Get the user selected language.
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/language", method=RequestMethod.GET)
	public final String changeLanguage(ModelMap model, HttpSession session, HttpServletRequest request){
	    return "login";
	}
	
	@RequestMapping(value = "/allCountries", method = RequestMethod.GET)
    @ResponseBody
    public final Map<String, Country> loadAllCountries(ModelMap model, HttpSession session, HttpServletRequest request) {
        
	    Map<String, Country> mapOfCountries = null;
        try {
            List<Country> countries = countryDao.loadAllCountries();
            mapOfCountries = new HashMap<String, Country>();
            for (Country country : countries) {
                mapOfCountries.put(country.getIsoCode(), country);
            }
        } catch (LeefyAppException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    
        return mapOfCountries;
    }
	
}
