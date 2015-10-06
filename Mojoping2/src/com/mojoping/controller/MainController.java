package com.mojoping.controller;
// This is the main controller and almost all the get method is in it

//This project is done in SpringMVC and Hibernate framework with four package: Controller DAO Model and Service
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;














import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mojoping.model.Category;
import com.mojoping.model.Checklist;
import com.mojoping.model.Confirmation;
import com.mojoping.model.EditChecklistObject;
import com.mojoping.model.Garbage;
import com.mojoping.model.Insurance;
import com.mojoping.model.Labor;
import com.mojoping.model.Material;
import com.mojoping.model.Overhead;
import com.mojoping.model.ProcedureStep;
import com.mojoping.model.Profit;
import com.mojoping.model.SearchObject;
import com.mojoping.model.SubCategory;
import com.mojoping.model.TotalCal;
import com.mojoping.model.User;
import com.mojoping.model.UserComment;
import com.mojoping.service.CategoryService;
import com.mojoping.service.ChecklistService;
import com.mojoping.service.GarbageService;
import com.mojoping.service.InsuranceService;
import com.mojoping.service.LaborService;
import com.mojoping.service.MaterialService;
import com.mojoping.service.OverheadService;
import com.mojoping.service.ProcedureStepService;
import com.mojoping.service.ProfitService;
import com.mojoping.service.SubCategoryService;
import com.mojoping.service.TotalCalService;
import com.mojoping.service.UserCommentService;
import com.mojoping.service.UserService;
import com.mojoping.session.CurrentUser;

@Controller
public class MainController {
	
	@Autowired
	UserService user_service;
	
	@Autowired
	CategoryService category_service;
	
	@Autowired
	SubCategoryService subcategory_service;
	
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
	UserCommentService usercomment_service;
	


	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcomePage(Model model) {
		
	    model.addAttribute("category", new Category()); // the Category object is used as a template to generate the form
	    model.addAttribute("user", new User());
	    
	    return "mojoping";
	}
	
	@RequestMapping(value= "/register", method = RequestMethod.GET)
	public String registerPage(Model model) {
		model.addAttribute("user", new User());
		
		return "register_to_mojoping";
	}
	
	@RequestMapping(value= "/profile", method = RequestMethod.GET)
	public String profilePage(Model model) {		
		String username = new CurrentUser().getCurrentUserName();
		
		if(!username.equals("anonymousUser")){
			User user = user_service.getUser(username);

			String user_profile_pic_path = user.getProfile_pic_path();
			if(user_profile_pic_path == null ){
				String profile_pic_path = "/Mojoping2/resources/images/mojoping_logo.png";
				model.addAttribute("profilePicture", profile_pic_path);
			}else{
				String profile_pic_path = "/Mojoping2/resources/images/" + username + "/" + user_profile_pic_path;
				model.addAttribute("profilePicture", profile_pic_path);
			}			
			
			model.addAttribute("user", user);
		}	
		
		return "profile";
	}
	
	@RequestMapping(value = "/user_confirmation", method = RequestMethod.GET)
	public String userConfirmation(Model model){
		model.addAttribute("confirmation", new Confirmation());

		return "confirmation";
	}
	
	@RequestMapping(value = "/user_edit_checklist", method = RequestMethod.GET)
	public ModelAndView userEditChecklist(Model model){
		
		String username = new CurrentUser().getCurrentUserName();
		Map<String, Object> model11 = new HashMap<String, Object>();
		
		List<Checklist> myList =checklist_service.listChecklistByUsername(username);
		
		model11.put("checkList", myList);
		
		 if(username.equals("anonymousUser")){
			 return new ModelAndView("checklists");
	        }else{
	        return new ModelAndView("user_edit_checklist", model11);
	        }
		
	}

