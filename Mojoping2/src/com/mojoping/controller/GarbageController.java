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
import com.mojoping.model.Garbage;
import com.mojoping.model.Insurance;
import com.mojoping.model.Labor;
import com.mojoping.model.Material;
import com.mojoping.model.Overhead;
import com.mojoping.model.Profit;
import com.mojoping.service.ChecklistService;
import com.mojoping.service.LaborService;
import com.mojoping.service.UserService;
import com.mojoping.service.GarbageService;


@Controller
public class GarbageController {
	
	
	
	@Autowired
	ChecklistService checklist_service;
	
	@Autowired
	GarbageService garbage_service;

	@RequestMapping(value = "/garbageAction", method = RequestMethod.POST)
	public String garbagepage(@ModelAttribute("checklist") Checklist checklist,@ModelAttribute("garbage")Garbage garbage,BindingResult result, Model model, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
		
		//This is the Garbage post page and since all the form is submitted by one form and I 
		// create "   ," in jquery when post data, all the data would be transferred in controller
		
		//Then this will redirect to the profit page and all data in session will be deal with in profit controller
		
		
		
		//The following is the function to deal with if the input is number verification .
		boolean if_garbage_cost=true;
		if(garbage!=null){
		if(garbage.getGarbage_cost().trim().contains("   ,")){
			String [] garbage_cost=garbage.getGarbage_cost().trim().split("   ,");
			
			for(int i =0;i<garbage_cost.length;i++){
				if(!isNum(garbage_cost[i])){
					if_garbage_cost=false;
					garbage.setGarbage_cost("");
					garbage.setGarbage_detail("");
					
				}
			}
			
		}else{
			
			if(!isNum(garbage.getGarbage_cost().trim())){
				if_garbage_cost=false;
				garbage.setGarbage_cost("");
				garbage.setGarbage_detail("");
				
				
			}
			

			
		}
		}
		
		if(!if_garbage_cost){
			result.rejectValue("garbage_cost","error.garbage","Garbage cost should be a number");
			model.addAttribute("garbage",garbage);
			return "garbage";
			
		}else{
		
		
			HttpSession session = request.getSession();
			session.setAttribute("garbage", garbage);
			model.addAttribute("garbage", garbage);
			redirectAttributes.addFlashAttribute("garbage", garbage);
			
			

			

			
			 return "redirect:/profit";
		}
	}
	
	private static boolean isNum(String string) {
		return string.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$")&&(!string.equals(""));
	}

		
	
	

}
