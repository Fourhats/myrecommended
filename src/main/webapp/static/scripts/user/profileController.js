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
	$scope.isLoading = false;
});

myRecommendedApp.controller('userProfileController', function($scope, $http, toastr, FileUploader) {
	$scope.user = user;
	
	if($scope.user.isFacebookLogin) {
		$scope.user.avatarPath = 'http://graph.facebook.com/' + $scope.user.providerId + '/picture?type=large';
	} else {
		$scope.user.avatarPath = getCurrentUserImagePath('currentAvatarThumb', "medium");
	}
	
	$scope.updateUser = function() {
		if ($scope.updateUserForm.$valid) {
			$scope.$parent.isLoading = true;
			$http.post(getCompletePath("users/updateUser"), JSON.stringify($scope.user))
			.success(function (result) {
				$scope.$parent.isLoading = false;
				if(result.hasError) {
					toastr.warning(result.error);
				} else {
					toastr.success('El usuario se ha modificado exitosamente');
				}
		    }).error(function (data, status, headers, config) {
		    	$scope.$parent.isLoading = false;
		    	toastr.error('Ha ocurrido un problema. Por favor intente nuevamente');
		    });
		}
	};
	
	//UPLOADER
	var uploader = $scope.uploader = new FileUploader({
        url: getCompletePath("image/uploadAvatar")
    });
	
    uploader.filters.push({
        name: 'typeFilter',
        fn: function(item, options) {
            var type = '|' + item.type.slice(item.type.lastIndexOf('/') + 1) + '|';
            return '|jpg|png|jpeg|'.indexOf(type) !== -1;
        }
    });
    
    uploader.filters.push({
        name: 'sizeFilter',
        fn: function(item, options) {
            return item.size <= 2097152;
        }
    });
    
    uploader.autoUpload = true;
    
    uploader.onCompleteItem = function(item, response, status, headers) {
    	$scope.user.avatarName = response.name;
    	$scope.isUploadingAvatar = false;
    };
    
    uploader.onBeforeUploadItem = function(item) {
    	$scope.isUploadingAvatar = true;
    };
    
    uploader.onErrorItem = function(item, response, status, headers) {
    	item.remove();
    	toastr.warning('Ha ocurrido un problema.', 'Por favor asegurese de subir un archivo jpg/png que no exceda los 2mb');
    	$scope.isUploadingAvatar = false;
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
				$scope.$parent.isLoading = true;
				$http.post(getCompletePath("users/changePassword"), JSON.stringify($scope.passowordDto))
				.success(function (result) {
					$scope.$parent.isLoading = false;
					if(result.hasError) {
						toastr.warning(result.error);
					} else {
						toastr.success('La contraseña se ha modificado exitosamente');
						$scope.passowordDto = {};
					}
			    }).error(function (data, status, headers, config) {
			    	$scope.$parent.isLoading = false;
					toastr.error('Ha ocurrido un problema. Por favor intente nuevamente');
			    });
			}
		}
	};
	
	$scope.$parent.currentPage = "userProfile";
	$scope.$parent.currentPageName = "Perfil de usuario";
	
	$(document).ready(function() {
		$('input, textarea').characterCounter();
	});
});

myRecommendedApp.controller('recommendedProfileController', function($scope, $http, toastr, FileUploader) {
	$scope.recommended = recommended == null ? { email : user.email, categoryIds: [], recommendedImages: [] } : recommended;
	$scope.recommended.recommendedImageNames = [];
	$scope.recommended.previousRecommendedImages = $scope.recommended.recommendedImages.slice();
	$scope.recommended.avatarPath = getCurrentUserImagePath('currentRecommendedAvatarThumb', "medium");
	$scope.categories = categories;
	
	$scope.qtyOldJobsImagesUploading = 0;
	
	$scope.toggleCategorySelection = function(category) {
		var idx = $scope.recommended.categoryIds.indexOf(category.id);
	    idx > -1 ?  $scope.recommended.categoryIds.splice(idx, 1) : $scope.recommended.categoryIds.push(category.id);
	};
	
	$scope.updateRecommended = function() {
		if ($scope.updateRecommendedForm.$valid) {
			$scope.$parent.isLoading = true;
			angular.forEach($scope.recommended.recommendedImageNames, function(image, key) {
				$scope.recommended.recommendedImages.push({ path: image });
			});
			
			$http.post(getCompletePath("recommended/updateRecommended"), JSON.stringify($scope.recommended))
			.success(function (result) {
				$scope.$parent.isLoading = false;
				if(result.hasError) {
					toastr.warning(result.error);
				} else {
					toastr.success('El recomendado se ha modificado exitosamente');
				}
			}).error(function (data, status, headers, config) {
				$scope.$parent.isLoading = false;
				toastr.error('Ha ocurrido un problema. Por favor intente nuevamente');
			});
		}
	};
	
	//UPLOADER
	var uploader = $scope.uploader = new FileUploader();
	
    uploader.filters.push({
        name: 'imageFilter',
        fn: function(item, options) {
            var type = '|' + item.type.slice(item.type.lastIndexOf('/') + 1) + '|';
            return '|jpg|png|jpeg|'.indexOf(type) !== -1;
        }
    });
    uploader.filters.push({
        name: 'sizeFilter',
        fn: function(item, options) {
            return item.size <= 2097152;
        }
    });
    
    
    uploader.autoUpload = true;
    
    uploader.onCompleteItem = function(item, response, status, headers) {
    	if(item.uploadAction == 'uploadAvatar') {
    		$scope.recommended.avatarName = response.name;
    		$scope.recommended.avatarPath = getImagePath('tempRecommendedThumb', response.name);
    		$scope.isUploadingAvatar = false;
    	} else {
    		$scope.recommended.recommendedImageNames.push(response.name);
    		$scope.qtyOldJobsImagesUploading--;
    	}
    };
    
    uploader.onBeforeUploadItem = function(item) {
    	if(item.uploadAction == 'uploadAvatar') {
    		$scope.isUploadingAvatar = true;
    		item.url = getCompletePath("image/uploadRecommendedAvatar");
    	} else {
    		$scope.isUploadingOldJobs = true;
    		$scope.qtyOldJobsImagesUploading++;
    		item.url = getCompletePath("image/uploadRecommendedOldJobsImages");
    	}
    };
    
    uploader.onErrorItem = function(item, response, status, headers) {
    	item.remove();
    	toastr.warning('Ha ocurrido un problema.', 'Por favor asegurese de subir un archivo jpg/png que no exceda los 5mb');
    	
    	if(item.uploadAction == 'uploadAvatar') {
    		$scope.isUploadingAvatar = false;
    	} else {
    		$scope.qtyOldJobsImagesUploading--;
    	}
    };
    
    $scope.uploadOldJobs = function() {
    	angular.element('#oldJobsUploadButton').click();
    };
    
    $scope.uploadAvatar = function() {
    	angular.element('#avatarUpload').click();
    };
    
    $scope.isUploadingOldWorksImages = function() {
    	return $scope.qtyOldJobsImagesUploading > 0;
    };
    //FIN UPLOADER
	
    $scope.getRecommendedImagePath = function(recommendedImage) {
    	return getImagePath('recommendedOldJobsThumb', recommendedImage.path, 'medium');
    };
    
	$scope.$parent.currentPage = "recommendedProfile";
	$scope.$parent.currentPageName = "Perfil de recomendado";
	
	$(document).ready(function() {
		$('input, textarea').characterCounter();
	});
});