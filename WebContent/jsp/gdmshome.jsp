<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1

-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TemplateWorld - Shape</title>
<link href="/projectGDMS/css/style.css" rel="stylesheet" type="text/css" />
<link rel="icon" href="images/icon.ico" />

<link rel="stylesheet" href="css/nivo-slider.css" media="screen" />


<script type="text/javascript">
	window.history.forward(1);
	function noBack()
  { 
  window.history.forward(); 
  }
</script>

</head>

<body onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">
	
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
							<li style="margin-right: 390px;"><a href="/projectGDMS/jsp/contactus.jsp" class="menu">Contact
									Us</a>
							</li>
							<li><a href="/projectGDMS/jsp/CustomerReg.jsp" class="menu">Registration</a>
							</li>
							<li><a href="/projectGDMS/jsp/Login.jsp" class="menu">Login</a>
							</li>
						</ul>
					</div>
				</div>

				<div id="headerrightblank">
					<div id="headernav">
						<ul>


						</ul>
					</div>
					<div></div>

					<div id="searchblank">
						<div id="searchinput">
							<form id="form1" name="form1" method="post" action="">
								<input name="textfield" type="text" class="searchinput"
									id="textfield" value="Enter 

				Search Items" />
							</form>
						</div>

					</div>
				</div>
				<div id="bannertxtblank"></div>

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
