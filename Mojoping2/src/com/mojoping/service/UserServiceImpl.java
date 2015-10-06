package com.mojoping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mojoping.DAO.UserDAO;
import com.mojoping.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO userDAO;

	@Transactional
	public void addUser(User user) {
		userDAO.addUser(user);		
	}

	@Transactional
	public List<User> listUser() {
		return userDAO.listUser();
	}

	@Transactional
	public void removeUser(Integer user_id) {
		userDAO.removeUser(user_id);		
	}

	@Transactional
	public User getUser(String username) {
		return userDAO.getUser(username);
	}
	
	@Transactional
	public void updateUser(User user){
		userDAO.updateUser(user);
	}

}
