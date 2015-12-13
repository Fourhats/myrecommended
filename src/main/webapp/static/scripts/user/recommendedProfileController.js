var recommendedProfileController = "recommendedProfileController";

myRecommendedApp.controller(recommendedProfileController, function($scope, $http, toastr, FileUploader) {
	$scope.recommended = recommended == null ? { email : user.email, categoryIds: [], recommendedImages: [] } : recommended;
	$scope.recommended.recommendedImageNames = [];
	$scope.recommended.previousRecommendedImages = $scope.recommended.recommendedImages.slice();
	$scope.recommended.avatarPath = getCurrentUserImagePath('currentRecommendedAvatarThumb', "medium");
	$scope.categories = categories;
	
	$scope.toggleCategorySelection = function(category) {
		var idx = $scope.recommended.categoryIds.indexOf(category.id);
	    idx > -1 ?  $scope.recommended.categoryIds.splice(idx, 1) : $scope.recommended.categoryIds.push(category.id);
	};
	
	$scope.updateRecommended = function() {
		if ($scope.updateRecommendedForm.$valid) {
			showMainProgressBar();
			angular.forEach($scope.recommended.recommendedImageNames, function(image, key) {
				$scope.recommended.recommendedImages.push({ path: image });
			});
			
			$http.post(getCompletePath("recommended/updateRecommended"), JSON.stringify($scope.recommended))
			.then(function (result) {
				if(result.data.hasError) {
					toastr.warning(result.data.error);
				} else {
					toastr.success('El recomendado se ha modificado exitosamente');
				}
			}).catch(function (result) {
				toastr.error('Ha ocurrido un problema. Por favor intente nuevamente');
			}).finally(function() {
				hideMainProgressBar();
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
    
    $scope.qtyOldJobsNewImages = 0;
	$scope.qtyAvatarChanges = 0;
    
    uploader.onCompleteItem = function(item, response, status, headers) {
    	if(item.uploadAction == 'uploadAvatar') {
    		$scope.recommended.avatarName = response.name;
    		$scope.recommended.avatarPath = getImagePath('tempRecommendedThumb', response.name);
    		$scope.isUploadingAvatar = false;
    		$scope.qtyAvatarChanges++;
    	} else {
    		$scope.recommended.recommendedImageNames.push(response.name);
    	}
    };
    
    uploader.onBeforeUploadItem = function(item) {
    	if(item.uploadAction == 'uploadAvatar') {
    		$scope.isUploadingAvatar = true;
    		item.url = getCompletePath("image/uploadRecommendedAvatar");
    	} else {
    		$scope.qtyOldJobsNewImages++;
    		item.url = getCompletePath("image/uploadRecommendedOldJobsImages");
    	}
    };
    
    uploader.onErrorItem = function(item, response, status, headers) {
    	item.remove();
    	toastr.warning('Ha ocurrido un problema.', 'Por favor asegurese de subir un archivo jpg/png que no exceda los 5mb');
    	
    	if(item.uploadAction == 'uploadAvatar') {
    		$scope.isUploadingAvatar = false;
    	}
    };
    
    $scope.hasUploadedMaxQuantityOldJobsImages = function() {
    	return $scope.recommended.previousRecommendedImages.length + $scope.qtyOldJobsNewImages >= 5;
    };
    
    $scope.uploadOldJobs = function() {
    	uploader.queueLimit = 5 + $scope.qtyAvatarChanges - $scope.recommended.previousRecommendedImages.length ;
    	angular.element('#oldJobsUploadButton').click();
    };
    
    $scope.uploadAvatar = function() {
    	uploader.queueLimit = 99999999;
    	angular.element('#avatarUpload').click();
    };
    //FIN UPLOADER
	
    $scope.getRecommendedImagePath = function(recommendedImage) {
    	return getImagePath('recommendedOldJobsThumb', recommendedImage.path, 'medium');
    };
    
	$scope.$parent.currentPage = "recommendedProfile";
	$scope.$parent.currentPageName = "Perfil de recomendado";
	
	$(document).ready(function() {
		$('input, textarea').characterCounter();
		hideMainProgressBar();
	});
});