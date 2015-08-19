<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html data-ng-app="myRecommendedApp">
<head>
	<%@ include file="../partials/styles.jsp"%>
	<title>Mis Recomendados</title>
</head>

<body data-ng-controller="recommendedGalleryController">
	<%@ include file="../partials/header.jsp"%>
	<main>
		<div class="section no-pad-bot" id="index-banners">
			<div class="container">
				<h4>Resultados</h4>
	
				<div class="row listRow z-depth-1" data-ng-repeat="recommended in recommendedPage.elements">
					<div class="col s2">
						<img class="rowThumbnail" data-ng-src="{{recommended.categories[0].image}}" alt="">
					</div>
					<div class="col s6">
						<h4 style="font-weight: 100;" data-ng-bind="recommended.name" data-ng-click="goToRecommendedDetail(recommended)" class="ng-binding"></h4>
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
					<li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
					<li class="active"><a href="#!">1</a></li>
					<li class="waves-effect"><a href="#!">2</a></li>
					<li class="waves-effect"><a href="#!">3</a></li>
					<li class="waves-effect"><a href="#!">4</a></li>
					<li class="waves-effect"><a href="#!">5</a></li>
					<li class="waves-effect"><a href="#!"><i class="material-icons">chevron_right</i></a></li>
				</ul>
	
			</div>
		</div>
	</main>
</body>

<%@ include file="../partials/scripts.jsp"%>

<script>
	var recommendedPage = <%=request.getAttribute("recommendedPage")%>;
	var categories = <%=request.getAttribute("categories")%>;
	var myRecommendedApp = angular.module('myRecommendedApp', [ 'ui.bootstrap' ]);
</script>
<script type="text/javascript" src="<%=scriptPageContext%>/static/scripts/recommended/recommendedGalleryController.js"></script>

<%@ include file="../partials/footerScritps.jsp"%>
</html>