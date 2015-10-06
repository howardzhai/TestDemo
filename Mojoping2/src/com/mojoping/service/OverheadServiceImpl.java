package com.mojoping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mojoping.DAO.OverheadDAO;
import com.mojoping.model.Overhead;



@Service
public class OverheadServiceImpl implements OverheadService{

	@Autowired
	OverheadDAO overheadDAO;
	
	@Transactional
	public void addOverhead(Overhead overhead) {
		overheadDAO.addOverhead(overhead);
		
	}
	@Transactional
	public List<Overhead> listOverhead() {
	    return overheadDAO.listOverhead();
	}
	@Transactional
	public Overhead getOverhead(Integer overhead_id) {
		
		return overheadDAO.getOverhead(overhead_id);
	}
	@Transactional
	public List<Overhead> getOverheadWithProcedureId(
			Integer procedure_id) {
		return overheadDAO.getOverheadWithProcedureId(procedure_id);
	}
	@Transactional
	public void removeOverhead(Integer overhead_id) {
		overheadDAO.removeOverhead(overhead_id);
		
	}
	
	@Transactional
	public void updateOverhead(Overhead overhead) {
		overheadDAO.updateOverhead(overhead);
		
	}
	
	

}
