<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Byblios Start Page</title>
	<!-- reference our style sheet -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" /></head>
</head>
<body>
	<div id="container">
		<div id="content">

			<table>
				<tr>
					<th>
						The BYBLIOS Engine&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
							Logged as <security:authentication property="principal.username" />
						</security:authorize>
					</th>
				</tr>

				<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
					<tr>
						<td>registered&nbsp;<a href="${pageContext.request.contextPath}/lib/listAuthors">authors</a></td>
					</tr>
				</security:authorize>

				<tr>
					<td>registered&nbsp;<a href="${pageContext.request.contextPath}/book/listBooks">books</a></td>
				</tr>

				<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
					<tr>
						<td>registered&nbsp;<a href="${pageContext.request.contextPath}/lib/listEditors">publishers</a></td>
					</tr>
				</security:authorize>

				<tr>
					<td>registered&nbsp;<a href="${pageContext.request.contextPath}/lib/listGenres">book styles</a></td>
				</tr>

				<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
					<tr>
						<td>registered&nbsp;<a href="${pageContext.request.contextPath}/book/listCollections">book collections</a></td>
					</tr>
				</security:authorize>

				<tr>
					<td>
						<br /><a href="${pageContext.request.contextPath}/showMyLoginPage">Sign In</a>
					</td>
				</tr>
				<tr>
					<td>
<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout" class="add-button" />
	</form:form>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>