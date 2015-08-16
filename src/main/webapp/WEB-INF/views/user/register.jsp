<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html data-ng-app="myRecommendedApp">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Mis Recomendados</title>
	<%@ include file="../partials/styles.jsp" %>
</head>

<body data-ng-controller="registerUserController">
	<%@ include file="../partials/header.jsp"%>
	<div class="container">
		<div id="content" class="space-top-none space-bottom-none">
			<div class="space30">&nbsp;</div>
			<div class="main-content">
				<h1 style="text-align: center;">¡Conectate con Mis Recomendados!</h1>
				<div class="space20">&nbsp;</div>
				<div class="col-lg-4">
					<div class="space20">&nbsp;</div>
					<form class="contact-form" data-ng-submit="login()" name="loginForm">
						<div class="form-block">
							<input class="form-control" required maxlength="100" placeholder="Nombre de usuario" type="text" tabindex="1" data-ng-model="user.email"/>
						</div>
						<div class="form-block">
							<input class="form-control" required maxlength="100" placeholder="Contraseña" type="password" tabindex="1" data-ng-model="user.password"/>
						</div>
						<div class="form-block">
							<button type="submit" class="beta-btn beta-btn-3d beta-btn-dodger beta-btn-small" data-ng-disabled="loginForm.$invalid" tabindex="3">
								Ingresar <i class="fa fa-chevron-right"></i>
							</button>
						</div>
					</form>
				</div>
				<div class="col-lg-4">
					<div class="space20">&nbsp;</div>
					<a href="javascript:void(0)" data-ng-click="facebookLogin()" class="btn btn-block btn-social btn-facebook"> <i style="color: #fff"
						class="fa fa-facebook"></i> Ingresa con Facebook
					</a>
				</div>
				<div class="col-lg-4">
					<div class="space20">&nbsp;</div>
					<div class="alert alert-danger col-lg-offset-2 col-lg-10 ng-hide" data-ng-show="error != undefined">
				    	<strong>Ups!</strong> <span data-ng-bind="error"></span>.
				    </div>
					<form class="contact-form" data-ng-submit="registerUser()" name="registrationForm">
						<div class="form-block">
							<label class="ng-hide" for="name" data-ng-show="registrationForm.name.$dirty && registrationForm.name.$invalid">
								<span data-ng-show="registrationForm.name.$error.required">Debe ingresar su nombre</span>
								<span data-ng-show="registrationForm.name.$error.maxlength">Supera la cantidad maxima de caracteres</span>
							</label>
							<input class="form-control" data-ng-readonly="newUser.signInProvider == 'FACEBOOK'" name="name" required maxlength="100" placeholder="Nombre" type="text" tabindex="4" data-ng-model="newUser.name"/>
						</div>
						<div class="form-block">
							<label class="ng-hide" for="surname" data-ng-show="registrationForm.surname.$dirty && registrationForm.surname.$invalid">
								<span data-ng-show="registrationForm.surname.$error.required">Debe ingresar su apellido</span>
								<span data-ng-show="registrationForm.surname.$error.maxlength">Supera la cantidad maxima de caracteres</span>
							</label>
							<input class="form-control" data-ng-readonly="newUser.signInProvider == 'FACEBOOK'" name="surname" required maxlength="60" placeholder="Apellido" type="text" tabindex="5" data-ng-model="newUser.surname"/>
						</div>
						<div class="form-block">
							<label class="ng-hide" for="username" data-ng-show="registrationForm.username.$dirty && registrationForm.username.$invalid">
								<span data-ng-show="registrationForm.username.$error.required">Debe ingresar su nombre de usuario</span>
								<span data-ng-show="registrationForm.username.$error.maxlength">Supera la cantidad maxima de caracteres</span>
							</label>
							<input class="form-control" data-ng-readonly="newUser.signInProvider == 'FACEBOOK'" name="username" required maxlength="60" placeholder="Nombre de usuario" type="text" tabindex="6" data-ng-model="newUser.username"/>
						</div>
						<div class="form-block">
							<label class="ng-hide" for="email" data-ng-show="registrationForm.email.$dirty && registrationForm.email.$invalid">
								<span data-ng-show="registrationForm.email.$error.required">Debe ingresar su e-mail</span>
								<span data-ng-show="registrationForm.email.$error.email">Debe ingresar un e-mail valido</span>
								<span data-ng-show="registrationForm.email.$error.maxlength">Supera la cantidad maxima de caracteres</span>
							</label>
							<input class="form-control" data-ng-readonly="newUser.signInProvider == 'FACEBOOK'" name="email" required maxlength="100" placeholder="Mail" type="email" tabindex="7" data-ng-model="newUser.email"/>
						</div>
						<div class="form-block">
							<label class="ng-hide" for="password" data-ng-show="registrationForm.password.$dirty && registrationForm.password.$invalid">
								<span data-ng-show="registrationForm.password.$error.required">Debe ingresar su contraseña</span>
								<span data-ng-show="registrationForm.password.$error.maxlength">Supera la cantidad maxima de caracteres</span>
								<span data-ng-show="registrationForm.password.$error.minlength">Debe tener mas de 5 caracteres</span>
							</label>
							<input class="form-control" data-ng-readonly="newUser.signInProvider == 'FACEBOOK'" data-ng-show="newUser.signInProvider != 'FACEBOOK'" name="password" required maxlength="100" data-ng-minlength="5" placeholder="Contraseña" type="password" tabindex="8" data-ng-model="newUser.password"/>
						</div>
						<div>
							<input type="file" nv-file-select="" uploader="uploader"/><br/>
							<div data-ng-repeat="item in uploader.queue">
                                <div data-ng-show="$last">
                                    <strong>{{ item.file.name }}</strong>
                                    <div data-ng-show="uploader.isHTML5" data-ng-thumb="{ file: item._file, height: 100 }"></div>
                                </div>
                            </div>
                            <div data-ng-show="uploader.queue.length == 0">
                                <img data-ng-src="{{defaultAvatarPath}}" style="height: 100px"/>
                            </div>
						</div>
						
						<div class="form-block">
							<button type="submit" class="beta-btn beta-btn-3d beta-btn-dodger beta-btn-small" data-ng-disabled="registrationForm.$invalid" tabindex="9">
								Registrar <i class="fa fa-chevron-right"></i>
							</button>
						</div>
					</form>
				</div>

			</div>
			<!-- .main-content -->
		</div>
		<!-- #content -->
	</div>
	<%@ include file="../partials/footer.jsp"%>
