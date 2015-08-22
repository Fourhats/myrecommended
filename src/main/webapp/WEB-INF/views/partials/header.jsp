<% String headerPageContext = request.getContextPath(); %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header data-ng-controller="headerController">
	<div class="container">
		<a href="#" data-activates="nav-mobile" class="button-collapse top-nav waves-effect waves-light circle hide-on-large-only">
			<i class="mdi-navigation-menu"></i>
		</a>
	</div>
	<ul id="nav-mobile" class="side-nav fixed">
		<li class="logo"><a href="/MyRecommended" style="display: inline;"><img src="<%=headerPageContext%>/static/img/logo.png" /></a></li>
		<li style="margin-bottom: 20px;">
			<div class="input-field col s6">
				<input id="searchKey" data-ng-model="recommendedKey" type="text" class="validate"> 
				<label for="searchKey">Busca tu recomendado</label>
			</div>
			<div class="input-field col s12">
				<select>
					<option value="" disabled selected>Ubicación</option>
					<option value="1">Caballito</option>
					<option value="2">Flores</option>
					<option value="3">Belgrano</option>
				</select>
			</div>
			<div class="input-field col s12">
				<select>
					<option value="" disabled selected>Especialidad</option>
					<option value="1">Electricista</option>
					<option value="2">Gasista</option>
					<option value="3">Plomero</option>
				</select>
			</div>
			<button class="btn-large waves-effect waves-light" data-ng-click="searchRecommended()">Buscar</button>
		</li>
		<sec:authorize access="!isAuthenticated()">
			<li class="menuLink">
				<a class="modal-trigger" href="#login">
					Iniciar Sesión
				</a>
			</li>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<li class="menuLink">Bienvenido 
				<strong> <sec:authentication property="principal.fullName" /> </strong>! 
				<a href='<c:url value="javascript:redirect(\"j_spring_security_logout\")" />'>
					Logout 
				</a>
			</li>
		</sec:authorize>
	</ul>
</header>

<div id="login" class="modal" style="text-align: center;">
	<div class="modal-content" style="margin-left: auto; margin-right: auto;">
		<h4>Inicia Sesión / Registrate</h4>
		<div class="input-field col s6">
			<input id="usuario" type="text" class="validate">
			<label for="usuario">Usuario</label>
		</div>
		<div class="input-field col s6">
			<input id="contrasena" type="text" class="validate"> 
			<label for="contrasena">Contraseña</label>
		</div>
		<button class="btn-large waves-effect waves-light">
			Registrate / Inicia
		</button>
		<br>
		<br>o<br>
		<br>
		<button class="btn-large waves-effect waves-light blue darken-1"
			data-ng-click="facebookLogin()">Iniciar sesión con Facebook</button>
	</div>
</div>