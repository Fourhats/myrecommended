<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html data-ng-app="myRecommendedApp">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Mis Recomendados</title>
	
	<%@ include file="../partials/styles.jsp" %>
	<style>
		.logoHeader{
			float: left;
		}
		.faHeader{
			font-size: 16px;
			margin-right: 10px;
			color: #606366;
		}
		
		.faHeader:hover a, .faHeader:hover i{
			color: white;
		}
		
		.tp-bannertimer{
			display: none;
		}
		
		
		a i{
			color: white;
		}
		
		textarea{
			width: 60%!important;
		}
		
		.form-block label{
			width: 140px;
		}}
	</style>
</head>

<body data-ng-controller="petitionController">
	<%@ include file="../partials/header.jsp" %>
	
	<span us-spinner="{radius:30, width:8, length: 16}" style="position: absolute;top: 50%;left: 50%;"></span>
	
	<div class="container">
		<div id="content" class="space-top-none space-bottom-none">
			<div class="space30">&nbsp;</div>
			<div class="main-content">
				<h1 style="text-align: center;">Ofrece un trabajo</h1>
				<div class="space20">&nbsp;</div>
				<div class="col-lg-12" style="margin-left: 10%;">
					<div class="space20">&nbsp;</div>
					<form class="contact-form" data-ng-submit="sendNewPetition()" name="petitionForm">
						<div class="form-block">
							<label for="category">Categoría</label>
							<select  id="category" tabindex="1" data-ng-model="newPetition.selectedCategory" data-ng-options="category.name for category in categories">
						    	<option value="">Seleccionar Categoría</option>
						    </select>
						</div>
						<div class="form-block">
							<label for="name">Tipo de trabajo</label>
							<input id="name" type="text" name="name" required maxlength="100" tabindex="2" data-ng-model="newPetition.name">
						</div>
						<div class="form-block">
							<label for="title">Título</label>
							<input id="title" type="text" name="title" required maxlength="100" tabindex="3" data-ng-model="newPetition.title">
						</div>
						<div class="form-block">
							<label for="description">Descripción</label>
							<textarea id="description" name="description" required maxlength="1000" tabindex="4" data-ng-model="newPetition.description"></textarea>
						</div>
						<div class="form-block">
							<label for="initialDate">Fecha ideal de inicio</label>
							<input id="initialDate" type="date" placeholder="dd/MM/yyyy" name="initialDate" required tabindex="5" data-ng-model="newPetition.initialDateInput">
						</div>
						<div class="form-block">
							<label for="address">Ubicación</label>
							<input id="address" type="text" name="address" required maxlength="100" tabindex="6" data-ng-model="newPetition.address">
						</div>
						<div class="form-block">
							<button type="submit" class="beta-btn beta-btn-3d beta-btn-dodger beta-btn-small" data-ng-disabled="petitionForm.$invalid" tabindex="7">
								Subí tu trabajo ;)
							</button>
						</div>
					</form>
				</div>
				<div class="space20">&nbsp;</div>
			</div> <!-- .main-content -->
		</div> <!-- #content -->
	</div>
</body>

<%@ include file="../partials/scripts.jsp" %>
<script src="<%=scriptPageContext%>/static/js/spin.min.js"></script>
<script src="<%=scriptPageContext%>/static/js/angularjs/angular-spinner.js"></script>

<script>
	var categories = <%= request.getAttribute("categories") %>;
	var myRecommendedApp = angular.module('myRecommendedApp', ['ui.bootstrap', 'ngLoadingSpinner', 'angularFileUpload']);
</script>
<script type="text/javascript" src="<%=scriptPageContext%>/static/scripts/recommended/petitionController.js"></script>

<%@ include file="../partials/footerScritps.jsp" %>
</html>