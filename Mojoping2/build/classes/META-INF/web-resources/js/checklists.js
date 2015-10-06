$(document).ready(function() {
      $(".single_list").dblclick(function(){
    	  
    	  $(this).children("#checklist_detail").toggle("slow");
      });
	
	 
	
});


$(document).ready(function() {
      $("#reset").click(function(){
   
    	  $(".checklist_detail").css("display","none");
      });
      
      $("a").click(function(){
    	  
    	  var need=Number($(this).html());
    	  var left=Number($("#money_left").html());
    	  if((!need==0)&&!(  $("#head_username").html()== $(this).next().html()  )&&!($(this).next().next().html()=="bought")){
    	  var conf=confirm("This checklist would cost your "+$(this).html());
    	  if((conf == true )&&(left >= need)) {
              alert("Loading now"+$(this).next().html()+"--"+$(this).next().next().html()+ $("#head_username").html());        
              return true;
          } else if((conf == true )&&(left<need)){
        	  alert("not Enough money"+left+"--"+need);
        	  return false;
          }else        
          {       	  
              alert("returning now"+$("#head_username").html());
              return false;
          }
    	  }
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

