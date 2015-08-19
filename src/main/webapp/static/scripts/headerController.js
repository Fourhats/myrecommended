myRecommendedApp.controller('headerController', function ($scope, $http) {
	$scope.searchRecommended = function() {
		if($scope.recommendedKey) {
			redirect("recomendados/" + $scope.recommendedKey);
		}
		
		//creacion de nuevo recomendado
		/*var newRecommended = {categoryIds : [1,2,3], name: "nuevo recomendado", description: "descripcion del nuevo recomendado"};
		$http.post(getCompletePath("recommended/createRecommended"), JSON.stringify(newRecommended))
		.success(function (user) {
	    }).error(function (data, status, headers, config) {
	    	alert("Ha ocurrido un problema. Por favor intente nuevamente");
	    });*/
		
		//update de user
		/*var user = {name: "nuevo nombre", surname: "nuevo apellido", avatarName: "nuevo avatar.jpg"};
		$http.post(getCompletePath("users/updateUser"), JSON.stringify(user))
		.success(function () {
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
	};
});