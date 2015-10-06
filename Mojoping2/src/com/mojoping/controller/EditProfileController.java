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

import com.mojoping.model.User;
import com.mojoping.service.UserService;

@Controller
public class EditProfileController {
	
	@Autowired
	UserService user_service;
	
	@RequestMapping(value="edit_user", method=RequestMethod.POST)
	public String editUser(@ModelAttribute("user") @Valid  User user, BindingResult result, Model model, HttpServletRequest request){
		
		User current_user = user_service.getUser(user.getUsername());
		
		String duplicate = checkDuplicateUser(user);
		
		if(duplicate.equals("email")){
			//If the email is already taken, give email error
			result.rejectValue("email", "error.user", "Email is already in our database. Please try new one!");
			
			//Send user info back to page
			model.addAttribute("user", user);
			
			return "profile";
		}else{
			if(result.hasErrors()) {
				//if there are some input errors on the form, return with the errors
	        	model.addAttribute("user", user);
	            return "profile";
	        }else{	
	        	current_user.setAddress_1(user.getAddress_1());
	        	current_user.setAddress_2(user.getAddress_2());
	        	current_user.setCity(user.getCity());
	        	current_user.setContact_number(user.getContact_number());
	        	current_user.setCountry(user.getCountry());
	        	current_user.setDate_of_birth(user.getDate_of_birth());
	        	current_user.setEmail(user.getEmail());
	        	current_user.setFacebook_url(user.getFacebook_url());
	        	current_user.setFirstname(user.getFirstname());
	        	current_user.setGender(user.getGender());
	        	current_user.setLastname(user.getLastname());
	        	current_user.setOccupation(user.getOccupation());
	        	current_user.setPassword(user.getPassword());
	        	current_user.setSkills(user.getSkills());
	        	current_user.setState(user.getState());
	        	current_user.setTwitter_url(user.getTwitter_url());
	        	current_user.setZipcode(user.getZipcode());
	        	current_user.setUser_money(user.getUser_money());
	        	//If everything is fine, add user to database and move forward
	        	user_service.updateUser(current_user);   
	        	
	        	String user_profile_pic_path = user.getProfile_pic_path();
				if(user_profile_pic_path == null ){
					String profile_pic_path = "/Mojoping2/resources/images/mojoping_logo.png";
					model.addAttribute("profilePicture", profile_pic_path);
				}else{
					String profile_pic_path = "/Mojoping2/resources/images/" + user.getUsername() + "/" + user_profile_pic_path;
					model.addAttribute("profilePicture", profile_pic_path);
				}			
	        	
	        	model.addAttribute("user", current_user);
	        	
	        	return "redirect:profile";
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
