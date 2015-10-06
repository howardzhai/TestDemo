var labor_step_count = 2;
$(document).ready(function(){

	$("#add_labor_button").click(function(){
		if (labor_step_count == 8) { 
			alert("You can add only 7 Steps."); 
		}
		else{			
			var html = '<div class="labor_step_'+ labor_step_count +'" id="labor_step_'+ labor_step_count +'"><tr><td><label for="labor_task">Task:</label></td><td><input name="labor_task" id="labor_task" style="margin-left:105px"/></td><td><errors cssClass="error" /></td></tr></br><tr><td><label for="labor_num_people">Number of People:</label></td><td><input name="labor_num_people" id="labor_num_people" style="margin-left:7px"/></td><td><errors  cssClass="error" /></td></tr></br><tr><td><label for="labor_num_hour">Number of Hour:</label></td><td><input name="labor_num_hour" id="labor_num_hour" style="margin-left:23px"/></td><td><errors cssClass="error" /></td></tr></br><tr><td><label for="labor_hourly_cost">Hourly Cost:</label></td><td><input name="labor_hourly_cost" id="labor_hourly_cost" style="margin-left:55px"/></td><td><errors  cssClass="error" /></td></tr></br><tr><td><label for="labor_insurance">Labor Insurance:</label></td><td><input name="labor_insurance" id="labor_insurance" style="margin-left:26px"/></td><td><errors  cssClass="error" /></td></tr></br><tr><td><label for="labor_detail">Details:</label></td><td><input name="labor_detail" id="labor_detail" style="margin-left:88px"/></td><td><errors  cssClass="error" /></p></td></tr></div>';
			$('#labor_step').append(html);
			$(".footer").css('bottom',-156*(labor_step_count-2)-50);
			$(".procedure").height(650+156*(labor_step_count-2));
			
			labor_step_count++;
		}
	});	
}); 

$(document).ready(function(){
	$("#delete_labor_button").click(function(){
		if (labor_step_count == 2) { 
			alert("You cannot delete anymore step."); 
		}
		else{			
			var html = '#labor_step_'+ (labor_step_count-1);
			
			$(html).remove();
			var procedure_height=$(".procedure").height();
			var footer_bot=parseInt($(".footer").css('bottom'));
			if(footer_bot<0){		
			$(".footer").css('bottom',footer_bot+156+50);
			}
			$(".procedure").height(procedure_height-156);
			
			labor_step_count--;
			
		}
	});	
}); 





$(document).ready(function(){

	$(':submit').click(function(){
		
		$("input[id='labor_task']").each(function(){
			var txt=$(this).val();
			txt=txt+"   ";
			$(this).val(txt);
	
		});
		
		$("input[id='labor_num_people']").each(function(){
			var txt=$(this).val();
			txt=txt+"   ";
			$(this).val(txt);
	
		});
		
		$("input[id='labor_num_hour']").each(function(){
			var txt=$(this).val();
			txt=txt+"   ";
			$(this).val(txt);
	
		});
		
		
		$("input[id='labor_hourly_cost']").each(function(){
			var txt=$(this).val();
			txt=txt+"   ";
			$(this).val(txt);
	
		});
		
		$("input[id='labor_insurance']").each(function(){
			var txt=$(this).val();
			txt=txt+"   ";
			$(this).val(txt);
	
		});
		
		$("input[id='labor_detail']").each(function(){
			var txt=$(this).val();
			txt=txt+"   ";
			$(this).val(txt);
	
		});
	});
}); 
