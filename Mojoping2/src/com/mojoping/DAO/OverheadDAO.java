package com.mojoping.DAO;

import java.util.List;

import com.mojoping.model.Overhead;

public interface OverheadDAO {

	public void addOverhead(Overhead overhead);
	
	public List<Overhead> listOverhead();
	
	public Overhead getOverhead(Integer overhead_id);
	
	public List<Overhead> getOverheadWithProcedureId(Integer procedure_id);
	
	public void removeOverhead(Integer overhead_id);
	
	public void updateOverhead(Overhead overhead);
}
