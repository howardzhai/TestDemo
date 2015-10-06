package com.mojoping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mojoping.model.Category;
import com.mojoping.model.SubCategory;
import com.mojoping.service.SubCategoryService;

@Controller
public class SubCategoryController {
	
	@Autowired
	SubCategoryService subcategory_service;
	
	@RequestMapping(value="getSubCategoriesRelatedToCategory", method=RequestMethod.POST, produces="application/json")
	public @ResponseBody String getSubCategoriesRelatedToCategory(@ModelAttribute(value="category") Category category) {
		
		List<SubCategory> subcategories = subcategory_service.getSubCategory(category.getCategory_id());
		
		Gson gson = new Gson();
		String json_subcategories = gson.toJson(subcategories);

		return json_subcategories;
	}
}
