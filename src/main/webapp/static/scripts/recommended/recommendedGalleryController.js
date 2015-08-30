myRecommendedApp.controller('recommendedGalleryController', function ($scope, $http, $document, toastr) {
	$scope.categories = categories;
	
	$scope.recommendedPage = recommendedPage;
	
	$scope.selectedCategories = [];
	
	$scope.isLoading = false;
	$scope.hasNextPage = function() {
		return $scope.recommendedPage.totalPages > $scope.recommendedPage.pageIndex;
	};
	
	$scope.getMoreRecommendeds = function() {
		$scope.isLoading = true;
		
		$http.get(getCompletePath("recommended/" + ($scope.recommendedPage.pageIndex + 1) + "/" + $scope.recommendedPage.pageSize + "/" + $scope.selectedCategories))
		.success(function (newRecommendedPage) {
			setCategoryImages(newRecommendedPage.elements);
			
			$scope.recommendedPage.pageIndex++;
			$scope.recommendedPage.elements = $scope.recommendedPage.elements.concat(newRecommendedPage.elements);
			$scope.recommendedPage.totalItems = newRecommendedPage.totalItems;
			
			$scope.isLoading = false;
	    }).error(function () {
	    	$scope.isLoading = false;
			toastr.error('Ha ocurrido un problema. Por favor intente nuevamente');
	    });
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
	
	function onScroll() {
		if ($scope.hasNextPage() && !$scope.isLoading) {
            var closeToBottom = ($(window).scrollTop() + $(window).height() > $(document).height() - 200);
            if (closeToBottom) {
                $scope.getMoreRecommendeds();
            }
        }
    };

	setCategoryImages(recommendedPage.elements);
	
    $document.bind('scroll', onScroll);
});