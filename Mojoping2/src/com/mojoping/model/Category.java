package com.mojoping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="category")
@Table(name="category")
public class Category {
	
	@Id
	@Column(name="category_id")
	@GeneratedValue
	private Integer category_id;
	
	@Column(name="category_name")
	private String category_name;
	
	@Column(name="category_search")
	private String category_search;
	
	public String getCategory_search() {
		return category_search;
	}

	public void setCategory_search(String category_search) {
		this.category_search = category_search;
	}

	public int getCategory_id() {
		return category_id;
	}

	public String getCategory_name() {
		return category_name;
	}
	
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
}
