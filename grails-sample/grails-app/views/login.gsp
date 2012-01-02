<%@ page contentType="text/html;charset=ISO-8859-1" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<meta name="layout" content="main"/>
<title>Login</title>
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
  	<g:if test="${flash.message}">
    	<div class="message">${flash.message}</div>
    </g:if>
  	<g:form controller="login" action="login" method="post">
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
  				<td colspan="2"><g:submitButton name="submitBtn" value="Login"/> </td>
  			</tr>  			
  		</table>
  	</g:form>
  </div>
</body>
</html>