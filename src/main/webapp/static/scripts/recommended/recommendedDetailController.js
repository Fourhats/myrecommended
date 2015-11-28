myRecommendedApp.controller('recommendedDetailController', function ($scope, $http, toastr) {
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
	
	$scope.questionsPage = recommendedQuestions;
	$scope.newQuestions = [];
	
	$scope.addQuestion = function() {
		if ($scope.newQuestion) {
			showMainProgressBar();
			
			var question = {description: $scope.newQuestion, entityId: recommended.id};
			var makeQuestionUrl = "questions/makeQuestion";
			
			$http.post(getCompletePath(makeQuestionUrl), JSON.stringify(question))
			.then(function (result) {
				if(result.data.hasError) {
					toastr.warning(result.data.error);
				} else {
					$scope.newQuestion = "";
					$scope.newQuestions.push(result.data);
					toastr.success('La pregunta se ha realizado correctamente');
				}
		    }).catch(function (response) {
				toastr.error('Ha ocurrido un problema. Por favor intente nuevamente');
		    }).finally(function() {
		    	hideMainProgressBar();
		    });
		}
	};
    
    $(document).ready(function() {
		hideMainProgressBar();
	});
});