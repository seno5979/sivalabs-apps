<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form method="post" action="j_spring_security_check">
		<div class="error">
			<c:if test="${not empty param.login_error}">
		      <font color="red">
		        Your login attempt was not successful, try again.<br/><br/>
		        Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
		      </font>
		    </c:if>
			${MSG} 
		</div>
		<fieldset>
		<legend><b>Login</b></legend>
		<table>
			<tr>
				<td>UserName</td>
				<td><input type='text' name='j_username' /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type='password' name='j_password'></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Login"></td>
			</tr>
			<tr>
				<td colspan="2">Not Registered yet? <a href="registration">Register</a></td>
			</tr>
		</table>
		</fieldset>
	</form>
</body>
</html>