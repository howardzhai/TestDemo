package com.mojoping.DAO;

import java.util.List;

import com.mojoping.model.Checklist;
import com.mojoping.model.SubCategory;

public interface SubCategoryDAO{
	
	public void addSubCategory(SubCategory subcategory_name);
	
	public List<SubCategory> listSubCategory();
	
	public List<SubCategory> getSubCategoryByName(String subcategory_name);
	
	public List<SubCategory> getSubCategory(Integer category_id);
	
	public void removeSubCategory(Integer subcategory_id);
}
