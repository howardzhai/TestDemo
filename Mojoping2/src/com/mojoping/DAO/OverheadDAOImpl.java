package com.mojoping.DAO;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mojoping.model.Overhead;

@Repository
public class OverheadDAOImpl implements OverheadDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addOverhead(Overhead overhead) {
		
		sessionFactory.getCurrentSession().save(overhead);
	}
	@SuppressWarnings("unchecked")
	public List<Overhead> listOverhead() {
		return sessionFactory.getCurrentSession().createQuery("from overhead").list();
	}

	public Overhead getOverhead(Integer overhead_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from overhead where overhead_id = :overhead_id");
		query.setParameter("overhead_id", overhead_id);
		
		@SuppressWarnings("unchecked")
		List<Overhead> overhead = query.list();
		
		if (overhead.size() > 0)  
            return overhead.get(0);  
        else  
            return null;  
	}

	public List<Overhead> getOverheadWithProcedureId(Integer procedure_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from overhead where procedure_id = :procedure_id");
		query.setParameter("procedure_id", procedure_id);
		
		@SuppressWarnings("unchecked")
		List<Overhead> overhead = query.list();
		
		if (overhead.size() > 0)  
            return overhead;  
        else  
            return null;  
	}


	public void removeOverhead(Integer overhead_id) {
		Overhead overhead = (Overhead) sessionFactory.getCurrentSession().load(Overhead.class, overhead_id);
		
        if (null != overhead) {
            sessionFactory.getCurrentSession().delete(overhead);
        }
		
	}
	
	public void updateOverhead(Overhead overhead){
		if (null != overhead) {
            sessionFactory.getCurrentSession().update(overhead);

	}


	}


	


}
