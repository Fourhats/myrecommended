myRecommendedApp.controller('userProfileController', function($scope, $http, toastr, FileUploader) {
	$scope.user = user;
	
	if($scope.user.isFacebookLogin) {
		$scope.user.avatarPath = 'http://graph.facebook.com/' + $scope.user.providerId + '/picture?type=large';
	} else {
		$scope.user.avatarPath = getCurrentUserImagePath('currentAvatarThumb', "medium");
	}
	
	$scope.updateUser = function() {
		if ($scope.updateUserForm.$valid) {
			showMainProgressBar();
			$http.post(getCompletePath("users/updateUser"), JSON.stringify($scope.user))
			.then(function (result) {
				if(result.data.hasError) {
					toastr.warning(result.data.error);
				} else {
					toastr.success('El usuario se ha modificado exitosamente');
				}
		    }).catch(function (result) {
		    	toastr.error('Ha ocurrido un problema. Por favor intente nuevamente');
		    }).finally(function() {
		    	hideMainProgressBar();
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
				showMainProgressBar();
				$http.post(getCompletePath("users/changePassword"), JSON.stringify($scope.passowordDto))
				.then(function (result) {
					if(result.data.hasError) {
						toastr.warning(result.data.error);
					} else {
						toastr.success('La contraseña se ha modificado exitosamente');
						$scope.passowordDto = {};
					}
			    }).catch(function (result) {
			    	toastr.error('Ha ocurrido un problema. Por favor intente nuevamente');
			    }).finally(function() {
			    	hideMainProgressBar();
			    });
			}
		}
	};
	
	$scope.$parent.currentPage = "userProfile";
	$scope.$parent.currentPageName = "Perfil de usuario";
	
	$(document).ready(function() {
		$('input, textarea').characterCounter();
		hideMainProgressBar();
	});
});