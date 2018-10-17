<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/projectGDMS/css/style1.css" rel="stylesheet"
	type="text/css" />
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
							<li style="margin-right: 320px;"><a href="/projectGDMS/jsp/contactus.jsp" class="menu">Contact Us</a></li>
							<li><h3 style="color: white;">Logged in as</h3></li>
									<%
									
									String type=(String)session.getAttribute("type");
									%>
							<li><h3 style="color:white; margin-left: 10px;"><%=type%>!</h3></li>
							<li><a href="/projectGDMS/jsp/signout.jsp" class="menu">Sign out</a></li>
							
						</ul>
					</div>
				</div><br/>
<form action="updatecontrol" method="post" name="updatefailure"  >
<h1 style="color: white;" align="center">Booking ID: <%=session.getAttribute("bookingid")%><br/><br/>  cannot be updated</h1>

<div style="margin-left: 500px;margin-top: 30px;">
<input type="button" value="back" src="/jsp/welcome.jsp" onclick="window.location='/projectGDMS/jsp/upsmain.jsp';"/>
</div>
</form>

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
				<div id="copyrights">© CTS GDMS. All Rights Reserved.</div>

			</div>
		</div>
	</div>
</body>
</html>