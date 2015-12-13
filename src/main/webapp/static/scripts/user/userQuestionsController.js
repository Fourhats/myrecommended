myRecommendedApp.controller('userQuestionsController', function($scope, $http, $filter, toastr) {
	$scope.questionsPage = questionsPage;
	
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
					$scope.$parent.unansweredQuestions--;
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
	
	$scope.$parent.currentPage = "userQuestions";
	$scope.$parent.currentPageName = "Preguntas";
	
	$(document).ready(function() {
		hideMainProgressBar();
	});
});