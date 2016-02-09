myRecommendedApp.controller('homeController', function ($scope) {
	$scope.categories = categories;
	
	angular.forEach($scope.categories, function(category, cKey) {
		category.image = getCompletePath('static/img/defaultImages/boxed/' + category.name + '.png');
	});
	
	$scope.searchRecommended = function() {
		if($scope.selectedCategory) {
			if($scope.recommendedKey) {
				redirect("recomendados/" + $scope.selectedCategory.id + "/" + $scope.recommendedKey);
			} else {
				redirect("recomendados/" + $scope.selectedCategory.id);
			}
		} else if($scope.recommendedKey) {
			redirect("recomendados/0/" + $scope.recommendedKey);
		} else {
			redirect("recomendados");
		}
	};
});