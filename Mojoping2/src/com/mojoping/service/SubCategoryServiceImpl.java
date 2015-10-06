package com.mojoping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mojoping.DAO.SubCategoryDAO;
import com.mojoping.model.SubCategory;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {
	
	@Autowired
	SubCategoryDAO subcategoryDAO;

	@Transactional
	public void addSubCategory(SubCategory subcategory_name) {
		subcategoryDAO.addSubCategory(subcategory_name);		
	}

	@Transactional
	public List<SubCategory> listSubCategory() {
		return subcategoryDAO.listSubCategory();
	}
	
	@Transactional
	public List<SubCategory> getSubCategory(Integer category_id){
		return subcategoryDAO.getSubCategory(category_id);
	}

	@Transactional
	public void removeSubCategory(Integer subcategory_id) {
		subcategoryDAO.removeSubCategory(subcategory_id);		
	}

	@Override
	public List<SubCategory> getSubCategoryByName(String subcategory_name) {
		// TODO Auto-generated method stub
		return subcategoryDAO.getSubCategoryByName(subcategory_name);
	}

}
