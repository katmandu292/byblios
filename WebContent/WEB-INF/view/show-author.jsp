<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Author Details</title>
	<!-- reference our style sheet -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" /></head>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Author: ${author.authorName}</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<table border="0">
				<tr>
					<td>Author's Name:&nbsp;</td>
					<td>${author.authorName}</td>
				</tr>
				<tr>
					<td>Born In:&nbsp;</td>
					<td>${author.authorBirthYear}&nbsp;</td>
				</tr>

				<tr>
					<td colspan="3">
						<table border="1" width="100%">
							<tr>
							  <td width="10%">&nbsp;</td>
							  <td>${author.authorBiography}</td>
							</tr>
						</table>
					
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td colspan="2">Back to&nbsp;<a href="${pageContext.request.contextPath}/lib/listAuthors">List</a></td>
				</tr>
			</table>
		</div>
	</div>
<!--  Version 1.6.1 of the Book Tracker -->
</body>
</html>