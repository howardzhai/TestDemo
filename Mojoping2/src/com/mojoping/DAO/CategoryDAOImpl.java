package com.mojoping.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mojoping.model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addCategory(Category category) {
		sessionFactory.getCurrentSession().save(category);		
	}

	@SuppressWarnings("unchecked")
	public List<Category> listCategory() {
		return sessionFactory.getCurrentSession().createQuery("from category").list();
	}

	public void removeCategory(Integer category_id) {
		Category category = (Category) sessionFactory.getCurrentSession().load(Category.class, category_id);
		
        if (null != category) {
            sessionFactory.getCurrentSession().delete(category);
        }		
	}

	public Category getCategory(String category_name) {
		Query query = sessionFactory.getCurrentSession().createQuery("from category where category_name = :category_name");
		query.setParameter("category_name", category_name);
		
		@SuppressWarnings("unchecked")
		List<Category> category = query.list();
		
		if (category.size() > 0)  
            return category.get(0);  
        else  
            return null;  
	}

}
