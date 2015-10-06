package com.mojoping.service;

import java.util.List;

import com.mojoping.model.SubCategory;

public interface SubCategoryService {
	
	public void addSubCategory(SubCategory subcategory_name);
	
	public List<SubCategory> listSubCategory();
	
	public List<SubCategory> getSubCategory(Integer category_id);
	
	public List<SubCategory> getSubCategoryByName(String subcategory_name);
	
	public void removeSubCategory(Integer subcategory_id);
}
