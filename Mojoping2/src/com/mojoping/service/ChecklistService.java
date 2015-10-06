package com.mojoping.service;

import java.util.List;

import com.mojoping.model.Checklist;

public interface ChecklistService {
	
	public void addChecklist(Checklist checklist);
	
	public List<Checklist> listChecklist();
	
	public List<Checklist>  getChecklistByCategory(Integer category_id);
	
	public List<Checklist> getChecklistBySubCategory(Integer subcategory_id);
	
	public List<Checklist> listChecklistByUsername(String username);
	
	public List<Checklist> listChecklistByTitle(String title);
	
	public Checklist getChecklistByUsername(String username);
	
	public Checklist getChecklistByChecklistId(Integer checklist_id);
	
	public void removeChecklist(Integer checklist_id);
	
	public void updateChecklistUsername(Integer checklist_id,String username);
	
	public void updateChecklistShare(Integer checklist_id,Integer share);
	
	public void updateChecklist(Checklist checklist);
	
	public List<Checklist> listChecklistByShare(Integer share);
}
