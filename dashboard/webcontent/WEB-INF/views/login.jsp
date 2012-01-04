<%@include file="taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SivaLabs</title>
<script type="text/javascript">
 
</script>
</head>
<body>

<center>

	<form:form action="login" method="post" commandName="login">
		<table>
			<tr>
				<td colspan="2"><span style="color: red">${ERROR_MSG}</span></td>
			</tr>
			<tr>
				<td>UserName</td>
				<td><form:input path="username"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:password path="password"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Login" class="btn">
				</td>
			</tr>
		</table>
	</form:form>
</center>
</body>