<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html data-ng-app="myRecommendedApp">
<head>
	<%@ include file="partials/styles.jsp"%>
</head>
<body data-ng-controller="homeController">
	<div style="position: absolute; width: 100%;">
		<%@ include file="partials/header.jsp"%>
	</div>
	<div class="section no-pad-bot" id="index-banner">
		<div class="container homeContainer">
			<br>
			<br>
			<h1 class="center">Mis Recomendados</h1>
			<div class="row center">
				<h5 class="header col s12 light">¡La mejor manera de contratar
					servicios!</h5>
			</div>
			<div class="row center homeSearch">
				<!-- <div class="input-field col s3 m3">
					<select style="width: 80%">
						<option value="" disabled selected>Ubicación</option>
						<option value="1">Option 1</option>
						<option value="2">Option 2</option>
						<option value="3">Option 3</option>
					</select>
				</div>-->
				<div class="input-field col s3 m4">
					<select style="width: 80%" 
						data-ng-model="selectedCategory" 
						data-ng-options="category.name for category in categories">
				     		<option value="" disabled selected>Especialidad</option>
				    </select>
				</div>
				<div class="input-field col s3 m4">
					<input id="searchKey" data-ng-model="recommendedKey" type="text"
						class="validate">
				</div>
				<div class="input-field col s3 m4 input-field">
					<button class="btn-large waves-effect waves-light" data-ng-click="searchRecommended()">
						Buscar
					</button>
				</div>
			</div>
			<br>
			<br>
		</div>
	</div>

	<div class="container">
		<div class="section">
			<h2 class="header col s12 light center" style="font-size: 30px;">Contratar
				servicios nunca fue tan fácil</h2>
			<!--   Icon Section   -->
			<div class="row">
				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center light-blue-text">
							<i class="material-icons"></i>
						</h2>
						<h5 class="center">Contanos tú necesidad</h5>
						<p class="light">Con tu ubicación y el especialista que
							busques vamos a seleccionar los mejores candidatos disponibles</p>
					</div>
				</div>

				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center light-blue-text">
							<i class="material-icons"></i>
						</h2>
						<h5 class="center">Elegí a tu recomendado</h5>
						<p class="light">Revisa los recomendados que quieras entre los
							cientos que tenemos disponibles en nuestra red de profesionales</p>
					</div>
				</div>

				<div class="col s12 m4">
					<div class="icon-block">
						<h2 class="center light-blue-text">
							<i class="material-icons"></i>
						</h2>
						<h5 class="center">¡Contratá!</h5>
						<p class="light">Contactá al recomendado que buscabas y
							resolvé tus problemas más rápido que nunca ;)</p>
					</div>
				</div>
			</div>

		</div>
		<br> <br>

		<div class="section">
			<div class="row homeImages">
				<div class="col s12 m3" data-ng-repeat="category in categories">
					<img data-ng-src="{{category.image}}" data-ng-attr-title="{{category.name}}"/>
				</div>
			</div>
		</div>
	</div>
</body>
<%@ include file="partials/scripts.jsp"%>
<script>
	var categories = <%=request.getAttribute("categories")%>;

	var myRecommendedApp = angular.module('myRecommendedApp', ['ui.bootstrap', 'toastr', 'angularFileUpload']);
    $(document).ready(function() {
		hideMainProgressBar();
	});
</script>
<script type="text/javascript" src="<%=scriptPageContext%>/static/scripts/homeController.js"></script>

<%@ include file="partials/footerScritps.jsp"%>
</html>