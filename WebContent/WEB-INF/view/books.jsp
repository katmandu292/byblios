<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Books in This Library</title>
	<!-- reference our style sheet -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/author.css" /></head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Catman&#39;s Book Tracker - List of BOOKS</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<!-- put new button: AddBook -->	
			<input type="button" value="Add Book"
				   onclick="window.location.href='addBook'; return false;"
				   class="add-button" />
<!--  add our html table here -->

			<table>
				<tr>
					<th>TITLE&nbsp;</th>
					<th>AUTHOR</th>
					<th>Year&nbsp;</th>
					<th>Published By&nbsp;</th>
					<th>Genre</th>
<!--  				<th>About&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th -->
					<th>Action</th>
				</tr>
<!-- loop over and print our books -->
				<c:forEach var="tmpBook" items="${books}">
<!-- construct an "update" link with book id -->
					<c:url var="bookUpdateLink" value="/lib/updateBook">
						<c:param name="bookID" value="${tmpBook.bookID}" />
					</c:url>
<!-- construct a "delete" link with book id -->
					<c:url var="bookDeleteLink" value="/lib/delBook">
						<c:param name="bookID" value="${tmpBook.bookID}" />
					</c:url>
					<c:url var="bookLink" value="/lib/showBook">
						<c:param name="bookID" value="${tmpBook.bookID}" />
					</c:url>
					<tr>
						<td>&nbsp;<a href="${bookLink}">${tmpBook.bookTitle}</a>&nbsp;</td>
						<td>&nbsp;${tmpBook.theAuthor.authorName}&nbsp;</td>
						<td>&nbsp;${tmpBook.bookPublYear}&nbsp;</td>
						<td>&nbsp;${tmpBook.theEditor.editorName}&nbsp;</td>
						<td>&nbsp;${tmpBook.novelStyle.genreLabel}&nbsp;</td>
<!--  					<td>&nbsp;${tmpBook.bookInfo}&nbsp;</td -->
						<td>&nbsp;&nbsp;<a href="${bookUpdateLink}">Update</a>
						   &nbsp;|&nbsp;<a href="${bookDeleteLink}"
						   onclick="if (!(confirm('Are you sure you want to delete this book entry ?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>
<!--  Version 1.4.0 of the Book Tracker -->
</body>
</html>
