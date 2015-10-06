package com.mojoping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="garbage")
@Table(name="garbage")
public class Garbage {

	@Id
	@Column(name="garbage_id")
	@GeneratedValue
	private Integer garbage_id;
	
	@Column(name="procedure_id")
	private Integer procedure_id;

	
	@Column(name="garbage_cost")
	private String garbage_cost;
	

	@Column(name="garbage_detail")
	private String garbage_detail;


	public Integer getGarbage_id() {
		return garbage_id;
	}


	public void setGarbage_id(Integer garbage_id) {
		this.garbage_id = garbage_id;
	}


	public Integer getProcedure_id() {
		return procedure_id;
	}


	public void setProcedure_id(Integer procedure_id) {
		this.procedure_id = procedure_id;
	}


	public String getGarbage_cost() {
		return garbage_cost;
	}


	public void setGarbage_cost(String garbage_cost) {
		this.garbage_cost = garbage_cost;
	}


	public String getGarbage_detail() {
		return garbage_detail;
	}


	public void setGarbage_detail(String garbage_detail) {
		this.garbage_detail = garbage_detail;
	}
	
	

}
