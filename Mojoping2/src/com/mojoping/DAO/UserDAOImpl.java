package com.mojoping.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mojoping.model.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> listUser() {
		return sessionFactory.getCurrentSession().createQuery("from user").list();
	}

	public void removeUser(Integer user_id) {
		User user = (User) sessionFactory.getCurrentSession().load(User.class, user_id);
		
        if (null != user) {
            sessionFactory.getCurrentSession().delete(user);
        }
	}

	public User getUser(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery("from user where username = :username");
		query.setParameter("username", username);
		
		@SuppressWarnings("unchecked")
		List<User> user = query.list();
		
		if (user.size() > 0)  
            return user.get(0);  
        else  
            return null;   
	}

	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);		
	}

}
