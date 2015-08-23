<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html data-ng-app="myRecommendedApp">
<head>
<%@ include file="partials/styles.jsp"%>
<title>Mis Recomendados</title>
</head>
<body>
	<%@ include file="partials/header.jsp"%>
	<main>
		<div class="section no-pad-bot" id="index-banner">
			<div class="container">
				<img id="banner1" class="homeImage" src="static/img/workerBanner1.jpg" />
				<img id="banner2" class="homeImage" src="static/img/workerBanner2.jpg" />
				<img id="banner3" class="homeImage" src="static/img/workerBanner3.jpg" />
				<div class="row homeRecommendedRow">
	
					<div class="col s4 homeRecommended">
						<div class="col s4">
							<img src="static/img/defaultImages/electricista.png">
						</div>
						<div class="col s8">
							<span class="recommendedTitle">Nombre del Recomendado</span>
							 <span class="recommendedDescription">Descripción</span>
						</div>
					</div>
					<div class="col s4 homeRecommended">
						<div class="col s4">
							<img src="static/img/defaultImages/gasista.png">
						</div>
						<div class="col s8">
							<span class="recommendedTitle">Nombre del Recomendado</span>
							<span class="recommendedDescription">Descripción Descripción
								Descripción Descripción Descripción Descripción </span>
						</div>
					</div>
					<div class="col s4 homeRecommended">
						<div class="col s4">
							<img src="static/img/defaultImages/jardinero.png">
						</div>
						<div class="col s8">
							<span class="recommendedTitle">Nombre del Recomendado</span> 
							<span class="recommendedDescription">Descripción Descripción
								Descripción Descripción Descripción Descripción </span>
						</div>
					</div>
					<div class="col s4 homeRecommended">
						<div class="col s4">
							<img src="static/img/defaultImages/gasista.png">
						</div>
						<div class="col s8">
							<span class="recommendedTitle">Nombre del Recomendado</span> 
							<span class="recommendedDescription">Descripción Descripción Descripción Descripción Descripción Descripción </span>
						</div>
					</div>
	
				</div>
			</div>
		</div>
	</main>
</body>
<%@ include file="partials/scripts.jsp"%>
<script>
	var myRecommendedApp = angular.module('myRecommendedApp', ['ui.bootstrap']);
</script>
<%@ include file="partials/footerScritps.jsp"%>
</html>