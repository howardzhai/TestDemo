package com.mojoping.service;

import java.util.List;

import com.mojoping.model.ProcedureStep;

public interface ProcedureStepService {

	public void addProcedureStep(ProcedureStep procedurestep);
	
	public List<ProcedureStep> listProcedureStep();
	
	public ProcedureStep getProcedureStep(Integer procedurestep_id);
	
	public List<ProcedureStep> getProcedureStepWithChecklistId(Integer checklist_id);
	
	public void removeProcedureStep(Integer procedurestep_id);
	
	public void updateProcedureStep(ProcedureStep procedurestep);
}
