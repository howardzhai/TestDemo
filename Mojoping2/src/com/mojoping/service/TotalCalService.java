package com.mojoping.service;

import java.util.List;

import com.mojoping.model.TotalCal;

public interface TotalCalService {
	public void addTotalCal(TotalCal totalcal);
	
	public List<TotalCal> listTotalCal();
	
	public TotalCal getTotalCal(Integer totalcal_id);
	
	public List<TotalCal> getTotalCalWithChecklistId(Integer checklist_id);
	
	public void removeTotalCal(Integer totalcal_id);
	
	public void updateTotalCal(TotalCal totalcal);

}