	@RequestMapping(value = "/userchecklists", method = RequestMethod.GET)
	public ModelAndView  userchecklistsPage() {		
		String username = new CurrentUser().getCurrentUserName();
		Map<String, Object> model = new HashMap<String, Object>();
		
		if(!username.equals("anonymousUser")){
		
		List<Checklist> myList =checklist_service.listChecklistByUsername(username);
		List<ProcedureStep> procedurestepList =procedurestep_service.listProcedureStep();
		List<Material> materialList =material_service.listMaterial();
		List<Labor> laborList  =labor_service.listLabor();
		
		List<Profit> profitList =profit_service.listProfit();
		List<Overhead> overheadList =overhead_service.listOverhead();
		List<Garbage> garbageList =garbage_service.listGarbage();
		List<Insurance> insuranceList =insurance_service.listInsurance();
		List<TotalCal> totalList =totalcal_service.listTotalCal();
		
		 model.put("checkList", myList);
		 model.put("procedureList", procedurestepList);
		 model.put("materialList", materialList);
		 model.put("laborList", laborList);
		 model.put("profitList", profitList);
		 model.put("overheadList", overheadList);
		 model.put("garbageList", garbageList);
		 model.put("insuranceList", insuranceList);
		 model.put("totalList", totalList);
		 
		 return new ModelAndView("userchecklists", model);
		}else{
		 return new ModelAndView("notuserchecklists", model);
	        
		}
       
        
	    
	}
	
	
	@RequestMapping(value = "/checklists", method = RequestMethod.GET)
	public ModelAndView  checklistsPage() {		
		//String username = new CurrentUser().getCurrentUserName();
		Map<String, Object> model = new HashMap<String, Object>();
		
		String username = new CurrentUser().getCurrentUserName();
		
		
		List<Checklist> myList =checklist_service.listChecklistByUsername("anonymousUser");
		if(checklist_service.listChecklistByShare(0)!=null){
		myList.addAll(checklist_service.listChecklistByShare(0));
		}
		List<ProcedureStep> procedurestepList =procedurestep_service.listProcedureStep();
		List<Material> materialList =material_service.listMaterial();
		List<Labor> laborList  =labor_service.listLabor();
		
		List<Profit> profitList =profit_service.listProfit();
		List<Overhead> overheadList =overhead_service.listOverhead();
		List<Garbage> garbageList =garbage_service.listGarbage();
		List<Insurance> insuranceList =insurance_service.listInsurance();
		List<TotalCal> totalList =totalcal_service.listTotalCal();
		
		 model.put("checkList", myList);
		 model.put("procedureList", procedurestepList);
		 model.put("materialList", materialList);
		 model.put("laborList", laborList);
		 model.put("profitList", profitList);
		 model.put("overheadList", overheadList);
		 model.put("garbageList", garbageList);
		 model.put("insuranceList", insuranceList);
		 model.put("totalList", totalList);
		
		 
		 if(!username.equals("anonymousUser")){
		 User current_user = user_service.getUser(username);
		 if(current_user.getUser_bought()!=null){
		 String[] bought=current_user.getUser_bought().split("\\.");
		 int[] bought_id=new int[bought.length-1];
		 for(int n=0;n<bought_id.length;n++){
			 bought_id[n]=Integer.parseInt(bought[n]);
		 }
		 model.put("bought_id", bought_id);
		 }
		 double money=current_user.getUser_money();
		 model.put("money", money);
		 }else{
		 model.put("money", 0); 
		 }
		 
	
       
		 return new ModelAndView("checklists", model);
        
        
	    
	}
	
