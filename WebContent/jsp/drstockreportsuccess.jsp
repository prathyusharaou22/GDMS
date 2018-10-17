<%@page import="cts.gdms.vo.StockReportvo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="/projectGDMS/css/style1.css" rel="stylesheet" type="text/css" />
<link rel="icon" href="images/icon.ico" />
<body>

<div id="headerbg">
  <div id="headerblank">
    <div id="header">
	<div id="menublank">
      <div id="menu">
        <ul>
          <li><a href="/projectGDMS/jsp/gdmshome.jsp" class="menu">Home </a></li>
          <li><a href="/projectGDMS/jsp/aboutus.jsp" class="menu">About Us</a></li>
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
	  

<br>
<br>
<br>
<br>
<div style="margin-left: 4px; margin-right: 15px; max-height:500px; overflow-y:auto ">
<h1 align="center"><font color="white"> STOCK REPORTS</font></h1>
<form action="StockRController" method="post">	 
	  
<table  align="center" cellpadding="10%" border="1"  cellspacing="" bordercolor="white">
			
				
				<tr bgcolor="" >
					<th><font color="white">Gift_Sub_ID</font></th>
					<th><font color="white">Description</font></th>
					<th><font color="white">Quantity</font></th>
					<th><font color="white">Cost</font></th>
					
					
					
				</tr>
				
					<%List<StockReportvo> list= (List<StockReportvo>) request.getAttribute("strvo");
					
					for(StockReportvo vo:list)
					{
					
					%>
					
				
					<tr>
					<td align="center"><font color="White"><%=vo.getGiftsubid()%></font></td>
					<td align="center"><font color="White"><%=vo.getGiftdescription()%></font></td>
					<td align="center"><font color="White"><%=vo.getQuantity()%></font></td>
					<td align="center"><font color="White"><%=vo.getCost()%></font></td>
					</tr>
					<%
					}%>
					
				
				</table>
				

<br>

</form></div>
<div style="margin-left: 400px">
	<input type="button" align="middle" value="back" onclick="window.location='/projectGDMS/jsp/dradminreports.jsp';"/></div>
				
				</div>
				</div>
				</div>
				<div id="footerbg">
  <div id="footerblank">
    <div id="footer">
      <div id="footerlinks"><a href="#" class="footerlinks">Home</a> | <a href="#" 

class="footerlinks">About Us</a> | <a href="#" class="footerlinks">Contact Us</a> </div>
      <div id="copyrights">© GDMS. All Rights Reserved.</div>
      
    </div>
  </div>
</div>
				</body>
				</html>
				