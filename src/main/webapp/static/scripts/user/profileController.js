myRecommendedApp.config(function($routeProvider) {
    $routeProvider
        .when('/usuario', {
        	templateUrl : getCompletePath('profileTemplates/user-profile.html'),
            controller  : 'userProfileController'
        })

        .when('/recomendado', {
        	templateUrl :  getCompletePath('profileTemplates/recommended-profile.html'),
            controller  : 'recommendedProfileController'
        })
    
    	.otherwise({
    		redirectTo : '/usuario'
    	});
});

myRecommendedApp.controller('userProfileController', function($scope, $http, toaster) {
	$scope.user = user;
	
	$scope.updateUser = function() {
		$http.post(getCompletePath("users/updateUser"), JSON.stringify($scope.user))
		.success(function () {
			toaster.pop('success', "Se ha modificado", "El usuario se ha modificado exitosamente");
	    }).error(function (data, status, headers, config) {
	    	toaster.pop('error', "Hubo un problema", "Ha ocurrido un problema. Por favor intente nuevamente");
	    });
	};
});

myRecommendedApp.controller('recommendedProfileController', function($scope, $http) {
	$scope.recommended = recommended;
});