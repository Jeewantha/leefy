package com.jeesoft.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	private Map<String, String> person = new HashMap<String, String>();

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public String displayRequest(HttpServletRequest request, @RequestHeader(value = "Accept") String accept,
			@RequestHeader("Accept-Encoding") String encoding, 
			//@RequestHeader("Accept-Charset") String charset,
			@RequestParam("input") String input, Model model) {
		logger.info("Calling displayRequest");
		model.addAttribute("RemoteAddress", request.getRemoteAddr());
		model.addAttribute("HeaderAccept", accept);
		model.addAttribute("HeaderAcceptEncoding", encoding);
		//model.addAttribute("HeaderAcceptCharset", charset);
		model.addAttribute("Output", input);
		return "display";
	}

	@RequestMapping(value = "/extractJson", method = RequestMethod.GET)
	public @ResponseBody Map<String, String> getJsonData(@RequestParam("input") String input) {
		logger.info("Calling extractJson");
		person.put("name", "Simba");
		person.put("website", "http://www.tanbh.net");
		person.put("output", input);
		return person;
	}

}
