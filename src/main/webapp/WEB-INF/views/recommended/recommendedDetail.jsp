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
							<div class="col l6 m6 s12" data-ng-if="!recommended.isOwner && !hasBought">
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
							<div data-ng-if="hasBought">
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
							</div>
							<div class="col s12" style="float: left; padding-top: 20px; text-align: left;">
							<!-- Dani, acá el <a> debería repetirse por cada imagen y el href apuntar a la imagen en tamaño grande -->
								<a class="fancybox-button" rel="fancybox-button" 
									data-ng-repeat="recommendedImage in recommended.recommendedImages"
									data-ng-href="{{recommendedImage.completePath}}">
									<img style="height: 70px; width: 70px; margin: 10px;"  data-ng-src="{{recommendedImage.completePath}}"/>
								</a>
							</div>
						</div>
						<div class="row" data-ng-if="!recommended.isOwner && !hasAlreadyAsked">
						<h5>Preguntas</h5>
						    <form class="col s12">
						    	<div class="row">
						        	<div class="input-field col s12">
						          		<input data-ng-model="newQuestion" placeholder="¡Hace tu pregunta!" id="new_question" type="text" class="validate">
						          		<label for="new_question"></label>
						        	</div>
						      	</div>
						    	<button id="questionButton" data-ng-click="addQuestion(newQuestion)" type="submit" class="waves-effect waves-light btn">Preguntar</button>
							</form>
						</div>
				      	<div class="row questionRow" data-ng-repeat="question in questionsPage.elements">
				        	<div class="col s10 pull-s2">
					        	<img width="25" data-ng-src="{{getQuestionUserAvatarPath(question.user)}}">
					        	<span class="questionName" data-ng-bind="question.user.fullName"></span><br>
					        	<span width="100" class="questionContent" style="float: left;" data-ng-bind="question.description"></span>
				        	</div>
					        <div class="col s10 pull-s2 answer" data-ng-show="question.hasAnswer">
					        	<img width="25" data-ng-src="{{recommended.avatarPath}}">
					        	<span class="questionName" data-ng-bind="recommended.name"></span><br>
					        	<span width="100" class="questionContent" style="float: left;" data-ng-bind="question.answers[0].description"></span>
					        </div>
					        <div class="col s10 pull-s2 answer" data-ng-show="recommended.isOwner && !question.hasAnswer">
								<input data-ng-model="newAnswer" placeholder="¡Responde la consulta!" id="new_answer_{{question.id}}" type="text" class="validate">
								<button data-ng-click="addAnswer(newAnswer, question)">Responder</button>
							</div>
							<hr>
				        </div>
			      	</div>
			      
				</div>
			</div>
		</div>
		<div id="contactModal" class="modal">
    		<div class="modal-content-question">
      			<h4 data-ng-show="!hasBought">¡Contacta a tu recomendado!</h4>
      			<h4 data-ng-if="hasBought">¡Gracias por contactarlo!</h4>
      			<p data-ng-show="!hasBought">En misrecomendados.com te ofrecemos acceder sin compromiso a la información de contacto del especialista que elegiste, sólo te pedimos que despejes tus dudas primero por el sistema de preguntas y respuestas ;)</p>
    			<p data-ng-if="hasBought">Te llegará un email con la información. Además ya puedes ver la información de contacto del recomendado</p>
    		</div>
    		<div class="modal-footer">
      			<a href="#!" class="modal-action waves-effect waves-green btn-flat" data-ng-show="!hasBought" data-ng-click="hireRecommended()">Ver información de contacto</a>
      			<a href="#!" class="modal-action modal-close waves-effect waves-green btn-flat">Cerrar</a>
    		</div>
  		</div>
	</main>
</body>

<%@ include file="../partials/scripts.jsp"%>
<script src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.3/fotorama.js"></script>
<script>
	var recommended = <%=request.getAttribute("recommended")%>;
	var recommendedQuestions = <%=request.getAttribute("recommendedQuestions")%>;
	var myRecommendedApp = angular.module('myRecommendedApp', ['ui.bootstrap', 'angularFileUpload', 'toastr']);
</script>
<script type="text/javascript" src="<%=scriptPageContext%>/static/scripts/recommended/recommendedDetailController.js"></script>

<%@ include file="../partials/footerScritps.jsp"%>

</html>