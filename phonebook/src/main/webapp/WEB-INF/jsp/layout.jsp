<%@ include file="taglib.jsp" %>

<html>
<head>
	<title><decorator:title default="Welcome!" /></title>
	<link href="resources/css/style.css" rel="stylesheet">
	<decorator:head/>
 

</head>
<body>
<div align="center">
<div class="site">
	<table class="tbl">
		<tbody>		  
		 <tr>
		 	<td colspan="2" height="70" class="header">
		 		<h2>Phonebook</h2>
		 	</td>
		 </tr>	
		 <tr>
		 	<td colspan="2" height="20"  class="userBanner">
		 		<div>
					<a href="showUser.htm">My Account</a>&nbsp;&nbsp;&nbsp;<a href="changePwd.htm">Change Pwd</a>
					&nbsp;&nbsp;<a href="logout.htm">Logout</a>
				</div>
		 	</td>
		 </tr>			 
		 <tr>
		 	<td width="15%" valign="top" class="nav">
		 		<table class="navTbl">
				  <tr>
				    <td><a class="link" href="home.htm">Home</a></td>
				  </tr>
				
				  <tr>
				    <td><a class="link" href="searchContacts.htm">PhoneBook</a></td>
				  </tr>
				  <tr>
				    <td><a class="link" href=logout.htm>Logout</a></td>
				  </tr>
				</table>
		 	</td>
		    <td valign="top">
		    	<table class="tbl">
		    		<tr>
		    			<td valign="top" class="workPanel">
		    				<decorator:body/>
		    			</td>
		    		</tr>
		    	</table>
		    </td>
		 </tr>
		 <tr class="footer" height="25">
	    	<td colspan="2">
	    		<a class="link" href="http://www.sivalabs.blogspot.com" target="_blank">
					http://www.sivalabs.blogspot.com. 
				</a>
	   		 </td>
		 </tr>
		</tbody>
	</table>	
</div>
</div>
</body>
</html>