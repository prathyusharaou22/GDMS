<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@page import="cts.gdms.vo.SearchGiftVO" %>

    <%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1
-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TemplateWorld - Shape</title>
<link href="/projectGDMS/css/style1.css" rel="stylesheet" type="text/css"  />
<link rel="icon" href="images/icon.ico" /> 
<script src="../js/checkstatus.js"></script>
</head>
<body>
	<div id="headerbg">
		<div id="headerblank">
			<div id="header">
				<div id="menublank">
					<div id="menu">
						<ul>
							<li><a href="/projectGDMS/jsp/gdmshome.jsp" class="menu">Home </a>
							</li>
							<li><a href="/projectGDMS/jsp/aboutus.jsp" class="menu">About Us</a>
							</li>
							<li style="margin-right: 320px;"><a href="/projectGDMS/jsp/contactus.jsp" class="menu">Contact Us</a></li>
							
							 <li><h3 style="color: white;">Logged in as</h3></li>
									<%
									
									String type=(String)session.getAttribute("type");
									%>
							<li><h3 style="color:white; margin-left: 10px;"><%=type%>!</h3></li>
							<li><a href="/projectGDMS/jsp/signout.jsp" class="menu">Sign out</a></li>	
							
							
						</ul>
					</div>
				</div>
<div>
<br>
</br>
<br>
</br>
<h2 align="center" style="color:white"> GIFT DELIVERY MANAGEMENT SYSTEM </h2>
<br>
</br>
<br>
</br>
<br>
</br>

<table>
<tr>

<% 
   List<String> subIds=(List<String>)session.getAttribute("listsub");
  SearchGiftVO searchvo=(SearchGiftVO)session.getAttribute("searchvo");
  if(subIds!=null)
  {
	  for(String subId:subIds)
	  {
  %>   
       <td>
      <a href="/projectGDMS/gfs?req=<%=subId%>"><img  alt="not available" width="150px" height="150px" src="/projectGDMS/css/images/<%=subId%>.jpg"><h3 style="color:white"><br></br>&nbsp;&nbsp;&nbsp;<%="Product ID : "%><%=subId%><br></br>&nbsp;&nbsp;&nbsp;<%="Gift Type : "%><%=searchvo.getGiftType()%><br></br>&nbsp;&nbsp;&nbsp;<%="Occassion Type : "%><%=searchvo.getOccassionType()%></h3></a>
       </td> 
		<%   
	}
 }
  if(subIds.size()==0)
 {
%>
</tr>
<td>
<h2 style="color: white" align="center">No Gifts Available in this Category!</h2>
</td>
<%
 }
%>


 </table>


</div>
</div>
		</div>
	</div>
	<div id="footerbg">
		<div id="footerblank">
			<div id="footer">
				<div id="footerlinks">
					<a href="/projectGDMS/jsp/gdmshome.jsp" class="footerlinks">Home</a> | <a href="/projectGDMS/jsp/aboutus.jsp"
						class="footerlinks">About Us</a> | <a href="/projectGDMS/jsp/contactus.jsp" class="footerlinks">Contact
						Us</a>
				</div>
				<div id="copyrights">© GDMS. All Rights Reserved.</div>

			</div>
		</div>
	</div>
</body>
</html>
