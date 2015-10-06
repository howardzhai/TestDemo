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
import com.mojoping.model.Insurance;
import com.mojoping.service.ChecklistService;
import com.mojoping.service.InsuranceService;


@Controller
public class InsuranceController {
	
	
	
	@Autowired
	ChecklistService checklist_service;
	
	@Autowired
	InsuranceService insurance_service;
	

	@RequestMapping(value = "/insuranceAction", method = RequestMethod.POST)
	public String insurancepage(@ModelAttribute("checklist") Checklist checklist,@ModelAttribute("insurance")Insurance insurance,BindingResult result, Model model, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
		
		
		//This is the Insurance post page and since all the form is submitted by one form and I 
		// create "   ," in jquery when post data, all the data would be transferred in controller
		
		//Then this will redirect to the garbage page
		
		
		
		//The following is the function to deal with if the input is number verification .
		boolean if_insurance_amount=true;
		if(insurance!=null){
		if(insurance.getInsurance_amount().trim().contains("   ,")){
			String [] insurance_amount=insurance.getInsurance_amount().trim().split("   ,");
			
			for(int i =0;i<insurance_amount.length;i++){
				if(!isNum(insurance_amount[i])){
					if_insurance_amount=false;
					insurance.setInsurance_amount("");
					insurance.setInsurance_detail("");
					
				}
			}
			
		}else{
			
			if(!isNum(insurance.getInsurance_amount().trim())){
				if_insurance_amount=false;
				insurance.setInsurance_amount("");
				insurance.setInsurance_detail("");
				
				
			}
			

			
		}
		}
		
		if(!if_insurance_amount){
			result.rejectValue("insurance_amount","error.insurance","Insurance amount should be a number");
			model.addAttribute("insurance",insurance);
			return "insurance";
			
		}else{
			
		
		
		
		
			HttpSession session = request.getSession();
			
			session.setAttribute("insurance", insurance);
			model.addAttribute("insurance", insurance);
			redirectAttributes.addFlashAttribute("insurance", insurance);
		    return "redirect:/garbage";
		}
		
	}
	
		private static boolean isNum(String string) {
			return string.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$")&&(!string.equals(""));
		}


}
