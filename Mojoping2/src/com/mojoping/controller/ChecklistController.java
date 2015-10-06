package com.mojoping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import com.mojoping.service.CategoryService;
import com.mojoping.service.ChecklistService;
import com.mojoping.service.UserService;

@Controller
public class ChecklistController {

	@Autowired
	UserService user_service;
	
	@Autowired
	ChecklistService checklist_service;
	
	@Autowired
	CategoryService category_service;
	
	@RequestMapping(value = "/createChecklistAction", method = RequestMethod.POST)
	public String welcomePage(@ModelAttribute("checklist") @Valid Checklist checklist, BindingResult result, Model model, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
		
		//This is the page of creating checklist and then redirect to procedure page
		if(result.hasErrors()){       
			
			model.addAttribute("category", category_service.listCategory());
			model.addAttribute("checklist", checklist);
			
			return "create_checklist";
		} else {
			
			HttpSession session = request.getSession();
			String userName=(String) session.getAttribute("username");
			checklist.setUsername(userName);
		    
			session.setAttribute("checklist", checklist);
		    redirectAttributes.addFlashAttribute("checklist", checklist);
		    return "redirect:/procedure";
		}
		
		
		
	}
}
