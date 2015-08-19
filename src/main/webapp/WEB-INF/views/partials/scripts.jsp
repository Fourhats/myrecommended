<% String scriptPageContext = request.getContextPath(); %>
<script>
	var ctx = "<%=request.getContextPath()%>";
</script>

<!-- JQuery LIBS -->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<!-- ANGULAR LIBS -->
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.12/angular.min.js"></script>
<script src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.12.0.js"></script>

<!-- COMMONS -->
<script type="text/javascript" src="<%=scriptPageContext%>/static/scripts/commonFunctions.js"></script>

<script>
	$i=1;
	window.setInterval(function(){
		var image = $('#index-banner');
		image.fadeOut(1000, function () {
			$i++;
			$img = "static/img/workerBanner" + $i + ".jpg";
		    image.css("background", "url('" + $img + "')");
		    image.fadeIn(1000);
		});
		
		if($i==3){
			$i=0;		
		}
	}, 5000);
</script>