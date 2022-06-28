<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novel Types</title>
	<!-- reference our style sheet -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" /></head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Book Tracker - Novel Types</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
			<!-- put new button: Add Novel Type -->	
			<input type="button" value="Add Novel Type"
				   onclick="window.location.href='newNovelType'; return false;"
				   class="add-button" />
<!--  add our html table here -->
			</security:authorize>
			<table>
				<tr>
					<th>Novel Type&nbsp;</th>
					<th>What&#39;s It About&nbsp;</th>
					<th>&nbsp;Action&nbsp;</th>
				</tr>
<!-- loop over and print our novel types -->
				<c:forEach var="tmpNovelType" items="${book_types}">
<!-- construct an "update" link with customer id -->
					<c:url var="genreUpdateLink" value="/lib/updateNovelType">
						<c:param name="genreID" value="${tmpNovelType.genreID}" />
					</c:url>
<!-- construct a "delete" link with customer id -->
					<c:url var="novelTypDeleteLink" value="/lib/delNovelType">
						<c:param name="genreID" value="${tmpNovelType.genreID}" />
					</c:url>

					<tr>
						<td>&nbsp;${tmpNovelType.genreLabel}&nbsp;</td>
						<td>&nbsp;${tmpNovelType.genreInfo}&nbsp;</td>
						<td>&nbsp;&nbsp;<a href="${genreUpdateLink}">Update</a>
						<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
						   &nbsp;|&nbsp;<a href="${novelTypDeleteLink}"
						   onclick="if (!(confirm('Are you sure you want to delete this novel type?'))) return false">Delete</a>
						</security:authorize>
						</td>
					</tr>
				</c:forEach>
					<tr>
						<td colspan=3>&nbsp;</td>
					</tr>
			</table>

		</div>
	</div>
<!--  Version 1.5.1 of the Book Tracker -->
		<div id="content"><br />
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	<!-- the logout button -->
		<input type="submit" value="Logout" class="add-button" />
	</form:form>
		</div>
</body>
</html>