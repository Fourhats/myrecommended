<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html data-ng-app="myRecommendedApp">
<head>
	<%@ include file="../partials/styles.jsp"%>
</head>
<body>
	<%@ include file="../partials/header.jsp"%>
	<div class="row">
		<div class="col s6" style="text-align: center;">
			<h3>Paso 1: Buscas el servicio que deseas</h3>
			<p><a href ="recomendados">Busc&aacute; el servicio</a> que desees, filtrando nombre y especialidad</p>
		</div>
		<div class="col s6" style="text-align: center;">
			<img style="width: 50%;" src="<%=headerPageContext%>/static/img/howWorks/howitworks-search.png" />
		</div>
	</div>
	<div class="row">
		<div class="col s6" style="text-align: center;">
			<img style="width: 50%;" src="<%=headerPageContext%>/static/img/howWorks/howitworks-question.png" />
		</div>
		<div class="col s6" style="text-align: center;">
			<h3>Paso 2: Le haces las preguntas que necesites</h3>
			<p>Hacel&eacute; las preguntas que consideres necesarias y el recomendado la responder&aacute; a todas</p>
		</div>
	</div>
	<div class="row">
		<div class="col s6" style="text-align: center;">
			<h3>Paso 3: Contratas al recomendado adecuado</h3>
			<p>Una vez que decidas cual es el recomendado que más te guste, contratalo</p>
		</div>
		<div class="col s6 style="text-align: center;"">
			<img style="width: 50%;" src="<%=headerPageContext%>/static/img/howWorks/howitworks-pay.png" />
		</div>
	</div>
	<div class="row">
		<div class="col s6" style="text-align: center;">
			<img style="width: 50%;" src="<%=headerPageContext%>/static/img/howWorks/howitworks-hire.png" />
		</div>
		<div class="col s6" style="text-align: center;">
			<h3>Paso 4: Lo calificas por sus servicios</h3>
			<p>Por &uacute;ltimo calificalo con un puntaje y comentario, así todos podemos saber como te fue</p>
		</div>
	</div>	

</body>
<%@ include file="../partials/scripts.jsp"%>
<script>
	var myRecommendedApp = angular.module('myRecommendedApp', ['ui.bootstrap', 'toastr']);
    $(document).ready(function() {
		hideMainProgressBar();
	});
</script>
<%@ include file="../partials/footerScritps.jsp"%>
</html>