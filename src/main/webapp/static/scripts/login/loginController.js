myRecommendedApp.controller('registerUserController', function ($scope, $http) {
	$scope.registerUser = function() {
		if ($scope.registrationForm.$valid) {
			$scope.sendRegisterUser();
		}
	};
	
	$scope.sendRegisterUser = function() {
		$http.post(getCompletePath("users/createUser"), JSON.stringify($scope.newUser))
		.success(function (user) {
			if(user.error) {
				$scope.error = user.error;
			} else {
				$scope.loginUser(user.username, user.password);
			}
	    }).error(function (data, status, headers, config) {
	    	alert("Ha ocurrido un problema. Por favor intente nuevamente");
	    });
	};
	
	function verifyAuthentication(response, onLoggedinSuccess) {
		if(isNaN(response) && response.indexOf("USER_IS_NOT_AUTHENTICATED") != -1) {
			loggedinCallback = onLoggedinSuccess;
			$('#modal-login').modal('show');	
		} else {
			onLoggedinSuccess();
		}
	}

	$scope.login = function() {
		if ($scope.loginForm.$valid) {
		    $scope.loginUser($scope.user.email, $scope.user.password);
		}
	};
	
	$scope.loginUser = function(user, password) {
	    $.ajax({
	          url: getCompletePath("j_spring_security_check"),
	          data: { j_username: user, j_password: password, _spring_security_remember_me: true }, 
	          type: "POST",
	          beforeSend: function (xhr) {
	             xhr.setRequestHeader("X-Ajax-call", "true");
	          },
	          success: function(result) {       
		          if (result == "ok") {
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
	};
	
	$scope.facebookLogin = function() {
		FB.login(function(response) {
		  if (response.status === 'connected') {
			  $http.post(getCompletePath("users/loginFBUser"), response.authResponse.accessToken)
				.success(function (user) {
					if(user.error) {
						$scope.error = user.error;
					} else {
						$scope.loginUser(user.email, user.password);
					}
			    }).error(function (data, status, headers, config) {
			    	alert("Ha ocurrido un problema. Por favor intente nuevamente");
			    });
		  } else if (response.status === 'not_authorized') {
		  } else {
		  }
		}, {scope: 'public_profile,email'});
	};
});