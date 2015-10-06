package com.mojoping.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="usercomment")
@Table(name="usercomment")
public class UserComment {

	@Id
	@Column(name="usercomment_id")
	@GeneratedValue
	private Integer usercomment_id;
	
	@Column(name="user_id")
	private Integer user_id;

	
	@Column(name="checklist_id")
	private Integer checklist_id;
	

	@Column(name="user_name")
	private String user_name;
	
	@Column(name="comment_text")
	private String comment_text;

	public Integer getUsercomment_id() {
		return usercomment_id;
	}

	public void setUsercomment_id(Integer usercomment_id) {
		this.usercomment_id = usercomment_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getChecklist_id() {
		return checklist_id;
	}

	public void setChecklist_id(Integer checklist_id) {
		this.checklist_id = checklist_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getComment_text() {
		return comment_text;
	}

	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}
	
	
	
}