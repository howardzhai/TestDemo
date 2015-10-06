package com.mojoping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity(name="procedurestep")
@Table(name="procedurestep")
public class ProcedureStep {
	
	
	@Id
	@Column(name="procedure_id")
	@GeneratedValue
	private Integer procedure_id;
	
	@Column(name="checklist_id")
	private Integer checklist_id;
	
	@Column(name="step_title")
	private String step_title;
	
	@Column(name="step_details")
	private String step_details;
	
	@Column(name="procedure_file")
	@Lob
	private byte[] procedure_file;
	
	@Column(name="tutoriol_video_url")
	private String tutoriol_video_url;

	public Integer getProcedure_id() {
		return procedure_id;
	}

	public void setProcedure_id(Integer procedure_id) {
		this.procedure_id = procedure_id;
	}

	public Integer getChecklist_id() {
		return checklist_id;
	}

	public void setChecklist_id(Integer checklist_id) {
		this.checklist_id = checklist_id;
	}

	public String getStep_title() {
		return step_title;
	}

	public void setStep_title(String step_title) {
		this.step_title = step_title;
	}

	public String getStep_details() {
		return step_details;
	}

	public void setStep_details(String step_details) {
		this.step_details = step_details;
	}

	public byte[] getProcedure_file() {
		return procedure_file;
	}

	public void setProcedure_file(byte[] procedure_file) {
		this.procedure_file = procedure_file;
	}

	public String getTutoriol_video_url() {
		return tutoriol_video_url;
	}

	public void setTutoriol_video_url(String tutoriol_video_url) {
		this.tutoriol_video_url = tutoriol_video_url;
	}
	
	
}
