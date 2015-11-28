<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html data-ng-app="myRecommendedApp">
<head>
	<%@ include file="../partials/styles.jsp"%>
	<link href="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.3/fotorama.css" rel="stylesheet">
</head>
<body class="blackMenu" data-ng-controller="recommendedDetailController">
	<%@ include file="../partials/header.jsp"%>

	<main>
		<div class="section no-pad-bot" id="index-banners">
			<div class="container">
				<div class="row">
					<div class="col l12" style="margin-bottom: 20px;">
						<h1 class="header center-on-small-only">Información del recomendado</h1>
					</div>
				</div>
				<div class="row" style="margin-top: 30px;">
					<div class="col l4 m12 s12">
						<img width="270" data-ng-src="{{recommended.avatarPath}}">
					</div>
					<div class="col l8 m12 s12" style="text-align: left;">
						<div class="row">
							<div class="col l6 m6 s12">
								<h4 style="font-weight: 100;" data-ng-bind="recommended.name"></h4>
							</div>
							<div class="col l6 m6 s12">
								<a class="waves-effect waves-light btn modal-trigger" href="#contactModal">¡Contacta a tú recomendado!</a>
							</div>
						</div>
						<div class="col s12" style="float: left;">
							<!-- <div class="rating">
								<span>&#9733;</span><span>&#9733;</span><span>&#9733;</span><span>&#9733;</span><span>&#9733;</span>
								(15 reviews positivos)
							</div>-->
						</div>
						<div class="col s12" style="float: left;">
							<div class="chip"
								data-ng-repeat="category in recommended.categories"
								data-ng-attr-title="{{category.name}}">
								{{category.name}} 
							</div>
						<br><br>	
						<strong style="width: 100%; float: left;">Acerca del recomendado:</strong>
						<span data-ng-bind="recommended.description" class="recommendedDescription" style="width:100%; float: left; margin-top: 5px; margin-bottom: 10px;"></span>
						<div style="width: 100%; float: left;margin-bottom: 10px; margin-top: 10px;">
							<strong style="float: left;margin-right: 10px;"><i style="float: left;" class="material-icons">email</i>Email:  </strong>
							<span data-ng-bind="recommended.email" class="recommendedDescription" style=" float: left;"></span><br>
						</div>
						<div style="width: 100%; float: left;margin-bottom: 10px; margin-top: 10px;">
							<strong style="float: left;margin-right: 10px;"><i style="float: left;" class="material-icons">phone</i>Teléfono:  </strong>
							<span data-ng-bind="recommended.phone" class="recommendedDescription" style=" float: left;"></span>
						</div>
						<div class="col s12" style="float: left; padding-top: 20px; text-align: left;">
						<!-- Dani, acá el <a> debería repetirse por cada imagen y el href apuntar a la imagen en tamaño grande -->
							<a class="fancybox-button" rel="fancybox-button" 
								data-ng-repeat="recommendedImage in recommended.recommendedImages"
								data-ng-href="{{recommendedImage.completePath}}">
								<img style="height: 70px; width: 70px; margin: 10px;" 
									data-ng-src="{{recommendedImage.completePath}}"/>
							</a>
						</div>
					</div>
					<div class="row">
					    <form class="col s12">
					      <div class="row">
					        <div class="input-field col s12">
					          <input placeholder="¡Hace tu pregunta!" id="first_name" type="text" class="validate">
					          <label for="first_name">Preguntas</label>
					        </div>
					      </div>
					      <button type="submit" class="waves-effect waves-light btn">Preguntar</button>
					     </form>
					</div>
			      <div class="row">
			        <div class="col s10 pull-s2">
			        	<img width="25" data-ng-src="{{recommended.avatarPath}}">
			        	<span data-ng-bind="recommended.name"></span><br>
			        	<span width="100" style="float: left;">Pregunta</span>
			        </div>
			        <div class="col s10 pull-s2 answer">
			        	<img width="25" data-ng-src="{{recommended.avatarPath}}">
			        	<span data-ng-bind="recommended.name"></span><br>
			        	<span width="100" style="float: left;">Pregunta</span>
			        </div>
			        <div class="col s10 pull-s2">
			        	<img width="25" data-ng-src="{{recommended.avatarPath}}">
			        	<span data-ng-bind="recommended.name"></span><br>
			        	<span width="100" style="float: left;">Pregunta</span>
			        </div>
			        <div class="col s10 pull-s2 answer">
			        	<img width="25" data-ng-src="{{recommended.avatarPath}}">
			        	<span data-ng-bind="recommended.name"></span><br>
			        	<span width="100" style="float: left;">Pregunta</span>
			        </div>
			        <!-- cada col s10 es una pregunta o respuesta, son iguales pero la respuesta tiene una clase answer. Despues le cavo más estilo"-->
			      </div>
			      
				</div>
			</div>
		</div>
		
		  
  

  
  <div id="contactModal" class="modal">
    <div class="modal-content">
      <h4>¡Contacta a tu recomendado!</h4>
      <p>En misrecomendado.com te ofrecemos acceder sin compromiso a la información de contacto del especialista que elegiste, sólo te pedimos que despejes tus dudas primero por el sistema de preguntas y respuestas ;)</p>
    </div>
    <div class="modal-footer">
      <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Ver información de contacto</a>
      <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Cerrar</a>
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
	var myRecommendedApp = angular.module('myRecommendedApp', ['ui.bootstrap', 'angularFileUpload', 'toastr']);
</script>
<script type="text/javascript" src="<%=scriptPageContext%>/static/scripts/recommended/recommendedDetailController.js"></script>

<%@ include file="../partials/footerScritps.jsp"%>

</html>