package com.mojoping.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mojoping.model.Confirmation;
import com.mojoping.model.User;
import com.mojoping.service.ConfirmationService;
import com.mojoping.service.MailService;

@Controller
public class ConfirmationEmailController {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	ConfirmationService confirmation_service;
	
	@RequestMapping(value="confirm_user", method=RequestMethod.GET)
	public String confirmUser(@ModelAttribute("user") User user, BindingResult result, Model model, HttpServletRequest request) {
		
		String confirmation_code = createConfirmationCode(user);
		
		String confirmation_mail_body = createConfirmationMailBody(user, confirmation_code);
		
		MailService mailService = (MailService) context.getBean("mailService");
		
		mailService.sendMail("mkuscuo1@binghamton.edu", user.getEmail(), "Welcome to Mojoping!", confirmation_mail_body);
		
		return "redirect:user_confirmation";
	}
	
	/* Create Confirmation Code for user and add it to database */
	public String createConfirmationCode(User user){
		String confirmation_code = String.valueOf(UUID.randomUUID());
		
		Confirmation confirmation = new Confirmation();
		
		confirmation.setConfirmation_id(confirmation_code);
		confirmation.setUsername(user.getUsername());
		
		confirmation_service.addConfirmation(confirmation);	
		
		return confirmation_code;
	}
	
	/* Create mail body for new user */
	public String createConfirmationMailBody(User user, String confirmation_code){
		String confirmation_mail_body = "Dear " + user.getFirstname() + "\r\n \r\n" + "It is glad to see you as our valuable member! "
				+ "Here is your activation code to finish your membership process: " + confirmation_code;
		
		return confirmation_mail_body;
	}
}
