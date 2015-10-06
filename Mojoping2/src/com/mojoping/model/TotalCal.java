package com.mojoping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="totalcal")
@Table(name="totalcal")
public class TotalCal {

	@Id
	@Column(name="totalcal_id")
	@GeneratedValue
	private Integer totalcal_id;
	
	@Column(name="checklist_id")
	private Integer checklist_id;

	
	@Column(name="total_cost")
	private String total_cost;
	

	@Column(name="total_profit")
	private String total_profit;


	@Column(name="subtotal_material")
	private String subtotal_material;
	

	@Column(name="subtotal_labor")
	private String subtotal_labor;
	

	@Column(name="subtotal_overhead")
	private String subtotal_overhead;
	

	@Column(name="subtotal_garbage")
	private String subtotal_garbage;
	

	@Column(name="subtotal_insurance")
	private String subtotal_insurance;
	
	
	
	

	
	
	
	public String getSubtotal_material() {
		return subtotal_material;
	}


	public void setSubtotal_material(String subtotal_material) {
		this.subtotal_material = subtotal_material;
	}


	public String getSubtotal_labor() {
		return subtotal_labor;
	}


	public void setSubtotal_labor(String subtotal_labor) {
		this.subtotal_labor = subtotal_labor;
	}


	public String getSubtotal_overhead() {
		return subtotal_overhead;
	}


	public void setSubtotal_overhead(String subtotal_overhead) {
		this.subtotal_overhead = subtotal_overhead;
	}


	public String getSubtotal_garbage() {
		return subtotal_garbage;
	}


	public void setSubtotal_garbage(String subtotal_garbage) {
		this.subtotal_garbage = subtotal_garbage;
	}


	public String getSubtotal_insurance() {
		return subtotal_insurance;
	}


	public void setSubtotal_insurance(String subtotal_insurance) {
		this.subtotal_insurance = subtotal_insurance;
	}


	public Integer getTotalcal_id() {
		return totalcal_id;
	}


	public void setTotalcal_id(Integer totalcal_id) {
		this.totalcal_id = totalcal_id;
	}


	public Integer getChecklist_id() {
		return checklist_id;
	}


	public void setChecklist_id(Integer checklist_id) {
		this.checklist_id = checklist_id;
	}


	public String getTotal_cost() {
		return total_cost;
	}


	public void setTotal_cost(String total_cost) {
		this.total_cost = total_cost;
	}


	public String getTotal_profit() {
		return total_profit;
	}


	public void setTotal_profit(String total_profit) {
		this.total_profit = total_profit;
	}


	

	

}
