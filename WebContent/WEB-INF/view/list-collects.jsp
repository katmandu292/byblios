<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Collections List</title>
	<!-- reference our style sheet -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/author.css" /></head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Book Tracker - Collections List</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<!-- put new button: Add Author -->	
			<input type="button" value="Add Collection"
				   onclick="window.location.href='newCollection'; return false;"
				   class="add-button" />
<!--  add our html table here -->

			<table>
				<tr>
					<th>Collection&#39;s Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
					<th>Born in&nbsp;</th>
					<th>By&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
					<th>About&nbsp;&nbsp;&nbsp;</th>
					<th>&nbsp;Action&nbsp;</th>
				</tr>
<!-- loop over and print our authors -->
				<c:forEach var="tmpBookColl" items="${bookColls}">
<!-- construct an "update" link with author identifier -->
					<c:url var="collectionUpdateLink" value="/lib/updateCollection">
						<c:param name="bookSeriesId" value="${tmpBookColl.collectionId}" />
					</c:url>
<!-- construct a "delete" link with author identifier -->
					<c:url var="collectionDeleteLink" value="/lib/delCollection">
						<c:param name="bookSeriesId" value="${tmpBookColl.collectionId}" />
					</c:url>

					<tr>
						<td>&nbsp;${tmpBookColl.collectionName}&nbsp;</td>
						<td>&nbsp;${tmpBookColl.firstYear}&nbsp;</td>
						<td>&nbsp;${tmpBookColl.collectionPublisher.editorName}</td>
						<td>&nbsp;${tmpBookColl.collectionInfo}&nbsp;</td>
						<td>&nbsp;&nbsp;<a href="${collectionUpdateLink}">Update</a>
						   &nbsp;|&nbsp;<a href="${collectionDeleteLink}"
						   onclick="if (!(confirm('Are you sure you want to delete this book series?'))) return false">Erase</a>
						</td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>

</body>
</html>