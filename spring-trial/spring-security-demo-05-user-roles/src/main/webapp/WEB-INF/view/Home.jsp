<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dox company home page</title>
</head>
<body>
	<h2>Dox company home page</h2>
	<hr>
	<p>WELCOME</p>
	<hr>
	<!-- display username and role -->
	<hr>
	<p>
		User:<security:authentication property="principal.username" />
		<br><br>
		Role(s): <security:authentication property="principal.authorities" />
	</p>
	
	<hr>
	
	<security:authorize access="hasRole('MANAGER')">
		<!-- Add a link to point to /systems ...this is for admin -->
		<a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
	</security:authorize>
	<hr>
	
	<security:authorize access="hasRole('ADMIN')">
	<!-- Add a link to point to /leaders ...this is for managers -->
		<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
	</security:authorize>
	
	<hr>
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout">
	</form:form>
</body>
</html>