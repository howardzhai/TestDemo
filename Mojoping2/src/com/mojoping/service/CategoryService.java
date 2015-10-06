package com.mojoping.service;

import java.util.List;

import com.mojoping.model.Category;

public interface CategoryService {
	
	public void addCategory(Category category);
	
	public List<Category> listCategory();
	
	public void removeCategory(Integer category_id);
	
	public Category getCategory(String category_name);
}
