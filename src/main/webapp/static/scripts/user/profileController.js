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

myRecommendedApp.controller('userProfileController', function($scope, $http, toastr) {
	$scope.user = user;
	
	$scope.updateUser = function() {
		if ($scope.updateUserForm.$valid) {
			$http.post(getCompletePath("users/updateUser"), JSON.stringify($scope.user))
			.success(function () {
				toastr.success('El usuario se ha modificado exitosamente');
		    }).error(function (data, status, headers, config) {
				toastr.error('Ha ocurrido un problema. Por favor intente nuevamente');
		    });
		}
	};
});

myRecommendedApp.controller('recommendedProfileController', function($scope, $http) {
	$scope.recommended = recommended;
});

//creacion de nuevo recomendado
/*var newRecommended = {categoryIds : [1,2,3], name: "nuevo recomendado", description: "descripcion del nuevo recomendado"};
$http.post(getCompletePath("recommended/createRecommended"), JSON.stringify(newRecommended))
.success(function (user) {
}).error(function (data, status, headers, config) {
	alert("Ha ocurrido un problema. Por favor intente nuevamente");
});*/

//update de recommended
/*var recommended = {name: "nuevo nombre", description: "nueva description", categoryIds: [2,5]};
$http.post(getCompletePath("recommended/updateRecommended"), JSON.stringify(recommended))
.success(function () {
}).error(function (data, status, headers, config) {
	alert("Ha ocurrido un problema. Por favor intente nuevamente");
});*/