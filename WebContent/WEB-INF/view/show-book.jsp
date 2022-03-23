<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book: ${old_book.bookTitle}</title>
	<!-- reference our style sheet -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/author.css" /></head>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Title:&nbsp;${old_book.bookTitle}</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<table>
				<tr>
					<td>Author's Name:&nbsp;</td>
					<td>${old_book.theAuthor.authorName}</td>
				</tr>
				<tr>
					<td>From the:&nbsp;</td>
					<td>${old_book.theCollection.collectionName}&nbsp;collection</td>
				</tr>
				<tr>
					<td>Published by:&nbsp;</td>
					<td>${old_book.theEditor.editorName}&nbsp;</td>
				</tr>
				<tr>
					<td>Published in:&nbsp;</td>
					<td>${old_book.bookPublYear}&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2">${old_book.bookInfo}</td>
				</tr>
				<tr>
					<td>ISBN:&nbsp;</td>
					<td>${old_book.codeISBN}&nbsp;</td>
				</tr>
				<tr>
					<td>Style:&nbsp;</td>
					<td>${old_book.novelStyle.genreLabel}&nbsp;</td>
				</tr>
			</table>
		</div>
	</div>
<!--  Version 1.4.0 of the Book Tracker -->
</body>
</html>