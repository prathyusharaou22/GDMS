<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1
-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TemplateWorld - Shape</title>
<link href="../css/style1.css" rel="stylesheet" type="text/css"  />
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
							<li><a href="/projectGDMS/jsp/contactus.jsp" class="menu" style="margin-right: 320px;">ContactUs</a>
							</li>
							<li><h3 style="color: white;">Logged in as</h3></li>
									<%
									
									String type=(String)session.getAttribute("type");
									%>
							<li><h3 style="color:white; margin-left: 10px;"><%=type%>!</h3></li>
							<li><a href="/projectGDMS/jsp/signout.jsp" class="menu">Sign out</a></li>
							
						</ul>
					</div>
				</div>

				<div style="font: italic; color: white;" align="center">
					<h1>Check Status</h1>
				</div>
				<div style="margin-left: 380px;margin-right: 20px">
					<form id="form1" name="form1" method="get" action="../Checkstatus">
						<table align="left" style="margin-top: 60px" >
							<tr align="center">
								<td><font style="color: white;">Booking
										Id</font></td>
								<td><input style="background-color: #FAFAD2" type="text" name="bookid" id="book" onkeyup="clearSpan(ownmer)"/><br /></td>
								
						
						<td><span id="ownmer" style="color:red" ></span></td></tr>
						<tr></tr><tr></tr><tr></tr><tr></tr>
							<tr>
								<td ></td><td><input type="submit"
									value="Check Status" onclick="return check()" />
									
								<input type="reset" value="Reset" /></td>
								
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div id="footerbg">
		<div id="footerblank">
			<div id="footer">
				<div id="footerlinks">
					<a href="#" class="footerlinks">Home</a> | <a href="#"
						class="footerlinks">About Us</a> | <a href="#" class="footerlinks">Contact
						Us</a>
				</div>
				<div id="copyrights">© GDMS. All Rights Reserved.</div>

			</div>
		</div>
	</div>
</body>
</html>