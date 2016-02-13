var sendContactController = 'sendContactController';

myRecommendedApp.controller(sendContactController, function ($scope, $http, toastr) {
	$scope.sendContact = function() {
		if($scope.contact.name && $scope.contact.description && $scope.contact.email) {
			showMainProgressBar();
		
			var sendContactUrl = "users/sendContact";
			
			$http.post(getCompletePath(sendContactUrl), JSON.stringify($scope.contact))
			.then(function () {
				toastr.success('El mail se ha enviado exitosamente');
		    }).catch(function (response) {
				toastr.error('Ha ocurrido un problema. Por favor intente nuevamente');
		    }).finally(function() {
		    	hideMainProgressBar();
		    });
		}
	};
});