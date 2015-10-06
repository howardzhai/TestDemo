package com.mojoping.DAO;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mojoping.model.Garbage;

@Repository
public class GarbageDAOImpl implements GarbageDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addGarbage(Garbage garbage) {
		
		sessionFactory.getCurrentSession().save(garbage);
	}
	@SuppressWarnings("unchecked")
	public List<Garbage> listGarbage() {
		return sessionFactory.getCurrentSession().createQuery("from garbage").list();
	}

	public Garbage getGarbage(Integer garbage_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from garbage where garbage_id = :garbage_id");
		query.setParameter("garbage_id", garbage_id);
		
		@SuppressWarnings("unchecked")
		List<Garbage> garbage = query.list();
		
		if (garbage.size() > 0)  
            return garbage.get(0);  
        else  
            return null;  
	}

	public List<Garbage> getGarbageWithProcedureId(Integer procedure_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from garbage where procedure_id = :procedure_id");
		query.setParameter("procedure_id", procedure_id);
		
		@SuppressWarnings("unchecked")
		List<Garbage> garbage = query.list();
		
		if (garbage.size() > 0)  
            return garbage;  
        else  
            return null;  
	}


	public void removeGarbage(Integer garbage_id) {
		Garbage garbage = (Garbage) sessionFactory.getCurrentSession().load(Garbage.class, garbage_id);
		
        if (null != garbage) {
            sessionFactory.getCurrentSession().delete(garbage);
        }
		
	}
	
	public void  updateGarbage(Garbage garbage){
		
		if (null != garbage) {
            sessionFactory.getCurrentSession().update(garbage);

	}
	}





	


}
