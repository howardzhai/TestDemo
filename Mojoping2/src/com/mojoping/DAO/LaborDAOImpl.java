package com.mojoping.DAO;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mojoping.model.Labor;

@Repository
public class LaborDAOImpl implements LaborDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addLabor(Labor labor) {
		
		sessionFactory.getCurrentSession().save(labor);
	}
	@SuppressWarnings("unchecked")
	public List<Labor> listLabor() {
		return sessionFactory.getCurrentSession().createQuery("from labor").list();
	}

	public Labor getLabor(Integer labor_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from labor where labor_id = :labor_id");
		query.setParameter("labor_id", labor_id);
		
		@SuppressWarnings("unchecked")
		List<Labor> labor = query.list();
		
		if (labor.size() > 0)  
            return labor.get(0);  
        else  
            return null;  
	}

	public List<Labor> getLaborWithProcedureId(Integer procedure_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from labor where procedure_id = :procedure_id");
		query.setParameter("procedure_id", procedure_id);
		
		@SuppressWarnings("unchecked")
		List<Labor> labor = query.list();
		
		if (labor.size() > 0)  
            return labor;  
        else  
            return null;  
	}


	public void removeLabor(Integer labor_id) {
		Labor labor = (Labor) sessionFactory.getCurrentSession().load(Labor.class, labor_id);
		
        if (null != labor) {
            sessionFactory.getCurrentSession().delete(labor);
        }
		
	}
	
	public void updateLabor(Labor labor){
		if (null != labor) {
            sessionFactory.getCurrentSession().update(labor);

	}
	}




	


}
