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
<script type="text/javascript" src="<%=scriptPageContext%>/static/js/prism.js"></script>
<script type="text/javascript" src="<%=scriptPageContext%>/static/js/materialize.js"></script>
<script type="text/javascript" src="<%=scriptPageContext%>/static/js/init.js"></script>

<script>
var count = 1
setInterval(function(){
  var old= $('#banner' + count);
  old.fadeOut(2000);

  count++;
  if (count>3){
    count = 1
  }

  var next= $('#banner' + count);
  next.fadeIn(2000);
}, 7000);


</script>