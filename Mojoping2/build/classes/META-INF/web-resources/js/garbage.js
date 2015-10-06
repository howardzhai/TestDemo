var garbage_step_count = 2;
$(document).ready(function(){

	$("#add_garbage_button").click(function(){
		if (garbage_step_count == 8) { 
			alert("You can add only 7 Steps."); 
		}
		else{			
			var html = '<div class="garbage_step_'+ garbage_step_count +'" id="garbage_step_'+ garbage_step_count +'"><tr><td><label for="garbage_cost">Garbage Cost:</label></td><td><input name="garbage_cost" id="garbage_cost" style="margin-left:21px"/></td><td><errors cssClass="error" /></td></tr></br><tr><td><label for="garbage_detail">Garbage Detail:</label></td><td><input name="garbage_detail" id="garbage_detail" style="margin-left:10px"/></td><td><errors  cssClass="error" /></p></td></tr></div>';
			$('#garbage_step').append(html);
			$(".footer").css('bottom',-52*(garbage_step_count-2));
			$(".procedure").height(550+52*(garbage_step_count-2));
			
			garbage_step_count++;
		}
	});	
}); 

$(document).ready(function(){
	$("#delete_garbage_button").click(function(){
		if (garbage_step_count == 2) { 
			alert("You cannot delete anymore step."); 
		}
		else{			
			var html = '#garbage_step_'+ (garbage_step_count-1);
			
			$(html).remove();
			var procedure_height=$(".procedure").height();
			var footer_bot=parseInt($(".footer").css('bottom'));
			if(footer_bot<0){		
			$(".footer").css('bottom',footer_bot+52);
			}
			$(".procedure").height(procedure_height-52);
			
			garbage_step_count--;
			
		}
	});	
}); 





$(document).ready(function(){

	$(':submit').click(function(){
		
		$("input[id='garbage_cost']").each(function(){
			var txt=$(this).val();
			txt=txt+"   ";
			$(this).val(txt);
	
		});
		
		$("input[id='garbage_detail']").each(function(){
			var txt=$(this).val();
			txt=txt+"   ";
			$(this).val(txt);
	
		});
		
	
	});
}); 
