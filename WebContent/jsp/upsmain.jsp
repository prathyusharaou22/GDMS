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
<script type="text/javascript">
function check(){
	var c=document.getElementById("book").value;
	var Exp = /^[0-9a-zA-Z]+$/; 
	if(c==""){
		document.getElementById("ownmer").innerHTML="Enter booking id";
		return false;
	}
	else if(!c.match(Exp)){
		document.getElementById("ownmer").innerHTML="Enter Only Alpha Numeric Values";
		return false;
	}
}
function clearSpan(elem){
    document.getElementById("ownmer").innerHTML=''; 
}
</script>
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
							<li style="margin-right: 320px;"><a href="/projectGDMS/jsp/contactus.jsp" class="menu">Contact
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
				<div style="font: italic; color: white;" align="center"><br/><br/><br/><br/><br/>
					<h1>Delivery Status</h1>
				</div>

				<div>
					<form action="../updatecontrol" method="post">
					<table align="center" style="margin-top: 80px" cellpadding="20">
							<tr align="center">
								<td align="justify"><font style="color: white;">Booking
										Id</font></td>
								<td><input style="background-color: #FAFAD2" type="text" id="book" name="bookid" onkeyup="clearSpan(ownmer)" />&nbsp;&nbsp;&nbsp;&nbsp;<span id="ownmer" style="color: red;"></span><br /></td>
								
								</tr>
								
						</table>
						<table align="center" cellpadding="20">
							<tr>
							 
								<td style="position: relative;"><input type="submit"
									value="Get Details" onclick="return check(this)" /></td>
								<td align="right"><input  type="reset" value="Reset" /></td>
							</tr>
						</table>
					<input type="hidden" name="book" value="book"/> 
					
					
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