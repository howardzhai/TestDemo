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
import com.mojoping.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService category_service;
	
	@RequestMapping(value="getAllCategories", method=RequestMethod.POST, produces="application/json")
	public @ResponseBody String getAllCategories(@ModelAttribute("category") Category category) {
		
		List<Category> categories = category_service.listCategory();
		
		return new Gson().toJson(categories);
	}
}
