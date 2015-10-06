package com.mojoping.DAO;

import java.util.List;

import com.mojoping.model.UserRoles;

public interface UserRolesDAO {
	
	public void addUserRoles(UserRoles user_roles);
	
	public List<UserRoles> listUserRoles();
	
	public void removeUserRoles(Integer user_roles_id);
	
	public UserRoles getUserRoles(Integer user_id);
}
