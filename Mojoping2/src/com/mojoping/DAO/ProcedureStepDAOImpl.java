package com.mojoping.DAO;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mojoping.model.Checklist;
import com.mojoping.model.ProcedureStep;

@Repository
public class ProcedureStepDAOImpl implements ProcedureStepDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addProcedureStep(ProcedureStep procedurestep) {
		sessionFactory.getCurrentSession().save(procedurestep);
		
	}
	@SuppressWarnings("unchecked")
	public List<ProcedureStep> listProcedureStep() {
		return sessionFactory.getCurrentSession().createQuery("from procedurestep").list();
		
	}

	public ProcedureStep getProcedureStep(Integer procedurestep_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from procedurestep where procedure_id = :procedure_id");
		query.setParameter("procedure_id", procedurestep_id);
		
		@SuppressWarnings("unchecked")
		List<ProcedureStep> procedurestep = query.list();
		
		if (procedurestep.size() > 0)  
            return procedurestep.get(0);  
        else  
            return null;  
	}

	public List<ProcedureStep> getProcedureStepWithChecklistId(
			Integer checklist_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from procedurestep where checklist_id = :checklist_id");
		query.setParameter("checklist_id", checklist_id);
		
		@SuppressWarnings("unchecked")
		List<ProcedureStep> procedurestep = query.list();
		
		if (procedurestep.size() > 0)  
            return procedurestep;  
        else  
            return null;  
	}

	public void removeProcedureStep(Integer procedurestep_id) {
	ProcedureStep procedurestep = (ProcedureStep) sessionFactory.getCurrentSession().load(ProcedureStep.class, procedurestep_id);
		
        if (null != procedurestep) {
            sessionFactory.getCurrentSession().delete(procedurestep);
        }
	}
	
	public void updateProcedureStep(ProcedureStep procedurestep){
		if (null != procedurestep) {
            sessionFactory.getCurrentSession().update(procedurestep);

	}
	}

}
