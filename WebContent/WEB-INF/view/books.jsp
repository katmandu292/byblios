<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Books in This Library</title>
	<!-- reference our style sheet -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" /></head>

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
				   onclick="window.location.href='newBook'; return false;"
				   class="add-button" />
<!--  add our html table here -->

			<table>
				<tr>
					<th>TITLE&nbsp;</th>
					<th>AUTHOR</th>
					<th>Published In&nbsp;</th>
					<th>Published By&nbsp;</th>
					<th>Genre</th>
					<th>Action</th>
				</tr>
<!-- loop over and print our books -->
				<c:forEach var="tmpBook" items="${books}">
<!-- construct an "update" link with book id -->
					<c:url var="bookUpdateLink" value="/book/updateBook">
						<c:param name="bookID" value="${tmpBook.bookId}" />
					</c:url>
<!-- construct a "delete" link with book id -->
					<c:url var="bookDeleteLink" value="/book/delBook">
						<c:param name="bookID" value="${tmpBook.bookId}" />
					</c:url>
					<c:url var="bookLink" value="/book/showBook">
						<c:param name="bookID" value="${tmpBook.bookId}" />
					</c:url>
					<tr>
						<td><a href="${bookLink}">&nbsp;${tmpBook.bookTitle}</a>&nbsp;</td>
						<td>&nbsp;${tmpBook.theAuthor.fullName}&nbsp;</td>
						<td>&nbsp;${tmpBook.bookPublYear}&nbsp;</td>
						<td>&nbsp;${tmpBook.thePublisher.editorName}&nbsp;</td>
						<td>&nbsp;${tmpBook.novelGenre.genreLabel}&nbsp;</td>
						<td>&nbsp;&nbsp;<a href="${bookUpdateLink}">Update</a>
						   &nbsp;|&nbsp;<a href="${bookDeleteLink}"
						   onclick="if (!(confirm('Are you sure you want to delete this book entry ?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>

		</div>
		<div id="content">
<!-- Add a logout button -->
			<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
			<input type="submit" value="Logout" class="add-button" />
			</form:form>
		</div>
	</div>
<!--  Version 1.5.1 of the Book Tracker -->
</body>
</html>
