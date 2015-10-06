package com.mojoping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mojoping.model.Confirmation;
import com.mojoping.model.User;
import com.mojoping.service.ConfirmationService;
import com.mojoping.service.UserService;

@Controller
public class ConfirmUserController {
	
	@Autowired
	ConfirmationService confirmation_service;
	
	@Autowired
	UserService user_service;
	
	@RequestMapping(value = "/confirm_user", method = RequestMethod.POST)
	public String confirmUser(@ModelAttribute("confirmation") Confirmation confirmation, BindingResult result, Model model){
		
		String confirm = checkConfirmationCode(confirmation.getUsername(), confirmation.getConfirmation_id());
		
		if(confirm.equals("username")){
			//If there is no such an username
			result.rejectValue("username", "error.confirmation", "Please register first!");
			
			//Send user info back to page
			model.addAttribute("confirmation", confirmation);
			
			return "confirmation";
		}else if(confirm.equals("notmatch")){
			//If confirmation code is wrong
			result.rejectValue("confirmation_id", "error.confirmation", "Confirmation code does not match with your username!");
			
			//Send user info back to page
			model.addAttribute("confirmation", confirmation);
			
			return "confirmation";
		}else {
			User user = user_service.getUser(confirmation.getUsername());
			
			//Enable user to login
			user.setEnabled(true);
			
			user_service.updateUser(user);
			
			return "redirect:/";
		}	
	}
	
	private String checkConfirmationCode(String username, String confirmation_id){
		Confirmation confirmation = confirmation_service.getConfirmation(username);
		
		if(confirmation == null){
			return "username";
		}else if(confirmation.getConfirmation_id().equals(confirmation_id)){
			return "match";
		}else{
			return "notmatch";
		}
	}
	

}
