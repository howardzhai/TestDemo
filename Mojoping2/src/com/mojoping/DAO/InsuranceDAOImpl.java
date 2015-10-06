package com.mojoping.DAO;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mojoping.model.Insurance;

@Repository
public class InsuranceDAOImpl implements InsuranceDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addInsurance(Insurance insurance) {
		
		sessionFactory.getCurrentSession().save(insurance);
	}
	@SuppressWarnings("unchecked")
	public List<Insurance> listInsurance() {
		return sessionFactory.getCurrentSession().createQuery("from insurance").list();
	}

	public Insurance getInsurance(Integer insurance_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from insurance where insurance_id = :insurance_id");
		query.setParameter("insurance_id", insurance_id);
		
		@SuppressWarnings("unchecked")
		List<Insurance> insurance = query.list();
		
		if (insurance.size() > 0)  
            return insurance.get(0);  
        else  
            return null;  
	}

	public List<Insurance> getInsuranceWithProcedureId(Integer procedure_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from insurance where procedure_id = :procedure_id");
		query.setParameter("procedure_id", procedure_id);
		
		@SuppressWarnings("unchecked")
		List<Insurance> insurance = query.list();
		
		if (insurance.size() > 0)  
            return insurance;  
        else  
            return null;  
	}


	public void removeInsurance(Integer insurance_id) {
		Insurance insurance = (Insurance) sessionFactory.getCurrentSession().load(Insurance.class, insurance_id);
		
        if (null != insurance) {
            sessionFactory.getCurrentSession().delete(insurance);
        }
		
	}
	
	public void updateInsurance(Insurance insurance){
		if (null != insurance) {
            sessionFactory.getCurrentSession().update(insurance);

	}
	}





	


}
