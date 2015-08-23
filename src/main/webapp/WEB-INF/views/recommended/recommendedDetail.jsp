<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html data-ng-app="myRecommendedApp">
<head>
<%@ include file="../partials/styles.jsp"%>
<title>Mis Recomendados</title>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.3/fotorama.css"
	rel="stylesheet">
<!-- 3 KB -->
</head>
<body data-ng-controller="recommendedDetailController">
	<%@ include file="../partials/header.jsp"%>

	<main>
		<div class="col m12">
			<h1 class="header center-on-small-only">Información del recomendado</h1>
		</div>
		<div class="section no-pad-bot" id="index-banners">
			<div class="container">
				<div class="row" style="margin-top: 30px;">
					<div class="col s4">
						<img data-ng-src="{{recommended.categories[0].image}}">
					</div>
					<div class="col s8" style="text-align: left;">
						<h4 style="font-weight: 100;" data-ng-bind="recommended.name"></h4>
						<div class="col s6" style="float: left;">
							<div class="rating">
								<span>&#9733;</span><span>&#9733;</span><span>&#9733;</span><span>&#9733;</span><span>&#9733;</span>
								(15 reviews positivos)
							</div>
						</div>
						<div class="col s6" style="float: left;">
							<img class="rowBadge"
								data-ng-repeat="category in recommended.categories"
								data-ng-src="{{category.image}}"
								data-ng-title="category.name"> 
						</div>
	
						<span data-ng-bind="recommended.description" class="recommendedDescription" style="width: 100%; float: left; margin-top: 30px;"></span>
	
						<div class="col s12" style="float: left; padding-top: 20px; text-align: left;">
							<img style="height: 70px; width: 70px; margin: 10px;"
								src="<%=headerPageContext%>/static/img/foto.jpg" />
								
								 <img
								style="height: 70px; width: 70px; margin: 10px;"
								src="<%=headerPageContext%>/static/img/foto.jpg" /> <img
								style="height: 70px; width: 70px; margin: 10px;"
								src="<%=headerPageContext%>/static/img/foto.jpg" /> <img
								style="height: 70px; width: 70px; margin: 10px;"
								src="<%=headerPageContext%>/static/img/foto.jpg" /> <img
								style="height: 70px; width: 70px; margin: 10px;"
								src="<%=headerPageContext%>/static/img/foto.jpg" />
						</div>
					</div>
					<div class="col s12"></div>
				</div>
			</div>
		</div>

	</main>
</body>

<%@ include file="../partials/scripts.jsp"%>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.3/fotorama.js"></script>
<!-- 16 KB -->
<script>
	var recommended = <%=request.getAttribute("recommended")%>;
	var myRecommendedApp = angular.module('myRecommendedApp', ['ui.bootstrap', 'angularFileUpload']);
</script>
<script type="text/javascript" src="<%=scriptPageContext%>/static/scripts/recommended/recommendedDetailController.js"></script>

<%@ include file="../partials/footerScritps.jsp"%>
</html>