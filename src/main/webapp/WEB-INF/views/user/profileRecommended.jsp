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

		</div> <!-- #content -->
	</div> <!-- .container -->

	<%@ include file="../partials/footer.jsp"%>
</body>

<%@ include file="../partials/scripts.jsp"%>
<script src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.3/fotorama.js"></script> <!-- 16 KB -->

</html>