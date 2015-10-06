package com.mojoping.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mojoping.model.User;
import com.mojoping.model.UserRoles;

@Repository
public class UserRolesDAOImpl implements UserRolesDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addUserRoles(UserRoles user_roles) {
		sessionFactory.getCurrentSession().save(user_roles);
	}

	@SuppressWarnings("unchecked")
	public List<UserRoles> listUserRoles() {
		return sessionFactory.getCurrentSession().createQuery("from user_roles").list();
	}

	public void removeUserRoles(Integer user_roles_id) {
		UserRoles user_roles = (UserRoles) sessionFactory.getCurrentSession().load(User.class, user_roles_id);
		
        if (null != user_roles) {
            sessionFactory.getCurrentSession().delete(user_roles);
        }

	}

	public UserRoles getUserRoles(Integer user_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from user_roles where user_id = :user_id");
		query.setParameter("user_id", user_id);
		
		@SuppressWarnings("unchecked")
		List<UserRoles> user_roles = query.list();
		
		if (user_roles.size() > 0)  
            return user_roles.get(0);  
        else  
            return null;
	}

}
