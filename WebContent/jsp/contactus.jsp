<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1
-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>Insert title here</title>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link href="../css/style1.css" rel="stylesheet" type="text/css" />
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
							<li><a href="/projectGDMS/jsp/contactus.jsp" class="menu" style="margin-right: 320px;">ContactUs</a>
							</li>
							<li><h3 style="color: white;">Logged in as</h3></li>
									<%
									
									String type=(String)session.getAttribute("type");
									if(type==null)
									{
										type="";
									}
									%>
							<li><h3 style="color:white; margin-left: 10px;"><%=type%>!</h3></li>
							<li><a href="/projectGDMS/jsp/signout.jsp" class="menu">Sign out</a></li>
        </ul>
      </div>
	  </div>
	  <div style="margin-top: 100px;margin-left:350px;">
	  <h2 style="color: white;">GIFTSIN / CONTACT</h2><br/><br/>
	  <h3 style="color: white; margin-left: -40px;">WE ARE ONLY A PHONE CALL AWAY</h3>
	  </div>
	  <div style="margin-left: 200px; margin-top: 150px;">
	  
	  <h3 style="color: white;">Call Us:</h3>  
	  <h4 style="color: white;">4043541999</h4>   
	  <h4 style="color: white;">24 Hours a Day</h4>  
	  <h4 style="color: white;">7 Days a Week</h4>   </div>
<div style="margin-left: 680px;margin-top: -80px;color: white;">
<h3>Mail Us:</h3>
<h4>Business@giftsin.com</h4>
 <h4>Gifts in Internet Private Limited</h4>
 <h4>Huntsville,Texas.</h4>
  </div>
</div></div></div>

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