	@SuppressWarnings("null")
	@RequestMapping(value = "/checklistswithsearch", method = RequestMethod.GET)
	public ModelAndView checklistsWithSearchPage(Model model,HttpServletRequest request) {		
		String username = new CurrentUser().getCurrentUserName();
		Map<String, Object> model00 = new HashMap<String, Object>();
		
		
		List<SearchObject> result = new ArrayList<SearchObject>();
		List<Checklist> myList=new ArrayList<Checklist>();
		String typename="";
		String tabname="";
		HttpSession session = request.getSession();
		Category category=(Category) session.getAttribute("category");
	
		
		if(category==null){			
			tabname=(String) session.getAttribute("tabname");
			typename=(String) session.getAttribute("typename");
			switch(tabname){
			case "subcategory":{
			
			List<SubCategory> subcategory=subcategory_service.getSubCategoryByName(typename);
			for(int i=0;i<subcategory.size();i++){
				myList.addAll(checklist_service.getChecklistBySubCategory(subcategory.get(i).getSubcategory_id()));			
			}
						
			};break;
			case "checklist":{
				
				myList.addAll(checklist_service.listChecklistByTitle(typename));
				
				
							
			};break;
			case "procedurestep":{
				result=simulateSearchResult(typename);
				for(int i=0;i<result.size();i++){
					if(result.get(i).category=="procedurestep"){
					 myList.add(checklist_service.getChecklistByChecklistId(result.get(i).id));
					}
				}				
			};break;
			
			case "material":{
				result=simulateSearchResult(typename);
				for(int i=0;i<result.size();i++){
					if(result.get(i).category=="material"){
						
						if(myList.contains(checklist_service.getChecklistByChecklistId(result.get(i).id))){}
						else{
				     myList.add(checklist_service.getChecklistByChecklistId(result.get(i).id));
				     }
					}
				}
							
			};break;
			

			case "labor":{
					result=simulateSearchResult(typename);
					for(int i=0;i<result.size();i++){
						if(result.get(i).category=="labor"){
							if(myList.contains(checklist_service.getChecklistByChecklistId(result.get(i).id))){}
							else{
					     myList.add(checklist_service.getChecklistByChecklistId(result.get(i).id));
					     }
						}
					}
								
				};break;

			
			
		case "other":{
			result=simulateSearchResult(typename);
			for(int i=0;i<result.size();i++){
				if(myList.contains(checklist_service.getChecklistByChecklistId(result.get(i).id))){}
				else{
		         myList.add(checklist_service.getChecklistByChecklistId(result.get(i).id));
		     }	
				
				
			}
						
		};break;
		
		}
			
		}else{
		
		myList=checklist_service.getChecklistByCategory(category.getCategory_id());
		}
		
		
		
		List<ProcedureStep> procedurestepList =procedurestep_service.listProcedureStep();
		List<Material> materialList =material_service.listMaterial();
		List<Labor> laborList  =labor_service.listLabor();
				
		List<Profit> profitList =profit_service.listProfit();
		List<Overhead> overheadList =overhead_service.listOverhead();
		List<Garbage> garbageList =garbage_service.listGarbage();
		List<Insurance> insuranceList =insurance_service.listInsurance();
		List<TotalCal> totalList =totalcal_service.listTotalCal();
	
		
		
		model00.put("checkList", myList);
		 
		 model00.put("procedureList", procedurestepList);
		 model00.put("materialList", materialList);
		 model00.put("laborList", laborList);
		 model00.put("profitList", profitList);
		 model00.put("overheadList", overheadList);
		 model00.put("garbageList", garbageList);
		 model00.put("insuranceList", insuranceList);
		 model00.put("totalList", totalList);
	
	    model.addAttribute("category", category); 
	    model.addAttribute("user", user_service.getUser(username));
	    
	    return new ModelAndView("checklists", model00);
	}
	

	@RequestMapping(value = "/create_checklist", method = RequestMethod.GET)
	public String createChecklist(Model model) {
		model.addAttribute("checklist", new Checklist());
	    model.addAttribute("category", category_service.listCategory());
	    model.addAttribute("subcategory", new SubCategory());
	    
	    return "create_checklist";
	}
	
	
	
@RequestMapping(value = "/procedure", method = RequestMethod.GET)	
public String redirectProcedurePage(@ModelAttribute("checklist") Checklist checklist, Model model) {	
	    model.addAttribute("checklist", checklist);
	    model.addAttribute("procedurestep", new ProcedureStep());
	    
	    return "procedure";
	}




@RequestMapping(value = "/material", method = RequestMethod.GET)
public String redirectMaterial(@ModelAttribute("checklist") Checklist checklist, Model model) {	
	    model.addAttribute("material", new Material());
	    
	    return "material";
	}
	


@RequestMapping(value = "/labor", method = RequestMethod.GET)
public String redirectLabor(@ModelAttribute("checklist") Checklist checklist, Model model) {	
//	model.addAttribute("checklist", checklist);
    model.addAttribute("labor", new Labor());
    return "labor";
}

@RequestMapping(value = "/overhead", method = RequestMethod.GET)
public String redirectOverhead(@ModelAttribute("checklist") Checklist checklist, Model model) {	
//	model.addAttribute("checklist", checklist);
    model.addAttribute("overhead", new Overhead());
    return "overhead";
}

@RequestMapping(value = "/profit", method = RequestMethod.GET)
public String redirectProfit(@ModelAttribute("checklist") Checklist checklist, Model model, HttpServletRequest request) {	

	HttpSession session = request.getSession();
	Material material=(Material) session.getAttribute("material");
	Labor labor=(Labor) session.getAttribute("labor");
	Overhead overhead=(Overhead) session.getAttribute("overhead");
	Insurance insurance=(Insurance) session.getAttribute("insurance");
	Garbage garbage=(Garbage) session.getAttribute("garbage");
	double total_cost = 0 ;
	
	
	//material step	
	if(material!=null){
	if(material.getMaterial_name().trim().contains("   ,")){
		String [] material_name=material.getMaterial_name().trim().split("   ,");
		String [] material_coverage=material.getCoverage().trim().split("   ,");
		String [] material_quantity=material.getQuantity().trim().split("   ,");
		for(int i =0;i<material_name.length;i++){
			total_cost=total_cost+(Double.parseDouble(material_coverage[i])*Double.parseDouble(material_quantity[i]));	
		}
		
	}else{
		
		total_cost=total_cost+(Double.parseDouble(material.getCoverage()))*Double.parseDouble(material.getQuantity());
		
		
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
			total_cost=total_cost+(Double.parseDouble(labor_num_hour[i])*Double.parseDouble(labor_hour_cost[i]))+Double.parseDouble(labor_insurance[i]);
	
		}
		
	}else{
		total_cost=total_cost+(Double.parseDouble(labor.getLabor_hourly_cost())*Double.parseDouble(labor.getLabor_num_hour()))+Double.parseDouble(labor.getLabor_insurance());
		
	}
	}
	
	
//overhead detail
	if(overhead!=null){
	if(overhead.getOverhead_cost().trim().contains("   ,")){
		String [] overhead_cost=overhead.getOverhead_cost().trim().split("   ,");
		String [] overhead_detail=overhead.getOverhead_detail().trim().split("   ,");
		
		for(int i =0;i<overhead_cost.length;i++){		
			total_cost=total_cost+Double.parseDouble(overhead_cost[i]);

		}
		
	}else{
		
		total_cost=total_cost+Double.parseDouble(overhead.getOverhead_cost());
		
	}
	}
//insurance step
	if(insurance!=null){
	if(insurance.getInsurance_amount().trim().contains("   ,")){
		String [] insurance_amount=insurance.getInsurance_amount().trim().split("   ,");
		String [] insurance_detail=insurance.getInsurance_detail().trim().split("   ,");
		
		for(int i =0;i<insurance_amount.length;i++){
			
			total_cost=total_cost+Double.parseDouble(insurance_amount[i]);
		}
		
	}else{
		
		total_cost=total_cost+Double.parseDouble(insurance.getInsurance_amount());
		
	}
	}
	

