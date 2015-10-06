package com.mojoping.DAO;

import java.util.List;

import com.mojoping.model.Category;

public interface CategoryDAO{
	
	public void addCategory(Category category);
	
	public List<Category> listCategory();
	
	public Category getCategory(String category_name);
	
	public void removeCategory(Integer category_id);
}
