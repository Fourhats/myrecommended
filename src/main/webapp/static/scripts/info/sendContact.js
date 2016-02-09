var homeController = 'homeController';

myRecommendedApp.controller(homeController, function ($scope, $http, toastr) {
	$scope.sendContact = function() {
		if($scope.contact.name && $scope.contact.description && $scope.contact.email) {
			showMainProgressBar();
		
			var sendContactUrl = "user/sendContact";
			
			$http.post(getCompletePath(sendContactUrl), JSON.stringify(contact))
			.then(function () {
				toastr.success('Has calificado a tu cliente exitosamente');
		    }).catch(function (response) {
				toastr.error('Ha ocurrido un problema. Por favor intente nuevamente');
		    }).finally(function() {
		    	hideMainProgressBar();
		    });
		}
	};
});