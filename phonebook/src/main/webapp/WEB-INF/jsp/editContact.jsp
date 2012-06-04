<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Contact</title>
<script type="text/javascript">

	function doDeleteContact(contactId)
	{
		var ok = confirm("Are you sure to delete?");
		if(ok)
		{
			document.forms[0].action="deleteContact.htm?contactId="+contactId;
			document.forms[0].submit();
		}
	}
</script>
</head>
<body>
	<form:form method="post" action="updateContact.htm" commandName="Contact">
		<p>
			<form:errors path="*"></form:errors>
			${MSG}
		</p>
		<form:hidden path="contactId"/>
		<p>FirstName : <form:input path="firstName"/></p>
		<p>LastName : <form:input path="lastName"/></p>
		<p>EmailId : <form:input path="emailId"/></p>
		<p>Phone : <form:input path="phone"/></p>
		
		<p><input type="submit" value="Save"> 
			<input type="button" value="Delete" onclick="javascript:doDeleteContact(${Contact.contactId});">
			<a href="searchContacts.htm">Back</a>
		</p>
	</form:form>
</body>
</html>