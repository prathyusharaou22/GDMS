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
									if(type==null){
										type="";
									}
									%>
							<li><h3 style="color:white; margin-left: 10px;"><%=type%>!</h3></li>
							<li><a href="/projectGDMS/jsp/signout.jsp" class="menu">Sign out</a></li>
        </ul>
      </div>
	  </div>
	  <br>
	  <br>
	  <br>
	  <h2 align="center" style="padding-top: 20px;padding-bottom: 30px"><font color="white">ABOUT US</font></h2>
	  <p style="color: white;margin-left: 80px;margin-right: 80px;margin-bottom: 30px" align="justify" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"Giftsin" is a leading destination for online Gift Delivery Store in India, offering the best 

prices and a complete hassle-free experience with options of paying through Cash on Delivery,Processed 

through secure and trusted gateways. Now shop for your favorite books,lifestyle accessories, toys, 

sports, Cakes, Chocolates, Cards, Idols, Watches, Toys & PhotoFrames, mobile phones, cameras and 

products from a host of other categories available. Some of the top selling electronic brands on the 

website are Samsung, HTC, Nokia, Sony, Canon, Nikon, Philips.</p>
<p style="color:white;margin-left: 80px;margin-right: 80px" align="justify">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;We Also Do Express Delivery of Flowers, Cakes, Sweets & Chocolates at Over 150 Locations all over India. We are committed to delivering the 

best online shopping experience imaginable. Browse through our cool lifestyle accessories featured on 

our site with expert descriptions to help you arrive at the right buying decision. "Giftsin" also 

offers free home delivery for many of our products. Get the best prices and the best online shopping 

experience every time.</p></div></div></div>

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