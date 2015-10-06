package com.mojoping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="checklist")
@Table(name="checklist")
public class Checklist {
	
	@Id
	@Column(name="checklist_id")
	@GeneratedValue
	private Integer checklist_id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="category_id")
	@NotNull
	private Integer category_id;
	
	@Column(name="subcategory_id")
	@NotNull
	private Integer subcategory_id;
	
	@Column(name="title")
	@NotEmpty
	private String title;
	
	@Column(name="brief_info")
	@NotEmpty @Size(max=150)
	private String brief_info;
	
	@Column(name="keywords")
	@NotEmpty
	private String keywords;
	
	@Column(name="share")
	private Integer share;
	
	@Column(name="share_value")
	private Double share_value;
	
	
	

	public Double getShare_value() {
		return share_value;
	}

	public void setShare_value(Double share_value) {
		this.share_value = share_value;
	}

	public Integer getChecklist_id() {
		return checklist_id;
	}

	public void setChecklist_id(Integer checklist_id) {
		this.checklist_id = checklist_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public Integer getSubcategory_id() {
		return subcategory_id;
	}

	public void setSubcategory_id(Integer subcategory_id) {
		this.subcategory_id = subcategory_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief_info() {
		return brief_info;
	}

	public void setBrief_info(String brief_info) {
		this.brief_info = brief_info;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Integer getShare() {
		return share;
	}

	public void setShare(Integer share) {
		this.share = share;
	}
	
	
}
