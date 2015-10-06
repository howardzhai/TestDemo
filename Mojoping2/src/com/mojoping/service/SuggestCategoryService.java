package com.mojoping.service;

import java.util.List;

import com.mojoping.model.SuggestCategory;

public interface SuggestCategoryService{
	
	public void addSuggestCategory(SuggestCategory suggestcategory);
	
	public List<SuggestCategory> listSuggestCategory();
	
	public SuggestCategory getSuggestCategory(String suggest_category_name);
	
	public void removeSuggestCategory(Integer suggest_category_id);
}
