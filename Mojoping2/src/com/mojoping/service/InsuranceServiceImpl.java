package com.mojoping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mojoping.DAO.InsuranceDAO;
import com.mojoping.model.Insurance;



@Service
public class InsuranceServiceImpl implements InsuranceService{

	@Autowired
	InsuranceDAO insuranceDAO;
	
	@Transactional
	public void addInsurance(Insurance insurance) {
		insuranceDAO.addInsurance(insurance);
		
	}
	@Transactional
	public List<Insurance> listInsurance() {
	    return insuranceDAO.listInsurance();
	}
	@Transactional
	public Insurance getInsurance(Integer insurance_id) {
		
		return insuranceDAO.getInsurance(insurance_id);
	}
	@Transactional
	public List<Insurance> getInsuranceWithProcedureId(
			Integer procedure_id) {
		return insuranceDAO.getInsuranceWithProcedureId(procedure_id);
	}
	@Transactional
	public void removeInsurance(Integer insurance_id) {
		insuranceDAO.removeInsurance(insurance_id);
		
	}
	
	@Transactional
	public void updateInsurance(Insurance insurance) {
		insuranceDAO.updateInsurance(insurance);
		
	}

}
