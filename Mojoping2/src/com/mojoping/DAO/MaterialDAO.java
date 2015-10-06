package com.mojoping.DAO;

import java.util.List;

import com.mojoping.model.Material;

public interface MaterialDAO {

	public void addMaterial(Material material);
	
	public List<Material> listMaterial();
	
	public Material getMaterial(Integer material_id);
	
	public List<Material> getMaterialWithProcedureId(Integer procedure_id);
	
	public void removeMaterial(Integer material_id);
	
	public void updateMaterial(Material material);
}
