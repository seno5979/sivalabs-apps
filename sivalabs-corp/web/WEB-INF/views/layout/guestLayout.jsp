<%@ include file="../taglib.jsp" %>

<html>
<head>
	<title>SivaLabs</title>
	
	<decorator:head/>
</head>
<body>

<div align="center">
<div class="site">
	<table class="tbl">
		<tbody>		  
		 <tr>
		 	<td colspan="2" height="70" class="header">
		 		Welcome
		 	</td>
		 </tr>	
		 <!--<tr>
		 	<td colspan="2" height="20"  class="userBanner">
		 		<%@include file="userBanner.jsp" %>
		 	</td>
		 </tr>			 
		 --><tr align="center">
		 	
		    <td colspan="2" valign="top" align="center">
		    	<table class="tbl">
		    		<tr>
		    			<td valign="top" class="workPanel"  align="center">
		    				<decorator:body/>
		    			</td>
		    		</tr>
		    	</table>
		    </td>
		 </tr>
		 <tr class="footer" height="25">
	    	<td colspan="2">
	    		Copyright@2012
	   		 </td>
		 </tr>
		</tbody>
	</table>	
</div>
</div>

</body>
</html>