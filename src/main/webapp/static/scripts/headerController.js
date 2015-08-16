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
		
	};
});