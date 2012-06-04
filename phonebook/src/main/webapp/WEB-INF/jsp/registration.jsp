<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form:form method="post" action="registration.htm" commandName="user">
		<p>
			<form:errors path="*"></form:errors>
			${MSG}
		</p>
		<p>UserName : <form:input path="userName"/></p>
		<p>Password : <form:password path="password"/></p>
		<p>FirstName : <form:input path="firstName"/></p>
		<p>LastName : <form:input path="lastName"/></p>
		<p>EmailId : <form:input path="emailId"/></p>
		
		<p><input type="submit" value="Register">
		Already Registered? <a href="login.htm">Login</a> </p>
	</form:form>
</body>
</html>