<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html data-ng-app="myRecommendedApp">
<head>
	<%@ include file="../partials/styles.jsp"%>
	<link href="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.3/fotorama.css" rel="stylesheet">
</head>

<body>
	<%@ include file="../partials/header.jsp"%>
	<main>
		<div class="col m12">
			<h1 class="header center-on-small-only">Perfil de usuario</h1>
		</div>
		<div class="section no-pad-bot" id="index-banners">
			<div class="container">
				<div class="row">
					<div class="col s3">
						<div class="collection">
							<a href="#usuario" class="collection-item active">Información del usuario</a> 
							<a href="#recomendado" class="collection-item">Información del recomendado</a> 
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
	var myRecommendedApp = angular.module('myRecommendedApp', ['ui.bootstrap', 'angularFileUpload', 'ngRoute', 'toastr']);
</script>
<script type="text/javascript" src="<%=scriptPageContext%>/static/scripts/user/profileController.js"></script>

<%@ include file="../partials/footerScritps.jsp" %>
</html>