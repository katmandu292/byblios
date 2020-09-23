<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Authors</title>
	<!-- reference our style sheet -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/author.css" /></head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Book Tracker - Editors List</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<!-- put new button: Add a new Editor -->	
			<input type="button" value="Add Publisher"
				   onclick="window.location.href='checkInEditor'; return false;"
				   class="add-button" />
<!--  add our html table here -->

			<table>
				<tr>
					<th>EDITOR&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
					<th>INFO&nbsp;</th>
					<th>&nbsp;Action&nbsp;</th>
				</tr>
<!-- loop over and print our publishers -->
				<c:forEach var="tmpEditor" items="${editors}">
<!-- construct an "update" link with author identifier -->
					<c:url var="editorUpdateLink" value="/lib/ckeckOutEditor">
						<c:param name="editorID" value="${tmpEditor.editorID}" />
					</c:url>
<!-- construct a "delete" link with editor identifier -->
					<c:url var="editorDeleteLink" value="/lib/delEditor">
						<c:param name="editorID" value="${tmpEditor.editorID}" />
					</c:url>

					<tr>
						<td>&nbsp;${tmpEditor.editorName}&nbsp;</td>
						<td>&nbsp;${tmpEditor.editorInfo}&nbsp;</td>
						<td>&nbsp;&nbsp;<a href="${editorUpdateLink}">Update</a>
						   &nbsp;|&nbsp;<a href="${editorDeleteLink}"
						   onclick="if (!(confirm('Are you sure you want to delete this Editor?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
<!--  Version 1.1.3 of the Book Tracker -->
</body>
</html>