package com.mojoping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mojoping.model.User;
import com.mojoping.model.UserRoles;
import com.mojoping.service.UserRolesService;
import com.mojoping.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	UserService user_service;
	
	@Autowired 
	UserRolesService user_roles_services;
	
	@RequestMapping(value="register_user", method=RequestMethod.POST)
    public String submitForm(@ModelAttribute("user") @Valid  User user, BindingResult result, Model model, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
		
		String duplicate = checkDuplicateUser(user);
		
		if(duplicate.equals("username")){
			//If the username is already taken, give username error			
			result.rejectValue("username", "error.user", "Username is already in our database. Please try new one!");
			
			//Send user info back to page
			model.addAttribute("user", user);
			
			return "register_to_mojoping";
		}else if(duplicate.equals("email")){
			//If the email is already taken, give email error
			result.rejectValue("email", "error.user", "Email is already in our database. Please try new one!");
			
			//Send user info back to page
			model.addAttribute("user", user);
			
			return "register_to_mojoping";
		}else{
			if(result.hasErrors()) {
				//if there are some input errors on the form, return with the errors
	        	model.addAttribute("user", user);
	            return "register_to_mojoping";
	        }else{
	        	UserRoles user_role = new UserRoles();
	        	
	        	user_role.setAuthority("ROLE_USER");
	        	user_role.setUser(user);      	
	        	user.setUser_money(0.0);
	        	//If everything is fine, add user to database and move forward
	        	user_service.addUser(user);   
	        	
	        	//Add user role to related table
	        	user_roles_services.addUserRoles(user_role);
	        	
	        	redirectAttributes.addFlashAttribute("user", user);
	        	
	        	return "redirect:confirm_user";
	        }
		}	
    }
	
	
	//Check the user if registered with the same username or email before
	private String checkDuplicateUser(User user){
		String duplicate = "no";
		
		List<User> all_users = user_service.listUser();

		for(int i=0; i<all_users.size(); i++){			
			if(all_users.get(i).getUsername().equals(user.getUsername())){
				duplicate = "username";	        	
			}else if(all_users.get(i).getEmail().equals(user.getEmail())){
				duplicate = "email";	        	
			}						
		}
		
		return duplicate;
	}

	
	
}
