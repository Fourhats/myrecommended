myRecommendedApp.controller('petitionController', function ($scope, $http) {
	$scope.categories = categories;
	
	$scope.sendNewPetition = function() {
		$scope.newPetition.categoryId = $scope.newPetition.selectedCategory.id;
		$scope.newPetition.initialDate = $scope.newPetition.initialDateInput.toLocaleDateString();
		if ($scope.petitionForm.$valid) {
			$http.post(getCompletePath("users/createPetition"), JSON.stringify($scope.newPetition))
			.success(function (petition) {
				if(petition.error) {
					$scope.error = petition.error;
				} else {
					redirect("home");
				}
		    }).error(function (data, status, headers, config) {
		    	alert("Ha ocurrido un problema. Por favor intente nuevamente");
		    });
		}
	};
});