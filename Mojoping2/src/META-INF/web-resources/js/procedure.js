
var procedure_step_count = 2;
$(document).ready(function(){

	$("#add_procedure_button").click(function(){
		if (procedure_step_count == 8) { 
			alert("You can add only 7 Steps."); 
		}
		else{			
			var html = '<div class="procedure_step_'+ procedure_step_count +'" id="procedure_step_'+ procedure_step_count +'"><tr><td><label for="step_title">Step Title:</label></td><td><input name="step_title" id="step_title" style="margin-left:110px"/></td><td><errors cssClass="error" /></td></tr></br><tr><td><label for="step_details">Step Details:</label></td><td><input name="step_details" id="step_details" style="margin-left:95px"/></td><td><errors for="step_details" cssClass="error" /></td></tr></br><tr><td><label for="procedure_file">Add your procedure file:</label></td><td><input type="file" name="procedure_file" id="procedure_file" style="margin-left:5px"/></td><td><errors for="procedure_file" cssClass="error" /></td></tr>	</div>';			
			$('#procedure_step').append(html);
			$(".footer").css('bottom',-78*(procedure_step_count-2));
			$(".procedure").height(550+78*(procedure_step_count-2));
			
			procedure_step_count++;
		}
	});	
}); 

$(document).ready(function(){
	$("#delete_procedure_button").click(function(){
		if (procedure_step_count == 2) { 
			alert("You cannot delete anymore step."); 
		}
		else{			
			var html = '#procedure_step_'+ (procedure_step_count-1);
			
			$(html).remove();
			var procedure_height=$(".procedure").height();
			var footer_bot=parseInt($(".footer").css('bottom'));
			if(footer_bot<0){		
			$(".footer").css('bottom',footer_bot+78);
			}
			$(".procedure").height(procedure_height-78);
			
			procedure_step_count--;
			
		}
	});	
}); 





$(document).ready(function(){

	$(':submit').click(function(){
		
		$("input[id='step_details']").each(function(){
			var txt=$(this).val();
			txt=txt+"   ";
			$(this).val(txt);
	
		});
		
		$("input[id='step_title']").each(function(){
			var txt=$(this).val();
			txt=txt+"   ";
			$(this).val(txt);
	
		});
	});
}); 
