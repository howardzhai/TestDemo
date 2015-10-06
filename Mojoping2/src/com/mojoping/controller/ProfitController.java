package com.mojoping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mojoping.model.Checklist;
import com.mojoping.model.Insurance;
import com.mojoping.model.Garbage;
import com.mojoping.model.Labor;
import com.mojoping.model.Material;
import com.mojoping.model.Overhead;
import com.mojoping.model.ProcedureStep;
import com.mojoping.model.Profit;
import com.mojoping.model.TotalCal;
import com.mojoping.model.SuggestCategory;
import com.mojoping.service.ChecklistService;
import com.mojoping.service.GarbageService;
import com.mojoping.service.LaborService;
import com.mojoping.service.MaterialService;
import com.mojoping.service.OverheadService;
import com.mojoping.service.ProcedureStepService;
import com.mojoping.service.ProfitService;
import com.mojoping.service.SuggestCategoryService;
import com.mojoping.service.TotalCalService;
import com.mojoping.service.UserService;
import com.mojoping.service.InsuranceService;
import com.mojoping.session.CurrentUser;


@Controller
public class ProfitController {
	

	

	@Autowired
	ProcedureStepService procedurestep_service;
	
	@Autowired
	MaterialService material_service;
	
	@Autowired
	ChecklistService checklist_service;
	
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
	SuggestCategoryService suggest_category_service;
	

