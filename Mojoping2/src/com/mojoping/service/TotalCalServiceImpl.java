package com.mojoping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mojoping.DAO.TotalCalDAO;
import com.mojoping.model.TotalCal;



@Service
public class TotalCalServiceImpl implements TotalCalService{

	@Autowired
	TotalCalDAO totalcalDAO;
	
	@Transactional
	public void addTotalCal(TotalCal totalcal) {
		totalcalDAO.addTotalCal(totalcal);
		
	}
	@Transactional
	public List<TotalCal> listTotalCal() {
	    return totalcalDAO.listTotalCal();
	}
	@Transactional
	public TotalCal getTotalCal(Integer totalcal_id) {
		
		return totalcalDAO.getTotalCal(totalcal_id);
	}
	@Transactional
	public List<TotalCal> getTotalCalWithChecklistId(
			Integer checklist_id) {
		return totalcalDAO.getTotalCalWithChecklistId(checklist_id);
	}
	@Transactional
	public void removeTotalCal(Integer totalcal_id) {
		totalcalDAO.removeTotalCal(totalcal_id);
		
	}
	
	@Transactional
	public void updateTotalCal(TotalCal totalcal) {
		totalcalDAO.updateTotalCal(totalcal);
		
	}

}