	//garbage step
			if(garbage!=null){
			if(garbage.getGarbage_cost().trim().contains("   ,")){
				String [] garbage_cost=garbage.getGarbage_cost().trim().split("   ,");
				String [] garbage_detail=garbage.getGarbage_detail().trim().split("   ,");
				
				for(int i =0;i<garbage_cost.length;i++){
			
					total_cost=total_cost+Double.parseDouble(garbage_cost[i]);

				}
				
			}else{
				total_cost=total_cost+Double.parseDouble(garbage.getGarbage_cost());

				
			}
			}			
	
	
	NumberFormat nf = NumberFormat.getNumberInstance();
	nf.setMaximumFractionDigits(2);            
	nf.setGroupingUsed(false);	
	total_cost=Double.parseDouble(nf.format(total_cost));
	model.addAttribute("cost", total_cost);
    model.addAttribute("profit", new Profit());
    return "profit";
}

@RequestMapping(value = "/garbage", method = RequestMethod.GET)
public String redirectGarbage(@ModelAttribute("checklist") Checklist checklist, Model model) {	
//	model.addAttribute("checklist", checklist);
    model.addAttribute("garbage", new Garbage());
    return "garbage";
}

@RequestMapping(value = "/insurance", method = RequestMethod.GET)
public String redirectInsurance(@ModelAttribute("checklist") Checklist checklist, Model model) {	
//	model.addAttribute("checklist", checklist);
    model.addAttribute("insurance", new Insurance());
    return "insurance";
}


