package com.mojoping.DAO;

import java.util.List;

import com.mojoping.model.Garbage;

public interface GarbageDAO {

	public void addGarbage(Garbage garbage);
	
	public List<Garbage> listGarbage();
	
	public Garbage getGarbage(Integer garbage_id);
	
	public List<Garbage> getGarbageWithProcedureId(Integer procedure_id);
	
	public void removeGarbage(Integer garbage_id);
	
	public void  updateGarbage(Garbage garbage);
}
