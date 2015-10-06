var profit_step_count = 2;
$(document).ready(function(){

	$("#add_profit_button").click(function(){
		if (profit_step_count == 8) { 
			alert("You can add only 7 Steps."); 
		}
		else{			
			var html = '<div class="profit_step_'+ profit_step_count +'" id="profit_step_'+ profit_step_count +'"><tr><td><label for="profit_amount">Profit Amount:</label></td><td><input name="profit_amount" id="profit_amount" style="margin-left:8px"/></td><td><errors cssClass="error" /></td></tr></br><tr><td><label for="profit_detail">Profit Detail:</label></td><td><input name="profit_detail" id="profit_detail" style="margin-left:19px"/></td><td><errors  cssClass="error" /></p></td></tr></div>';
			$('#profit_step').append(html);
			$(".footer").css('bottom',-52*(profit_step_count-2));
			$(".procedure").height(550+52*(profit_step_count-2));
			
			profit_step_count++;
		}
	});	
}); 

$(document).ready(function(){
	$("#delete_profit_button").click(function(){
		if (profit_step_count == 2) { 
			alert("You cannot delete anymore step."); 
		}
		else{			
			var html = '#profit_step_'+ (profit_step_count-1);
			
			$(html).remove();
			var procedure_height=$(".procedure").height();
			var footer_bot=parseInt($(".footer").css('bottom'));
			if(footer_bot<0){		
			$(".footer").css('bottom',footer_bot+52);
			}
			$(".procedure").height(procedure_height-52);
			
			profit_step_count--;
			
		}
	});	
}); 





$(document).ready(function(){

	$(':submit').click(function(){
		
		$("input[id='profit_amount']").each(function(){
			var txt=$(this).val();
			txt=txt+"   ";
			$(this).val(txt);
	
		});
		
		$("input[id='profit_detail']").each(function(){
			var txt=$(this).val();
			txt=txt+"   ";
			$(this).val(txt);
	
		});
		
	
	});
}); 



$(document).ready(function(){
	var cost= $("#total_cost").html();
	$("input[id='percentage']").change(function(){
		var x=parseFloat($(this).val());
		var cost2=parseFloat(cost);
		var all=100*cost2/(100-x);
		var percen=Math.round((all-cost2) * 100) / 100
		$("#profit_amount").val(percen);
		
				
	});
	
	
	$("input[id='profit_amount']").change(function(){
		var profit=parseFloat($(this).val());
		var cost2=parseFloat(cost);
		var all=cost2+profit;
		var percen=Math.round(profit * 100/all);
		$("#percentage").val(percen);
		
				
	});
});




