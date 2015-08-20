<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
	<%@ include file="../partials/styles.jsp" %>
	<title>Mis Recomendados</title>
	<link  href="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.3/fotorama.css" rel="stylesheet"> <!-- 3 KB -->

</head>

<body>
	<%@ include file="../partials/header.jsp"%>
	
 <main>
<div class="section no-pad-bot" id="index-banners">
	<div class="container">
		
		<h4>Perfil de usuario</h4>
		
		<div class="row">
			<div class="col s3">
			 <div class="collection">
				<a href="#!" class="collection-item active">Información del usuario</a>
				<a href="#!" class="collection-item">Información del Recomendado</a>
				<a href="#!" class="collection-item">Trabajos realizados</a>
				<a href="#!" class="collection-item">Preguntas <span class="new badge">4</span></a>
			  </div>
			</div>
			<form class="col s9">
			  <div class="row">
				<div class="input-field col s6">
				  <input  id="first_name" type="text" class="validate">
				  <label for="first_name">Nombre</label>
				</div>
				<div class="input-field col s6">
				  <input id="last_name" type="text" class="validate">
				  <label for="last_name">Apellido</label>
				</div>
			  </div>
			  <div class="row">
				<div class="input-field col s6">
				  <input id="email" type="email" class="validate">
				  <label for="email">Email</label>
				</div>
				<div class="input-field col s6">
				  <input id="phone" type="text" class="validate">
				  <label for="email">Teléfono</label>
				</div>
			  </div>
			</form>
		</div>
	</div>
</div>

  
</main>
<!-- 
<div class="container">
		<div id="content">
			<div class="col-md-3">
				<%@ include file="profileMenu.jsp"%>
			</div>
			<div class="col-md-9">
				<h3>Pedidos a mi</h3>
				<div class="row">
					<div class="singleJob">
						<div class="col-md-9">
							<h6>Nombre del trabajo</h6>
							<span>Categoría</span>
							<p>Descripción del proyecto del proyecto del proyecto del proyecto del proyecto</p>
						</div>
						<div class="col-md-3">
							<span class="singleJobOptions">Opciones</span>
							<ul id="singleJobOptions">
							  <li><a href="#"><i class="fa fa-eye"></i> Ver trabajo</a></li>
							  <li><a href="#"><i class="fa fa-pencil"></i>Actualizar</a></li>
							  <li><a href="#"><i class="fa fa-plus"></i>Agregar imagenes</a></li>
							  <li><a href="#"><i class="fa fa-question"></i>Ver preguntas</a></li>
							  <li><a href="#"><i class="fa fa-thumbs-o-down"></i>Cancelar trabajo</a></li>
							</ul>
						</div>
					</div>
					<span style="width: 100%; display: inline-block; text-align: center;">
					<a class="beta-btn primary">Ver todos</a>
					</span>					
				</div>
				<h3>Pedidos a terceros</h3>
				<div class="row">
					<div class="singleJob">
						<div class="col-md-9">
							<h6>Nombre del trabajo</h6>
							<span>Categoría</span>
							<p>Descripción del proyecto del proyecto del proyecto del proyecto del proyecto</p>
						</div>
						<div class="col-md-3">
							<span class="singleJobOptions">Opciones</span>
							<ul id="singleJobOptions">
							  <li><a href="#"><i class="fa fa-eye"></i> Ver trabajo</a></li>
							  <li><a href="#"><i class="fa fa-pencil"></i>Actualizar</a></li>
							  <li><a href="#"><i class="fa fa-plus"></i>Agregar imagenes</a></li>
							  <li><a href="#"><i class="fa fa-question"></i>Ver preguntas</a></li>
							  <li><a href="#"><i class="fa fa-thumbs-o-down"></i>Cancelar trabajo</a></li>
							</ul>
						</div>			
					</div>
					<span style="width: 100%; display: inline-block; text-align: center;">
					<a class="beta-btn primary">Ver todos</a>
					</span>					
				</div>
				
			</div>

		</div>
	</div>
	
 -->
</body>

<%@ include file="../partials/scripts.jsp"%>
<script src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.3/fotorama.js"></script> <!-- 16 KB -->

</html>