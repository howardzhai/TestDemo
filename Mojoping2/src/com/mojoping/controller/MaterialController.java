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
import com.mojoping.model.Material;
import com.mojoping.service.ChecklistService;
import com.mojoping.service.MaterialService;
import com.mojoping.service.UserService;

@Controller
public class MaterialController {

	
	@Autowired
	ChecklistService checklist_service;
	
	@Autowired
	MaterialService material_service;
	
	@RequestMapping(value = "/materialAction", method = RequestMethod.POST)
	public String materialpage(@ModelAttribute("checklist") Checklist checklist,@ModelAttribute("material")Material material,BindingResult result, Model model, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
		
		//This is the material post page and since all the form is submitted by one form and I 
		// create "   ," in jquery when post data, all the data would be transferred in controller
		
		//Then this will redirect to the labor page
		
		
		
		//The following is the function to deal with if the input is number verification .
		boolean if_coverage=true;
		boolean if_quantity=true;
		if(material!=null){
			if(material.getMaterial_name().trim().contains("   ,")){
				String [] material_name=material.getMaterial_name().trim().split("   ,");
				String [] material_coverage=material.getCoverage().trim().split("   ,");
				String [] material_quantity=material.getQuantity().trim().split("   ,");
				for(int i =0;i<material_name.length;i++){
					
					if(!isNum(material_coverage[i])){
						if_coverage=false;
						
					}
					
					if(!isNum(material_quantity[i])){
						if_quantity=false;
						
					}
					
				}
				
			}else{
				if(!isNum(material.getCoverage().trim())){
					if_coverage=false;
	
			}
				if(!isNum(material.getQuantity().trim())){
					if_quantity=false;
					
				}
		}
		}
		
		
		if(!if_coverage){
			material.setMaterial_name("");
			material.setCoverage("");
			material.setQuantity("");
			result.rejectValue("coverage","error.material","Coverage should be number");
			
			model.addAttribute("material",material);
			return "material";
		}else if(!if_quantity){
			material.setMaterial_name("");
			material.setCoverage("");
			material.setQuantity("");
			result.rejectValue("quantity","error.material","Quantity should be number");
			return "material";
		}else{
		
			HttpSession session = request.getSession();

			
			session.setAttribute("material", material);
			model.addAttribute("material", material);
			redirectAttributes.addFlashAttribute("material", material);
		    return "redirect:/labor";
		}
		}
	private static boolean isNum(String string) {
		return string.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$")&&(!string.equals(""));
	}
		
	
	
}
