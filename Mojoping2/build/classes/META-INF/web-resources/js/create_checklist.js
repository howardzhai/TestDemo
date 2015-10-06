$(document).ready(function(){
	$('#category_id').change(function(event){		
		listAllSubCategories();
	});
});

//Get All SubCategories to Create Checklist Section When a Category is selected
function listAllSubCategories(){
	var category_id = $('#category_id').val();
	
	$.post('/Mojoping2/getSubCategoriesRelatedToCategory', {
		category_id : category_id
	},function(subcategories){
		var $select = $('#subcategory_id');
		$select.find('option').remove();
		
		if($.isEmptyObject(subcategories)){
			 $('<option>').val("no_subcategory").text("There is no subcategory").appendTo($select); 
			 $select.attr('disabled','true');	
		}else{                        
            $.each(subcategories, function(key, value) {               
                $('<option>').val(value.subcategory_id).text(value.subcategory_name).appendTo($select);                 
            });   
            $select.removeAttr('disabled'); 
		}
	});		 
}