<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
</head>
<body>
	<form:form method="post" action="changePwd.htm" commandName="changePwd">
		<p>
			<form:errors path="*"></form:errors>
			${MSG} 
		</p>
		<p>Current Password : <input type="password" name="pwd"> </p>
		<p>New Password : <input type="password" name="newPwd"></p>
		<p>Retype Password: <input type="password" name="retypePwd"></p>
		
		<p><input type="submit" value="Save">
		<a href="home.htm">Home</a> </p>
	</form:form>
</body>
</html>