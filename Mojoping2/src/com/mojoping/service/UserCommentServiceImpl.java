package com.mojoping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mojoping.DAO.UserCommentDAO;
import com.mojoping.model.UserComment;



@Service
public class UserCommentServiceImpl implements UserCommentService{

	@Autowired
	UserCommentDAO usercommentDAO;
	
	@Transactional
	public void addUserComment(UserComment usercomment) {
		usercommentDAO.addUserComment(usercomment);
		
	}
	@Transactional
	public List<UserComment> listUserComment() {
	    return usercommentDAO.listUserComment();
	}
	@Transactional
	public UserComment getUserComment(Integer usercomment_id) {
		
		return usercommentDAO.getUserComment(usercomment_id);
	}
	@Transactional
	public List<UserComment> getUserCommentWithUserId(
			Integer user_id) {
		return usercommentDAO.getUserCommentWithUserId(user_id);
	}
	
	@Transactional
	public List<UserComment> getUserCommentWithChecklistId(
			Integer checklist_id) {
		return usercommentDAO.getUserCommentWithChecklistId(checklist_id);
	}
	
	@Transactional
	public void removeUserComment(Integer usercomment_id) {
		usercommentDAO.removeUserComment(usercomment_id);
		
	}

}
