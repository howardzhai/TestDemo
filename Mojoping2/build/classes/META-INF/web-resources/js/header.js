$(document).ready(function() {
	$(".header").load("jsp/header.jsp");
});

function performLogin() {
	
    var j_username = $("#j_username").val();
    var j_password = $("#j_password").val();
   
    $.ajax({
        cache: false,
        type: 'POST',
        url: "/Mojoping2/login",
        crossDomain: true,
        async: false,
        data: { 'j_username': j_username, 'j_password': j_password},
        dataType: 'json',
        beforeSend: function (xhr) {
            xhr.setRequestHeader("x-ajax-call", "no-cache");
        },
        success: function(data) {    
        	if(JSON.stringify(data) == "false"){
	        	$(".header").load("jsp/header.jsp", function(){        		
	           		 	$("#header_login_error").replaceWith('<div id="header_login_error"><p>Invalid username or password!</p></div>'); 
	           		 	$("#header_login_error").css('opacity','1');
	        	});
        	} else if(JSON.stringify(data) == "\"confirm\""){ 
        		window.location.replace("/Mojoping2/user_confirmation");
        	} else {
        		window.location.reload();
        	}
        }
        
    });
      
    return false;
}

