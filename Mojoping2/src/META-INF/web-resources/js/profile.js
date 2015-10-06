$(document).ready(function() {
	$('.profile-input-edit').hide();
	$('#submit-profile').hide();
});

$(document).ready(function() {
	$("#edit-profile").click(function() {
		$('.profile-label').hide();
		$('#edit-profile').hide();
		
		$('.profile-input-edit').show();
		$('#submit-profile').show();
    });
});

$(document).ready(function() {
//	$("#submit-profile").click(function() {
//		$.ajax({
//		    type:"post",
//		    data: str,
//		    url:"/myaction.htm",
//		    async: false,
//		    dataType: "json",
//		    success: function(){
//		       alert("success");
//		    }
//		});
//
//    });
});