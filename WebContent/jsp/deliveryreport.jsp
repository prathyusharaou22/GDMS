<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="/projectGDMS/css/style1.css" rel="stylesheet" type="text/css" />
<link rel="icon" href="images/icon.ico" />
<link rel="stylesheet" href="/projectGDMS/css/jquery-ui.custom.css" />
<link rel="stylesheet" href="/projectGDMS/css/jquery-ui.custom.min.css" />
<script src="/projectGDMS/js/jquery.js"></script>
<script src="/projectGDMS/js/jquery-ui.custom.min.js"></script>
<script src="/projectGDMS/js/test.js" ></script> 
<script src="/projectGDMS/js/jquery-ui.custom.js"></script>
<script type="text/javascript">

	$(function() { $( "#datepicker" ).datepicker();});
	$(function() {$( "#datepicker1" ).datepicker();});
	
	
</script>
<!-- <!-- <title>jQuery UI Datepicker - Default functionality</title> 
 <link rel="stylesheet" href="/projectGDMS/WebContent/js/jquery-ui-date.css"/> 
 
  <script src="/projectGDMS/js/jquery-1.9.1.js"></script> 
   <script src="/projectGDMS/js/jquery-ui.js"></script>  
   <script src="/projectGDMS/test.js" ></script> 
   <link rel="stylesheet" href="/resources/demos/style.css" />  <script>  
   $(function() {    $( "#datepicker" ).datepicker();  }); 
   $(function() {    $( "#datepicker1" ).datepicker();  });
   </script> -->
 
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
							<li style="margin-right: 320px;"><a href="#" class="menu">Contact
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
	  
	  <div style="margin-top: 60px">
	   <h1 align="center"><font color="white">GIFT DELIVERY REPORTS</font></h1>
	  <div style="margin-top: 100px">
	  <form action="../dreportcontroller" onsubmit="return equalValidate(this)" method="post">
	  
<br>
<br>
<br>
<div style="margin-left: 200px;">
<table align="center" >

	<tr >
	 
<td class="tabletxt1" align="center"><font color="white" >  From Date </font> </td> 
<td> <input class="TextBox"  type="text"  style="background-color:#FAFAD2" name="fromDate" id="datepicker"  value="" onchange="return dateValidate1(this)" onkeyup="clearspan(this)"/></td>


 
</tr>
<tr><td></td><td> <span id="tdate" style="color:red; margin-right: 20px;" ></span></td></tr>
<tr >


<td class="tabletxt1" align="center"> <font color="white">  To Date </font> </td>
<td> <input class="TextBox"  type="text" style="background-color:#FAFAD2" name="toDate" id="datepicker1" value=""  onchange="return dateValidate1(this)" onkeyup="clearspan(this)" />
</td>

</tr>
<tr>

<tr></tr><tr></tr>
<tr>


</table></div>
<div style="margin-left: 300px;">
<table align="center" style="margin-left: 10px"><tr>
<td align="right"><input class="button3" type="submit" value="GetReports"  onclick="return notEmpty(this)" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input class="button3" type="button" value=" Reset "  " onclick="ClearTextboxes()"></td>

<td><input type="button" name="Back" value="Back" onclick="window.location='/projectGDMS/jsp/dradminreports.jsp';"/> </td>
</tr>

</table>
</div>
</form>
	  
	  </div>
	  
	  <div style="margin-left: 800px;margin-right: 10px;margin-top: 40px;">
	  
	  </div>
     </div></div></div></div>
        
        
      
     

<div id="footerbg">
  <div id="footerblank">
    <div id="footer">
      <div id="footerlinks"><a href="#" class="footerlinks">Home</a> | <a href="#" 

class="footerlinks">About Us</a> | <a href="#" class="footerlinks">Contact Us</a> </div>
      <div id="copyrights">© GDMS. All Rights Reserved.</div>
      
    </div>
  </div>
</div>
</body>
</html>
