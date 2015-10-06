$(document).ready(function() {
      $(".single_list").dblclick(function(){
    	  
    	  $(this).children("#checklist_detail").toggle("slow");
      });
	
	 
	
});


$(document).ready(function() {
      $("#reset").click(function(){
   
    	  $(".checklist_detail").css("display","none");
      });
  
	
	
	
});



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

