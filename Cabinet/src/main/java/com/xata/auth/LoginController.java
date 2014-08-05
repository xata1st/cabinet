package com.xata.auth;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, final HttpServletRequest request, Principal principal) {

		
		System.out.println("in a login controller");		
		
		ModelAndView model = new ModelAndView();

		System.out.println(principal);
		if(principal != null) {
			model.setViewName("test");
			return model;
		} else {			
			if(error != null) {
				model.addObject("error", "Invalid username and password");
			}
			if(logout != null) {
				model.addObject("msg", "You have been logout successfully");
			}
			model.setViewName("auth/login");
			
			return model;
		}
	}
	
	@RequestMapping(value = "/home", method=RequestMethod.GET)
	public String welcomePage() {
		return "home";
	}
}
