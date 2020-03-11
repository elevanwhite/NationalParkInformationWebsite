<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<c:url value="/css/npgeek.css" var="cssHref"/>
<link rel="stylesheet" href="${cssHref}">
</head>
<body>
	<header>Header</header>
	<nav>
		<c:url value="/" var="homeUrl"/>
		<a href="${homeUrl}">Home</a>
		<c:url value="/survey" var="surveyUrl"/>
		<a href="${surveyUrl}">Survey</a>
	</nav>