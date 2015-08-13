<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html data-ng-app="myRecommendedApp">
<head>
	<%@ include file="partials/styles.jsp"%>
	<title>Mis Recomendados</title>
</head>
<body>
	<%@ include file="partials/header.jsp"%>

	<section>
		<div class="homeHero">
			<div class="col-sm-10 .col-md-offset-4" style="margin-left: 10%;">
				<div class="col-lg-6 textContent">
					<span class="heroTitle">Recomendados</span>
					<p>La mejor manera de contratar servicios y recomendarlos ;)</p>
					<br />
					<button type="submit" class="beta-btn beta-btn-3d beta-btn-dodger beta-btn-small" data-ng-disabled="loginForm.$invalid" tabindex="3">
						Busca un recomendado
					</button>
				</div>
				<div class="col-lg-6 imgContent">
					<img src="static/images/carl.jpg"/>
					<span>Jose</span>
					<span>Arquitecto de Mis Recomendados</span>
				</div>
			</div>
		</div>
		<div class="main-content builderContact">
			¿Queres ofercer tus servicios? <a href="#">¡Contactanos!</a>
		</div>
		<div class="container">
			<div id="content" class="space-top-none space-bottom-none">
				<!-- .main-content -->
			</div>
			<!-- #content -->
		</div>
		<!-- .container -->
		<div class="clear"></div>
		<div class="abs-fullwidth bg-gray">
			<div class="space70">&nbsp;</div>
			<div class="container">
				<div class="row">
					<div class="col-sm-4 wow flipInY">
						<div class="media icon-box icon-box-b">
							<div class="pull-left">
								<i class="fa fa-users"></i>
							</div>
							<div class="media-body">
								<h5>Miles de proveedores</h5>
								<p>Para resolver todo lo que necesites en tu hogar u oficina</p>
							</div>
						</div>
					</div>
					<div class="col-sm-4 wow flipInY">
						<div class="media icon-box icon-box-b">
							<div class="pull-left">
								<i class="fa fa-refresh"></i>
							</div>
							<div class="media-body">
								<h5>Revisados por clientes</h5>
								<p>Para tu seguridad y tranquilidad</p>
							</div>
						</div>
					</div>
					<div class="col-sm-4 wow flipInY">
						<div class="media icon-box icon-box-b">
							<div class="pull-left">
								<i class="fa fa-map-marker"></i>
							</div>
							<div class="media-body">
								<h5>En toda Ciudad y Gran Buenos Aires</h5>
								<p>Cubrimos todo el espacio</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="space60">&nbsp;</div>
		</div>

		<div class="space50">&nbsp;</div>
		<div class="container">
			<h2 class="text-center wow fadeInDown">
				Algunos de los trabajos realizados recientemente
			</h2>
		</div>
		<div class="space30">&nbsp;</div>

		<div class="abs-fullwidth">
			<div class="portfolio-filters">
				<div class="beta-filter-container2">
					<div class="portfolioitems-holder">
						<ul id="portfolioitems"
							class="isotope beta-filter-body four_up tiles latest-works">
							<li class="isotope-item web">
								<a href="single_type_image.html" class="beta-block">
									<div class="beta-block-over over-a">
										<div class="over-details">
											<h5 class="over-title">Pintura en habitación</h5>
											<p class="over-date">25 de Diciembre 2014</p>
										</div>
										<span class="over-more"><i class="fa fa-plus"></i></span>
									</div> 
									<img class="over-img-active" src="static/images/pintor.jpg" alt="">
								</a>
							</li>
							<li class="isotope-item photography web">
								<a href="single_type_image.html" class="beta-block">
									<div class="beta-block-over over-a">
										<div class="over-details">
											<h5 class="over-title">Reparación de fuga</h5>
											<p class="over-date">14 de Enero 2015</p>
										</div>
										<span class="over-more"><i class="fa fa-plus"></i></span>
									</div>
									<img class="over-img-active" src="static/images/gasista.jpg" alt="">
								</a>
							</li>
							<li class="isotope-item photography web illustrations"><a
								href="single_type_image.html" class="beta-block">
									<div class="beta-block-over over-a">
										<div class="over-details">
											<h5 class="over-title">Cortocircuito en tablero de
												edificio</h5>
											<p class="over-date">27 de Enero de 2015</p>
										</div>
										<span class="over-more"><i class="fa fa-plus"></i></span>
									</div> <img class="over-img-active"
									src="static/images/electricista.jpg" alt="">
							</a></li>
							<li class="isotope-item web illustrations"><a
								href="single_type_image.html" class="beta-block">
									<div class="beta-block-over over-a">
										<div class="over-details">
											<h5 class="over-title">Extensión de sala de estar</h5>
											<p class="over-date">14 de febrero de 2015</p>
										</div>
										<span class="over-more"><i class="fa fa-plus"></i></span>
									</div> <img class="over-img-active" src="static/images/albanil.jpg"
									alt="">
							</a></li>
							<li class="isotope-item photography illustrations"><a
								href="single_type_image.html" class="beta-block">
									<div class="beta-block-over over-a">
										<div class="over-details">
											<h5 class="over-title">Preparación de patiog</h5>
											<p class="over-date">29 de Febrero de 2015</p>
										</div>
										<span class="over-more"><i class="fa fa-plus"></i></span>
									</div> <img class="over-img-active" src="static/images/jardinero.jpg"
									alt="">
							</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- end of abs filter -->

		<div class="space80">&nbsp;</div>
		<div class="container">
			<div class="row">
				<div class="col-sm-6 triggerAnimation animated"
					data-animate="fadeInLeft">
					<div class="space30">&nbsp;</div>
					<h2>En Mis Recomendados queremos que elijas y recomiendes a
						los mejores</h2>
					<div class="space15">&nbsp;</div>
					<p>Sabemos muy bien que contratar puede ser un dolor de cabeza
						. . . . .</p>
					<p>Por eso creamos Mis Recomendados, para que . . . . .</p>
					<div class="space20">&nbsp;</div>
					<a href="single_type_gallery.html" class="beta-btn primary">Read
						More <i class="fa fa-chevron-right"></i>
					</a>
				</div>
				<div class="col-sm-6 triggerAnimation animated"
					data-animate="fadeInRight">
					<div class="space10">&nbsp;</div>
					<img src="static/images/helmet.png" alt="">
				</div>
			</div>
		</div>
		<div class="abs-fullwidth">
			<hr>
		</div>
		<div class="clear"></div>
		<div class="space70">&nbsp;</div>
		<div class="container">
			<h2 class="text-center wow fadeInDown">Algunos comentarios de
				nuestros usuarios</h2>
			<div class="space20">&nbsp;</div>
			<div class="beta-slider beta-slides-quote">
				<div class="beta-slider-items">
					<div class="beta-slider-item">
						<div class="text-center col-sm-6 col-sm-push-3">
							<p class="beta-circle mb25">
								<i class="fa fa-quote-left"></i>
							</p>
							<p>El sistema de recomendaciones y ratings me permitió llegar
								a un electricista genial, prolijo y rápido como ninguno que
								conocí</p>
							<h5>Pedro Alessandri</h5>
						</div>
					</div>
					<div class="beta-slider-item">
						<div class="text-center col-sm-6 col-sm-push-3">
							<p class="beta-circle mb25">
								<i class="fa fa-quote-left"></i>
							</p>
							<p>Increíble todo, me barrieron y pasaron el trapo después de
								pintar!!!</p>
							<h5>Daniel Orozco</h5>
						</div>
					</div>
				</div>

				<a href="#" class="beta-arrow-left"><i
					class="fa fa-chevron-left"></i></a> <a href="#"
					class="beta-arrow-right"><i class="fa fa-chevron-right"></i></a>
			</div>
		</div>
		<div class="space70">&nbsp;</div>

	</section>
	<%@ include file="partials/footer.jsp"%>
</body>
<%@ include file="partials/scripts.jsp"%>
<script>
	var myRecommendedApp = angular.module('myRecommendedApp', ['ui.bootstrap']);
</script>
<%@ include file="partials/footerScritps.jsp" %>
</html>