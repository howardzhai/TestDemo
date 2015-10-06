var insurance_step_count = 2;
$(document).ready(function(){

	$("#add_insurance_button").click(function(){
		if (insurance_step_count == 8) { 
			alert("You can add only 7 Steps."); 
		}
		else{			
			var html = '<div class="insurance_step_'+ insurance_step_count +'" id="insurance_step_'+ insurance_step_count +'"><tr><td><label for="insurance_amount">Insurance Amount:</label></td><td><input name="insurance_amount" id="insurance_amount" style="margin-left:8px"/></td><td><errors cssClass="error" /></td></tr></br><tr><td><label for="insurance_detail">Insurance Detail:</label></td><td><input name="insurance_detail" id="insurance_detail" style="margin-left:19px"/></td><td><errors  cssClass="error" /></p></td></tr></div>';
			$('#insurance_step').append(html);
			$(".footer").css('bottom',-52*(insurance_step_count-2));
			$(".procedure").height(550+52*(insurance_step_count-2));
			
			insurance_step_count++;
		}
	});	
}); 

$(document).ready(function(){
	$("#delete_insurance_button").click(function(){
		if (insurance_step_count == 2) { 
			alert("You cannot delete anymore step."); 
		}
		else{			
			var html = '#insurance_step_'+ (insurance_step_count-1);
			
			$(html).remove();
			var procedure_height=$(".procedure").height();
			var footer_bot=parseInt($(".footer").css('bottom'));
			if(footer_bot<0){		
			$(".footer").css('bottom',footer_bot+52);
			}
			$(".procedure").height(procedure_height-52);
			
			insurance_step_count--;
			
		}
	});	
}); 





$(document).ready(function(){

	$(':submit').click(function(){
		
		$("input[id='insurance_amount']").each(function(){
			var txt=$(this).val();
			txt=txt+"   ";
			$(this).val(txt);
	
		});
		
		$("input[id='insurance_detail']").each(function(){
			var txt=$(this).val();
			txt=txt+"   ";
			$(this).val(txt);
	
		});
		
	
	});
}); 
