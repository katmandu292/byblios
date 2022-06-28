<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<title>Save Editor Form</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add_author.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Book Tracker - Publisher Registration</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Publisher</h3>
	
		<form:form action="savEditor" modelAttribute="new_editor" method="POST">
<!-- need to associate this data with customer id -->
			<form:hidden path="editorID" />
			<table>
				<tbody>
					<tr>
						<td><label>Editor:&nbsp;</label></td>
						<td><form:input path="editorName" /></td>
					</tr>

					<tr>
						<td><label>About:&nbsp;</label></td>
						<td><form:textarea path="editorInfo" rows="25" cols="64" /></td>
					</tr>
					<tr>
						<td>Address:&nbsp;</td>
						<td><form:input path="editorBase" rows="25" cols="64" /></td>
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
			<a href="${pageContext.request.contextPath}/lib/listEditors">Back to List</a>
		</p>
	</div>
</body>
<!--  Version 1.5.1 of the Book Tracker -->
</html>
