<%@ page contentType="text/html;charset=ISO-8859-1" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>Register</title>
</head>
<body>
  <div class="body">
  	<div>
  		<g:hasErrors bean="${user}">
            <div class="errors">
                <g:renderErrors bean="${user}" as="list" />
            </div>
            </g:hasErrors>
  	</div>
  	<g:form controller="registration" method="post">
  		<table width="200px;">
  			<tr>
  				<td>UserName</td>
  				<td><g:textField name="username" value="${user?.username}"/> </td>
  			</tr>
  			<tr>
  				<td>Password</td>
  				<td><g:passwordField name="password" value="${user?.password}"/> </td>
  			</tr>
  			<tr>
  				<td>Email</td>
  				<td><g:textField name="email" value="${user?.email}"/> </td>
  			</tr>
  			<tr>
  				<td>Phone</td>
  				<td><g:textField name="phone" value="${user?.phone}"/> </td>
  			</tr>
  			<tr>
  				<td>DOB</td>
  				<td><g:datePicker name="dob" precision="day"/></td>
  			</tr>
  			<tr>
  				<td colspan="2">
  					<g:actionSubmit action="register" value="Register"/> 
  					<g:actionSubmit action="login" value="Login" />
  				</td>
  			</tr>  			
  		</table>
  	</g:form>
  </div>
</body>
</html>