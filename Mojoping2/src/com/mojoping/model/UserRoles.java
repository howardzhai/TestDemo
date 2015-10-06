package com.mojoping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="user_roles")
@Table(name="user_roles")
public class UserRoles {
	
	@Id
	@Column(name="user_role_id")
	@GeneratedValue
	private Integer user_role_id;
	
	@ManyToOne  
	@JoinColumn(name = "user_id")  
	private User user;
	
	@Column(name="authority")
	private String authority;

	public Integer getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(Integer user_role_id) {
		this.user_role_id = user_role_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	

}
