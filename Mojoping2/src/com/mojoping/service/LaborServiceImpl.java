package com.mojoping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mojoping.DAO.LaborDAO;
import com.mojoping.model.Labor;



@Service
public class LaborServiceImpl implements LaborService{

	@Autowired
	LaborDAO laborDAO;
	
	@Transactional
	public void addLabor(Labor labor) {
		laborDAO.addLabor(labor);
		
	}
	@Transactional
	public List<Labor> listLabor() {
	    return laborDAO.listLabor();
	}
	@Transactional
	public Labor getLabor(Integer labor_id) {
		
		return laborDAO.getLabor(labor_id);
	}
	@Transactional
	public List<Labor> getLaborWithProcedureId(
			Integer procedure_id) {
		return laborDAO.getLaborWithProcedureId(procedure_id);
	}
	@Transactional
	public void removeLabor(Integer labor_id) {
		laborDAO.removeLabor(labor_id);
		
	}
	
	@Transactional
	public void updateLabor(Labor labor) {
		laborDAO.updateLabor(labor);
		
	}

}
