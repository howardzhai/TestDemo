package com.mojoping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mojoping.DAO.ProcedureStepDAO;
import com.mojoping.model.ProcedureStep;



@Service
public class ProcedureStepServiceImpl implements ProcedureStepService{

	@Autowired
	ProcedureStepDAO procedurestepDAO;
	
	@Transactional
	public void addProcedureStep(ProcedureStep procedurestep) {
		procedurestepDAO.addProcedureStep(procedurestep);
		
	}
	@Transactional
	public List<ProcedureStep> listProcedureStep() {
	    return procedurestepDAO.listProcedureStep();
	}
	@Transactional
	public ProcedureStep getProcedureStep(Integer procedurestep_id) {
		
		return procedurestepDAO.getProcedureStep(procedurestep_id);
	}
	@Transactional
	public List<ProcedureStep> getProcedureStepWithChecklistId(
			Integer checklist_id) {
		return procedurestepDAO.getProcedureStepWithChecklistId(checklist_id);
	}
	@Transactional
	public void removeProcedureStep(Integer procedurestep_id) {
		procedurestepDAO.removeProcedureStep(procedurestep_id);
		
	}
	@Transactional
	public void updateProcedureStep(ProcedureStep procedurestep){
		procedurestepDAO.updateProcedureStep(procedurestep);
		
	}

}
