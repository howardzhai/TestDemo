package com.mojoping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mojoping.DAO.GarbageDAO;
import com.mojoping.model.Garbage;



@Service
public class GarbageServiceImpl implements GarbageService{

	@Autowired
	GarbageDAO garbageDAO;
	
	@Transactional
	public void addGarbage(Garbage garbage) {
		garbageDAO.addGarbage(garbage);
		
	}
	@Transactional
	public List<Garbage> listGarbage() {
	    return garbageDAO.listGarbage();
	}
	@Transactional
	public Garbage getGarbage(Integer garbage_id) {
		
		return garbageDAO.getGarbage(garbage_id);
	}
	@Transactional
	public List<Garbage> getGarbageWithProcedureId(
			Integer procedure_id) {
		return garbageDAO.getGarbageWithProcedureId(procedure_id);
	}
	@Transactional
	public void removeGarbage(Integer garbage_id) {
		garbageDAO.removeGarbage(garbage_id);
		
	}
	
	
	@Transactional
	public void updateGarbage(Garbage garbage) {
		garbageDAO.updateGarbage(garbage);
		
	}

}
