package com.mojoping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mojoping.DAO.ConfirmationDAO;
import com.mojoping.model.Confirmation;

@Service
public class ConfirmationServiceImpl implements ConfirmationService {
	
	@Autowired
	ConfirmationDAO confirmationDAO;
	
	@Transactional
	public void addConfirmation(Confirmation confirmation) {
		confirmationDAO.addConfirmation(confirmation);
	}

	@Transactional
	public Confirmation getConfirmation(String confirmation) {
		return confirmationDAO.getConfirmation(confirmation);
	}

	@Transactional
	public void updateConfirmation(Confirmation confirmation) {
		confirmationDAO.updateConfirmation(confirmation);
	}

}
