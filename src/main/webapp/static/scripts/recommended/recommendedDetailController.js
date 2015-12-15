var recommendedDetailController = "recommendedDetailController";

myRecommendedApp.controller(recommendedDetailController, function ($scope, $http, toastr) {
	$scope.recommended = recommended;
	$scope.recommended.avatarPath = $scope.recommended.avatarName ?
			getImagePath('recommendedAvatarThumb', $scope.recommended.avatarName, "medium") :
			getCompletePath('static/img/defaultImages/' + $scope.recommended.categories[0].name + '.png');
	
	angular.forEach(recommended.categories, function(category, key) {
		category.image = getCompletePath('static/img/defaultImages/' + category.name + '.png');
	});
	
	$scope.hasBought = false;
	
	$scope.hireRecommended = function() {
		showMainProgressBar();
		var contactRecommendedUrl = "recommended/contactRecommended";
		
		$http.post(getCompletePath(contactRecommendedUrl))
		.then(function (result) {
			if(result.data.hasError) {
				if(result.data.error === "USER_IS_NOT_AUTHENTICATED") {
					toastr.warning("Debe ingresar a recomendados para contactar al recomendado");
				} else {
					toastr.warning(result.data.error);
				}
			} else {
				$scope.hasBought = true;
				toastr.success('Has contactado al recomendado');
			}
	    }).catch(function (response) {
			toastr.error('Ha ocurrido un problema. Por favor intente nuevamente');
	    }).finally(function() {
	    	hideMainProgressBar();
	    });
	};
	
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
	$scope.hasAlreadyAsked = false;
	
	$scope.addQuestion = function(newQuestion) {
		if (newQuestion) {
			showMainProgressBar();
			
			var question = {description: newQuestion, entityId: recommended.id};
			var makeQuestionUrl = "questions/makeQuestion";
			
			$http.post(getCompletePath(makeQuestionUrl), JSON.stringify(question))
			.then(function (result) {
				if(result.data.hasError) {
					toastr.warning(result.data.error);
				} else {
					$scope.questionsPage.elements.unshift(result.data);
					$scope.hasAlreadyAsked = true;
					toastr.success('La pregunta se ha realizado correctamente');
				}
		    }).catch(function (response) {
				toastr.error('Ha ocurrido un problema. Por favor intente nuevamente');
		    }).finally(function() {
		    	hideMainProgressBar();
		    });
		}
	};
	
	$scope.addAnswer = function(newAnswer, question) {
		if (newAnswer) {
			showMainProgressBar();
			
			var answer = {description: newAnswer, questionId: question.id};
			var makeAnswerUrl = "questions/answerQuestion";
			
			$http.post(getCompletePath(makeAnswerUrl), JSON.stringify(answer))
			.then(function (result) {
				if(result.data.hasError) {
					toastr.warning(result.data.error);
				} else {
					question.hasAnswer = true;
					question.answers = [{ description : newAnswer }];
					toastr.success('La pregunta se ha realizado correctamente');
				}
		    }).catch(function (response) {
				toastr.error('Ha ocurrido un problema. Por favor intente nuevamente');
		    }).finally(function() {
		    	hideMainProgressBar();
		    });
		}
	};
	
	$scope.getQuestionUserAvatarPath = function(userAvatarName) {
		return getImagePath('avatarThumb', userAvatarName, 'small');
	};
    
    $(document).ready(function() {
		hideMainProgressBar();
	});
});