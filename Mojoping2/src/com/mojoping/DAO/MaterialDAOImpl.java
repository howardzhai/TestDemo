package com.mojoping.DAO;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mojoping.model.Material;

@Repository
public class MaterialDAOImpl implements MaterialDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addMaterial(Material material) {
		
		sessionFactory.getCurrentSession().save(material);
	}
	@SuppressWarnings("unchecked")
	public List<Material> listMaterial() {
		return sessionFactory.getCurrentSession().createQuery("from material").list();
	}

	public Material getMaterial(Integer material_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from material where material_id = :material_id");
		query.setParameter("material_id", material_id);
		
		@SuppressWarnings("unchecked")
		List<Material> material = query.list();
		
		if (material.size() > 0)  
            return material.get(0);  
        else  
            return null;  
	}

	public List<Material> getMaterialWithProcedureId(Integer procedure_id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from material where procedure_id = :procedure_id");
		query.setParameter("procedure_id", procedure_id);
		
		@SuppressWarnings("unchecked")
		List<Material> material = query.list();
		
		if (material.size() > 0)  
            return material;  
        else  
            return null;  
	}


	public void removeMaterial(Integer material_id) {
		Material material = (Material) sessionFactory.getCurrentSession().load(Material.class, material_id);
		
        if (null != material) {
            sessionFactory.getCurrentSession().delete(material);
        }
		
	}
	
	public void updateMaterial(Material material){
		
		if (null != material) {
            sessionFactory.getCurrentSession().update(material);

	}
	}


	


}
