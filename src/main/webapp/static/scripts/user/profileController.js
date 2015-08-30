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
    
    	.otherwise({
    		redirectTo : '/usuario'
    	});
});

myRecommendedApp.controller('MainProfileController', function($scope) {
});

myRecommendedApp.controller('userProfileController', function($scope, $http, toastr, FileUploader) {
	$scope.user = user;
	
	if($scope.user.isFacebookLogin) {
		$scope.user.avatarPath = 'http://graph.facebook.com/' + $scope.user.providerId + '/picture?type=large';
	} else {
		$scope.user.avatarPath = getCurrentUserImagePath('currentAvatarThumb', "originals");
	}
	
	$scope.updateUser = function() {
		if ($scope.updateUserForm.$valid) {
			$http.post(getCompletePath("users/updateUser"), JSON.stringify($scope.user))
			.success(function (result) {
				if(result.hasError) {
					toastr.warning(result.error);
				} else {
					toastr.success('El usuario se ha modificado exitosamente');
				}
		    }).error(function (data, status, headers, config) {
				toastr.error('Ha ocurrido un problema. Por favor intente nuevamente');
		    });
		}
	};
	
	//UPLOADER
	var uploader = $scope.uploader = new FileUploader({
        url: getCompletePath("image/uploadAvatar")
    });
	
    uploader.filters.push({
        name: 'imageFilter',
        fn: function(item, options) {
            var type = '|' + item.type.slice(item.type.lastIndexOf('/') + 1) + '|';
            return '|jpg|png|jpeg|'.indexOf(type) !== -1;
        }
    });
    uploader.autoUpload = true;
    
    uploader.onCompleteItem = function(item, response, status, headers) {
    	$scope.user.avatarName = response.name;
    };
    
    uploader.onErrorItem = function(item, response, status, headers) {
    	uploader.cleanQueue();
    	toastr.warning('Ha ocurrido un problema.', 'Por favor asegurese de subir un archivo jpg/png que no exceda los 5mb');
    };
    
    $scope.uploadAvatar = function() {
    	angular.element('#avatarUpload').click();
    };
    //FIN UPLOADER
    
    $scope.changePassword = function() {
		if ($scope.changePasswordForm.$valid) {
			if($scope.passowordDto.newPassword != $scope.passowordDto.passwordRepeated) {
				toastr.warning('Las contraseñas nuevas deben coincidir');
			} else {
				$http.post(getCompletePath("users/changePassword"), JSON.stringify($scope.passowordDto))
				.success(function (result) {
					if(result.hasError) {
						toastr.warning(result.error);
					} else {
						toastr.success('La contraseña se ha modificado exitosamente');
						$scope.passowordDto = {};
					}
			    }).error(function (data, status, headers, config) {
					toastr.error('Ha ocurrido un problema. Por favor intente nuevamente');
			    });
			}
		}
	};
	
	$scope.$parent.currentPage = "userProfile";
});

myRecommendedApp.controller('recommendedProfileController', function($scope, $http, toastr, FileUploader) {
	$scope.recommended = recommended == null ? { email : user.email } : recommended;
	
	$scope.updateRecommended = function() {
		if ($scope.updateRecommendedForm.$valid) {
			$http.post(getCompletePath("recommended/updateRecommended"), JSON.stringify($scope.recommended))
			.success(function (result) {
				if(result.hasError) {
					toastr.warning(result.error);
				} else {
					toastr.success('El usuario se ha modificado exitosamente');
				}
			}).error(function (data, status, headers, config) {
				toastr.error('Ha ocurrido un problema. Por favor intente nuevamente');
			});
		}
	};
	
	//UPLOADER
	var uploader = $scope.uploader = new FileUploader({
        url: getCompletePath("image/uploadAvatar")
    });
	
    uploader.filters.push({
        name: 'imageFilter',
        fn: function(item, options) {
            var type = '|' + item.type.slice(item.type.lastIndexOf('/') + 1) + '|';
            return '|jpg|png|jpeg|'.indexOf(type) !== -1;
        }
    });
    uploader.autoUpload = true;
    
    uploader.onCompleteItem = function(item, response, status, headers) {
    	$scope.user.avatarName = response.name;
    };
    
    uploader.onErrorItem = function(item, response, status, headers) {
    	uploader.cleanQueue();
    	toastr.warning('Ha ocurrido un problema.', 'Por favor asegurese de subir un archivo jpg/png que no exceda los 5mb');
    };
    
    $scope.uploadAvatar = function() {
    	angular.element('#avatarUpload').click();
    };
  //FIN UPLOADER
	
	$scope.$parent.currentPage = "recommendedProfile";
});

//update de recommended
/*var recommended = {name: "nuevo nombre", description: "nueva description", categoryIds: [2,5]};
$http.post(getCompletePath("recommended/updateRecommended"), JSON.stringify(recommended))
.success(function () {
}).error(function (data, status, headers, config) {
	alert("Ha ocurrido un problema. Por favor intente nuevamente");
});*/