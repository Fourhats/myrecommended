myRecommendedApp.controller('homeController', function ($scope, $http) {
	$scope.searchRecommended = function() {
		if($scope.recommendedKey) {
			redirect("recomendados/" + $scope.recommendedKey);
		}
	};
});