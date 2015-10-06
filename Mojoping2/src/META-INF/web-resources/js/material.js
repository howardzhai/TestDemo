
var material_step_count = 2;
$(document).ready(function(){

	$("#add_material_button").click(function(){
		if (material_step_count == 8) { 
			alert("You can add only 7 Steps."); 
		}
		else{			
			var html = '<div class="material_step_'+ material_step_count +'" id="material_step_'+ material_step_count +'"><tr><td><label for="material_name">Material Name:</label></td><td><input name="material_name" id="material_name" style="margin-left:63px"/></td><td><errors cssClass="error" /></td></tr></br><tr><td><label for="coverage">Coverage:</label></td><td><input name="coverage" id="coverage" style="margin-left:97px" /></td><td><errors cssClass="error" /></td></tr></br><tr><td><label for="quantity">Quantity:</label></td><td><input name="quantity" id="quantity" style="margin-left:105px"/></td><td><errors  cssClass="error" /></td></tr></br><tr><td><label for="material_file">Add your material file:</label></td><td><input type="file" name="material_file" id="material_file"style="margin-left:5px"/></td><td><errors cssClass="error" /></td></tr>	</div>';			
			$('#material_step').append(html);
			$(".footer").css('bottom',-78*(material_step_count-2));
			$(".procedure").height(550+78*(material_step_count-2));
			
			material_step_count++;
		}
	});	
}); 

$(document).ready(function(){
	$("#delete_material_button").click(function(){
		if (material_step_count == 2) { 
			alert("You cannot delete anymore step."); 
		}
		else{			
			var html = '#material_step_'+ (material_step_count-1);
			
			$(html).remove();
			var procedure_height=$(".procedure").height();
			var footer_bot=parseInt($(".footer").css('bottom'));
			if(footer_bot<0){		
			$(".footer").css('bottom',footer_bot+78);
			}
			$(".procedure").height(procedure_height-78);
			
			material_step_count--;
			
		}
	});	
}); 





$(document).ready(function(){

	$(':submit').click(function(){
		
		$("input[id='material_name']").each(function(){
			var txt=$(this).val();
			txt=txt+"   ";
			$(this).val(txt);
	
		});
		
		$("input[id='coverage']").each(function(){
			var txt=$(this).val();
			txt=txt+"   ";
			$(this).val(txt);
	
		});
		
		$("input[id='quantity']").each(function(){
			var txt=$(this).val();
			txt=txt+"   ";
			$(this).val(txt);
	
		});
	});
}); 

