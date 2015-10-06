package com.mojoping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mojoping.model.Checklist;
import com.mojoping.model.EditChecklistObject;
import com.mojoping.model.Garbage;
import com.mojoping.model.Insurance;
import com.mojoping.model.Labor;
import com.mojoping.model.Material;
import com.mojoping.model.Overhead;
import com.mojoping.model.ProcedureStep;
import com.mojoping.model.Profit;
import com.mojoping.model.TotalCal;
import com.mojoping.model.User;
import com.mojoping.service.ChecklistService;
import com.mojoping.service.GarbageService;
import com.mojoping.service.InsuranceService;
import com.mojoping.service.LaborService;
import com.mojoping.service.MaterialService;
import com.mojoping.service.OverheadService;
import com.mojoping.service.ProcedureStepService;
import com.mojoping.service.ProfitService;
import com.mojoping.service.TotalCalService;
import com.mojoping.service.UserService;
import com.mojoping.session.CurrentUser;


//This is the edit checklist page and all the data could be edit
@Controller
public class EditChecklistController {
	
	@Autowired
	UserService user_service;

	

	@Autowired
	ProcedureStepService procedurestep_service;
	
	@Autowired
	MaterialService material_service;
	

	
	@Autowired
	InsuranceService insurance_service;
	
	@Autowired
	LaborService labor_service;
	
	@Autowired
	OverheadService overhead_service;
	
	@Autowired
	ProfitService profit_service;
	
	@Autowired
	GarbageService garbage_service;
	
	@Autowired
	TotalCalService totalcal_service;

	@Autowired
	ChecklistService checklist_service;
	
