<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html data-ng-app="myRecommendedApp">
<head>
	<%@ include file="../partials/styles.jsp"%>
</head>
<body>
	<%@ include file="../partials/header.jsp"%>
</body>
<%@ include file="../partials/scripts.jsp"%>
<script>
	var myRecommendedApp = angular.module('myRecommendedApp', ['ui.bootstrap']);
    $(document).ready(function() {
		hideMainProgressBar();
	});
</script>
<%@ include file="../partials/footerScritps.jsp"%>
</html>