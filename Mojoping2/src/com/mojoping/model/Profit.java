package com.mojoping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="profit")
@Table(name="profit")
public class Profit {

	@Id
	@Column(name="profit_id")
	@GeneratedValue
	private Integer profit_id;
	
	@Column(name="procedure_id")
	private Integer procedure_id;

	
	@Column(name="profit_amount")
	private String profit_amount;
	

	@Column(name="profit_detail")
	private String profit_detail;


	public Integer getProfit_id() {
		return profit_id;
	}


	public void setProfit_id(Integer profit_id) {
		this.profit_id = profit_id;
	}


	public Integer getProcedure_id() {
		return procedure_id;
	}


	public void setProcedure_id(Integer procedure_id) {
		this.procedure_id = procedure_id;
	}


	public String getProfit_amount() {
		return profit_amount;
	}


	public void setProfit_amount(String profit_amount) {
		this.profit_amount = profit_amount;
	}


	public String getProfit_detail() {
		return profit_detail;
	}


	public void setProfit_detail(String profit_detail) {
		this.profit_detail = profit_detail;
	}

	

}
