myRecommendedApp.config(function($routeProvider) {
    $routeProvider
        .when('/usuario', {
        	templateUrl : getCompletePath('profileTemplates/user-profile.html'),
            controller  : 'userProfileController'
        })

        .when('/recomendado', {
        	templateUrl :  getCompletePath('profileTemplates/recommended-profile.html'),
            controller  : 'recommendedProfileController'
        })
        
        .when('/preguntas', {
        	templateUrl :  getCompletePath('profileTemplates/user-questions.html'),
            controller  : 'userQuestionsController'
        })
    
    	.otherwise({
    		redirectTo : '/usuario'
    	});
});

myRecommendedApp.controller('MainProfileController', function($scope) {
	$scope.unansweredQuestions = 0;
	
	angular.forEach(questionsPage.elements, function(question, key) {
		$scope.unansweredQuestions += question.hasAnswer ? 0 : 1;
	});
});