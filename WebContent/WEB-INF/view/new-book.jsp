<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<title>Book Entry Profile</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add_author.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/author.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Book Tracker - New Book Registration</h2>
		</div>
	</div>

	<div id="container">
		<h3>Update/Define Book</h3>
	
		<form:form action="savBook" modelAttribute="new_book" method="POST">
<!-- need to associate this data with book id -->
			<form:hidden path="bookID" />
			<table>
				<tbody>
				
					<tr>
						<td><label>Title:&nbsp;</label></td>
						<td><form:input path="bookTitle" /></td>
					</tr>

					<tr>
						<td><label>By:&nbsp;</label></td>
						<td><form:select path="theAuthor">
							<form:options items="${initialAuth}" />
							<form:options items="${authorList}" />
							</form:select>
						</td>
					</tr>
					<tr>
						<td><label>Publication Year:&nbsp;</label></td>
						<td><form:input path="bookPublYear" /></td>
					</tr>
					<tr>
						<td><label>Published By:&nbsp;</label></td>
						<td><form:select path="theEditor">
							   <form:options items="${initialEditor}" />
						       <form:options items="${publishers}" />
						    </form:select>
						</td>
					</tr>
					<tr>
						<td><label>ISBN:&nbsp;</label></td>
						<td><form:input path="codeISBN" /></td>
					</tr>
					<tr>
						<td><label>Novel Genre:&nbsp;</label></td>
						<td><form:select path="novelStyle">
							<form:options items="${initialType}" />
							<form:options items="${novelTypes}" />
							</form:select>
						</td>
					</tr>

					<tr>
						<td><label>Collection:&nbsp;</label></td>
						<td><form:select path="theCollection">
							<form:options items="${collection}" />
							<form:options items="${bookCollections}" />
							</form:select>
						</td>
					</tr>

					<tr>
						<td><label>Info:&nbsp;</label></td>
						<td><form:textarea path="bookInfo" rows="25" cols="64" /></td>
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
			<a href="${pageContext.request.contextPath}/lib/listBooks">Back to List</a>
		</p>
	</div>

</body>
<!--  Version 1.2.9 of the Book Tracker -->
</html>
