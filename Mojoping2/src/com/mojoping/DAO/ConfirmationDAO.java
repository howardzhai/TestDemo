package com.mojoping.DAO;

import com.mojoping.model.Confirmation;

public interface ConfirmationDAO {
	
	public void addConfirmation(Confirmation confirmation);
	
	public Confirmation getConfirmation(String username);
	
	public void updateConfirmation(Confirmation confirmation);

}
