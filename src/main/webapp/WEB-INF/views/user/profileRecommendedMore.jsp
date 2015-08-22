<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<%@ include file="../partials/styles.jsp"%>
<title>Mis Recomendados</title>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.3/fotorama.css"
	rel="stylesheet">
<!-- 3 KB -->

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
						<a href="#!" class="collection-item">Información del usuario</a> <a
							href="#!" class="collection-item active">Información del
							Recomendado</a> <a href="#!" class="collection-item">Trabajos
							realizados</a> <a href="#!" class="collection-item">Preguntas <span
							class="new badge">4</span></a>
					</div>
				</div>
				<form class="col s9">
					<div class="row">
						<div class="input-field col s6">
							<input id="first_name" type="text" class="validate"> <label
								for="first_name">Nombre del Recomendado</label>
						</div>
						<div class="input-field col s6">
							<input id="last_name" type="text" class="validate"> <label
								for="last_name">Razón Social</label>
						</div>
						<div class="input-field col s12">
							<textarea id="textarea1" class="materialize-textarea"></textarea>
							<label for="textarea1">Descripción</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<input id="email" type="email" class="validate"> <label
								for="email">Telefono</label>
						</div>
						<div class="input-field col s6">
							<input id="phone" type="text" class="validate"> <label
								for="email">Email</label>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	</main>
</body>

<%@ include file="../partials/scripts.jsp"%>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.3/fotorama.js"></script>
<!-- 16 KB -->

</html>