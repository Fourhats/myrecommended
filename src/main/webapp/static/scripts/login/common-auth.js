var loggedinCallback;

function verifyAuthentication(response, onLoggedinSuccess){
	if(isNaN(response) && response.indexOf("USER_IS_NOT_AUTHENTICATED") != -1) {
		loggedinCallback = onLoggedinSuccess;
		$('#modal-login').modal('show');	
	} else {
		onLoggedinSuccess();
	}
}

function login(){
    var user_pass = $("#password").val();
    var user_name = $("#username").val();
    
    $.ajax({
          url: getCompletePath("j_spring_security_check"),
          data: { j_username: user_name , j_password: user_pass, _spring_security_remember_me: true }, 
          type: "POST",
          beforeSend: function (xhr) {
             xhr.setRequestHeader("X-Ajax-call", "true");
          },
          success: function(result) {       
	          //if login is success, hide the login modal and
	          //re-execute the function which called the protected resource
	          //(#7 in the diagram flow)
	          if (result == "ok") {
	            //loggedinCallback();
	            location.reload();
	             
	            return true;
	          } else {
				return false;           
	          }
    	  },
	      error: function(XMLHttpRequest, textStatus, errorThrown){
	    	  alert("Usuario o contraseña incorrecta");
	    	  return false; 
	      }
	});
}