@RequestMapping(value="/detail_{id}", method = {RequestMethod.GET})
public ModelAndView getDetail(@PathVariable(value="id") Integer id,Model model_detail){
    
    Map<String, Object> model = new HashMap<String, Object>();
    
    
	
	Checklist myList =checklist_service.getChecklistByChecklistId(id);
	
	List<ProcedureStep> procedurestepList =procedurestep_service.getProcedureStepWithChecklistId(id);
	List<Material> materialList =material_service.getMaterialWithProcedureId(id);
	List<Labor> laborList  =labor_service.getLaborWithProcedureId(id);
	
	List<Profit> profitList =profit_service.getProfitWithProcedureId(id);
	List<Overhead> overheadList =overhead_service.getOverheadWithProcedureId(id);
	List<Garbage> garbageList =garbage_service.getGarbageWithProcedureId(id);
	List<Insurance> insuranceList =insurance_service.getInsuranceWithProcedureId(id);
	List<TotalCal> totalList =totalcal_service.getTotalCalWithChecklistId(id);
	
	List<UserComment> usercommentList=usercomment_service.getUserCommentWithChecklistId(id);
	
	
	
	String username = new CurrentUser().getCurrentUserName();
	
	List<Checklist> userList =checklist_service.listChecklistByUsername(username);
	boolean belonguser=false;
	for(int s=0;s<userList.size();s++){
		if(id==userList.get(s).getChecklist_id()){
			belonguser=true;
		}
	}
	
	
	
	if(!username.equals("anonymousUser")){
	boolean bought=false;
	User current_user = user_service.getUser(username);
	if(current_user.getUser_bought()!=null){
	String[] bought_list=current_user.getUser_bought().split("\\.");
	for(int m=0;m<bought_list.length;m++){
		if(bought_list[m].equals(myList.getChecklist_id().toString())){
			bought=true;
		}
	
	}

	}
	
	if(!bought){
		if(myList.getShare_value()!=0&&!belonguser){
	double x=current_user.getUser_money()-myList.getShare_value();
	String bought_history=myList.getChecklist_id().toString()+"."+current_user.getUser_bought();
	current_user.setUser_bought(bought_history);
	current_user.setUser_money(x);
	user_service.updateUser(current_user);
		}
	}
	}
	
	String username2=myList.getUsername();
	if(username2.equals("anonymousUser")){
		
	}else{
	User user2= user_service.getUser(username2);
	if(!username.equals(username2)){
	double y=user2.getUser_money()+myList.getShare_value();
	user2.setUser_money(y);
	user_service.updateUser(user2);
	}
	}
	
	
	int user_match=0;
	String check_username=myList.getUsername();
	if(check_username.equals(username)){
		user_match=1;
	}
	 model.put("checkList", myList);
	 model.put("procedureList", procedurestepList);
	 model.put("materialList", materialList);
	 model.put("laborList", laborList);
	 model.put("profitList", profitList);
	 model.put("overheadList", overheadList);
	 model.put("garbageList", garbageList);
	 model.put("insuranceList", insuranceList);
	 model.put("totalList", totalList);
	 model.put("usercommentList", usercommentList);
	 model.put("user_match", user_match);
	 
	 model_detail.addAttribute("usercomment", new UserComment());
	 model_detail.addAttribute("checklist", new Checklist());
	 model_detail.addAttribute("procedurestep", new ProcedureStep());
	 model_detail.addAttribute("material", new Material());
	 model_detail.addAttribute("labor", new Labor());
	 model_detail.addAttribute("overhead", new Overhead());
	 model_detail.addAttribute("profit", new Profit());
	 model_detail.addAttribute("garbage", new Garbage());
	 model_detail.addAttribute("insurance", new Insurance());
	 model_detail.addAttribute("editchecklistobject",new EditChecklistObject());
	 
    return new ModelAndView("detail", model);
}


private List<SearchObject> simulateSearchResult(String category_name) {
	 
	List<Category> categories =  category_service.listCategory();
	List<SubCategory> subcategories =  subcategory_service.listSubCategory();
	List<Checklist> checklists =checklist_service.listChecklist();
	List<ProcedureStep> proceduresteps =procedurestep_service.listProcedureStep();
	List<Material> materials =material_service.listMaterial();
	List<Labor> labors =labor_service.listLabor();
	
	List<SearchObject> result = new ArrayList<SearchObject>();
	
	for(int i=0; i<categories.size(); i++){
		if(categories.get(i).getCategory_name().contains(category_name)){
			result.add(new SearchObject("category",categories.get(i).getCategory_name(),categories.get(i).getCategory_id()));
			
		}
	}	
	
	
	for(int i=0; i<subcategories.size(); i++){
		if(subcategories.get(i).getSubcategory_name().contains(category_name)){
			result.add(new SearchObject("subcategory",subcategories.get(i).getSubcategory_name(),subcategories.get(i).getSubcategory_id()));
			
		}
	}	
	for(int i=0; i<checklists.size(); i++){
		if(checklists.get(i).getTitle().contains(category_name)){
			result.add(new SearchObject("checklist",checklists.get(i).getTitle(),checklists.get(i).getChecklist_id()));
		}
	}	
	for(int i=0; i<proceduresteps.size(); i++){
		if(proceduresteps.get(i).getStep_title().contains(category_name)){
			result.add(new SearchObject("procedurestep",proceduresteps.get(i).getStep_title(),proceduresteps.get(i).getChecklist_id()));
		}
	}	
	for(int i=0; i<materials.size(); i++){
		if(materials.get(i).getMaterial_name().contains(category_name)){
			result.add(new SearchObject("material",materials.get(i).getMaterial_name(),materials.get(i).getProcedure_id()));
		}
	}	
	for(int i=0; i<labors.size(); i++){
		if(labors.get(i).getLabor_task().contains(category_name)){
			result.add(new SearchObject("labor",labors.get(i).getLabor_task(),labors.get(i).getProcedure_id()));
		}
	}	

	return result;
}

}

