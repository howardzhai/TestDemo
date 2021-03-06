package com.mojoping.DAO;

import java.util.List;

import com.mojoping.model.UserComment;

public interface UserCommentDAO {

	public void addUserComment(UserComment usercomment);
	
	public List<UserComment> listUserComment();
	
	public UserComment getUserComment(Integer usercomment_id);
	
	public List<UserComment> getUserCommentWithUserId(Integer user_id);
	
	public List<UserComment> getUserCommentWithChecklistId(Integer checklist_id);
	
	public void removeUserComment(Integer usercomment_id);
}
