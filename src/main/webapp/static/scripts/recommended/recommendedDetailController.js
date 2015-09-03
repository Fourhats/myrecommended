myRecommendedApp.controller('recommendedDetailController', function ($scope, $http) {
	$scope.recommended = recommended;
	
	angular.forEach(recommended.categories, function(category, key) {
		category.image = getCompletePath('static/img/defaultImages/' + category.name + '.png');
	});
	
	$scope.getRecommendedImagePath = function(recommendedImage) {
    	return getImagePath('recommendedOldJobsThumb', recommendedImage.path, 'medium');
    };
    
    $(document).ready(function() {
		hideMainProgressBar();
	});
});