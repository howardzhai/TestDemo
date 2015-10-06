package com.mojoping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class LoginController {
	@Autowired
	@Qualifier("authenticationManager")
	AuthenticationManager authenticationManager;

	@Autowired
	SecurityContextRepository repository;

	@Autowired
	RememberMeServices rememberMeServices;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody String performLogin(@RequestParam("j_username") String username, @RequestParam("j_password") String password,
			HttpServletRequest request, HttpServletResponse response) {
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
		
		try {
			Authentication auth = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(auth);
			repository.saveContext(SecurityContextHolder.getContext(), request,
					response);
			rememberMeServices.loginSuccess(request, response, auth);
			HttpSession session = request.getSession();
			session.setAttribute("username",username);
			return "true";
		} catch (BadCredentialsException ex) {
			return "false";
		} catch (DisabledException ex){
			return new Gson().toJson("confirm");
		}
			
	}
	
	
}
