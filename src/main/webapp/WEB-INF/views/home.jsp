<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html data-ng-app="myRecommendedApp">
<head><meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
	<%@ include file="partials/styles.jsp"%>
</head>
<body data-ng-controller="homeController">
	<div style="position: absolute; width: 100%;">
		<%@ include file="partials/header.jsp"%>
	</div>
	<div class="section no-pad-bot" id="index-banner">
		<div class="container homeContainer">
			<br>
			<h1 class="center">Mis Recomendados</h1>
			<div class="row center">
				<h5 class="header col s12 light">¡La mejor manera de contratar servicios!</h5>
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
			<div class="row">
				<div class="col s12 m4">
					<div class="icon-block">
						<h5 class="center"><span class="numberingHome">1</span>Contanos tú necesidad</h5>
						<p class="light">Con tu ubicación y el especialista que
							busques vamos a seleccionar los mejores candidatos disponibles</p>
					</div>
				</div>

				<div class="col s12 m4">
					<div class="icon-block">
						<h5 class="center"><span class="numberingHome">2</span>Elegí a tu recomendado</h5>
						<p class="light">Revisa los recomendados que quieras entre los
							cientos que tenemos disponibles en nuestra red de profesionales</p>
					</div>
				</div>

				<div class="col s12 m4">
					<div class="icon-block">
						<h5 class="center"><span class="numberingHome">3</span>¡Contratá!</h5>
						<p class="light">Contactá al recomendado que buscabas y
							resolvé tus problemas más rápido que nunca ;)</p>
					</div>
				</div>
			</div>
			<br>
			<br>
		</div>
	</div>

	<div class="container">
		<div class="section">
			<h2 class="header col s12 light center" style="font-size: 30px;">¡Contratar
				servicios nunca fue tan fácil!</h2>
				<h4 class="header col s12 center homeP">Mis recomendados te ofrece profesionales de calidad calificados por nuestros usuarios<br>¡Podrás accederlos de manera fácil, rápida y gratuita!</h4>
			<div class="row">
				<div class="col s4 center">
					<a href="#">Albañiles </a><br>
					<a href="#">Armadores de muebles</a><br>
					<a href="#">Automotores</a><br>
					<a href="#">Decoradores</a><br>
					<a href="#">Durlock</a><br>
					<a href="#">Electricistas</a><br>
					<a href="#">Fletes</a><br>			
				</div>
				<div class="col s4 center">
					<a href="#">Gasistas</a><br>
					<a href="#">Limpieza de alfombras y tapizados</a><br>
					<a href="#">Maestros mayor de obra</a><br>
					<a href="#">Mudanzas</a><br>
					<a href="#">Pequeñas Soluciones</a><br>
					<a href="#">Pintores</a><br>
				</div>
				<div class="col s4 center">
					<a href="#">Pisos</a><br>
					<a href="#">Plomeros</a><br>
					<a href="#">Service Aire Acondicionado</a><br>
					<a href="#">Service Línea Blanca</a><br>
					<a href="#">Service TV, Audio y Video</a><br>
					<a href="#">Service Técnico PC</a><br>	
				</div>			
			</div>
			<div class="row">
				<div class="col s12 center">
					<a class="btn-large waves-effect waves-light" href="comoFunciona">¡Descubrí como funciona Mis Recomendados!</a>
				</div>
			</div>		
		</div>
		<br> <br>
		
		<img style="width: 100%;" src="<%=headerPageContext%>/static/img/bannerIcons.png" />
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