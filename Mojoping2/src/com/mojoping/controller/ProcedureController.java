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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mojoping.model.Checklist;
import com.mojoping.model.ProcedureStep;
import com.mojoping.service.ChecklistService;
import com.mojoping.service.ProcedureStepService;
@Controller
public class ProcedureController {
	
	
	@Autowired
	ChecklistService checklist_service;
	@Autowired
	ProcedureStepService procedurestep_service;
	

	@RequestMapping(value = "/procedurestepAction", method = RequestMethod.POST)
	public String createProcedure(@ModelAttribute("checklist") Checklist checklist,@ModelAttribute("procedurestep") ProcedureStep procedurestep,  
			BindingResult result, Model model, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
		
	
		//This is the page of procedure page and then redirect to material page
		//In the database procedure is named as procedurestep because procedure is key word in SQL
		HttpSession session = request.getSession();
		checklist=(Checklist) session.getAttribute("checklist");
	
	
		procedurestep.setChecklist_id(checklist.getChecklist_id());

 
	   session.setAttribute("procedurestep", procedurestep);
	   redirectAttributes.addFlashAttribute("checklist", checklist);
	   redirectAttributes.addFlashAttribute("procedurestep", procedurestep);
	    return "redirect:/material";
	}
	

}
