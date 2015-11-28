<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html data-ng-app="myRecommendedApp">
<head>
	<%@ include file="../partials/styles.jsp"%>
</head>

<body class="blackMenu" data-ng-controller="recommendedGalleryController">
	<%@ include file="../partials/header.jsp"%>
	<main>	
		<div class="section no-pad-bot" id="index-banners">
			<div class="container">
				<div class="row">
					<div class="col m12" style="margin-bottom: 20px;">
						<h1 class="header center-on-small-only">Recomendados</h1>
					</div>
				</div>
				<div class="row">
					<div class="col l3 m12 s12 center">
						<div class="input-field col s12">
							<input id="searchKey" data-ng-model="recommendedKey" type="text" class="validate" style="color:black;"> 
							<label for="searchKey">Busca tu recomendado</label>
						</div>
						<div class="col s12">
							<select 
								data-ng-model="selectedCategory" 
								data-ng-options="category.name for category in categories">
						     		<option value="" disabled selected>Especialidad</option>
						    </select>
						</div>
						<button class="btn-large waves-effect waves-light" data-ng-click="searchRecommended()">
							Buscar
						</button>
					</div>
					<div class="col l9 m12 s12">
						<div style="cursor: hand;" class="row listRow z-depth-1"
							data-ng-repeat="recommended in recommendedPage.elements" data-ng-click="goToRecommendedDetail(recommended)"
									class="ng-binding">
							<div class="col l2 m2 s12">
								<img class="rowThumbnail" data-ng-src="{{recommended.avatarPath}}">
							</div>
							<div class="col l6 m6 s12">
								<h4 style="font-weight: 100;" data-ng-bind="recommended.name"
									></h4>
								<p>Zonas de trabajo: Palermo, Recoleta, Caballito</p>
							</div>
							<div class="col l2 m2 s12">
								<!-- <div class="rating">
									<span>&#9733;</span><span>&#9733;</span><span>&#9733;</span><span>&#9733;</span><span>&#9733;</span><br>
									(15 reviews positivos)
								</div>-->
							</div>
							<div class="col l2 m2 l12" style="padding-top: 20px;">
								<img class="rowBadge"
									data-ng-repeat="category in recommended.categories"
									data-ng-src="{{category.image}}"
									data-ng-attr-title="{{category.name}}">
							</div>
						</div>
					</div>
				</div>
				<div class="row" style="text-align: right;">
					<ul class="pagination" style="display: inline-block;">
						<li data-ng-class="{'disabled' : !recommendedPage.hasPreviousPage , 'waves-effect' : recommendedPage.hasPreviousPage}"
							data-ng-click="goToPreviousPage()">
							<a href="#!"><i class="material-icons">chevron_left</i></a>
						</li>
						<li data-ng-repeat="i in getNumber(recommendedPage.pageIndex, recommendedPage.totalPages)" 
							data-ng-class="{'active' : i == recommendedPage.pageIndex, 'waves-effect' : i != recommendedPage.pageIndex}"
							data-ng-click="goToPage(i)" >
							<a data-ng-bind="i"></a>
						</li>
						<li data-ng-class="{'disabled' : !recommendedPage.hasNextPage, 'waves-effect' : recommendedPage.hasNextPage}"
							data-ng-click="goToNextPage()">
							<a href="#!"><i class="material-icons">chevron_right</i></a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</main>
</body>

<%@ include file="../partials/scripts.jsp"%>

<script>
	var recommendedPage = <%=request.getAttribute("recommendedPage")%>;
	var categories = <%=request.getAttribute("categories")%>;
	var categoryId = <%=request.getAttribute("categoryId")%>;
	var recommendedKey = <%=request.getAttribute("recommendedKey")%>;
	
	var myRecommendedApp = angular.module('myRecommendedApp', ['ui.bootstrap', 'angularFileUpload', 'toastr']);
</script>
<script type="text/javascript" src="<%=scriptPageContext%>/static/scripts/recommended/recommendedGalleryController.js"></script>

<%@ include file="../partials/footerScritps.jsp"%>
</html>