package com.mojoping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mojoping.DAO.ProfitDAO;
import com.mojoping.model.Profit;



@Service
public class ProfitServiceImpl implements ProfitService{

	@Autowired
	ProfitDAO profitDAO;
	
	@Transactional
	public void addProfit(Profit profit) {
		profitDAO.addProfit(profit);
		
	}
	@Transactional
	public List<Profit> listProfit() {
	    return profitDAO.listProfit();
	}
	@Transactional
	public Profit getProfit(Integer profit_id) {
		
		return profitDAO.getProfit(profit_id);
	}
	@Transactional
	public List<Profit> getProfitWithProcedureId(
			Integer procedure_id) {
		return profitDAO.getProfitWithProcedureId(procedure_id);
	}
	@Transactional
	public void removeProfit(Integer profit_id) {
		profitDAO.removeProfit(profit_id);
		
	}
	
	@Transactional
	public void updateProfit(Profit profit) {
		profitDAO.updateProfit(profit);
		
	}

}
