package com.mojoping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="overhead")
@Table(name="overhead")
public class Overhead {

	@Id
	@Column(name="overhead_id")
	@GeneratedValue
	private Integer overhead_id;
	
	@Column(name="procedure_id")
	private Integer procedure_id;

	
	@Column(name="overhead_cost")
	private String overhead_cost;
	

	@Column(name="overhead_detail")
	private String overhead_detail;

	public Integer getOverhead_id() {
		return overhead_id;
	}


	public void setOverhead_id(Integer overhead_id) {
		this.overhead_id = overhead_id;
	}


	public Integer getProcedure_id() {
		return procedure_id;
	}


	public void setProcedure_id(Integer procedure_id) {
		this.procedure_id = procedure_id;
	}


	public String getOverhead_cost() {
		return overhead_cost;
	}


	public void setOverhead_cost(String overhead_cost) {
		this.overhead_cost = overhead_cost;
	}


	public String getOverhead_detail() {
		return overhead_detail;
	}


	public void setOverhead_detail(String overhead_detail) {
		this.overhead_detail = overhead_detail;
	}


	
}