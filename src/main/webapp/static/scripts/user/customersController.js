var customersController = "customersController";

myRecommendedApp.controller(customersController, function($scope, $http, toastr) {
	$scope.customersPage = customersPage;
	
	$scope.giveUserFeedback = function(customer, feedback) {
		if (feedback) {
			showMainProgressBar();
			
			var recommendedFeedbackRequest = {recommendedHiredId : customer.id, feedback: feedback};
			var giveFeedbackUrl = "recommended/giveFeedbackToUser";
			
			$http.post(getCompletePath(giveFeedbackUrl), JSON.stringify(recommendedFeedbackRequest))
			.then(function (result) {
				if(result.data.hasError) {
					toastr.warning(result.data.error);
				} else {
					customer.hasUserFeedback = true;
					customer.recommendedFeedback = feedback;
					toastr.success('Has calificado a tu cliente exitosamente');
				}
		    }).catch(function (response) {
				toastr.error('Ha ocurrido un problema. Por favor intente nuevamente');
		    }).finally(function() {
		    	hideMainProgressBar();
		    });
		}
	};
	
	$scope.$parent.currentPage = "customers";
	$scope.$parent.currentPageName = "Trabajos realizados";
	
	$(document).ready(function() {
		hideMainProgressBar();
	});
});