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
				<div class="col m12" style="margin-bottom: 20px;">
					<h1 class="header center-on-small-only">Información del recomendado</h1>
				</div>
				<div class="row" style="margin-top: 30px;">
					<div class="col s4">
						<img width="270" data-ng-src="{{recommended.avatarPath}}">
					</div>
					<div class="col s8" style="text-align: left;">
						<h4 style="font-weight: 100;" data-ng-bind="recommended.name"></h4>
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
								<strong style="float: left; margin-right: 10px;">
									<i style="float: left;" class="material-icons"></i>
									Email: 
								</strong>
								<span data-ng-bind="recommended.email" class="recommendedDescription" style=" float: left;"></span><br>
							</div>
							<div style="width: 100%; float: left;margin-bottom: 10px; margin-top: 10px;">
								<strong style="float: left;margin-right: 10px;">
									<i style="float: left;" class="material-icons"></i>
									Teléfono:  
								</strong>
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
						<div class="col s12"></div>
					</div>
				</div>
			</div>
		</div>
		<div>
			<input type="text" data-ng-model="newQuestion">
			<input type="submit" data-ng-click="addQuestion()">
		</div>
		<div>
			Nuevas preguntas
			<div data-ng-repeat="question in newQuestions">
				<span data-ng-bind="question.fullName"></span>:
				<span data-ng-bind="question.description"></span>
			</div>
		</div>
		<div>
			Viejas preguntas
			<div data-ng-repeat="question in questionsPage.elements">
				<span data-ng-bind="question.fullName"></span>:
				<span data-ng-bind="question.description"></span>
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
	var recommendedQuestions = <%=request.getAttribute("recommendedQuestions")%>;
	var myRecommendedApp = angular.module('myRecommendedApp', ['ui.bootstrap', 'angularFileUpload', 'toastr']);
</script>
<script type="text/javascript" src="<%=scriptPageContext%>/static/scripts/recommended/recommendedDetailController.js"></script>

<%@ include file="../partials/footerScritps.jsp"%>

</html>