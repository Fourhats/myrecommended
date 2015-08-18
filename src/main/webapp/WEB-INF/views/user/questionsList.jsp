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
			
			<h4>Preguntas</h4>
			
			<div class="row">
				<div class="col s3">
				 <div class="collection">
					<a href="#!" class="collection-item">Información del usuario</a>
					<a href="#!" class="collection-item">Información del Recomendado</a>
					<a href="#!" class="collection-item">Trabajos realizados</a>
					<a href="#!" class="collection-item active">Preguntas <span class="new badge">4</span></a>
				  </div>
				</div>
				<div class="col s9">
				  <div class="row">
					<ul class="collection">
					    <li class="collection-item avatar">
					      <img src="../static/img/defaultImages/jardinero.png" alt="" class="circle">
					      <span class="title">NombreDelQuePregunta</span>
					      <p>¿Es esta la pregunta?<br>
					      </p>
					      <label for="email">Respuesta</label>
					      <input id="phone" type="text" class="validate">
					       <button class="btn waves-effect waves-light secondary-content" type="submit" name="action">Responder
   								<i class="material-icons right">send</i>
							</button>
					    </li>
					    <li class="collection-item avatar">
					      <img src="../static/img/defaultImages/jardinero.png" alt="" class="circle">
					      <span class="title">NombreDelQuePregunta</span>
					      <p>¿Es esta la pregunta?<br>
					      </p>
					      <label for="email">Respuesta</label>
					      <input id="phone" type="text" class="validate">
					       <button class="btn waves-effect waves-light secondary-content" type="submit" name="action">Responder
   								<i class="material-icons right">send</i>
							</button>
					    </li>
					    <li class="collection-item avatar">
					      <img src="../static/img/defaultImages/jardinero.png" alt="" class="circle">
					      <span class="title">NombreDelQuePregunta</span>
					      <p>¿Es esta la pregunta?<br>
					      </p>
					      <label for="email">Respuesta</label>
					      <input id="phone" type="text" class="validate">
					       <button class="btn waves-effect waves-light secondary-content" type="submit" name="action">Responder
   								<i class="material-icons right">send</i>
							</button>
					    </li>
					  </ul>
				  </div>
				</div>
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
				<h3>Preguntas</h3>
				<div class="row">
					<div class="questionBlock">
						<span class="questiontitle">NombreTareaAsociada</span>
						<div class="space10">&nbsp;</div>
						<div class="comment depth-1 media">
							<img src="../static/images/defaultImages/pintor.png" alt="" class="avatar pull-left">
							<div class="media-body">
								<p class="font-large">Preguntado por Daniel</p>
								<p class="font-large">¿Trabajan en provincia?</p>
							</div>
						</div>
	
						<div class="comment depth-2 media">
							<img src="../static/images/defaultImages/electricista.png" alt="" class="avatar pull-left">
							<div class="media-body">
								<p class="font-large">Pues claro!</p>
							</div>
						</div>
						<div class="space10">&nbsp;</div>
						<div class="comment depth-1 media">
							<img src="../static/images/defaultImages/pintor.png" alt="" class="avatar pull-left">
							<div class="media-body">
								<p class="font-large">Preguntado por Daniel</p>
								<p class="font-large">¿Trabajan en provincia?</p>
							</div>
						</div>
	
						<div class="comment depth-2 media">
							<img src="../static/images/defaultImages/electricista.png" alt="" class="avatar pull-left">
							<div class="media-body">
								<p class="font-large">Pues claro!</p>
							</div>
						</div>
					</div>
					<div class="questionBlock">
						<span class="questionTitle">NombreTareaAsociada</span>
						<div class="space10">&nbsp;</div>
						<div class="comment depth-1 media">
							<img src="../static/images/defaultImages/pintor.png" alt="" class="avatar pull-left">
							<div class="media-body">
								<p class="font-large">Preguntado por Daniel</p>
								<p class="font-large">¿Trabajan en provincia?</p>
							</div>
						</div>
	
						<div class="comment depth-2 media">
							<img src="../static/images/defaultImages/electricista.png" alt="" class="avatar pull-left">
							<div class="media-body">
								<p class="font-large">Pues claro!</p>
							</div>
						</div>
						<div class="space10">&nbsp;</div>
						<div class="comment depth-1 media">
							<img src="../static/images/defaultImages/pintor.png" alt="" class="avatar pull-left">
							<div class="media-body">
								<p class="font-large">Preguntado por Daniel</p>
								<p class="font-large">¿Trabajan en provincia?</p>
							</div>
						</div>
	
						<div class="comment depth-2 media">
							<img src="../static/images/defaultImages/electricista.png" alt="" class="avatar pull-left">
							<div class="media-body">
								<p class="font-large">Pues claro!</p>
							</div>
						</div>
					</div>						
				</div>
								
			</div>

		</div> 
	</div> 
-->
	<%@ include file="../partials/footer.jsp"%>
</body>

<%@ include file="../partials/scripts.jsp"%>
<script src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.3/fotorama.js"></script> <!-- 16 KB -->

</html>