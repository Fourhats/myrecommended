myRecommendedApp.controller('headerController', function ($scope, $http) {
	$scope.searchRecommended = function() {
		if($scope.recommendedKey) {
			redirect("recomendados/" + $scope.recommendedKey);
		}
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