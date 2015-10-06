package com.mojoping.DAO;

import java.util.List;

import com.mojoping.model.Labor;

public interface LaborDAO {

	public void addLabor(Labor labor);
	
	public List<Labor> listLabor();
	
	public Labor getLabor(Integer labor_id);
	
	public List<Labor> getLaborWithProcedureId(Integer procedure_id);
	
	public void removeLabor(Integer labor_id);
	
	public void updateLabor(Labor labor);
}
