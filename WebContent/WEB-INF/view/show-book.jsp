<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Details</title>
	<!-- reference our style sheet -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" /></head>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Title:&nbsp;${oldBook.bookTitle}</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<table border="0">
				<tr>
					<td>Author's Name:&nbsp;</td>
					<td>${oldBook.theAuthor.authorName}</td>
				</tr>
				<tr>
					<td>From the:&nbsp;</td>
					<td>${oldBook.bookSeries.collectionName}&nbsp;collection</td>
				</tr>
				<tr>
					<td>Published by:&nbsp;</td>
					<td>${oldBook.theEditor.editorName}&nbsp;</td>
				</tr>
				<tr>
					<td>Published in:&nbsp;</td>
					<td>${oldBook.bookPublYear}&nbsp;</td>
				</tr>
				<tr>
					<td colspan="3">
						<table border="1" width="100%">
							<tr>
							  <td width="10%">&nbsp;</td>
							  <td>${oldBook.bookInfo}</td>
							</tr>
						</table>
					
					</td>
				</tr>
				<tr>
					<td>ISBN:&nbsp;</td>
					<td>${oldBook.codeISBN}&nbsp;</td>
				</tr>
				<tr>
					<td>Style:&nbsp;</td>
					<td>${oldBook.novelStyle.genreLabel}&nbsp;</td>
				</tr>
			</table>
		</div>
	</div>
<!--  Version 1.4.0 of the Book Tracker -->
</body>
</html>