	@RequestMapping(value="edit_checklist", method=RequestMethod.POST)
	public String editUser(@ModelAttribute("user") @Valid  User user, BindingResult result, Model model, HttpServletRequest request){
		
		    
		String[] x=request.getParameterValues("deletevalue");
		String[] y=request.getParameterValues("sharevalue");
		String[] money=request.getParameterValues("value_need");
		String username = new CurrentUser().getCurrentUserName();
		List<Checklist> myList =checklist_service.listChecklistByUsername(username);
		for(int i=0;i<x.length;i++){
			if(x[i].equals("1")){
			int id=myList.get(i).getChecklist_id();
			myList.get(i).setUsername("admin");
			checklist_service.updateChecklist(myList.get(i));
			}
		}
			
		for(int j=0;j<x.length;j++){
				if(y[j].equals("1")){
				double sharevalue=Double.parseDouble(money[j]);

				myList.get(j).setShare(1);
				myList.get(j).setShare_value(sharevalue);
				checklist_service.updateChecklist(myList.get(j));
				}else if(y[j].equals("0")){
				int id=myList.get(j).getChecklist_id();
				checklist_service.updateChecklistShare(id, 0);
				}
			
		}
				
				
				
	        	return "redirect:/userchecklists";
	        }
	
	
	@RequestMapping(value="edit_checklist_action", method=RequestMethod.POST)
	public String editchecklist(@ModelAttribute("editchecklistobject")EditChecklistObject editchecklistobject,
			BindingResult result, Model model, HttpServletRequest request){
		
				
		String username = new CurrentUser().getCurrentUserName();
		String checklist_username=request.getParameter("username");
		int id=Integer.parseInt(request.getParameter("checklist_id"));
		int user_match=0;
		
        Checklist myList=checklist_service.getChecklistByChecklistId(id);
    	
		List<ProcedureStep> procedurestepList =procedurestep_service.getProcedureStepWithChecklistId(id);
		List<Material> materialList =material_service.getMaterialWithProcedureId(id);
		List<Labor> laborList  =labor_service.getLaborWithProcedureId(id);
		List<Profit> profitList =profit_service.getProfitWithProcedureId(id);
		List<Overhead> overheadList =overhead_service.getOverheadWithProcedureId(id);
		List<Garbage> garbageList =garbage_service.getGarbageWithProcedureId(id);
		List<Insurance> insuranceList =insurance_service.getInsuranceWithProcedureId(id);
		List<TotalCal> totalList =totalcal_service.getTotalCalWithChecklistId(id);
		
		double total_profit=0,total_cost = 0, subtotal_material=0,subtotal_labor=0,subtotal_overhead=0, subtotal_garbage=0,subtotal_insurance=0;
		
		if(username.equals(checklist_username)){
				user_match=1;

				
				myList.setTitle(request.getParameter("title").trim());
				myList.setBrief_info(request.getParameter("brief_info").trim());
				myList.setKeywords(request.getParameter("keywords").trim());
				myList.setShare_value(0.0);
				checklist_service.updateChecklist(myList);
				
				//procedurestepList set
				for(int i =0;i<procedurestepList.size();i++){
					procedurestepList.get(i).setStep_title(request.getParameterValues("step_title")[i].trim());
					procedurestepList.get(i).setStep_details(request.getParameterValues("step_details")[i].trim());
					procedurestepList.get(i).setTutoriol_video_url(request.getParameterValues("tutoriol_video_url")[i].trim());
					procedurestep_service.updateProcedureStep(procedurestepList.get(i));
					
				}
				//materialList set
				for(int i =0;i<materialList.size();i++){
					materialList.get(i).setMaterial_name(request.getParameterValues("material_name")[i].trim());
					materialList.get(i).setCoverage(request.getParameterValues("coverage")[i].trim());
					materialList.get(i).setQuantity(request.getParameterValues("quantity")[i].trim());
					material_service.updateMaterial(materialList.get(i));
					if(isNum(materialList.get(i).getCoverage().trim())&&isNum(materialList.get(i).getQuantity().trim())){
					subtotal_material=subtotal_material+Double.parseDouble(materialList.get(i).getCoverage())*Double.parseDouble(materialList.get(i).getQuantity());
					}
				}
				//laborList set
				for(int i =0;i<laborList.size();i++){
					laborList.get(i).setLabor_task(request.getParameterValues("labor_task")[i].trim());
					laborList.get(i).setLabor_num_people(request.getParameterValues("labor_num_people")[i].trim());
					laborList.get(i).setLabor_num_hour(request.getParameterValues("labor_num_hour")[i].trim());
					laborList.get(i).setLabor_hourly_cost(request.getParameterValues("labor_hourly_cost")[i].trim());
					laborList.get(i).setLabor_insurance(request.getParameterValues("labor_insurance")[i].trim());
					laborList.get(i).setLabor_detail(request.getParameterValues("labor_detail")[i].trim());					
					labor_service.updateLabor(laborList.get(i));
					if(isNum(laborList.get(i).getLabor_num_hour().trim())&&isNum(laborList.get(i).getLabor_hourly_cost().trim())&&isNum(laborList.get(i).getLabor_insurance().trim())){
						subtotal_labor=subtotal_labor+Double.parseDouble(laborList.get(i).getLabor_num_hour())*
								Double.parseDouble(laborList.get(i).getLabor_hourly_cost())+Double.parseDouble(laborList.get(i).getLabor_insurance());
					}
				}
				
				//overheadList set
				for(int i =0;i<overheadList.size();i++){
					overheadList.get(i).setOverhead_cost(request.getParameterValues("overhead_cost")[i].trim());
					overheadList.get(i).setOverhead_detail(request.getParameterValues("overhead_detail")[i].trim());
					
					overhead_service.updateOverhead(overheadList.get(i));
					
					if(isNum(overheadList.get(i).getOverhead_cost().trim())){
						subtotal_overhead=subtotal_overhead+Double.parseDouble(overheadList.get(i).getOverhead_cost());
					}
				}
				//garbage set
				for(int i =0;i<garbageList.size();i++){
					garbageList.get(i).setGarbage_cost(request.getParameterValues("garbage_cost")[i].trim());
					garbageList.get(i).setGarbage_detail(request.getParameterValues("garbage_detail")[i].trim());
					
					garbage_service.updateGarbage(garbageList.get(i));
					if(isNum(garbageList.get(i).getGarbage_cost().trim())){
						subtotal_garbage=subtotal_garbage+Double.parseDouble(garbageList.get(i).getGarbage_cost());
					}
				}
				
				//insuranceList set
				for(int i =0;i<insuranceList.size();i++){
					insuranceList.get(i).setInsurance_amount(request.getParameterValues("insurance_amount")[i].trim());
					insuranceList.get(i).setInsurance_detail(request.getParameterValues("insurance_detail")[i].trim());
					
					insurance_service.updateInsurance(insuranceList.get(i));
					
					if(isNum(insuranceList.get(i).getInsurance_amount().trim())){
						subtotal_insurance=subtotal_insurance+Double.parseDouble(insuranceList.get(i).getInsurance_amount());
					}
				}
				
				//profitList set
				for(int i =0;i<profitList.size();i++){
					profitList.get(i).setProfit_amount(request.getParameterValues("profit_amount")[i].trim());
					profitList.get(i).setProfit_detail(request.getParameterValues("profit_detail")[i].trim());
					
					profit_service.updateProfit(profitList.get(i));
					
					if(isNum(profitList.get(i).getProfit_amount().trim())){
						total_profit=total_profit+Double.parseDouble(profitList.get(i).getProfit_amount());
					}
				}
				
				//total set
				total_cost=subtotal_labor+subtotal_material+subtotal_overhead+subtotal_insurance+subtotal_garbage;
				for(int i = 0;i<totalList.size();i++){
					totalList.get(i).setTotal_profit(Double.toString(total_profit));
					totalList.get(i).setTotal_cost(Double.toString(total_cost));
					totalList.get(i).setSubtotal_labor(Double.toString(subtotal_labor));
					totalList.get(i).setSubtotal_material(Double.toString(subtotal_material));
					totalList.get(i).setSubtotal_overhead(Double.toString(subtotal_overhead));
					totalList.get(i).setSubtotal_garbage(Double.toString(subtotal_garbage));
					totalList.get(i).setSubtotal_insurance(Double.toString(subtotal_insurance));
					totalcal_service.updateTotalCal(totalList.get(i));
				}
				
				
			}else{
				Checklist copy_checklist=new Checklist();
				copy_checklist.setUsername(username);
				copy_checklist.setShare(0);
				copy_checklist.setShare_value(0.0);
				copy_checklist.setTitle(request.getParameter("title").trim());
				copy_checklist.setBrief_info(request.getParameter("brief_info").trim());
				copy_checklist.setKeywords(request.getParameter("keywords").trim());
				copy_checklist.setCategory_id(myList.getCategory_id());
				copy_checklist.setSubcategory_id(myList.getSubcategory_id());
				
				checklist_service.addChecklist(copy_checklist);
				
				int copy_id=copy_checklist.getChecklist_id();

				//procedurestepList set
				
				for(int i =0;i<procedurestepList.size();i++){
					ProcedureStep copy_procedurestep=new ProcedureStep();
					copy_procedurestep.setChecklist_id(copy_id);
					copy_procedurestep.setStep_title(request.getParameterValues("step_title")[i].trim());
					copy_procedurestep.setStep_details(request.getParameterValues("step_details")[i].trim());
					copy_procedurestep.setTutoriol_video_url(request.getParameterValues("tutoriol_video_url")[i].trim());
					procedurestep_service.addProcedureStep(copy_procedurestep);
							
				}
				
				//materialList set
				
				for(int i =0;i<materialList.size();i++){
					Material copy_material=new Material();
					copy_material.setProcedure_id(copy_id);
					copy_material.setMaterial_name(request.getParameterValues("material_name")[i].trim());
					copy_material.setCoverage(request.getParameterValues("coverage")[i].trim());
					copy_material.setQuantity(request.getParameterValues("quantity")[i].trim());
					material_service.addMaterial(copy_material);
					if(isNum(copy_material.getCoverage().trim())&&isNum(copy_material.getQuantity().trim())){
					subtotal_material=subtotal_material+Double.parseDouble(copy_material.getCoverage())*Double.parseDouble(copy_material.getQuantity());
					}
				}
				
				//laborList set
				
				for(int i =0;i<laborList.size();i++){
					Labor copy_labor=new Labor();
					copy_labor.setProcedure_id(copy_id);
					copy_labor.setLabor_task(request.getParameterValues("labor_task")[i].trim());
					copy_labor.setLabor_num_people(request.getParameterValues("labor_num_people")[i].trim());
					copy_labor.setLabor_num_hour(request.getParameterValues("labor_num_hour")[i].trim());
					copy_labor.setLabor_hourly_cost(request.getParameterValues("labor_hourly_cost")[i].trim());
					copy_labor.setLabor_insurance(request.getParameterValues("labor_insurance")[i].trim());
					copy_labor.setLabor_detail(request.getParameterValues("labor_detail")[i].trim());					
					labor_service.addLabor(copy_labor);
					if(isNum(copy_labor.getLabor_num_hour().trim())&&isNum(copy_labor.getLabor_hourly_cost().trim())&&isNum(copy_labor.getLabor_insurance().trim())){
						subtotal_labor=subtotal_labor+Double.parseDouble(copy_labor.getLabor_num_hour())*
								Double.parseDouble(copy_labor.getLabor_hourly_cost())+Double.parseDouble(copy_labor.getLabor_insurance());
					}
				}
				
				//overheadList set
				
				for(int i =0;i<overheadList.size();i++){
					Overhead copy_overhead=new Overhead();
					copy_overhead.setProcedure_id(copy_id);
					copy_overhead.setOverhead_cost(request.getParameterValues("overhead_cost")[i].trim());
					copy_overhead.setOverhead_detail(request.getParameterValues("overhead_detail")[i].trim());
					
					overhead_service.addOverhead(copy_overhead);
					
					if(isNum(copy_overhead.getOverhead_cost().trim())){
						subtotal_overhead=subtotal_overhead+Double.parseDouble(copy_overhead.getOverhead_cost());
					}
				}
				//garbage set
				
				for(int i =0;i<garbageList.size();i++){
					Garbage copy_garbage=new Garbage();
					copy_garbage.setProcedure_id(copy_id);
					copy_garbage.setGarbage_cost(request.getParameterValues("garbage_cost")[i].trim());
					copy_garbage.setGarbage_detail(request.getParameterValues("garbage_detail")[i].trim());
					
					garbage_service.addGarbage(copy_garbage);
					if(isNum(copy_garbage.getGarbage_cost().trim())){
						subtotal_garbage=subtotal_garbage+Double.parseDouble(copy_garbage.getGarbage_cost());
					}
				}
				
				//insuranceList set
				
				for(int i =0;i<insuranceList.size();i++){
					Insurance copy_insurance=new Insurance();
					copy_insurance.setProcedure_id(copy_id);
					copy_insurance.setInsurance_amount(request.getParameterValues("insurance_amount")[i].trim());
					copy_insurance.setInsurance_detail(request.getParameterValues("insurance_detail")[i].trim());
					
					insurance_service.addInsurance(copy_insurance);
					
					if(isNum(copy_insurance.getInsurance_amount().trim())){
						subtotal_insurance=subtotal_insurance+Double.parseDouble(copy_insurance.getInsurance_amount());
					}
				}
				
				//profitList set
				
				for(int i =0;i<profitList.size();i++){
					Profit copy_profit = new Profit();
					copy_profit.setProcedure_id(copy_id);
					copy_profit.setProfit_amount(request.getParameterValues("profit_amount")[i].trim());
					copy_profit.setProfit_detail(request.getParameterValues("profit_detail")[i].trim());
					
					profit_service.addProfit(copy_profit);
					
					if(isNum(copy_profit.getProfit_amount().trim())){
						total_profit=total_profit+Double.parseDouble(copy_profit.getProfit_amount());
					}
				}
				
				//total set
				total_cost=subtotal_labor+subtotal_material+subtotal_overhead+subtotal_insurance+subtotal_garbage;
				for(int i = 0;i<totalList.size();i++){
					TotalCal copy_total = new TotalCal();
					copy_total.setChecklist_id(copy_id);
					copy_total.setTotal_profit(Double.toString(total_profit));
					copy_total.setTotal_cost(Double.toString(total_cost));
					copy_total.setSubtotal_labor(Double.toString(subtotal_labor));
					copy_total.setSubtotal_material(Double.toString(subtotal_material));
					copy_total.setSubtotal_overhead(Double.toString(subtotal_overhead));
					copy_total.setSubtotal_garbage(Double.toString(subtotal_garbage));
					copy_total.setSubtotal_insurance(Double.toString(subtotal_insurance));
					totalcal_service.addTotalCal(copy_total);
				}
				
						
				
			}
			
			return "redirect:/detail_"+id;
	        	
	        }


	private  boolean isNum(String string) {
		return string.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$")&&(!string.equals(""));
	}

	



}
