myRecommendedApp.controller('recommendedDetailController', function ($scope, $http) {
	$scope.recommended = recommended;
	
	angular.forEach(recommended.categories, function(category, key) {
		category.image = getCompletePath('/static/img/defaultImages/' + category.name + '.png');
	});
});