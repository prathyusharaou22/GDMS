<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="/projectGDMS/css/style1.css" rel="stylesheet" type="text/css" />
<link rel="icon" href="images/icon.ico" />


<title>Insert title here</title>
</head>
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
	  
	  
	  <div style="margin-top: 50px">
	   <h1 align="center"><font color="white">ADMIN REPORTS</font></h1>
	  <div style="margin-top: 100px">
<form action="../StockRController" method="post">
	 
<br>


<table align="center">
<tr><td><input type="hidden" name="variable" value="10" ></td></tr>
<tr>
 <td align="center"> <h4 align="center"><font color="white">STOCK REPORTS:    <input class="button3" name="Stock Reports" type="submit" value="  GetStockReports   " style="position: absolute; margin-left: 17px" ></font></h4></td>


</table>
<input type="hidden" name="variable" value="0"/>
</form>
<form action="deliveryreport.jsp" method="post">	 
<br>
<table align="center">
<tr>
<td align="left"  > <h4 align="center" ><font color="white">DELIVERY REPORTS: <input class="button3" type="submit" value="GetDeliveryReports" style="position: absolute;  "  ></font></h4></td>


</table>
</form>
	  
	  </div>
     </div></div></div></div>
        
        
      
     

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