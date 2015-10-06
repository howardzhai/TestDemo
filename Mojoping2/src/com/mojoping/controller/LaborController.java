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
import com.mojoping.model.Labor;
import com.mojoping.service.ChecklistService;
import com.mojoping.service.LaborService;
import com.mojoping.service.MaterialService;
import com.mojoping.service.UserService;



@Controller
public class LaborController {
	
	
	
	@Autowired
	ChecklistService checklist_service;
	
	@Autowired
	LaborService labor_service;

	@RequestMapping(value = "/laborAction", method = RequestMethod.POST)
	public String laborpage(@ModelAttribute("checklist") Checklist checklist,@ModelAttribute("labor")Labor labor,BindingResult result, Model model, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
		
		//This is the Labor post page and since all the form is submitted by one form and I 
		// create "   ," in jquery when post data, all the data would be transferred in controller
		
		//Then this will redirect to the overhead page
		
		
		
		//The following is the function to deal with if the input is number verification .
		
		
		
		
		
		
		boolean if_labor_num_people=true;
		boolean if_labor_num_hour=true;
		boolean if_labor_hourly_cost=true;
		boolean if_labor_insurance=true;
		
		
		
		if(labor!=null){
		if(labor.getLabor_task().trim().contains("   ,")){
			String [] labor_task=labor.getLabor_task().trim().split("   ,");
			String [] labor_num_people=labor.getLabor_num_people().trim().split("   ,");
			String []labor_num_hour=labor.getLabor_num_hour().trim().split("   ,");
			String [] labor_hour_cost=labor.getLabor_hourly_cost().trim().split("   ,");
			String [] labor_insurance=labor.getLabor_insurance().trim().split("   ,");
			for(int i =0;i<labor_task.length;i++){
				if(!isNum(labor_num_people[i])){
					if_labor_num_people=false;
					
				}
				if(!isNum(labor_num_hour[i])){
					if_labor_num_hour=false;
					
				}
				if(!isNum(labor_hour_cost[i])){
					if_labor_hourly_cost=false;
					
				}
				if(!isNum(labor_insurance[i])){
					if_labor_insurance=false;
					
				}
					
			}
			
		}else{
			if(!isNum(labor.getLabor_num_people().trim())){
				if_labor_num_people=false;
				
			}
			if(!isNum(labor.getLabor_num_hour().trim())){
				if_labor_num_hour=false;
				
			}
			if(!isNum(labor.getLabor_hourly_cost().trim())){
				if_labor_hourly_cost=false;
				
			}
			if(!isNum(labor.getLabor_insurance().trim())){
				if_labor_insurance=false;
				
			}
		
		}
		}
		
		if(!(if_labor_num_people||if_labor_num_hour||if_labor_hourly_cost||if_labor_insurance)){
			labor.setLabor_num_hour("");
			labor.setLabor_detail("");
			labor.setLabor_task("");
			labor.setLabor_num_people("");
			labor.setLabor_insurance("");
			labor.setLabor_hourly_cost("");
		}
		
		if(!if_labor_num_people){
			result.rejectValue("labor_num_people","error.labor","People number should be number");
			model.addAttribute("labor",labor);
			return "labor";
			
		}else if(!if_labor_num_hour){
			result.rejectValue("if_labor_num_hour","error.labor","Hour number should be number");
			model.addAttribute("labor",labor);
			return "labor";
			
		}else if(!if_labor_hourly_cost){
			result.rejectValue("labor_hourly_cost","error.labor","Cost should be number");
			model.addAttribute("labor",labor);
			return "labor";
			
		}else if(!if_labor_insurance){
			result.rejectValue("labor_insurance","error.labor","Insurance should be number");
			model.addAttribute("labor",labor);
			return "labor";
			
		}else{
			
		
		
			HttpSession session = request.getSession();
			session.setAttribute("labor", labor);
			model.addAttribute("labor", labor);
			redirectAttributes.addFlashAttribute("labor", labor);
			 return "redirect:/overhead";
		}
	}
		
		
	
	private static boolean isNum(String string) {
		return string.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$")&&(!string.equals(""));
	}

}
