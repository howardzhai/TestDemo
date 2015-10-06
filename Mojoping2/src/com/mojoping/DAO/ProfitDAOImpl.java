package com.mojoping.DAO;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mojoping.model.Profit;

@Repository
public class ProfitDAOImpl implements ProfitDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addProfit(Profit profit) {
		
		sessionFactory.getCurrentSession().save(profit);
	}
	@SuppressWarnings("unchecked")
	public List<Profit> listProfit() {
		return sessionFactory.getCurrentSession().createQuery("from profit").list();
	}

	public Profit getProfit(Integer profit_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from profit where profit_id = :profit_id");
		query.setParameter("profit_id", profit_id);
		
		@SuppressWarnings("unchecked")
		List<Profit> profit = query.list();
		
		if (profit.size() > 0)  
            return profit.get(0);  
        else  
            return null;  
	}

	public List<Profit> getProfitWithProcedureId(Integer procedure_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from profit where procedure_id = :procedure_id");
		query.setParameter("procedure_id", procedure_id);
		
		@SuppressWarnings("unchecked")
		List<Profit> profit = query.list();
		
		if (profit.size() > 0)  
            return profit;  
        else  
            return null;  
	}


	public void removeProfit(Integer profit_id) {
		Profit profit = (Profit) sessionFactory.getCurrentSession().load(Profit.class, profit_id);
		
        if (null != profit) {
            sessionFactory.getCurrentSession().delete(profit);
        }
		
	}
	
	public void updateProfit(Profit profit){
		if (null != profit) {
            sessionFactory.getCurrentSession().update(profit);

		
	}


	}


	


}
