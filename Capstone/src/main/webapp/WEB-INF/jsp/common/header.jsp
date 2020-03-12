<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>National Park Geek</title>
<c:url value="/css/npgeek.css" var="cssHref"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="${cssHref}">

</head>
<nav>
	<div id="navDiv">
		<img id="navImg" src="img/logo.png"/>
		<c:url value="/" var="homeUrl"/>
		<a href="${homeUrl}">Home</a>
		<c:url value="/survey" var="surveyUrl"/>
		<a href="${surveyUrl}">Survey</a>
	</div>
	</nav>
<body>
	