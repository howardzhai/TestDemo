package com.mojoping.DAO;

import java.util.List;

import com.mojoping.model.Profit;

public interface ProfitDAO {

	public void addProfit(Profit profit);
	
	public List<Profit> listProfit();
	
	public Profit getProfit(Integer profit_id);
	
	public List<Profit> getProfitWithProcedureId(Integer procedure_id);
	
	public void removeProfit(Integer profit_id);
	
	public void updateProfit(Profit profit);
}
