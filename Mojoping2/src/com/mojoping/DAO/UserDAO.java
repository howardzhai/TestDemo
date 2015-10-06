package com.mojoping.DAO;

import java.util.List;

import com.mojoping.model.User;

public interface UserDAO {
	
	public void addUser(User user);
	
	public List<User> listUser();
	
	public void removeUser(Integer user_id);
	
	public User getUser(String username);
	
	public void updateUser(User user);
}
