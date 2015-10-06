package com.mojoping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="insurance")
@Table(name="insurance")
public class Insurance {

	@Id
	@Column(name="insurance_id")
	@GeneratedValue
	private Integer insurance_id;
	
	@Column(name="procedure_id")
	private Integer procedure_id;

	
	@Column(name="insurance_amount")
	private String insurance_amount;
	

	@Column(name="insurance_detail")
	private String insurance_detail;


	public Integer getInsurance_id() {
		return insurance_id;
	}


	public void setInsurance_id(Integer insurance_id) {
		this.insurance_id = insurance_id;
	}


	public Integer getProcedure_id() {
		return procedure_id;
	}


	public void setProcedure_id(Integer procedure_id) {
		this.procedure_id = procedure_id;
	}


	public String getInsurance_amount() {
		return insurance_amount;
	}


	public void setInsurance_amount(String insurance_amount) {
		this.insurance_amount = insurance_amount;
	}


	public String getInsurance_detail() {
		return insurance_detail;
	}


	public void setInsurance_detail(String insurance_detail) {
		this.insurance_detail = insurance_detail;
	}
	
	
	
}