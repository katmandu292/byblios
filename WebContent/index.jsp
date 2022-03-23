<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Byblios Start Page</title>
	<!-- reference our style sheet -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/author.css" /></head>
</head>
<body>
	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>The BYBLIOS Engine</th>
				</tr>
				<tr>
					<td>registered&nbsp;<a href="${pageContext.request.contextPath}/lib/listAuthors">authors</a></td>
				</tr>
				<tr>
					<td>registered&nbsp;<a href="${pageContext.request.contextPath}/lib/listBooks">books</a></td>
				</tr>
				<tr>
					<td>registered&nbsp;<a href="${pageContext.request.contextPath}/lib/listEditors">publishers</a></td>
				</tr>
				<tr>
					<td>registered&nbsp;<a href="${pageContext.request.contextPath}/lib/listGenres">book styles</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>