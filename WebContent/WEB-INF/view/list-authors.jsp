<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Authors</title>
	<!-- reference our style sheet -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/author.css" /></head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Book Tracker - Authors List</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<!-- put new button: Add Author -->	
			<input type="button" value="Add Author"
				   onclick="window.location.href='checkInAuthor'; return false;"
				   class="add-button" />
<!--  add our html table here -->

			<table>
				<tr>
					<th>Author&#39;s Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
					<th>Born in&nbsp;</th>
<!--  				 th>About&nbsp;</th   -->
					<th>&nbsp;Action&nbsp;</th>
				</tr>
<!-- loop over and print our authors -->
				<c:forEach var="tmpAuthor" items="${authors}">
<!-- construct an "update" link with author identifier -->
					<c:url var="authorUpdateLink" value="/lib/checkOutAuthor">
						<c:param name="authorId" value="${tmpAuthor.authorID}" />
					</c:url>
<!-- construct a "delete" link with author identifier -->
					<c:url var="authorDeleteLink" value="/lib/delAuthor">
						<c:param name="authorId" value="${tmpAuthor.authorID}" />
					</c:url>
					<c:url var="authorLink" value="/lib/showAuthor">
						<c:param name="authorId" value="${tmpAuthor.authorID}" />
					</c:url>
					<tr>
						<td>&nbsp;<a href="${authorLink}">${tmpAuthor.authorName}</a>&nbsp;</td>
						<td>&nbsp;${tmpAuthor.authorBirthYear}&nbsp;</td>
<!-- 					 td>&nbsp;${tmpAuthor.authorBiography}&nbsp;</td  -->
						<td>&nbsp;&nbsp;<a href="${authorUpdateLink}">Update</a>
						   &nbsp;|&nbsp;<a href="${authorDeleteLink}"
						   onclick="if (!(confirm('Are you sure you want to delete this author?'))) return false">Erase</a>
						</td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
<!--  Version 1.1.3 of the Book Tracker -->
</body>
</html>