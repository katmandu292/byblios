<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<title>Novel Type Form</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add_author.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/author.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Book Tracker - New Novel Type Registration</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Genre</h3>
	
		<form:form action="sav_novel_type" modelAttribute="new_novel_type" method="POST">
<!-- need to associate this data with customer id -->
			<form:hidden path="genreID" />
			<table>
				<tbody>
				
					<tr>
						<td><label>Novel Type:&nbsp;</label></td>
						<td><form:input path="genreLabel" /></td>
					</tr>

					<tr>
						<td><label>About:&nbsp;</label></td>
						<td><form:textarea path="genreInfo" rows="25" cols="64" /></td>
					</tr>

					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				</tbody>
			</table>
		</form:form>
	
	<div style="clear; both;"></div>
		<p>
			<a href="${pageContext.request.contextPath}/lib/listGenres">Back to List</a>
		</p>
	</div>

</body>
<!--  Version 1.2.7 of the Book Tracker -->
</html>
