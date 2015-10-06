package com.mojoping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mojoping.DAO.CategoryDAO;
import com.mojoping.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDAO categoryDAO;

	@Transactional
	public void addCategory(Category category) {		
		categoryDAO.addCategory(category);		
	}

	@Transactional
	public List<Category> listCategory() {
		return categoryDAO.listCategory();
	}

	@Transactional
	public void removeCategory(Integer category_id) {
		categoryDAO.removeCategory(category_id);		
	}

	@Transactional
	public Category getCategory(String category_name) {
		return categoryDAO.getCategory(category_name);
	}
	
	

}
