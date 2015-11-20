myRecommendedApp.controller('recommendedDetailController', function ($scope, $http) {
	$scope.recommended = recommended;
	$scope.recommended.avatarPath = $scope.recommended.avatarName ?
			getImagePath('recommendedAvatarThumb', $scope.recommended.avatarName, "medium") :
			getCompletePath('static/img/defaultImages/' + $scope.recommended.categories[0].name + '.png');
	
	angular.forEach(recommended.categories, function(category, key) {
		category.image = getCompletePath('static/img/defaultImages/' + category.name + '.png');
	});
	
	angular.forEach(recommended.recommendedImages, function(recommendedImage, key) {
		recommendedImage.completePath = getImagePath('recommendedOldJobsThumb', recommendedImage.path, 'medium');
	
		if(recommended.recommendedImages.length - 1 == key) {
			$(".fancybox-button").fancybox({
				prevEffect		: 'none',
				nextEffect		: 'none',
				closeBtn		: false,
				helpers		: {
					title	: { type : 'inside' },
					buttons	: {}
				}
			});
		}
	});
    
    $(document).ready(function() {
		hideMainProgressBar();
	});
});