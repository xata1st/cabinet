package com.xata.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		
		ModelAndView model = new ModelAndView();
		if(error != null) {
			model.addObject("error", "Invalid username and password");
		}
		if(logout != null) {
			model.addObject("msg", "You have been logout successfully");
		}
		model.setViewName("auth/login");
		
		return model;
	}
	
	@RequestMapping(value = "test")
	public String welcomePage() {
		return "test";
	}
}
