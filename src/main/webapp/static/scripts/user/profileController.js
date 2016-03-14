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
    
        .when('/recomendadosContratados', {
        	templateUrl :  getCompletePath('profileTemplates/hired-recommended.html'),
            controller  : 'hiredRecommendedController'
        })
        
        .when('/trabajosRealizados', {
        	templateUrl :  getCompletePath('profileTemplates/customers.html'),
            controller  : 'customersController'
        })
        
    	.otherwise({
    		redirectTo : '/usuario'
    	});
});

myRecommendedApp.controller('MainProfileController', function($scope) {
	$scope.unansweredQuestions = 0;
	$scope.canBeRecommended = user.canBeRecommended;
	
	angular.forEach(questionsPage.elements, function(question, key) {
		$scope.unansweredQuestions += question.hasAnswer ? 0 : 1;
	});
});