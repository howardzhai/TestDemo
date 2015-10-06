package com.mojoping.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="confirmation")
@Table(name="confirmation")
public class Confirmation {
	
	@Id
	@Column(name="confirmation_id")
	private String confirmation_id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="creation")
	private Date creation;
	
	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public String getConfirmation_id() {
		return confirmation_id;
	}

	public void setConfirmation_id(String confirmation_id) {
		this.confirmation_id = confirmation_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
