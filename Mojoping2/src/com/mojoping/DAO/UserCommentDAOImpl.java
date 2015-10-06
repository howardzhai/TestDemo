package com.mojoping.DAO;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mojoping.model.UserComment;

@Repository
public class UserCommentDAOImpl implements UserCommentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addUserComment(UserComment usercomment) {
		
		sessionFactory.getCurrentSession().save(usercomment);
	}
	@SuppressWarnings("unchecked")
	public List<UserComment> listUserComment() {
		return sessionFactory.getCurrentSession().createQuery("from usercomment").list();
	}

	public UserComment getUserComment(Integer usercomment_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from usercomment where usercomment_id = :usercomment_id");
		query.setParameter("usercomment_id", usercomment_id);
		
		@SuppressWarnings("unchecked")
		List<UserComment> usercomment = query.list();
		
		if (usercomment.size() > 0)  
            return usercomment.get(0);  
        else  
            return null;  
	}

	public List<UserComment> getUserCommentWithUserId(Integer user_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from usercomment where user_id = :user_id");
		query.setParameter("user_id", user_id);
		
		@SuppressWarnings("unchecked")
		List<UserComment> usercomment = query.list();
		
		if (usercomment.size() > 0)  
            return usercomment;  
        else  
            return null;  
	}
	
	
	public List<UserComment> getUserCommentWithChecklistId(Integer checklist_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from usercomment where checklist_id = :checklist_id");
		query.setParameter("checklist_id", checklist_id);
		
		@SuppressWarnings("unchecked")
		List<UserComment> usercomment = query.list();
		
		if (usercomment.size() > 0)  
            return usercomment;  
        else  
            return null;  
	}


	public void removeUserComment(Integer usercomment_id) {
		UserComment usercomment = (UserComment) sessionFactory.getCurrentSession().load(UserComment.class, usercomment_id);
		
        if (null != usercomment) {
            sessionFactory.getCurrentSession().delete(usercomment);
        }
		
	}





	


}
