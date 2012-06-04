<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyAccount</title>
</head>
<body>
	<form:form method="post" action="updateUser.htm" commandName="user">
		<p>
			<form:errors path="*"></form:errors>
			${MSG}
		</p>
		<form:hidden path="userId"/>
		<form:hidden path="password"/>
		<p>UserName : <form:input path="userName" readonly="true"/></p>
		<p>FirstName : <form:input path="firstName"/></p>
		<p>LastName : <form:input path="lastName"/></p>
		<p>EmailId : <form:input path="emailId"/></p>
		
		<p><input type="submit" value="Save">
		<a href="home.htm">Home</a> </p>
	</form:form>
</body>
</html>