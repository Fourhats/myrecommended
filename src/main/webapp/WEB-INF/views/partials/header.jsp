<% String headerPageContext = request.getContextPath(); %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="header" data-ng-controller="headerController">
	<div class="header-bottom">
		<div class="container">
			<a class="visible-xs beta-menu-toggle pull-right" href="#"><span class='beta-menu-toggle-text'>Menu</span> <i class="fa fa-bars"></i></a>
			<div class="visible-xs clearfix"></div>
			<a href="/MyRecommended"><span class="logoHeaderText">MisRecomendados.Com</span></a>
			<nav class="main-menu">
				<ul class="l-inline ov">
					<li><a href="javascript: redirect('pedilo');"><i class="fa fa-flag-o faHeader"></i>Pedir un trabajo</a></li>
					<li><a href="#"><i class="fa fa-pencil faHeader"></i>Registrarse como proveedor</a></li>
					<li>
						<input class="searchInput" placeholder="¡Busca tu recomendado!" data-ng-model="recommendedKey"/>
						<i style="margin-left: 2px;" class="fa fa-search faHeader" data-ng-click="searchRecommended()"></i>
					</li>
					<sec:authorize access="!isAuthenticated()">
						<li><a href="javascript: redirect('registracion');"><i class="fa fa-sign-in faHeader"></i>Login</a></li>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						<li>
							Bienvenido <strong><sec:authentication property="principal.fullName" /></strong>!
			        		<a href='<c:url value="javascript:redirect(\"j_spring_security_logout\")" />'>
				        		Logout
				        	</a>
		    	    	</li>
					</sec:authorize>
				</ul>
				<div class="clearfix"></div>
			</nav>
		</div> <!-- .container -->
	</div> <!-- .header-bottom -->
</div>