<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
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
							<li style="margin-right: 320px;"><a href="#" class="menu">Contact
									Us</a></li>
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
<div style="margin-left: 4px; margin-right: 15px;">
<h2 align="center"><font color="white"> GIFT DELIVERY REPORTS</font></h2>
 <div style="margin-top: 50px">
<table  align="center" cellpadding="10%" border="1"  cellspacing="" bordercolor="white">
			
				
				<tr bgcolor="" >
					<th><font color="white">Gift_Sub_ID</font></th>
					<th><font color="white">No: of Gifts Booked</font></th>
					<th><font color="white">No: of Gifts delivered before expected date</font></th>
					<th><font color="white">No: of Gifts delivered on expected date</font></th>
					<th><font color="white">No: of Gifts delivered after expected date</font></th>
					
				</tr>
				
				<tr bgcolor=""><td align="center">
					<%List<String> l= (List<String>) request.getAttribute("giftsubs");
					int i=0;
					for(String s:l)
					{	
					%>
					<font color="white"><%= s  %></font>
					
					<br>
					<%} i++;%>
					
					</td><td align="center">
					<%List<Integer> l1= (List<Integer>) request.getAttribute("bkdgift");
					
					for(Integer s:l1)
					{	
					%>
					<font color="white"><%= s %></font>
					<br>
					<%}%>
					</td><td align="center">
					<%List<Integer> l2= (List<Integer>) request.getAttribute("beforeexpected");
					
					for(Integer s:l2)
					{	
					%>
					<font color="white"><%= s %></font>
					<br>
					<%}%>
					</td><td align="center">
					<%List<Integer> l3= (List<Integer>) request.getAttribute("onexpected");
					
					for(Integer s:l3)
					{	
					%>
					<font color="white"><%= s %></font>
					<br>
					<%}%>
					</td><td align="center">
					
					<%List<Integer> l4= (List<Integer>) request.getAttribute("afterexpected");
					
					for(Integer s:l4)
					{	
					%>
					<font color="white"><%= s %></font>
					<br>
					<%}%> 
					</td>
				</tr>	
				</table>
				
<br>
<table align="center">
<tr>
<td align="left"  > <h4 align="center" ><font color="white"><input class="button3" type="submit" value="Back" style="position: absolute; " onclick="window.location='/projectGDMS/jsp/deliveryreport.jsp';" ></font></h4></td>


</table>
</form>
				</div>
				 </div>
				 </div>
     </div></div>
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