<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form:form method="post" action="login.htm" commandName="user">
		<p>
			<form:errors path="*"></form:errors>
			${MSG}
		</p>
		<p>UserName : <form:input path="userName"/></p>
		<p>Password : <form:password path="password"/></p>
		<p><input type="submit" value="Login"> </p>
		<p>Not Registered yet? <a href="registration.htm">Register</a> </p>
	</form:form>
</body>
</html>