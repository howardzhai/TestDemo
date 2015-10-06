package com.mojoping.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mojoping.model.Checklist;

@Repository
public class ChecklistDAOImpl implements ChecklistDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addChecklist(Checklist checklist) {
		sessionFactory.getCurrentSession().save(checklist);	
	}

	@SuppressWarnings("unchecked")
	public List<Checklist> listChecklist() {
		return sessionFactory.getCurrentSession().createQuery("from checklist").list();
	}

	public List<Checklist>  getChecklistByCategory(Integer category_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from checklist where category_id = :category_id");
		query.setParameter("category_id", category_id);
		
		@SuppressWarnings("unchecked")
		List<Checklist> checklist = query.list();
		
		if (checklist.size() > 0)  
            return checklist;  
        else  
            return null;  
	}

	public List<Checklist> getChecklistBySubCategory(Integer subcategory_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from checklist where subcategory_id = :subcategory_id");
		query.setParameter("subcategory_id", subcategory_id);
		
		@SuppressWarnings("unchecked")
		List<Checklist> checklist = query.list();
		
		if (checklist.size() > 0)  
            return checklist;  
        else  
            return null;  
	}

	public List<Checklist> listChecklistByUsername(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery("from checklist where username = :username");
		query.setParameter("username", username);
		
		@SuppressWarnings("unchecked")
		List<Checklist> checklist = query.list();
		
		if (checklist.size() > 0)  
            return checklist;  
        else  
            return null;  
	}
	
	public List<Checklist> listChecklistByShare(Integer share) {
		Query query = sessionFactory.getCurrentSession().createQuery("from checklist where share > :share");
		query.setParameter("share", share);
		
		@SuppressWarnings("unchecked")
		List<Checklist> checklist = query.list();
		
		if (checklist.size() > 0)  
            return checklist;  
        else  
            return null;  
	}
	
	public Checklist getChecklistByUsername(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery("from checklist where username = :username");
		query.setParameter("username", username);
		
		@SuppressWarnings("unchecked")
		List<Checklist> checklist = query.list();
		
		if (checklist.size() > 0)  
            return checklist.get(0);  
        else  
            return null;  
	}

	public void removeChecklist(Integer checklist_id) {
		Checklist checklist = (Checklist) sessionFactory.getCurrentSession().load(Checklist.class, checklist_id);
		
        if (null != checklist) {
            sessionFactory.getCurrentSession().delete(checklist);
        }

	}

	public List<Checklist> listChecklistByTitle(String title) {
		Query query = sessionFactory.getCurrentSession().createQuery("from checklist where title = :title");
		query.setParameter("title", title);
		
		@SuppressWarnings("unchecked")
		List<Checklist> checklist = query.list();
		
		if (checklist.size() > 0)  
            return checklist;  
        else  
            return null;  
         
	}

	public Checklist getChecklistByChecklistId(Integer checklist_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from checklist where checklist_id = :checklist_id");
		query.setParameter("checklist_id", checklist_id);
		
		@SuppressWarnings("unchecked")
		List<Checklist> checklist = query.list();
		
		if (checklist.size() > 0)  
            return checklist.get(0);  
        else  
            return null;  
	}
	
	public void updateChecklistUsername(Integer checklist_id,String username) {
		Checklist checklist = (Checklist) sessionFactory.getCurrentSession().load(Checklist.class, checklist_id);
		checklist.setUsername(username);
        if (null != checklist) {
            sessionFactory.getCurrentSession().update(checklist);

	}
	}
	
	public void updateChecklistShare(Integer checklist_id,Integer share) {
		Checklist checklist = (Checklist) sessionFactory.getCurrentSession().load(Checklist.class, checklist_id);
		checklist.setShare(share);
        if (null != checklist) {
            sessionFactory.getCurrentSession().update(checklist);

	}
	}
	
	public void updateChecklist(Checklist checklist){
		if (null != checklist) {
            sessionFactory.getCurrentSession().update(checklist);

	}
	}
	
	

}
