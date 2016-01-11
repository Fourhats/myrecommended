var hiredRecommendedController = "hiredRecommendedController";

myRecommendedApp.controller(hiredRecommendedController, function($scope, $http, toastr) {
	$scope.recommendedsHiredPage = recommendedsHiredPage;
	
	$scope.giveFeedback = function(recommendedHired, feedback, stars) {
		if (feedback || stars < 1 || stars > 5) {
			showMainProgressBar();
			
			var recommendedFeedbackRequest = {recommendedHiredId : recommendedHired.id, feedback: feedback, stars: stars};
			var giveFeedbackUrl = "recommended/giveFeedbackToRecommended";
			
			$http.post(getCompletePath(giveFeedbackUrl), JSON.stringify(recommendedFeedbackRequest))
			.then(function (result) {
				if(result.data.hasError) {
					toastr.warning(result.data.error);
				} else {
					recommendedHired.hasRecommendedFeedback = true;
					recommendedHired.star = stars;
					recommendedHired.recommendedFeedback = feedback;
					toastr.success('Has calificado al recomendado exitosamente');
				}
		    }).catch(function (response) {
				toastr.error('Ha ocurrido un problema. Por favor intente nuevamente');
		    }).finally(function() {
		    	hideMainProgressBar();
		    });
		}
	};
	
	$scope.$parent.currentPage = "hiredRecommended";
	$scope.$parent.currentPageName = "Recomendados contratados";
	
	$(document).ready(function() {
		hideMainProgressBar();
	});
});