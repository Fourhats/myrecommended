<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html data-ng-app="myRecommendedApp">
<head>
	<%@ include file="../partials/styles.jsp"%>
	<title>Mis Recomendados</title>
</head>

<body data-ng-controller="recommendedGalleryController">
	<%@ include file="../partials/header.jsp"%>

	<!-- <span us-spinner="{radius:30, width:8, length: 16}" style="position: absolute;top: 50%;left: 50%;"></span> -->

<main>
	<div class="section no-pad-bot" id="index-banners">
		<div class="container">
			<h4>Resultados</h4>
			
			<div class="row listRow z-depth-1">
									<div class="col s2">
										<img class="rowThumbnail" src="static/img/defaultImages/electricista.png" alt="" src="static/img/defaultImages/electricista.png">
									</div>
									<div class="col s6" >
										<h4 style="font-weight: 100;" data-ng-bind="recommended.name" class="ng-binding">Vendedor test</h4>
										<p>Zonas de trabajo: Palermo, Recoleta, Caballito</p>
									</div>
									<div class="col s2">
										<div class="rating">
											<span>&#9733;</span><span>&#9733;</span><span>&#9733;</span><span>&#9733;</span><span>&#9733;</span><br>
											(15 reviews positivos)
										</div>
									</div>
									<div class="col s2" style="  padding-top: 20px;">
									<img class="rowBadge" src="static/img/badges/constructor.png" title="Constructor">
									<img class="rowBadge" src="static/img/badges/electricista.png" title="Electricista">
									<img class="rowBadge" src="static/img/badges/gasista.png" title="Gasista">
									<img class="rowBadge" src="static/img/badges/jardinero.png" title="Jardinero">
									<img class="rowBadge" src="static/img/badges/pintor.png" title="Pintor">
									</div>
		</div>
		
			<div class="row listRow z-depth-1">
									<div class="col s2">
										<img class="rowThumbnail" src="static/img/defaultImages/gasista.png" alt="" src="static/img/defaultImages/electricista.png">
									</div>
									<div class="col s6" >
										<h4 style="font-weight: 100;" data-ng-bind="recommended.name" class="ng-binding">Vendedor test</h4>
										<p>Zonas de trabajo: Palermo, Recoleta, Caballito</p>
									</div>
									<div class="col s2">
										<div class="rating">
											<span>&#9733;</span><span>&#9733;</span><span>&#9733;</span><span>&#9733;</span><span>&#9733;</span><br>
											(15 reviews positivos)
										</div>
									</div>
									<div class="col s2" style="  padding-top: 20px;">
									<img class="rowBadge" src="static/img/badges/constructor.png" title="Constructor">
									<img class="rowBadge" src="static/img/badges/electricista.png" title="Electricista">
									<img class="rowBadge" src="static/img/badges/gasista.png" title="Gasista">
									<img class="rowBadge" src="static/img/badges/jardinero.png" title="Jardinero">
									<img class="rowBadge" src="static/img/badges/pintor.png" title="Pintor">
									</div>
		</div>
		
			<div class="row listRow z-depth-1">
									<div class="col s2">
										<img class="rowThumbnail" src="static/img/defaultImages/jardinero.png" alt="" src="static/img/defaultImages/electricista.png">
									</div>
									<div class="col s6" >
										<h4 style="font-weight: 100;" data-ng-bind="recommended.name" class="ng-binding">Vendedor test</h4>
										<p>Zonas de trabajo: Palermo, Recoleta, Caballito</p>
									</div>
									<div class="col s2">
										<div class="rating">
											<span>&#9733;</span><span>&#9733;</span><span>&#9733;</span><span>&#9733;</span><span>&#9733;</span><br>
											(15 reviews positivos)
										</div>
									</div>
									<div class="col s2" style="  padding-top: 20px;">
									<img class="rowBadge" src="static/img/badges/constructor.png" title="Constructor">
									<img class="rowBadge" src="static/img/badges/electricista.png" title="Electricista">
									<img class="rowBadge" src="static/img/badges/gasista.png" title="Gasista">
									<img class="rowBadge" src="static/img/badges/jardinero.png" title="Jardinero">
									<img class="rowBadge" src="static/img/badges/pintor.png" title="Pintor">
									</div>
		</div>
		
		
		 <ul class="pagination">
	    <li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
	    <li class="active"><a href="#!">1</a></li>
	    <li class="waves-effect"><a href="#!">2</a></li>
	    <li class="waves-effect"><a href="#!">3</a></li>
	    <li class="waves-effect"><a href="#!">4</a></li>
	    <li class="waves-effect"><a href="#!">5</a></li>
	    <li class="waves-effect"><a href="#!"><i class="material-icons">chevron_right</i></a></li>
	  </ul>
	
		</div>
	</div>



