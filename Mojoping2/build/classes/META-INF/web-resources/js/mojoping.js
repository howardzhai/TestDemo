$(document).ready(function() {
	$("#category_name").autocomplete({
		
		
		
		  source: function(request, response) {
			 
		    $.getJSON("/Mojoping2/getCategories", { category_name : document.getElementById("category_name").value, 
		    	category_search: document.getElementById("category_search").value }, 
		    	function(result){
		    		response($.map(result, function(item) {
		                return { value: item.category+"  :  "+item.category_name, data: item.id }
		            }));
		    
						        
		    	}
		    
		    );           
		  },
		  messages: {
		        noResults: '',
		        results: function() {}
		    },
		  minLength: 1,
		  select: function(event, ui){
		    console.log("OK");
		  }
		});//.autocomplete("widget").addClass("autocomplete");
	
/*	$( "#category_name" ).autocomplete({	
		serviceUrl: '/Mojoping2/getCategories',
		paramName: "category_name",
		delimiter: ",",		
		transformResult: function(response) {			 
			return {      	
		
			  suggestions: $.map($.parseJSON(response), function(item) {
				   return { value: item.category+"  :  "+item.category_name, data: item.id }
				         
			
				   
				   ;
			   })	 
			};	 
		}		
	});	*/

});

