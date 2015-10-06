var overhead_step_count = 2;
$(document).ready(function(){

	$("#add_overhead_button").click(function(){
		if (overhead_step_count == 8) { 
			alert("You can add only 7 Steps."); 
		}
		else{			
			var html = '<div class="overhead_step_'+ overhead_step_count +'" id="overhead_step_'+ overhead_step_count +'"><tr><td><label for="overhead_cost">Overhead Cost:</label></td><td><input name="overhead_cost" id="overhead_cost" style="margin-left:21px"/></td><td><errors cssClass="error" /></td></tr></br><tr><td><label for="overhead_detail">Overhead Detail:</label></td><td><input name="overhead_detail" id="overhead_detail" style="margin-left:10px"/></td><td><errors  cssClass="error" /></p></td></tr></div>';
			$('#overhead_step').append(html);
			$(".footer").css('bottom',-52*(overhead_step_count-2));
			$(".procedure").height(550+52*(overhead_step_count-2));
			
			overhead_step_count++;
		}
	});	
}); 

$(document).ready(function(){
	$("#delete_overhead_button").click(function(){
		if (overhead_step_count == 2) { 
			alert("You cannot delete anymore step."); 
		}
		else{			
			var html = '#overhead_step_'+ (overhead_step_count-1);
			
			$(html).remove();
			var procedure_height=$(".procedure").height();
			var footer_bot=parseInt($(".footer").css('bottom'));
			if(footer_bot<0){		
			$(".footer").css('bottom',footer_bot+52);
			}
			$(".procedure").height(procedure_height-52);
			
			overhead_step_count--;
			
		}
	});	
}); 





$(document).ready(function(){

	$(':submit').click(function(){
		
		$("input[id='overhead_cost']").each(function(){
			var txt=$(this).val();
			txt=txt+"   ";
			$(this).val(txt);
	
		});
		
		$("input[id='overhead_detail']").each(function(){
			var txt=$(this).val();
			txt=txt+"   ";
			$(this).val(txt);
	
		});
		
	
	});
}); 
