<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Author: ${old_author.authorName}</title>
	<!-- reference our style sheet -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/author.css" /></head>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>${old_author.authorName}</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<table>
				<tr>
					<td>Author's Name:&nbsp;</td>
					<td>${old_author.authorName}</td>
				</tr>
				<tr>
					<td>Born In:&nbsp;</td>
					<td>${old_author.authorBirthYear}</td>
				</tr>
				<tr>
					<td colspan="2">${old_author.authorBiography}</td>
				</tr>
			</table>
		</div>
	</div>
<!--  Version 1.1.3 of the Book Tracker -->
</body>
</html>