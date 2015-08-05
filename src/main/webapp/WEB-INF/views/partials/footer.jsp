<% String footerPageContext = request.getContextPath(); %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="footer">
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<div class="widget">
					<h4 class="widget-title">Nuestro Instagram</h4>
					<div id="beta-instagram-feed"><div></div></div>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="widget">
					<h4 class="widget-title">Secciones</h4>
					<div>
						<ul>
							<li><a href="blog_fullwidth_2col.html"><i class="fa fa-chevron-right"></i> Pedir un trabajo</a></li>
							<li><a href="blog_fullwidth_2col.html"><i class="fa fa-chevron-right"></i> Registrarse como proveedor</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-sm-4">
			 <div class="col-sm-10">
				<div class="widget">
					<h4 class="widget-title">¡Contactanos!</h4>
					<div>
						<div class="contact-info">
							<i class="fa fa-map-marker"></i>
							<p>Escribínos a hola@misrecomendados.com.ar</p>
							<p>Nicasio Oroño 55, Ciudad de Buenos Aires. Teléfono: +54 11 4433-0713</p>
						</div>
					</div>
				</div>
			   </div>
			</div>
			<div class="col-sm-3">
				<div class="widget">
					<h4 class="widget-title">¡Suscribite a nuestro Newsletter!</h4>
					<form action="#" method="post">
						<input type="email" name="your_email">
						<button class="pull-right" type="submit">Enviar<i class="fa fa-chevron-right"></i></button>
					</form>
				</div>
			</div>
		</div> <!-- .row -->
	</div> <!-- .container -->
</div> <!-- #footer -->