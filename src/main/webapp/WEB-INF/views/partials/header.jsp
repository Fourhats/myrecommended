<% String headerPageContext = request.getContextPath(); %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="mainProgressBar" class="progress spinner-red" style="position: fixed; z-index: 9999; top: -8px;">
  	<div class="indeterminate"></div>
</div>

<header data-ng-controller="headerController">
	<!-- <div class="container">
		<a href="#" data-activates="nav-mobile" class="button-collapse top-nav waves-effect waves-light circle hide-on-large-only">
			<i class="mdi-navigation-menu"></i>
		</a>
	</div>
	<ul id="nav-mobile" class="side-nav fixed">
		<li class="logo"><a href="javascript:redirect('home');" style="display: inline;"><img src="<%=headerPageContext%>/static/img/logo.png" /></a></li>
		<li style="margin-bottom: 20px;">
			<div class="input-field col s6">
				<input id="searchKey" data-ng-model="recommendedKey" type="text" class="validate"> 
				<label for="searchKey">Busca tu recomendado</label>
			</div>
			<div class="col s12">
				<select>
					<option value="" selected>Ubicación</option>
					<option value="1">Caballito</option>
					<option value="2">Flores</option>
					<option value="3">Belgrano</option>
				</select>
			</div>
			<div class="col s12">
				<select>
					<option value="" disabled selected>Especialidad</option>
					<option value="1">Electricista</option>
					<option value="2">Gasista</option>
					<option value="3">Plomero</option>
				</select>
			</div>
			<button class="btn-large waves-effect waves-light" 
				data-ng-disabled="!recommendedKey"
				data-ng-click="searchRecommended()">
				Buscar
			</button>
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
				<strong><sec:authentication property="principal.fullName" /></strong>!
				<a href="<%=headerPageContext%>/perfil" >
					Ver Perfíl 
				</a> 
				<a href='<c:url value="javascript:redirect(\"j_spring_security_logout\")" />'>
					Salir 
				</a>
			</li>
		</sec:authorize>
	</ul>-->
	  <nav class="transparentBackground" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo"><a href="javascript:redirect('home');" style="display: inline;"><img src="<%=headerPageContext%>/static/img/logo.png" /></a></a>
      <ul class="right hide-on-med-and-down">
		<sec:authorize access="!isAuthenticated()">
			<li>
				<a class="modal-trigger" href="#login">
					Ingresa
				</a>
			</li>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<ul id="dropdown1" class="dropdown-content">
			  <li><a href="<%=headerPageContext%>/perfil" >Mi Perfíl</a></li>
			  <li><a href='<c:url value="javascript:redirect(\"j_spring_security_logout\")" />'>Salir</a></li>
			</ul>
			<li ><a class="dropdown-button" href="#!" data-activates="dropdown1">Bienvenido <strong><sec:authentication property="principal.fullName" /></strong>!</a></li>
		</sec:authorize>
        <li><a href="#">Ayuda</a></li>
      </ul>

      <ul id="nav-mobile" class="side-nav">
        <li><a href="#">Navbar Link</a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
  </nav>
</header>

