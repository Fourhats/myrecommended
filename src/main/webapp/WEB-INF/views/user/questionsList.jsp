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
				<h3>Preguntas</h3>
				<div class="row">
					<div class="questionBlock">
						<span class="questiontitle">NombreTareaAsociada</span>
						<div class="space10">&nbsp;</div>
						<div class="comment depth-1 media">
							<img src="../static/images/defaultImages/pintor.png" alt="" class="avatar pull-left">
							<div class="media-body">
								<p class="font-large">Preguntado por Daniel</p>
								<p class="font-large">풲rabajan en provincia?</p>
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
								<p class="font-large">풲rabajan en provincia?</p>
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
								<p class="font-large">풲rabajan en provincia?</p>
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
								<p class="font-large">풲rabajan en provincia?</p>
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

		</div> <!-- #content -->
	</div> <!-- .container -->

	<%@ include file="../partials/footer.jsp"%>
</body>

<%@ include file="../partials/scripts.jsp"%>
<script src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.3/fotorama.js"></script> <!-- 16 KB -->

</html>