package com.mojoping.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mojoping.model.Confirmation;

@Repository
public class ConfirmationDAOImpl implements ConfirmationDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addConfirmation(Confirmation confirmation) {
		sessionFactory.getCurrentSession().save(confirmation);
	}

	public Confirmation getConfirmation(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery("from confirmation where username = :username");
		query.setParameter("username", username);
		
		@SuppressWarnings("unchecked")
		List<Confirmation> confirmation = query.list();
		
		if (confirmation.size() > 0)  
            return confirmation.get(0);  
        else  
            return null;   
	}

	public void updateConfirmation(Confirmation confirmation) {
		sessionFactory.getCurrentSession().update(confirmation);

	}

}
