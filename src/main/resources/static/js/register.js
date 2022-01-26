$('document').ready(function(){			
	var password = document.getElementById("password")
	var confirmPassword = document.getElementById("confirm");
	
	function validatePassword(){
	  if(password.value != confirmPassword.value) {
	    confirmPassword.setCustomValidity("Passwords Don't Match");
	  } else {
	    confirmPassword.setCustomValidity('');
	  }
	}	
	password.onchange = validatePassword;
	confirm.onkeyup = validatePassword;		
});