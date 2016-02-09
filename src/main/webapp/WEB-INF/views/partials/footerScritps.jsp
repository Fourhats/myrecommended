<% String footerScriptsPageContext = request.getContextPath(); %>
 <a style="position: fixed; bottom: 15px; right: 30px;" class="btn-floating btn-large waves-effect waves-light btn modal-trigger" href="#contactForm"><i class="material-icons">email</i></a>

  <!-- Modal Structure -->
  <div id="contactForm" class="modal">
    		<div class="modal-content-question">
      			<h4 style="text-align: center;">¡Escribinos!</h4>
      			<p style="padding: 0px;text-align: center;">¿Tenes dudas, consultas o sugerencias sobre Mis Recomendados?<br>¿Queres formar parte de nuestra base de profesionales?<br><b>Escribinos que en breve te estaremos contactando!</b></p>
			    <form class="col s12">
			    	<div class="row">
			        	<div class="input-field col s12">
							<input placeholder="Tu email" id="new_question" type="text" class="validate">
							<input placeholder="Tu nombre" id="new_question" type="text" class="validate">
							<textarea placeholder="Tus comentarios"id="textarea1" class="materialize-textarea"></textarea>
			        	</div>
			      	</div>
			    	<button id="questionButton" data-ng-click="addQuestion(newQuestion)" type="submit" class="waves-effect waves-light btn">Enviar</button>
				</form>
    		</div>
  </div>
<footer class="page-footer">
	<div class="container">
		<div class="row">
			<div class="col l6 s12">
				<h5 class="white-text">Mis Recomendados</h5>
				<p class="grey-text text-lighten-4">La mejor manera de contratar profesionales</p>
			</div>
			<div class="col l4 offset-l2 s12">
				<h5 class="white-text">Links</h5>
				<ul>
					<li>
						<a class="grey-text text-lighten-3" href="#!"> ¡Ofrece tus servicios!</a>
					</li>
					<li>
						<a class="grey-text text-lighten-3" href="#!">¿Como funciona?</a>
					</li>
					<li>
						<a class="grey-text text-lighten-3" href="#!">Ingresa</a>
					</li>
					<li>
						<a class="grey-text text-lighten-3" href="#!">Contacto</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="footer-copyright">
		<div class="container">
			© 2015 Copyright Mis Recomendados 
			<a class="grey-text text-lighten-4 right" href="#!">¡Registrate!</a>
		</div>
	</div>
</footer>

<script type="text/javascript" src="<%=footerScriptsPageContext%>/static/js/angularjs/imageUploader/ngThumbDirective.js"></script>
<script type="text/javascript" src="<%=footerScriptsPageContext%>/static/scripts/headerController.js"></script>
<script type="text/javascript" src="<%=footerScriptsPageContext%>/static/js/jquery.fancybox.js"></script>