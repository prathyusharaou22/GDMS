<%@page import="java.text.SimpleDateFormat"%>
<%@page import="cts.gdms.vo.UpdateBokkingVo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
 
            body {font-family:Arial, Sans-Serif;}
 
            #container {width:550px; margin:0 auto;}
 
            /* Nicely lines up the labels. */
            form label {display:inline-block; width:140px;}
 
            /* You could add a class to all the input boxes instead, if you like. That would be safer, and more backwards-compatible */
            form input[type="text"],
            form input[type="password"],
            form input[type="email"] {width:160px;}
 
            form .line {clear:both;}
            form .line.submit {text-align:right;}
 
        </style>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/projectGDMS/css/style1.css" rel="stylesheet"
	type="text/css" />
<link rel="icon" href="images/icon.ico" />

<link rel="stylesheet" href="/projectGDMS/css/jquery-ui.custom.css" />
<link rel="stylesheet" href="/projectGDMS/css/jquery-ui.custom.min.css" />
<script src="/projectGDMS/js/jquery.js"></script>
<script src="/projectGDMS/js/jquery-ui.custom.min.js"></script>
<script src="/projectGDMS/js/jquery-ui.custom.js"></script>
<script type="text/javascript">
	$(function() { 
		$( "#datepicker" ).datepicker(); 
	});	
</script>
<title>Insert title here</title>

<script src="/projectGDMS/js/update.js"></script>
 <!-- <script type="text/javascript">
 var retval=true;
 function mandate()
 {
	var value1=document.display.deliveryStatus.value;
 	var bdt=display.bdate.value;
 	/* alert(display.bdate.value); */
 	//var bdt1=bdt.substring(0,4)+"/"+bdt.substring(5,7)+"/"+bdt.substring(8,10);
 	var bdt2=new Date(bdt);
 	var adt=new Date(document.getElementById('datepicker').value);
 	var adt1=document.getElementById("datepicker").value;
 	/* alert(adt); */
 	if(adt1==""){
 		document.getElementById('delmsg2').innerHTML="date should not be empty";
 		return false;
 	}
 	if(adt<bdt2){
 		document.getElementById('delmsg2').innerHTML="should be greater than booking date";
 		return false;
 	} 
 	if(value1=="" || value1==null){
 		document.getElementById('delmsg1').innerHTML="should not be empty";
 		return false;
 	}
 	if(value1.length<10)
	{
	document.getElementById('delmsg1').innerHTML="Should be more than ten characters";
	return false;
	}
 	if(retval!=false)
	{
	retval=true;
	}
 	
 	return retval;
 		 
 	//return false;
 }
 function clearSpan(elem){
	    document.getElementById("delmsg1").innerHTML=''; 
	}
 function clearSpan(elem){
	    document.getElementById("delmsg2").innerHTML=''; 
	}
 
</script>  
 --><!-- <script type="text/javascript">

function checkSize()
{
	
	var value=form.deliveryStatus.value;
	
	if(value.length<10)
		{
		document.getElementById('delmsg1').innerHTML="Enter more than ten characters";
		form.deliveryStatus.focus();
		return false;
		}else
			{
			return true;
			}	
}
</script> -->  
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
				</div><br/>
				<div style="font: italic; color: white;" align="center"><br/><br/><br/><br/>
					<h1>Update Delivery Status</h1>
				</div><br/>
<%
	UpdateBokkingVo bookingVo=(UpdateBokkingVo)session.getAttribute("bookvo");
session.setAttribute("bookingid",bookingVo.getBookingId());
%>

<div id="container">

<form action="updatecontrol" method="post" name="display" onsubmit="return mandate();" >


<div class="line" align="left"><label for="bi" style="color: white;"  >BookingId: </label><input style="background-color: #FAFAD2" type="text" id="bi" name="bookingId" value="<%=bookingVo.getBookingId()%>" readonly="readonly"></div><br/>
<div class="line" align="left"><label for="da" style="color: white;">Dispatch Address:</label><input style="background-color: #FAFAD2" type="text" id="da" name="toAddress" value="<%=bookingVo.getToAddress()%>" readonly="readonly" ></div><br/>
<div class="line" align="left"><label for="cn" style="color: white;">Contact No:</label><input style="background-color: #FAFAD2" type="text" id="cn" name="phoneno" value="<%=bookingVo.getPhoneno()%>" readonly="readonly"></div><br/>
<div class="line" align="left"><label for="edn" style="color: white;">Expected Date:</label><input style="background-color: #FAFAD2" type="text" id="edn"  name="expectedDateOfDelivery" value="<%=bookingVo.getExpectedDateOfDelivery()%>" readonly="readonly"></div><br/>

<%
SimpleDateFormat odate=new SimpleDateFormat("dd-MMM-yyyy");
SimpleDateFormat rdate=new SimpleDateFormat("yyyy/MM/dd");
java.util.Date date1=odate.parse(bookingVo.getBookingDate());
String bookdate=rdate.format(date1);
%>
<div class="line" align="left"><label for="bookdate" style="color: white;">Booking Date:</label><input style="background-color: #FAFAD2" id="bookdate" type="text"  name="bdate" value="<%=bookdate%>" readonly="readonly"></div><br/> 
<div class="line" align="left"><label for="ds" style="color: white;">Delivery Status*:</label><input style="background-color: #FAFAD2" type="text" id="ds"   name="deliveryStatus" value="<%=bookingVo.getDeliveryStatus()%>" onkeyup="clearSpan(delmsg1)"><span id="delmsg1" style="color: red"></span><br/></div><br/>
<span id="delmsg1" style="color: white"></span>
<div class="line" align="left"><label for="datepicker" style="color: white;">Actual Date*:</label><input style="background-color: #FAFAD2" class="TextBox" type="text" name="actualDateOfDelivery" id="datepicker" value="" onkeyup="clearSpan(delmsg2)" ><span id="delmsg2" style="color: red"></span></div> <br/><br/><br/>
<!-- <span id="delmsg2" style="color: white"></span> -->
<input type="hidden" name="update" value="update"/>
<!-- <div class="line submit" style="position: relative;" > -->&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" value="Update" /><!-- </div> -->&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<!-- <div class="line reset" > --><input type="reset" value="Reset"><!-- </div> --><br/>
<!--onclick="return dateValidate(this.form)"  -->
<p style="color: white;">Note: Please make sure your details are correct before submitting form and that all fields marked with * are completed!.</p>

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