


$(document).ready(function() {
    $("#change_map").click(function(){
  	  if($("#check_list").css("display")=="none"){
	  		$("#check_list").fadeIn("slow");
	    }else{
	  		$("#check_list").css("display","none");
	    }
		if($("#check_table").css("display")=="none"){
	  		$("#check_table").fadeIn("slow");
	    }else{
	  		$("#check_table").css("display","none");
	    }
	  
		
    });
	
	
	
});

$(document).ready(function() {
	   $(".input-edit").hide();
	   $("#submit_modify").hide();
	   if($("#user_match").val()==1){
		   $("#modify_copy").hide();
	   }
       $("#modify_checklist").click(function(){

    	   $(".input-edit").show();
    	   $(".edit_label").hide();
    	   $("#submit_modify").show();
    	   $(this).hide();
    	  
       });
       
  
    
	
});

$(document).ready(function() {
	if($("#user_match").val()==0){
		   $("#modify_checklist").hide();
	   }
	$("#modify_copy").click(function(){
		   $(".input-edit").show();
		   $(".edit_label").hide();
		   $("#submit_modify").show();
		   $(this).hide();
		  
	   });
	
});

$(document).ready(function() {
	
 	$( "#checklist_form" ).validate({
	  	rules: {
	  	quantity: {
	      required: true,
	      number: true
	    },
		
		coverage: {
		      required: true,
		      number: true
		   },
			
		   labor_num_people: {
			      required: true,
			      number: true
			   },
				
			   labor_num_hour: {
				      required: true,
				      number: true
				   },
					
				   labor_hourly_cost: {
					      required: true,
					      number: true
					   },
						
					   labor_insurance: {
						      required: true,
						      number: true
						   },
							
						   overhead_cost: {
							      required: true,
							      number: true
							   },
								
							   garbage_cost: {
								      required: true,
								      number: true
								   },
									
								   insurance_amount: {
									      required: true,
									      number: true
									   },
										
									   profit_amount: {
										      required: true,
										      number: true
										   }
	  }
	});

	
});





