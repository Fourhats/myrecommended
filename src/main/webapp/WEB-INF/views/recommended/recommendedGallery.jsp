<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html data-ng-app="myRecommendedApp">
<head>
	<%@ include file="../partials/styles.jsp"%>
</head>

<body data-ng-controller="recommendedGalleryController">
	<%@ include file="../partials/header.jsp"%>
	<main>
		<div class="col m12">
			<h1 class="header center-on-small-only">Recomendados</h1>
		</div>
		
		<div class="section no-pad-bot" id="index-banners">
			<div class="container">
	
				<div style="cursor: hand;" class="row listRow z-depth-1"
					data-ng-repeat="recommended in recommendedPage.elements" data-ng-click="goToRecommendedDetail(recommended)"
							class="ng-binding">
					<div class="col s2">
						<img class="rowThumbnail" data-ng-src="{{recommended.avatarPath}}">
					</div>
					<div class="col s6">
						<h4 style="font-weight: 100;" data-ng-bind="recommended.name"
							></h4>
						<p>Zonas de trabajo: Palermo, Recoleta, Caballito</p>
					</div>
					<div class="col s2">
						<div class="rating">
							<span>&#9733;</span><span>&#9733;</span><span>&#9733;</span><span>&#9733;</span><span>&#9733;</span><br>
							(15 reviews positivos)
						</div>
					</div>
					<div class="col s2" style="padding-top: 20px;">
						<img class="rowBadge"
							data-ng-repeat="category in recommended.categories"
							data-ng-src="{{category.image}}"
							data-ng-attr-title="{{category.name}}">
					</div>
				</div>
	
				<ul class="pagination">
					<li data-ng-class="{'disabled' : !recommendedPage.hasPreviousPage , 'waves-effect' : recommendedPage.hasPreviousPage}"
						data-ng-click="goToPreviousPage()">
						<a href="#!"><i class="material-icons">chevron_left</i></a>
					</li>
					<li data-ng-repeat="i in getNumber(recommendedPage.pageIndex, recommendedPage.totalPages)" 
						data-ng-class="{'active' : i == recommendedPage.pageIndex, 'waves-effect' : i != recommendedPage.pageIndex}"
						data-ng-click="goToPage(i)" >
						<a data-ng-bind="i"></a>
					</li>
					<li data-ng-class="{'disabled' : !recommendedPage.hasNextPage, 'waves-effect' : recommendedPage.hasNextPage}"
						data-ng-click="goToNextPage()">
						<a href="#!"><i class="material-icons">chevron_right</i></a>
					</li>
				</ul>
			</div>
		</div>
	</main>
</body>

<%@ include file="../partials/scripts.jsp"%>

<script>
	var recommendedPage = <%=request.getAttribute("recommendedPage")%>;
	var categories = <%=request.getAttribute("categories")%>;
	var selectedCategories = <%=request.getAttribute("selectedCategories")%>;
	var recommendedKey = <%=request.getAttribute("recommendedKey")%>;
	
	var myRecommendedApp = angular.module('myRecommendedApp', ['ui.bootstrap', 'angularFileUpload', 'toastr']);
</script>
<script type="text/javascript" src="<%=scriptPageContext%>/static/scripts/recommended/recommendedGalleryController.js"></script>

<%@ include file="../partials/footerScritps.jsp"%>
</html>