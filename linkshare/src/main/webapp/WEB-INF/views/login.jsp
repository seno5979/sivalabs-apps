<%@include file="taglib.jsp"%>
<html>
<head>
	<style>
		
		label, input { display:block; }
		
	</style>
	<script>
	$(function() {
		$( "input:submit" ).button();
	});
	</script>
</head>
<body>
	<div style="width:400px; margin-right:auto; margin-left:auto; border:1px solid #000;">
	
	<form:form action="login.htm" commandName="user" method="post">
		<table>
			<tbody>							
				<tr>
					<td width="100" align="right">UserName </td>
					<td><form:input path="userName" title="UserName"></form:input>
					<form:errors cssStyle="color:red" path="userName"/></td>
				</tr>
				
				<tr>
					<td width="100" align="right">Password </td>
					<td><form:password path="password"></form:password>
					<form:errors cssStyle="color:red" path="password"/></td>
				</tr>				
				<tr>
					<td>&nbsp;</td>
					<td  width="100" align="right">
						<input name="" value="Login" type="submit">						
					</td>					
				</tr>
				<tr>
					<td colspan="2">
					<form:errors cssStyle="color:red" />
					</td>
				</tr>				
			</tbody>
		</table>
	</form:form>
	</div>
	
</body>
</html>
