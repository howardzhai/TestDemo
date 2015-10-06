package com.mojoping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mojoping.model.Checklist;
import com.mojoping.model.User;
import com.mojoping.model.UserComment;
import com.mojoping.service.ChecklistService;
import com.mojoping.service.UserCommentService;
import com.mojoping.service.UserService;
import com.mojoping.session.CurrentUser;


@Controller
public class UserCommentController {
	
	@Autowired
	UserService user_service;
	
	@Autowired
	ChecklistService checklist_service;
	
	@Autowired
	UserCommentService usercomment_service;

	@RequestMapping(value = "/usercommentAction", method = RequestMethod.POST)
	public String usercommentpage(@ModelAttribute("usercomment")UserComment usercomment,BindingResult result, Model model, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
		
			String username = new CurrentUser().getCurrentUserName();
			String id= Integer.toString(usercomment.getChecklist_id());
			if(!username.equals("anonymousUser")){
			User user = user_service.getUser(username);
		    System.out.println(username);
			
		    
			usercomment.setUser_id(user.getUser_id());
			usercomment.setUser_name(username);
			//usercomment.setChecklist_id(checklist_id);
			usercomment_service.addUserComment(usercomment);
			
			return "redirect:/detail_"+id;
			}else{
				
				result.rejectValue("comment_text","error.usercomment", "please login and comment");
				model.addAttribute("usercomment",usercomment);
				return "detail";
				
				
			}
			 
		    
		
			
		}
		
		
	
	

}