<div id="login" class="modal" style="text-align: center;" data-ng-controller="loginController">
	<div class="col m12">
		<h1 class="header center-on-small-only">Inicia sesión</h1>
	</div>
	<div class="modal-content" style="margin-left: auto; margin-right: auto;">
		<div id="loginForm">	
			<form name="loginForm" data-ng-submit="login()" >
				<div class="input-field col s6">
					<input id="usuario" type="text" required maxlength="100" data-ng-model="user.email">
					<label for="usuario">Usuario</label>
				</div>
				<div class="input-field col s6">
					<input id="contrasena" type="password" required maxlength="100" data-ng-model="user.password">
					<label for="contrasena">Contraseña</label>
				</div>
				<div class="row">
					<div class="col s6">
						<button class="btn-large waves-effect waves-light modalButton" data-ng-disabled="loginForm.$invalid" type="submit">Inicia sesión</button>
					</div>
					<div class="col s6">
						<button class="btn-large waves-effect waves-light blue darken-1 modalButton" type="button" data-ng-click="facebookLogin()">Inicia con <br>Facebook</button>
					</div>
				</div>
			</form>
			
			¿No tenés una cuenta?
			<br>
			<button id="register" class="btn-large waves-effect waves-light blue darken-1">Registrate</button>
		</div>
		<div id="registerForm">	
			<div class="col m12 ng-hide" data-ng-show="error != undefined">
		    	<strong>Ups!</strong> <span data-ng-bind="error"></span>.
		    </div>
			<form class="contact-form" data-ng-submit="registerUser()" name="registrationForm">
				<div class="row">
					<div class="col m12">
						<div class="input-field">
							<input name="name" required maxlength="50" placeholder="Nombre" type="text" tabindex="4" data-ng-model="newUser.name"/>
							<label class="ng-hide" for="name" data-ng-show="registrationForm.name.$dirty && registrationForm.name.$invalid">
								<span data-ng-show="registrationForm.name.$error.required">Debe ingresar su nombre</span>
								<span data-ng-show="registrationForm.name.$error.maxlength">Supera la cantidad maxima de caracteres</span>
							</label>
						</div>	
					</div>
					<div class="col m12">
						<div class="input-field">
							<input name="surname" required maxlength="50" placeholder="Apellido" type="text" tabindex="5" data-ng-model="newUser.surname"/>
							<label class="ng-hide" for="surname" data-ng-show="registrationForm.surname.$dirty && registrationForm.surname.$invalid">
								<span data-ng-show="registrationForm.surname.$error.required">Debe ingresar su apellido</span>
								<span data-ng-show="registrationForm.surname.$error.maxlength">Supera la cantidad maxima de caracteres</span>
							</label>
						</div>
					</div>
					<div class="col m12">
						<div class="input-field">
							<input name="username" required maxlength="20" placeholder="Nombre de usuario" type="text" tabindex="6" data-ng-model="newUser.username"/>
							<label class="ng-hide" for="username" data-ng-show="registrationForm.username.$dirty && registrationForm.username.$invalid">
								<span data-ng-show="registrationForm.username.$error.required">Debe ingresar su nombre de usuario</span>
								<span data-ng-show="registrationForm.username.$error.maxlength">Supera la cantidad maxima de caracteres</span>
							</label>
						</div>
					</div>
					<div class="col m12">
						<div class="input-field">
							<input name="email" required maxlength="50" placeholder="Mail" type="email" tabindex="7" data-ng-model="newUser.email"/>
							<label class="ng-hide" for="email" data-ng-show="registrationForm.email.$dirty && registrationForm.email.$invalid">
								<span data-ng-show="registrationForm.email.$error.required">Debe ingresar su e-mail</span>
								<span data-ng-show="registrationForm.email.$error.email">Debe ingresar un e-mail valido</span>
								<span data-ng-show="registrationForm.email.$error.maxlength">Supera la cantidad maxima de caracteres</span>
							</label>
						</div>
						
					</div>
					<div class="col m12">
						<div class="input-field">
							<input name="password" required maxlength="50" data-ng-minlength="5" placeholder="Contraseña" type="password" tabindex="8" data-ng-model="newUser.password"/>
							<label class="ng-hide" for="password" data-ng-show="registrationForm.password.$dirty && registrationForm.password.$invalid">
								<span data-ng-show="registrationForm.password.$error.required">Debe ingresar su contraseña</span>
								<span data-ng-show="registrationForm.password.$error.maxlength">Supera la cantidad maxima de caracteres</span>
								<span data-ng-show="registrationForm.password.$error.minlength">Debe tener mas de 5 caracteres</span>
							</label>
						</div>
					</div>
					
					<div class="col m12">
						<button type="submit" class="btn-large waves-effect waves-light blue darken-1" data-ng-disabled="registrationForm.$invalid" tabindex="9">
							Registrar 
						</button>
						<br>
						<span style="cursor: pointer; color: #26a69a" id="backRegister">Volver</span>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>