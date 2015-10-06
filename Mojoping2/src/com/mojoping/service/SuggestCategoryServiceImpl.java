package com.mojoping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mojoping.DAO.SuggestCategoryDAO;
import com.mojoping.model.SuggestCategory;

@Service
public class SuggestCategoryServiceImpl implements SuggestCategoryService {
	
	@Autowired
	SuggestCategoryDAO suggestcategoryDAO;

	@Transactional
	public void addSuggestCategory(SuggestCategory suggestcategory) {		
		suggestcategoryDAO.addSuggestCategory(suggestcategory);		
	}

	@Transactional
	public List<SuggestCategory> listSuggestCategory() {
		return suggestcategoryDAO.listSuggestCategory();
	}

	@Transactional
	public void removeSuggestCategory(Integer suggest_category_id) {
		suggestcategoryDAO.removeSuggestCategory(suggest_category_id);	
	}

	@Transactional
	public SuggestCategory getSuggestCategory(String suggest_category_name) {
		return suggestcategoryDAO.getSuggestCategory(suggest_category_name);
	}
	
	

}
