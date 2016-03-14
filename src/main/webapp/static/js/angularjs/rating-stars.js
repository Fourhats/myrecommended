angular
	.module("starrating", []).directive("ratingstars", 
	function() {
		var directive = {};
		directive.restrict = 'AE';
	
		directive.scope = {
			score: '=score',
			max: '=max',
			readonly: '=readonly',
			labelValue: '=labelvalue'
		};
	
		directive.templateUrl = "static/js/angularjs/rating-stars.html";
	
		directive.link = function(scope, elements, attr) {
			scope.labelValue = scope.labelValue;
			scope.fullStarSrc = "static/img/ratingStars/fullstar.png";
			scope.emptyStarSrc = "static/img/ratingStars/emptystar.png";
	
			scope.updateStars = function() {
				scope.stars = [];
				for ( var idx = scope.max; idx > 0; idx--) {
					var score = scope.hoverIdx > 0 ? scope.hoverIdx : scope.score;
					scope.stars.push({
						full : score >= idx,
						index : idx
					});
				}
			};
	
			scope.hover = function(idx) {
				scope.hoverIdx = idx;
			};
	
			scope.stopHover = function() {
				scope.hoverIdx = -1;
			};
	
			scope.setRating = function(idx) {
				if(!scope.readonly) {
					scope.score = idx;
					scope.stopHover();
				}
			};
	
			scope.$watch('score', function(newValue, oldValue) {
				if (newValue !== null && newValue !== undefined) {
					scope.updateStars();
				}
			});
			
			scope.$watch('hoverIdx', function(newValue, oldValue) {
				if (!scope.readonly && newValue !== null && newValue !== undefined) {
					scope.updateStars();
				}
			});
			
			if(!scope.score) {
				scope.score = 3;
			}
		};
	  
	  return directive;
});
