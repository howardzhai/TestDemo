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
import com.mojoping.model.Overhead;
import com.mojoping.service.ChecklistService;
import com.mojoping.service.OverheadService;


@Controller
public class OverheadController {
	
	
	
	@Autowired
	ChecklistService checklist_service;
	
	@Autowired
	OverheadService overhead_service;

	@RequestMapping(value = "/overheadAction", method = RequestMethod.POST)
	public String overheadpage(@ModelAttribute("checklist") Checklist checklist,@ModelAttribute("overhead")Overhead overhead,BindingResult result, Model model, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
		
		//This is the Overhead post page and since all the form is submitted by one form and I 
		// create "   ," in jquery when post data, all the data would be transferred in controller
		
		//Then this will redirect to the insurance page
		
		
		
		//The following is the function to deal with if the input is number verification .
		boolean if_overhead_cost=true;
		if(overhead!=null){
		if(overhead.getOverhead_cost().trim().contains("   ,")){
			String [] overhead_cost=overhead.getOverhead_cost().trim().split("   ,");
			
			for(int i =0;i<overhead_cost.length;i++){
				if(!isNum(overhead_cost[i])){
					if_overhead_cost=false;
					overhead.setOverhead_cost("");
					overhead.setOverhead_detail("");
					
				}
			}
			
		}else{
			
			if(!isNum(overhead.getOverhead_cost().trim())){
				if_overhead_cost=false;
				overhead.setOverhead_cost("");
				overhead.setOverhead_detail("");
				
			}
			

			
		}
		}
		
		if(!if_overhead_cost){
			result.rejectValue("overhead_cost","error.overhead","Cost should be a number");
			model.addAttribute("overhead",overhead);
			return "overhead";
			
		}else{
			
		
		
			HttpSession session = request.getSession();
			session.setAttribute("overhead", overhead);
			model.addAttribute("overhead", overhead);
			redirectAttributes.addFlashAttribute("overhead", overhead);
			 return "redirect:/insurance";
		}
		
	}
	
	private static boolean isNum(String string) {
		return string.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$")&&(!string.equals(""));
	}

}
