<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html data-ng-app="myRecommendedApp">
<head>
	<%@ include file="../partials/styles.jsp"%>
	<title>Mis Recomendados</title>
	<link  href="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.3/fotorama.css" rel="stylesheet"> <!-- 3 KB -->
</head>
<body data-ng-controller="recommendedDetailController">
	<%@ include file="../partials/header.jsp"%>
	
	<div class="container">
		<div id="content">
			<div class="row">
				<div class="col-sm-9">
					<div class="row">
						<div class="col-sm-4">
							<img data-ng-src="{{recommended.categories[0].image}}" />
						</div>
						<div class="col-sm-8 single-item-main">
							<div class="single-item-body">
								<p class="single-item-title" data-ng-bind="recommended.name"></p>
							</div>

							<div class="woocommerce-product-rating" >
								<div class="star-rating" title="Rated 4.00 out of 5"> 
									<span style="width:80%"> <strong itemprop="ratingValue" class="rating">4.00</strong> out of 5 </span>
								</div> 
								<span class="color-gray">(14)</span>
							</div>

							<div class="clearfix"></div>
							<div class="space20">&nbsp;</div>

							<div class="single-item-desc">
								<p data-ng-bind="recommended.description"></p>
							</div>
							<div class="space20">&nbsp;</div>
						</div>
					</div>
					<div class="space40">&nbsp;</div>
					<div class="widget">
						<h5 class="widget-title">Categor�as</h5>
						<div class="widget-body">
							<div class="beta-tags">
								<a href="blog_with_2sidebars_type_e.html" data-ng-repeat="category in recommended.categories">
									<span data-ng-bind="category.name"></span>
									<img class="rowBadge" data-ng-src="{{category.image}}"/>
								</a>
							</div>
						</div>
					</div> <!-- tags cloud widget -->
					<div class="space40">&nbsp;</div>
					<div class="photoGallery">
						<h5 class="widget-title">Fotos de algunos trabajos</h5>
						<a class="fancybox" href="../../static/images/electricista.jpg" data-fancybox-group="gallery"><img src="../../static/images/electricista.jpg" alt="" /></a>
						<a class="fancybox" href="../../static/images/pintor.jpg" data-fancybox-group="gallery"><img src="../../static/images/pintor.jpg" alt="" /></a>
						<a class="fancybox" href="../../static/images/gasista.jpg" data-fancybox-group="gallery"><img src="../../static/images/gasista.jpg" alt="" /></a>
					</div>
					<div class="space40">&nbsp;</div>
					<div class="reviews">
						<h5>Reviews</h5>
								<div class="col-md-8 col-md-offset-2 reviewRow" style="padding-top: 20px;">
									<div class="col-md-2">
										<img class="rowThumbnail" src="../../static/images/carl.jpg" style="border-radius: 100%;"/>
									</div>
									<div class="col-md-10">
										<p style="font-style: italic"><strong>Gasista profesional, el mejor</strong></p>
										<p style="color: #0077ea">Puntaje: 95%</p>
									</div>
								</div>
								<div class="col-md-8 col-md-offset-2 reviewRow" style="padding-top: 20px;">
									<div class="col-md-2">
										<img class="rowThumbnail" src="../../static/images/carl.jpg" style="border-radius: 100%;"/>
									</div>
									<div class="col-md-10">
										<p style="font-style: italic"><strong>Gasista profesional, el mejor</strong></p>
										<p style="color: #0077ea">Puntaje: 95%</p>
									</div>
								</div>
								<div class="col-md-8 col-md-offset-2 reviewRow" style="padding-top: 20px;">
									<div class="col-md-2">
										<img class="rowThumbnail" src="../../static/images/carl.jpg" style="border-radius: 100%;"/>
									</div>
									<div class="col-md-10">
										<p style="font-style: italic"><strong>Gasista profesional, el mejor</strong></p>
										<p style="color: #0077ea">Puntaje: 95%</p>
									</div>
								</div>
					</div>
					<br/>
					<div class="space20">&nbsp;</div>

					<h5>Preguntas</h5>
					<div class="space10">&nbsp;</div>
					<div class="comment depth-1 media">
						<img src="../../static/images/defaultImages/pintor.png" alt="" class="avatar pull-left">
						<div class="media-body">
							<p class="font-large">Preguntado por Daniel</p>
							<p class="font-large">�Trabajan en provincia?</p>
						</div>
					</div>

					<div class="comment depth-2 media">
						<img src="../../static/images/defaultImages/electricista.png" alt="" class="avatar pull-left">
						<div class="media-body">
							<p class="font-large">Pues claro!</p>
						</div>
					</div>
					<div class="space50">&nbsp;</div>
					<div class="beta-products-list">
						<h4>Otros recomendados parecidos</h4>
					<div class="space40">&nbsp;</div>
						<div class="row">
							<div class="col-sm-4">
								<div class="single-item">
									<div class="single-item-header">
										<a href="product.html"><img src="../../static/images/defaultImages/constructor.png" alt=""></a>
									</div>
									<div class="single-item-body">
										<p class="single-item-title">John Constructor</p>
									</div>
									<div class="single-item-caption">
										<a class="add-to-cart pull-left" href="shopping_cart.html"><i class="fa fa-arrow-right"></i></a>
										<a class="beta-btn primary" href="product.html">Conocelo! </i></a>
										<div class="clearfix"></div>
									</div>
								</div>
							</div>
							<div class="col-sm-4">
								<div class="single-item">
									<div class="single-item-header">
										<a href="product.html"><img src="../../static/images/defaultImages/constructor.png" alt=""></a>
									</div>
									<div class="single-item-body">
										<p class="single-item-title">John Constructor</p>
									</div>
									<div class="single-item-caption">
										<a class="add-to-cart pull-left" href="shopping_cart.html"><i class="fa fa-arrow-right"></i></a>
										<a class="beta-btn primary" href="product.html">Conocelo! </i></a>
										<div class="clearfix"></div>
									</div>
								</div>
							</div>
						</div>
					</div> <!-- .beta-products-list -->
				</div>
				<div class="col-sm-3 aside">
					<div class="widget">
						<h3 class="widget-title">Los m�s recomendados</h3>
						<div class="widget-body">
							<div class="beta-sales beta-lists side-recommended">
								<div class="media beta-sales-item">
									<a class="pull-left" href="product.html"><img src="../../static/images/defaultImages/constructor.png" alt=""></a>
									<div class="media-body">
										Bob, un constructor
									</div>
								</div>
								<div class="media beta-sales-item">
									<a class="pull-left" href="product.html"><img src="../../static/images/defaultImages/constructor.png" alt=""></a>
									<div class="media-body">
										Bob, un constructor
									</div>
								</div>
								<div class="media beta-sales-item">
									<a class="pull-left" href="product.html"><img src="../../static/images/defaultImages/constructor.png" alt=""></a>
									<div class="media-body">
										Bob, un constructor
									</div>
								</div>
								<div class="media beta-sales-item">
									<a class="pull-left" href="product.html"><img src="../../static/images/defaultImages/constructor.png" alt=""></a>
									<div class="media-body">
										Bob, un constructor
									</div>
								</div>
							</div>
						</div>
					</div> <!-- best sellers widget -->
				</div>
			</div>
		</div> <!-- #content -->
	</div> <!-- .container -->

	<%@ include file="../partials/footer.jsp"%>
</body>

<%@ include file="../partials/scripts.jsp"%>
<script src="http://cdnjs.cloudflare.com/ajax/libs/fotorama/4.6.3/fotorama.js"></script> <!-- 16 KB -->
<script>
	var recommended = <%= request.getAttribute("recommended") %>;
	var myRecommendedApp = angular.module('myRecommendedApp', ['ui.bootstrap']);
</script>
<script type="text/javascript" src="<%=scriptPageContext%>/static/scripts/recommended/recommendedDetailController.js"></script>

<%@ include file="../partials/footerScritps.jsp" %>
</html>