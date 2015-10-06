
$(document).ready(function() {
    $(":checkbox").each(function(){
  	  if($(this).val()==null){
  		  //$(this).removeAttr("checked"); 	
  		$(this).val("0");  
  	  }
		   if($(this).val()=="1"){
  		  $(this).attr("checked",'true');	  
  	  }
		  
  	  
    });
	  
	  
	    $(":checkbox").click(function(){
  	
		  if($(this).val()=="0"){
  		  $(this).val("1");  
  	  }else{
  		   $(this).val("0");	  
  	  };
	  
    });
	
	
	
});


$(document).ready(function() {
	$(':submit').click(function(){
		  $(":checkbox").each(function(){
		  	  if($(this).val()=="0"){
		  		  //$(this).removeAttr("checked"); 	
		  		$(this).next().val("0");  
		  	  }
				   if($(this).val()=="1"){
					   $(this).next().val("1");  
		  	  }
	});
		  
	});
});
