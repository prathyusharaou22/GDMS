<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
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
				 
<%
String s1=(String)request.getAttribute("bookingid");
%>
<br>
</br>
<br>
</br>
<br>
</br>
    <h1 align="center" style="color:white">Booked Successfully!</h1>
    <br></br>
    <br></br>
    <br></br>
   <h1 align="center" style="color: white"><%="Booking ID : "%><%=s1%></h1>
   <div style="margin-right: 60px;margin-left: 440px;margin-top: 20px">
    <br></br>
    <br></br>
    <form action="/projectGDMS/gfs" method="get">
	  <input type="submit" style="height:35px; width:150px" value="Book One More Gift" align="right"></input>
	 </form>
	  </div>
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
   
