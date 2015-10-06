package com.mojoping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mojoping.DAO.UserRolesDAO;
import com.mojoping.model.UserRoles;

@Service
public class UserRolesServiceImpl implements UserRolesService{
	
	@Autowired
	UserRolesDAO user_rolesDAO;

	@Transactional
	public void addUserRoles(UserRoles user_roles) {
		user_rolesDAO.addUserRoles(user_roles);		
	}

	@Transactional
	public List<UserRoles> listUserRoles() {
		return user_rolesDAO.listUserRoles();
	}

	@Transactional
	public void removeUserRoles(Integer user_roles_id) {
		user_rolesDAO.removeUserRoles(user_roles_id);
	}

	@Transactional
	public UserRoles getUserRoles(Integer user_id) {
		return user_rolesDAO.getUserRoles(user_id);
	}

}
