package com.mojoping.DAO;

import java.util.List;

import com.mojoping.model.TotalCal;

public interface TotalCalDAO {

	public void addTotalCal(TotalCal totalcal);
	
	public List<TotalCal> listTotalCal();
	
	public TotalCal getTotalCal(Integer totalcal_id);
	
	public List<TotalCal> getTotalCalWithChecklistId(Integer checklist_id);
	
	public void removeTotalCal(Integer totalcal_id);
	
	public void updateTotalCal(TotalCal totalcal);
}
