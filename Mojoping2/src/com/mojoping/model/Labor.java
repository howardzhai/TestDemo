package com.mojoping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="labor")
@Table(name="labor")
public class Labor {

	@Id
	@Column(name="labor_id")
	@GeneratedValue
	private Integer labor_id;
	
	@Column(name="procedure_id")
	private Integer procedure_id;
	
	@Column(name="labor_task")
	private String labor_task;
	
	@Column(name="labor_num_people")
	private String labor_num_people;
	
	@Column(name="labor_num_hour")
	private String labor_num_hour;
	
	@Column(name="labor_hourly_cost")
	private String labor_hourly_cost;
	
	@Column(name="labor_insurance")
	private String labor_insurance;
	
	@Column(name="labor_detail")
	private String labor_detail;

	public Integer getlabor_id() {
		return labor_id;
	}

	public void setlabor_id(Integer labor_id) {
		this.labor_id = labor_id;
	}

	public Integer getProcedure_id() {
		return procedure_id;
	}

	public void setProcedure_id(Integer procedure_id) {
		this.procedure_id = procedure_id;
	}

	public Integer getLabor_id() {
		return labor_id;
	}

	public void setLabor_id(Integer labor_id) {
		this.labor_id = labor_id;
	}

	public String getLabor_task() {
		return labor_task;
	}

	public void setLabor_task(String labor_task) {
		this.labor_task = labor_task;
	}

	public String getLabor_num_people() {
		return labor_num_people;
	}

	public void setLabor_num_people(String labor_num_people) {
		this.labor_num_people = labor_num_people;
	}

	public String getLabor_num_hour() {
		return labor_num_hour;
	}

	public void setLabor_num_hour(String labor_num_hour) {
		this.labor_num_hour = labor_num_hour;
	}

	public String getLabor_hourly_cost() {
		return labor_hourly_cost;
	}

	public void setLabor_hourly_cost(String labor_hourly_cost) {
		this.labor_hourly_cost = labor_hourly_cost;
	}

	public String getLabor_insurance() {
		return labor_insurance;
	}

	public void setLabor_insurance(String labor_insurance) {
		this.labor_insurance = labor_insurance;
	}

	public String getLabor_detail() {
		return labor_detail;
	}

	public void setLabor_detail(String labor_detail) {
		this.labor_detail = labor_detail;
	}


	
	
}
