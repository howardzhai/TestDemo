package com.mojoping.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mojoping.model.SuggestCategory;

@Repository
public class SuggestCategoryDAOImpl implements SuggestCategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addSuggestCategory(SuggestCategory suggestcategory) {
		sessionFactory.getCurrentSession().save(suggestcategory);		
	}

	@SuppressWarnings("unchecked")
	public List<SuggestCategory> listSuggestCategory() {
		return sessionFactory.getCurrentSession().createQuery("from suggest_category").list();
	}

	public void removeSuggestCategory(Integer suggest_category_id) {
		SuggestCategory suggestcategory = (SuggestCategory) sessionFactory.getCurrentSession().load(SuggestCategory.class, suggest_category_id);
		
        if (null != suggestcategory) {
            sessionFactory.getCurrentSession().delete(suggestcategory);
        }		
	}

	public SuggestCategory getSuggestCategory(String suggest_category_name) {
		Query query = sessionFactory.getCurrentSession().createQuery("from suggest_category where suggest_category_name = :suggest_category_name");
		query.setParameter("suggest_category_name", suggest_category_name);
		
		@SuppressWarnings("unchecked")
		List<SuggestCategory> category = query.list();
		
		if (category.size() > 0)  
            return category.get(0);  
        else  
            return null;  
	}

}
