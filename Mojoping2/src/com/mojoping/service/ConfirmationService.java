package com.mojoping.service;

import com.mojoping.model.Confirmation;

public interface ConfirmationService {
	
	public void addConfirmation(Confirmation confirmation);
	
	public Confirmation getConfirmation(String confirmation);
	
	public void updateConfirmation(Confirmation confirmation);

}
