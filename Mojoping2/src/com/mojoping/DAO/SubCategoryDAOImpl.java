package com.mojoping.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mojoping.model.SubCategory;

@Repository
public class SubCategoryDAOImpl implements SubCategoryDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addSubCategory(SubCategory subcategory_name) {		
		sessionFactory.getCurrentSession().save(subcategory_name);		
	}

	@SuppressWarnings("unchecked")
	public List<SubCategory> listSubCategory() {
		return sessionFactory.getCurrentSession().createQuery("from subcategory").list();
	}
	
	public List<SubCategory> getSubCategory(Integer category_id){
		Query query = sessionFactory.getCurrentSession().createQuery("from subcategory where category_id = :category_id");
		query.setParameter("category_id", category_id);
		
		@SuppressWarnings("unchecked")
		List<SubCategory> subcategory = query.list();
		
		if (subcategory.size() > 0)  
            return subcategory;  
        else  
            return null; 
	}

	public void removeSubCategory(Integer subcategory_id) {
		SubCategory subcategory = (SubCategory) sessionFactory.getCurrentSession().load(SubCategory.class, subcategory_id);
		
        if (null != subcategory) {
            sessionFactory.getCurrentSession().delete(subcategory);
        }
		
	}

	@Override
	public List<SubCategory> getSubCategoryByName(String subcategory_name) {
		Query query = sessionFactory.getCurrentSession().createQuery("from subcategory where subcategory_name = :subcategory_name");
		query.setParameter("subcategory_name", subcategory_name);
		
		@SuppressWarnings("unchecked")
		List<SubCategory> subcategory = query.list();
		
		if (subcategory.size() > 0)  
            return subcategory;  
        else  
            return null; 
	}

}