</main>
<!-- 
	<div class="container">
		<div id="content">
			<div class="row">
				<div class="col-sm-9 main-content pull-right">
					<div class="space10">&nbsp;</div>
					<div class="beta-promobox">
						<h2 class="pull-left "><span class="white">Recomendados</span> ¡Conocelos y contratalos vos también!</h2>
						<div class="clearfix"></div>
					</div> 
					
					<div class="space50">&nbsp;</div>
					<div class="beta-products-list">
						<h4>Nuevos recomendados</h4>
						<div class="beta-products-details">
							<p class="pull-left"><span data-ng-bind="recommendedPage.totalItems"></span> recomendados encontrados | <a href="#">Ver todos</a></p>
							<p class="pull-right">
								<span class="sort-by">Ordenar por</span>
								<select name="sortproducts" class="beta-select-primary">
									<option value="desc">Últimos agregados</option>
									<option value="popular">Populares</option>
									<option value="rating">Calificaciones</option>
									<option value="best">Cantidad de trabajos realizados</option>
								</select>
							</p>
							<div class="clearfix"></div>
						</div>
						
						<div data-ng-repeat="recommended in recommendedPage.elements">
							<div class="row listRow">
								<div class="col-md-2">
									<img class="rowThumbnail" data-ng-src="{{recommended.categories[0].image}}" alt="" />
								</div>
								<div class="col-md-6" style="padding-top: 20px;">
									<h4 data-ng-bind="recommended.name" data-ng-click="goToRecommendedDetail(recommended)"></h4>
									<p>Zonas de trabajo: Palermo, Recoleta, Caballito</p>
								</div>
								<div class="col-md-2">
									<div class="rating">
										<span>&#9733;</span><span>&#9733;</span><span>&#9733;</span><span>&#9733;</span><span>&#9733;</span>
										<br>
										(15 reviews positivos)
									</div>
								</div>
								<div class="col-md-2" style="padding-top: 20px;">
									<img class="rowBadge" 
										data-ng-repeat="category in recommended.categories" 
										data-ng-src="{{category.image}}" 
										data-ng-attr-title="{{category.name}}"/>
								</div>
							</div>
						</div>
					</div>
					<div class="space50">&nbsp;</div>
					
				</div>

				<div class="col-sm-3 aside">
					<div class="widget">
						<h3 class="widget-title">Tipos de recomendados</h3>
						<div class="widget-body">
							<ul class="list-unstyled">
								<li data-ng-repeat="category in categories">
									<input type="checkbox" data-ng-checked="selectedCategories.indexOf(category.id) > -1" data-ng-click="toggleCategorySelection(category.id)" id="category-{{category.name}}" value="{{category.id}}">
									<label for="category-{{category.name}}"><span></span><span data-ng-bind="category.name"></span></label>
								</li>
							</ul>
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
<script src="<%=scriptPageContext%>/static/js/spin.min.js"></script>
<script src="<%=scriptPageContext%>/static/js/angularjs/angular-spinner.js"></script>

<script>
	var recommendedPage = <%= request.getAttribute("recommendedPage") %>;
	var categories = <%= request.getAttribute("categories") %>;
	var myRecommendedApp = angular.module('myRecommendedApp', ['ui.bootstrap', 'ngLoadingSpinner']);
</script>
<script type="text/javascript" src="<%=scriptPageContext%>/static/scripts/recommended/recommendedGalleryController.js"></script>

<%@ include file="../partials/footerScritps.jsp" %>
</html>