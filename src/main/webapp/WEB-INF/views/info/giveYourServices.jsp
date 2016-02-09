<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html data-ng-app="myRecommendedApp">
<head>
	<%@ include file="../partials/styles.jsp"%>
</head>
<body>
	<%@ include file="../partials/header.jsp"%>
	
<main>
	<div class="section no-pad-bot" id="index-banners">
		<div class="container">
			<div class="row">
				<div class="col l12" style="margin-bottom: 20px;">			
	      			<img style="margin-left: 25%; width: 50%;" src="<%=headerPageContext%>/static/img/logoFull.png" />
	      			<h5 style="text-align: center; line-height: 40px;"><b>¿Queres formar parte del equipo de Mis recomendados?</b><br>¡Es muy fácil! Simplemente crea una cuenta y registra tus datos haciendo click <a class="modal-trigger" href="#login">acá</a></h5>
	      			<p style="text-align: center;">Si tenes alguna duda completa este formulario y te estaremos contactando en pocos minutos ;)</p>
				    <form class="col s6 offset-s3">
				    	<div class="row">
				        	<div class="input-field col s12">
								<input placeholder="Tu nombre" id="new_question" type="text" class="validate">
								<input placeholder="Tu email" id="new_question" type="text" class="validate">
								<input placeholder="Tu teléfono" id="new_question" type="text" class="validate">
								<textarea placeholder="Contanos acerca de vos, como nos encontraste y que dudas tenes"id="textarea1" class="materialize-textarea"></textarea>
				        	</div>
				      	</div>
				    	<button id="questionButton" data-ng-click="addQuestion(newQuestion)" type="submit" class="waves-effect waves-light btn">Enviar</button>
					</form>
				</div>
    		</div>
		</div>
	</div>
	</div>
</main>
</body>
<%@ include file="../partials/scripts.jsp"%>
<script>
	var myRecommendedApp = angular.module('myRecommendedApp', ['ui.bootstrap']);
    $(document).ready(function() {
		hideMainProgressBar();
	});
</script>
<%@ include file="../partials/footerScritps.jsp"%>
</html>