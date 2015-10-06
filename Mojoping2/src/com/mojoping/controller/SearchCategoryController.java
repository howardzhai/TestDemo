package com.mojoping.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mojoping.model.Category;
import com.mojoping.model.Checklist;
import com.mojoping.model.Labor;
import com.mojoping.model.Material;
import com.mojoping.model.ProcedureStep;
import com.mojoping.model.SearchObject;
import com.mojoping.model.SubCategory;
import com.mojoping.service.CategoryService;
import com.mojoping.service.ChecklistService;
import com.mojoping.service.LaborService;
import com.mojoping.service.MaterialService;
import com.mojoping.service.ProcedureStepService;
import com.mojoping.service.SubCategoryService;

//This is the search engine in the main page
@Controller
public class SearchCategoryController {
	
	@Autowired	
	private CategoryService category_service;
	
	@Autowired
	private SubCategoryService subcategory_service;	
	

	@Autowired
	ProcedureStepService procedurestep_service;
	
	@Autowired
	MaterialService material_service;
	
	@Autowired
	ChecklistService checklist_service;
	
	
	@Autowired
	LaborService labor_service;
	
	int count=0;
	String[] search_name={"result","Category","Subcategory","Checklist","Procedure","Material","Labor"};
	String search_id="";
	
	@RequestMapping(value = "/search_category",  method = RequestMethod.POST)
	public String searchCategoryFromDatabase(@ModelAttribute("category") Category category, Model model,HttpServletRequest request, BindingResult result, final RedirectAttributes redirectAttributes){
		String[] name=new String[2];
		String tab="";
		if(category.getCategory_name().contains("  :  ")){
	
		name=category.getCategory_name().split("  :  ");
	    tab=name[0];
		}else{

		name[1]=category.getCategory_name();
		tab="other";
	
		}
		
		if(count==0){
		
			result.rejectValue("category_name", "error.category", "There is no "+search_name[Integer.parseInt(search_id)-1]+" exist!");
			

			
			return "mojoping";
		}else{	
			switch(tab){
			case "category":{
			Category category1=category_service.getCategory(name[1]);
			HttpSession  session= request.getSession();
			session.setAttribute("category", category1);
			};
			break;
			
			case "subcategory":{
				HttpSession  session= request.getSession();
				session.setAttribute("category", null);
				session.setAttribute("tabname",tab);
				session.setAttribute("typename",name[1]);
							
			};break;
		    
			case "checklist":{
				HttpSession  session= request.getSession();
				session.setAttribute("category", null);
				session.setAttribute("tabname",tab);
				session.setAttribute("typename",name[1]);
							
			};break;
			
			case "procedurestep":{
				HttpSession  session= request.getSession();
				session.setAttribute("category", null);
				session.setAttribute("tabname",tab);
				session.setAttribute("typename",name[1]);
							
			};break;
			case "material":{
				HttpSession  session= request.getSession();
				session.setAttribute("category", null);
				session.setAttribute("tabname",tab);
				session.setAttribute("typename",name[1]);
							
			};break;
			case "labor":{
				HttpSession  session= request.getSession();
				session.setAttribute("category", null);
				session.setAttribute("tabname",tab);
				session.setAttribute("typename",name[1]);
							
			};break;
			
			case "other":{
				HttpSession  session= request.getSession();
				session.setAttribute("category", null);
				session.setAttribute("tabname",tab);
				session.setAttribute("typename",name[1]);
							
			};break;
		 		
			//redirectAttributes.addFlashAttribute("category", category);
			
			}
			
			return "redirect:checklistswithsearch";
}
				
	}
	
	
	@RequestMapping(value = "/getCategories", method = RequestMethod.GET)
	public @ResponseBody List<SearchObject> getCategories(@RequestParam String category_name, @RequestParam String category_search) {		
		search_id=category_search;
		return  simulateSearchResult(category_name,category_search);
 
	}
	

	
	private List<SearchObject> simulateSearchResult(String category_name,String category_search) {
		
		List<Category> categories =  category_service.listCategory();
		List<SubCategory> subcategories =  subcategory_service.listSubCategory();
		List<Checklist> checklists =checklist_service.listChecklist();
		List<ProcedureStep> proceduresteps =procedurestep_service.listProcedureStep();
		List<Material> materials =material_service.listMaterial();
		List<Labor> labors =labor_service.listLabor();
		
		List<SearchObject> result = new ArrayList<SearchObject>();
		if(category_search.equals("1")||category_search.equals("2")){
		for(int i=0; i<categories.size(); i++){
			if(categories.get(i).getCategory_name().contains(category_name)){
				result.add(new SearchObject("category",categories.get(i).getCategory_name(),categories.get(i).getCategory_id()));
				
			}
		}
		}
		
		if(category_search.equals("1")||category_search.equals("3")){
		for(int i=0; i<subcategories.size(); i++){
			if(subcategories.get(i).getSubcategory_name().contains(category_name)){
				result.add(new SearchObject("subcategory",subcategories.get(i).getSubcategory_name(),subcategories.get(i).getSubcategory_id()));
				
			}
		}	
		}
		
		if(category_search.equals("1")||category_search.equals("4")){
		for(int i=0; i<checklists.size(); i++){
			if(checklists.get(i).getTitle().contains(category_name)){
				result.add(new SearchObject("checklist",checklists.get(i).getTitle(),checklists.get(i).getChecklist_id()));
			}
		}	
		}
		
		if(category_search.equals("1")||category_search.equals("5")){
		for(int i=0; i<proceduresteps.size(); i++){
			if(proceduresteps.get(i).getStep_title().contains(category_name)){
				result.add(new SearchObject("procedurestep",proceduresteps.get(i).getStep_title(),proceduresteps.get(i).getProcedure_id()));
			}
		}	
		}
		
		if(category_search.equals("1")||category_search.equals("6")){
		for(int i=0; i<materials.size(); i++){
			if(materials.get(i).getMaterial_name().contains(category_name)){
				result.add(new SearchObject("material",materials.get(i).getMaterial_name(),materials.get(i).getMaterial_id()));
			}
		}	
		}
		if(category_search.equals("1")||category_search.equals("7")){
		for(int i=0; i<labors.size(); i++){
			if(labors.get(i).getLabor_task().contains(category_name)){
				result.add(new SearchObject("labor",labors.get(i).getLabor_task(),labors.get(i).getLabor_id()));
			}
		}	
		}
		
		count=result.size();
		
		return result;
	}
	
}
