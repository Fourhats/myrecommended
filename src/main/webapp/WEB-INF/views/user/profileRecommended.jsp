<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html data-ng-app="myRecommendedApp">
<head>
	<%@ include file="../partials/styles.jsp"%>
	<link href="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.3/fotorama.css" rel="stylesheet">
</head>

<body class="blackMenu" data-ng-controller="MainProfileController as vm">
	<%@ include file="../partials/header.jsp"%>
	<main>
		<div class="section no-pad-bot" id="index-banners">
			<div class="container">
				<div class="col m12">
					<h1 class="header center-on-small-only" data-ng-bind="currentPageName"></h1>
				</div>	
				<div class="row">
					<div class="col l3 m12 s12 profileMenu">
						<div class="collection">
							<a href="#usuario" class="collection-item" data-ng-class="{'active' : currentPage == 'userProfile'}">Información del usuario</a> 
							<a href="#recomendado" class="collection-item" data-ng-class="{'active' : currentPage == 'recommendedProfile'}">Información del recomendado</a> 
							<a href="#!" class="collection-item">Trabajos realizados</a> 
							<a href="#!" class="collection-item">Preguntas <span class="new badge">4</span></a>
						</div>
					</div>
					<div data-ng-view></div>
				</div>
			</div>
		</div>
	</main>
</body>

<%@ include file="../partials/scripts.jsp"%>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.12/angular-route.js"></script>

<script src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.3/fotorama.js"></script>

<script>
	var user = <%=request.getAttribute("user")%>;
	var recommended = <%=request.getAttribute("recommended")%>;
	var categories = <%=request.getAttribute("categories")%>;
	var myRecommendedApp = angular.module('myRecommendedApp', ['ui.bootstrap', 'angularFileUpload', 'ngRoute', 'toastr']);
</script>
<script type="text/javascript" src="<%=scriptPageContext%>/static/scripts/user/profileController.js"></script>
<script type="text/javascript" src="<%=scriptPageContext%>/static/scripts/user/userProfileController.js"></script>
<script type="text/javascript" src="<%=scriptPageContext%>/static/scripts/user/recommendedProfileController.js"></script>

<%@ include file="../partials/footerScritps.jsp" %>
</html>