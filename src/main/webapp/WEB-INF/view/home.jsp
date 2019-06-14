<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC Security</title>
</head>
<body>
	<h2>Company Home Page</h2>
	<hr>
	<p>
		User:
		<security:authentication property="principal.username" />
		<br> <br> Role:
		<security:authentication property="principal.authorities" />
		<br>

	</p>


	<security:authorize access="hasRole('MANAGER')">
		<p>

			<a href="${pageContext.request.contextPath}/managers">Managers</a>

		</p>
	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
		<p>

			<a href="${pageContext.request.contextPath}/administrators">Administrators</a>

		</p>
	</security:authorize>
	<hr>
	<p>Wellcome to Spring security!!!</p>
	<hr>
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout">
	</form:form>
</body>
</html>