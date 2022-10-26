

$(document).ready(function(){
	$(".pure-steps_group-triggers_item:nth-child(2)").on("click",function(){
    	if($("#input_email").val()!="" && $("#input_name").val()!='' && $("#input_about").val()!="" && $("#input_password").val()!="" && $("#input_img").val()!=""){
    	    $( ".pure-steps_group-triggers" ).slideDown( "slow" );
    	}else{
    	    $( ".pure-steps_group-triggers" ).slideUp( "slow" );
   		 }

	});

	$(".pure-steps_group-step_item input").on("keyup",function(){
    	if($("#input_email").val()!="" && $("#input_name").val()!='' && $("#input_about").val()!="" && $("#input_password").val()!="" && $("#input_img").val()!=""){
    	    $( ".pure-steps_group-triggers" ).slideDown( "slow" );
    	}else{
    	    $( ".pure-steps_group-triggers" ).slideUp( "slow" );
    	}
	});
	
	
});
