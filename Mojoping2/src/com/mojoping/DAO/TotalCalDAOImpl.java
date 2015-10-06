package com.mojoping.DAO;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mojoping.model.TotalCal;

@Repository
public class TotalCalDAOImpl implements TotalCalDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addTotalCal(TotalCal totalcal) {
		
		sessionFactory.getCurrentSession().save(totalcal);
	}
	@SuppressWarnings("unchecked")
	public List<TotalCal> listTotalCal() {
		return sessionFactory.getCurrentSession().createQuery("from totalcal").list();
	}

	public TotalCal getTotalCal(Integer totalcal_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from totalcal where totalcal_id = :totalcal_id");
		query.setParameter("totalcal_id", totalcal_id);
		
		@SuppressWarnings("unchecked")
		List<TotalCal> totalcal = query.list();
		
		if (totalcal.size() > 0)  
            return totalcal.get(0);  
        else  
            return null;  
	}

	public List<TotalCal> getTotalCalWithChecklistId(Integer checklist_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from totalcal where checklist_id = :checklist_id");
		query.setParameter("checklist_id", checklist_id);
		
		@SuppressWarnings("unchecked")
		List<TotalCal> totalcal = query.list();
		
		if (totalcal.size() > 0)  
            return totalcal;  
        else  
            return null;  
	}


	public void removeTotalCal(Integer totalcal_id) {
		TotalCal totalcal = (TotalCal) sessionFactory.getCurrentSession().load(TotalCal.class, totalcal_id);
		
        if (null != totalcal) {
            sessionFactory.getCurrentSession().delete(totalcal);
        }
		
	}

	public void updateTotalCal(TotalCal totalcal){
		if (null != totalcal) {
            sessionFactory.getCurrentSession().update(totalcal);

	}
	}



	


}
