<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

 <script type="text/javascript"> 
        function submitform(form) { alert("ksdjfgksdj");  document.form.submit(); } 
   </script> 
</head>
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
          <li><a href="/projectGDMS/jsp/aboutus.jsp"  class="menu">About Us</a></li>
          <li style="margin-right: 320px;"><a href="#" class="menu">Contact Us</a></li>
          <li><h3 style="color: white;">Logged in as</h3></li>
									<%
									
									String type=(String)session.getAttribute("type");
									%>
							<li><h3 style="color:white; margin-left: 10px;"><%=type%>!</h3></li>
							<li><a href="/projectGDMS/jsp/signout.jsp" class="menu">Sign out</a></li>
        </ul>
       
      </div>
	  </div>
	 
	 <div style="margin-top: 160px; margin-left: 100px;">
	 <form action="/projectGDMS/gfs" name="bookgift" method="post">
	  <input type="submit" value="Book Gift" style="width: 200px;height: 100px;"/>
	  </form>
	  </div>
	  <div style="margin-left: 100px;margin-top: 2px;margin-top: -20px;">
	<input type="button" name="Check status" value="Check Status" onclick="window.location='/projectGDMS/jsp/checkstatushme.jsp';" style="width: 200px;height: 100px;"/>
	  
	  
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
