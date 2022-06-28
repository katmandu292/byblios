<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Publishers</title>
	<!-- reference our style sheet -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" /></head>

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
				   onclick="window.location.href='newEditor'; return false;"
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
					<c:url var="editorUpdateLink" value="/lib/updateEditor">
						<c:param name="editorID" value="${tmpEditor.editorID}" />
					</c:url>
<!-- construct a "delete" link with editor identifier -->
					<c:url var="editorDeleteLink" value="/lib/delEditor">
						<c:param name="authorId" value="${tmpEditor.editorID}" />
					</c:url>

					<tr>
						<td>&nbsp;${tmpEditor.editorName}&nbsp;</td>
						<td>&nbsp;${tmpEditor.editorInfo}&nbsp;</td>
						<td>&nbsp;&nbsp;<a href="${editorUpdateLink}">Update</a>
							<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
						   		&nbsp;|&nbsp;<a href="${editorDeleteLink}"
						   onclick="if (!(confirm('Are you sure you want to delete this Editor?'))) return false">Delete</a>
						   	</security:authorize>
						</td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>

	<div id="content"><br />
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
<!-- the logout button -->
		<input type="submit" value="Logout" class="add-button" />
	</form:form>
	</div>
<!--  Version 1.5.1 of the Book Tracker -->
</body>
</html>