myRecommendedApp.controller('recommendedGalleryController', function ($scope, $http, toastr) {
	$scope.categories = categories;
	
	$scope.recommendedPage = recommendedPage;
	
	$scope.selectedCategories = selectedCategories ? selectedCategories : [];
	
	$scope.goToPage = function(pageNumber) {
		$http.get(getCompletePath("recommended/" + pageNumber + "/" + $scope.recommendedPage.pageSize + "/" + $scope.selectedCategories))
		.success(function (newRecommendedPage) {
			setCategoryImages(newRecommendedPage.elements);
			
			$scope.recommendedPage = newRecommendedPage;
	    }).error(function () {
			toastr.error('Ha ocurrido un problema. Por favor intente nuevamente');
	    });
	};
	
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
	
	$scope.toggleCategorySelection = function (categoryId) {
	    var idx = $scope.selectedCategories.indexOf(categoryId);

	    if (idx > -1) {
	    	$scope.selectedCategories.splice(idx, 1);
	    } else {
	    	$scope.selectedCategories.push(categoryId);
	    }
	    
	    $scope.recommendedPage.pageIndex = 0;
	    $scope.recommendedPage.elements = [];
	    $scope.getMoreRecommendeds();
	};

	$scope.goToRecommendedDetail = function(recommended) {
		redirect("recomendado/" + recommended.id + "/" + recommended.name);
	};
	
	function setCategoryImages(newRecommended) {
		angular.forEach(newRecommended, function(aRecommended, key) {
			aRecommended.recommendedCategoriesImages = [];
			angular.forEach(aRecommended.categories, function(category, key) {
				category.image = getCompletePath('static/img/defaultImages/' + category.name + '.png');
			});
		});
	};

	/****Pager****/
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
	
	
	setCategoryImages(recommendedPage.elements);
});