</body>

<%@ include file="../partials/scripts.jsp"%>
<script type="text/javascript" src="<%=scriptPageContext%>/static/js/angularjs/imageUploader/angular-file-upload.min.js"></script>

<script>
	var myRecommendedApp = angular.module('myRecommendedApp', ['ui.bootstrap', 'angularFileUpload']);
</script>

<script type="text/javascript" src="<%=scriptPageContext%>/static/js/angularjs/imageUploader/ngThumbDirective.js"></script>
<script type="text/javascript" src="<%=scriptPageContext%>/static/scripts/login/loginController.js"></script>
<script>
	window.fbAsyncInit = function() {
		  FB.init({
			//prd
		    //appId      : '592902834143382',
		    //localhost
		    appId      : '614363918663940',
		    cookie     : true,
			xfbml      : true,
			version    : 'v2.0'
		  });
	  };
	  
	(function(d, s, id) {
	    var js, fjs = d.getElementsByTagName(s)[0];
	    if (d.getElementById(id)) return;
	    js = d.createElement(s); js.id = id;
	    js.src = "//connect.facebook.net/es_ES/sdk.js";
	    fjs.parentNode.insertBefore(js, fjs);
	  }(document, 'script', 'facebook-jssdk'));
</script>

<%@ include file="../partials/footerScritps.jsp" %>
</html>