	@RequestMapping(value = "/profitAction", method = RequestMethod.POST)
	public String profitpage(@ModelAttribute("checklist") Checklist checklist,@ModelAttribute("profit")Profit profit,BindingResult result, Model model, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
		
		
		//This is the final step to create Checklist
		
		//The following function will deal with the data format
		boolean if_profit_amount=true;
		
		if(profit!=null){
			if(profit.getProfit_amount().trim().contains("   ,")){
				String [] profit_amount=profit.getProfit_amount().trim().split("   ,");
				
				for(int i =0;i<profit_amount.length;i++){
					if(!isNum(profit_amount[i])){
						if_profit_amount=false;
						profit.setProfit_amount("");
						profit.setProfit_detail("");
						
					}
				}
				
			}else{
				if(!isNum(profit.getProfit_amount().trim())){
					if_profit_amount=false;
					profit.setProfit_amount("");
					profit.setProfit_detail("");
					
				}

				
			}
			}
		
		
		if(!if_profit_amount){
			result.rejectValue("profit_amount","error.garbage","Profit amount should be a number");
			model.addAttribute("profit",profit);
			return "profit";
			
		}else{
		
	
		//The following fuction is to get all the data model
		HttpSession session = request.getSession();
		checklist=(Checklist) session.getAttribute("checklist");
		ProcedureStep procedurestep=(ProcedureStep) session.getAttribute("procedurestep");
		Material material=(Material) session.getAttribute("material");
		Labor labor=(Labor) session.getAttribute("labor");
		Overhead overhead=(Overhead) session.getAttribute("overhead");
		Insurance insurance=(Insurance) session.getAttribute("insurance");
		Garbage garbage=(Garbage) session.getAttribute("garbage");
		SuggestCategory suggestcategory=new SuggestCategory();
		
		String username = new CurrentUser().getCurrentUserName();
		
		int share=0;
		
		if(username==null){
			username="anonymousUser";
		}
		checklist.setUsername(username);
		checklist.setShare(share);
		checklist.setShare_value(0.0);
		String[] title=checklist.getTitle().split(",");
		checklist.setTitle(title[1]);
		suggestcategory.setSuggest_category_name(title[0]);
		
		checklist_service.addChecklist(checklist);
		suggestcategory.setChecklist_id(checklist.getChecklist_id());
		suggest_category_service.addSuggestCategory(suggestcategory);
		
		TotalCal totalcal=new TotalCal();
		
		
		//Here is function to set related checklist_id for all the subcategory
		int checkid=checklist.getChecklist_id();
		if(procedurestep!=null){
		procedurestep.setChecklist_id(checkid);}
		if(material!=null){
		material.setProcedure_id(checkid);}
		if(labor!=null){
		labor.setProcedure_id(checkid);}
		if(overhead!=null){
		overhead.setProcedure_id(checkid);}
		if(profit!=null){
		profit.setProcedure_id(checkid);}
		if(garbage!=null){
		garbage.setProcedure_id(checkid);}
		if(insurance!=null){
		insurance.setProcedure_id(checkid);}
		
		totalcal.setChecklist_id(checkid);
		
		
		//The following function is to calculate the total cost and profit and put all the data into database
		double total_profit=0,total_cost = 0, subtotal_material=0,subtotal_labor=0,subtotal_overhead=0, subtotal_garbage=0,subtotal_insurance=0;
//procedure step		
		if(procedurestep.getStep_title().trim().contains("   ,")){
			String [] step_title=procedurestep.getStep_title().trim().split("   ,");
			String [] step_detail=procedurestep.getStep_title().trim().split("   ,");
			for(int i =0;i<step_title.length;i++){
				ProcedureStep procedurestep00=new ProcedureStep();
				procedurestep00.setChecklist_id(procedurestep.getChecklist_id());
				procedurestep00.setStep_title(step_title[i]);
				procedurestep00.setStep_details(step_detail[i]);
				procedurestep00.setTutoriol_video_url(procedurestep.getTutoriol_video_url());
				procedurestep_service.addProcedureStep(procedurestep00);				
			}
			
		}else{
			procedurestep.setStep_title(procedurestep.getStep_title().trim());
			procedurestep.setStep_details(procedurestep.getStep_details().trim());
			procedurestep.setTutoriol_video_url(procedurestep.getTutoriol_video_url().trim());
			procedurestep_service.addProcedureStep(procedurestep);
			
		}
//material step	
		if(material!=null){
		if(material.getMaterial_name().trim().contains("   ,")){
			String [] material_name=material.getMaterial_name().trim().split("   ,");
			String [] material_coverage=material.getCoverage().trim().split("   ,");
			String [] material_quantity=material.getQuantity().trim().split("   ,");
			for(int i =0;i<material_name.length;i++){
				Material material00=new Material();
				material00.setProcedure_id(material.getProcedure_id());
				material00.setMaterial_name(material_name[i]);
				material00.setCoverage(material_coverage[i]);
				material00.setQuantity(material_quantity[i]);
				total_cost=total_cost+(Double.parseDouble(material_coverage[i])*Double.parseDouble(material_quantity[i]));
				subtotal_material=subtotal_material+(Double.parseDouble(material_coverage[i])*Double.parseDouble(material_quantity[i]));
				material_service.addMaterial(material00);			
			}
			
		}else{
			
			total_cost=total_cost+(Double.parseDouble(material.getCoverage()))*Double.parseDouble(material.getQuantity());
			subtotal_material=subtotal_material+(Double.parseDouble(material.getCoverage()))*Double.parseDouble(material.getQuantity());
			material.setCoverage(material.getCoverage().trim());
			material.setMaterial_name(material.getMaterial_name().trim());
			material.setQuantity(material.getQuantity().trim());

			material_service.addMaterial(material);
			
			
		}
		}
//labor step	
		
		if(labor!=null){
		if(labor.getLabor_task().trim().contains("   ,")){
			String [] labor_task=labor.getLabor_task().trim().split("   ,");
			String [] labor_num_people=labor.getLabor_num_people().trim().split("   ,");
			String []labor_num_hour=labor.getLabor_num_hour().trim().split("   ,");
			String [] labor_hour_cost=labor.getLabor_hourly_cost().trim().split("   ,");
			String [] labor_insurance=labor.getLabor_insurance().trim().split("   ,");
			String [] labor_detail=labor.getLabor_detail().trim().split("   ,");
			for(int i =0;i<labor_task.length;i++){
				Labor labor00=new Labor();
				labor00.setProcedure_id(labor.getProcedure_id());
				labor00.setLabor_task(labor_task[i]);
				labor00.setLabor_num_people(labor_num_people[i]);
				labor00.setLabor_num_hour(labor_num_hour[i]);
				labor00.setLabor_hourly_cost(labor_hour_cost[i]);
				labor00.setLabor_insurance(labor_insurance[i]);
				labor00.setLabor_detail(labor_detail[i]);
				
				
				total_cost=total_cost+(Double.parseDouble(labor_num_hour[i])*Double.parseDouble(labor_hour_cost[i]))+Double.parseDouble(labor_insurance[i]);
				subtotal_labor=subtotal_labor+(Double.parseDouble(labor_num_hour[i])*Double.parseDouble(labor_hour_cost[i]))+Double.parseDouble(labor_insurance[i]);
				labor_service.addLabor(labor00);			
			}
			
		}else{
			total_cost=total_cost+(Double.parseDouble(labor.getLabor_hourly_cost())*Double.parseDouble(labor.getLabor_num_hour()))+Double.parseDouble(labor.getLabor_insurance());
			subtotal_labor=subtotal_labor+(Double.parseDouble(labor.getLabor_hourly_cost())*Double.parseDouble(labor.getLabor_num_hour()))+Double.parseDouble(labor.getLabor_insurance());
			labor.setLabor_detail(labor.getLabor_detail().trim());
			labor.setLabor_hourly_cost(labor.getLabor_hourly_cost().trim());
			labor.setLabor_insurance(labor.getLabor_insurance().trim());
			labor.setLabor_num_hour(labor.getLabor_num_hour().trim());
			labor.setLabor_num_people(labor.getLabor_num_people().trim());
			labor.setLabor_task(labor.getLabor_task().trim());
			labor_service.addLabor(labor);
			
		}
		}
		
		
//overhead detail
		if(overhead!=null){
		if(overhead.getOverhead_cost().trim().contains("   ,")){
			String [] overhead_cost=overhead.getOverhead_cost().trim().split("   ,");
			String [] overhead_detail=overhead.getOverhead_detail().trim().split("   ,");
			
			for(int i =0;i<overhead_cost.length;i++){
				Overhead overhead00=new Overhead();
				overhead00.setProcedure_id(overhead.getProcedure_id());
				overhead00.setOverhead_cost(overhead_cost[i]);
				overhead00.setOverhead_detail(overhead_detail[i]);
				
				total_cost=total_cost+Double.parseDouble(overhead_cost[i]);
				subtotal_overhead=subtotal_overhead+Double.parseDouble(overhead_cost[i]);
				overhead_service.addOverhead(overhead00);	
			}
			
		}else{
			
			total_cost=total_cost+Double.parseDouble(overhead.getOverhead_cost());
			subtotal_overhead=subtotal_overhead+Double.parseDouble(overhead.getOverhead_cost());
			overhead.setOverhead_cost(overhead.getOverhead_cost().trim());
			overhead.setOverhead_detail(overhead.getOverhead_detail().trim());
			overhead_service.addOverhead(overhead);
			
		}
		}
//profit step
		if(profit!=null){
		if(profit.getProfit_amount().trim().contains("   ,")){
			String [] profit_amount=profit.getProfit_amount().trim().split("   ,");
			String [] profit_detail=profit.getProfit_detail().trim().split("   ,");
			
			for(int i =0;i<profit_amount.length;i++){
				Profit profit00=new Profit();
				profit00.setProcedure_id(profit.getProcedure_id());
				profit00.setProfit_amount(profit_amount[i]);
				profit00.setProfit_detail(profit_detail[i]);
				
				total_profit=total_profit+Double.parseDouble(profit_amount[i]);
				
				profit_service.addProfit(profit00);
			}
			
		}else{
			total_profit=total_profit+Double.parseDouble(profit.getProfit_amount());
			profit.setProfit_detail(profit.getProfit_detail().trim());
			profit.setProfit_amount(profit.getProfit_amount().trim());
			profit_service.addProfit(profit);
			
		}
		}
//garbage step
		if(garbage!=null){
		if(garbage.getGarbage_cost().trim().contains("   ,")){
			String [] garbage_cost=garbage.getGarbage_cost().trim().split("   ,");
			String [] garbage_detail=garbage.getGarbage_detail().trim().split("   ,");
			
			for(int i =0;i<garbage_cost.length;i++){
				Garbage garbage00=new Garbage();
				garbage00.setProcedure_id(garbage.getProcedure_id());
				garbage00.setGarbage_cost(garbage_cost[i]);
				garbage00.setGarbage_detail(garbage_detail[i]);
				garbage_service.addGarbage(garbage00);
				
				total_cost=total_cost+Double.parseDouble(garbage_cost[i]);
				subtotal_garbage=subtotal_garbage+Double.parseDouble(garbage_cost[i]);
			}
			
		}else{
			total_cost=total_cost+Double.parseDouble(garbage.getGarbage_cost());
			subtotal_garbage=subtotal_garbage+Double.parseDouble(garbage.getGarbage_cost());
			garbage.setGarbage_cost(garbage.getGarbage_cost().trim());
			garbage.setGarbage_detail(garbage.getGarbage_detail().trim());
			garbage_service.addGarbage(garbage);
			
		}
		}
//insurance step
		if(insurance!=null){
		if(insurance.getInsurance_amount().trim().contains("   ,")){
			String [] insurance_amount=insurance.getInsurance_amount().trim().split("   ,");
			String [] insurance_detail=insurance.getInsurance_detail().trim().split("   ,");
			
			for(int i =0;i<insurance_amount.length;i++){
				Insurance insurance00=new Insurance();
				insurance00.setProcedure_id(insurance.getProcedure_id());
				insurance00.setInsurance_amount(insurance_amount[i]);
				insurance00.setInsurance_detail(insurance_detail[i]);
				
				total_cost=total_cost+Double.parseDouble(insurance_amount[i]);
				subtotal_insurance=subtotal_insurance+Double.parseDouble(insurance_amount[i]);
				insurance_service.addInsurance(insurance00);
			}
			
		}else{
			
			total_cost=total_cost+Double.parseDouble(insurance.getInsurance_amount());
			subtotal_insurance=subtotal_insurance+Double.parseDouble(insurance.getInsurance_amount());
			insurance.setInsurance_amount(insurance.getInsurance_amount().trim());
			insurance.setInsurance_detail(insurance.getInsurance_detail().trim());
			insurance_service.addInsurance(insurance);
			
		}
		}
		String tc=Double.toString(total_cost);
		String tp=Double.toString(total_profit);
		String tm=Double.toString(subtotal_material);
		String tl=Double.toString(subtotal_labor);
		String to=Double.toString(subtotal_overhead);
		String tg=Double.toString(subtotal_garbage);
		String ti=Double.toString(subtotal_insurance);
		totalcal.setTotal_cost(tc);
		totalcal.setTotal_profit(tp);
		totalcal.setSubtotal_material(tm);
		totalcal.setSubtotal_labor(tl);
		totalcal.setSubtotal_overhead(to);
		totalcal.setSubtotal_garbage(tg);
		totalcal.setSubtotal_insurance(ti);
		totalcal_service.addTotalCal(totalcal);
		
			
			 return "create_checklist";
		}
		
	}
		
		
	private static boolean isNum(String string) {
		return string.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$")&&(!string.equals(""));
	}
	

}
