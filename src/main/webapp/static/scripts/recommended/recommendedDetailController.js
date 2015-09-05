myRecommendedApp.controller('recommendedDetailController', function ($scope, $http) {
	$scope.recommended = recommended;
	$scope.recommended.avatarPath = $scope.recommended.avatarName ?
			getImagePath('recommendedAvatarThumb', $scope.recommended.avatarName, "medium") :
			getCompletePath('static/img/defaultImages/' + $scope.recommended.categories[0].name + '.png');
	
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