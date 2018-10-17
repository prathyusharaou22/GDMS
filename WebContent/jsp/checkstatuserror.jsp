<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "_http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/style1.css" rel="stylesheet" type="text/css" />
<link rel="icon" href="images/icon.ico" />
<body>

<div id="headerbg">
  <div id="headerblank">
    <div id="header">
	<div id="menublank">
      <div id="menu">
        <ul>
          <li><a href="/projectGDMS/jsp/gdmshome.jsp" class="menu">Home </a></li>
          <li><a href="/projectGDMS/jsp/aboutus.jsp"  class="menu">About Us</a></li>
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
	  <h3 align="center" style="padding-top: 150px"><font color="white">Entered BookingID Doesn't Exist</font></h3>
	  <div style="margin-right: 60px;margin-left: 480px;margin-top: 20px">
	  <input type="button" value="  Back  " align="right" onclick="window.location='/projectGDMS/jsp/checkstatushme.jsp';"></input>
	  </div>
</div></div>

<div id="copyrights">© GDMS. All Rights Reserved.
</div>
</div>

</body>
</html>