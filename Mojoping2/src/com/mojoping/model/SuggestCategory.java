package com.mojoping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="suggest_category")
@Table(name="suggest_category")
public class SuggestCategory {
	
	@Id
	@Column(name="suggest_category_id")
	@GeneratedValue
	private Integer suggest_category_id;
	
	@Column(name="suggest_category_name")
	private String suggest_category_name;
	
	@Column(name="checklist_id")
	private Integer checklist_id;

	public Integer getSuggest_category_id() {
		return suggest_category_id;
	}

	public void setSuggest_category_id(Integer suggest_category_id) {
		this.suggest_category_id = suggest_category_id;
	}

	public String getSuggest_category_name() {
		return suggest_category_name;
	}

	public void setSuggest_category_name(String suggest_category_name) {
		this.suggest_category_name = suggest_category_name;
	}

	public Integer getChecklist_id() {
		return checklist_id;
	}

	public void setChecklist_id(Integer checklist_id) {
		this.checklist_id = checklist_id;
	}
	



}
