var recommendedGalleryController = "recommendedGalleryController";

myRecommendedApp.controller(recommendedGalleryController, function ($scope, $http, toastr) {
	$scope.categories = categories;
	
	$scope.recommendedPage = recommendedPage;
	
	$scope.getSelectedCategory = function(categoryId) {
		var selectedCategory = { id: 0 };
		angular.forEach($scope.categories, function(aCategory, rKey) {
			if(aCategory.id == categoryId) {
				selectedCategory = aCategory;
			}
		});
		
		return selectedCategory;
	};
	
	$scope.selectedCategory = $scope.getSelectedCategory(categoryId);
	$scope.recommendedKey = recommendedKey;
	
	$scope.goToPage = function(pageNumber) {
		showMainProgressBar();
		
		var getUrl = "recommended/" + pageNumber + "/" + $scope.recommendedPage.pageSize + "/" + $scope.selectedCategory.id;
		if($scope.recommendedKey != "") getUrl += "/" + $scope.recommendedKey;
		
		$http.get(getCompletePath(getUrl))
		.then(function (response) {
			setImages(response.data.elements);
			
			$scope.recommendedPage = response.data;
	    }).catch(function (response) {
			toastr.error('Ha ocurrido un problema. Por favor intente nuevamente');
	    }).finally(function() {
	    	hideMainProgressBar();
	    });
	};
	
	$scope.goToRecommendedDetail = function(recommended) {
		redirect("recomendado/" + recommended.id + "/" + recommended.name);
	};
	
	function setImages(newRecommended) {
		angular.forEach(newRecommended, function(aRecommended, rKey) {
			aRecommended.recommendedCategoriesImages = [];
			angular.forEach(aRecommended.categories, function(category, cKey) {
				category.image = getCompletePath('static/img/defaultImages/' + category.name + '.png');
			});
			
			aRecommended.avatarPath = aRecommended.avatarName ?
					getImagePath('recommendedAvatarThumb', aRecommended.avatarName, "medium") :
					aRecommended.categories[0].image;
		});
	};
	
	$scope.searchRecommended = function() {
		if($scope.selectedCategory) {
			if($scope.recommendedKey) {
				redirect("recomendados/" + $scope.selectedCategory.id + "/" + $scope.recommendedKey);
			} else {
				redirect("recomendados/" + $scope.selectedCategory.id);
			}
		} else if($scope.recommendedKey) {
			redirect("recomendados/0/" + $scope.recommendedKey);
		} else {
			redirect("recomendados");
		}
	};

	/****Pager****/
	$scope.goToNextPage = function() {
		if($scope.recommendedPage.hasNextPage) {
			$scope.goToPage($scope.recommendedPage.pageIndex + 1);
		}
	};
	
	$scope.goToPreviousPage = function() {
		if($scope.recommendedPage.hasPreviousPage) {
			$scope.goToPage($scope.recommendedPage.pageIndex - 1);
		}
	};
	
	$scope.getNumber = function(currentNumber, totalPages) {
	    var array = [];
	    if(currentNumber < 5) {
	    	addElements(array, 1, totalPages < 9 ? totalPages : 9);
	    } else if (currentNumber > totalPages - 5) {
	    	addElements(array, totalPages - 9 < 1 ? 1 : totalPages - 9 , totalPages);
	    } else {
	    	addElements(array, currentNumber - 4, currentNumber + 4);
	    }
	    
	    return array;
	};
	
	function addElements(array, from, to) {
		for(var i = from; i <= to; i++) {
	    	array.push(i);
	    }
	}
	/****FIN Pager****/
	
	setImages(recommendedPage.elements);
	
    $(document).ready(function() {
		hideMainProgressBar();
	});
});