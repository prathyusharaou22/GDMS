<%@page import="java.text.SimpleDateFormat,java.util.*"%>
<%@page import="cts.gdms.vo.Checkstatusvo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1
-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TemplateWorld - Shape</title>
<link href="/projectGDMS/css/style1.css" rel="stylesheet" type="text/css" />
<link rel="icon" href="images/icon.ico" />
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
							<li style="margin-right: 320px;"><a href="/projectGDMS/jsp/contactus.jsp" class="menu">Contact
									Us</a>
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
					<h1>Gift Status</h1>
				</div>
				<div style="margin-top: 100px;">
					<form>
						<%
							Checkstatusvo checkstatusvo = (Checkstatusvo) request
									.getAttribute("checkvo");

							String expDate = checkstatusvo.getExpecteddate();
							String date[] = expDate.split(" ");
							expDate = date[0];
						%>
						<table border="2" cellpadding="10" align="center">
							<tr style="color: white;">
								<th>booking_id</th>
								<th>gift_sub_id</th>
								<th>Expected_date_of_delivery</th>
								<th>Delivery_status</th>
							</tr>
							<tr style="color: white;">
								<td colspan="1"><%=checkstatusvo.getBookingid()%></td>
								<td><%=checkstatusvo.getGiftsubid()%></td>
								<td><%=expDate%></td>
								<td><%=checkstatusvo.getDeliverystatus()%></td>
							</tr>
						</table>
						<div align="center" style="margin-top: 20px">
						<input type="button" value="  Back  " align="right" onclick="window.location='/projectGDMS/jsp/checkstatushme.jsp';" ></input>
						</div>
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