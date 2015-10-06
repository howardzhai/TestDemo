package com.mojoping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mojoping.DAO.MaterialDAO;
import com.mojoping.model.Material;



@Service
public class MaterialServiceImpl implements MaterialService{

	@Autowired
	MaterialDAO materialDAO;
	
	@Transactional
	public void addMaterial(Material material) {
		materialDAO.addMaterial(material);
		
	}
	@Transactional
	public List<Material> listMaterial() {
	    return materialDAO.listMaterial();
	}
	@Transactional
	public Material getMaterial(Integer material_id) {
		
		return materialDAO.getMaterial(material_id);
	}
	@Transactional
	public List<Material> getMaterialWithProcedureId(
			Integer procedure_id) {
		return materialDAO.getMaterialWithProcedureId(procedure_id);
	}
	@Transactional
	public void removeMaterial(Integer material_id) {
		materialDAO.removeMaterial(material_id);
		
	}
	
	@Transactional
	public void updateMaterial(Material material) {
		materialDAO.updateMaterial(material);
		
	}

}
