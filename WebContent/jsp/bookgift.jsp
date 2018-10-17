
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*" %>
    <%@page import="java.util.*" %>
    <%@page import="java.text.SimpleDateFormat"%>
        <%@page import="cts.gdms.vo.SearchGiftVO" %>
    <%@ page import="cts.gdms.dao.GiftDAO" %>
    <%@ page import="cts.gdms.vo.BookVO"%>
<%@page import="cts.gdms.bo.GiftDetailsBO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1
-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TemplateWorld - Shape</title>
<link href="/projectGDMS/css/style1.css" rel="stylesheet" type="text/css"  />
<link rel="icon" href="images/icon.ico" /> 
<script src="../js/checkstatus.js"></script>
<script src="/projectGDMS/js/giftbook.js"></script>
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



<div>
<br>
</br>
<br>
</br>
<h2 align="center" style="color:white">GIFT DELIVERY MANAGEMENT SYSTEM</h2>
<br>
</br>
<br>
</br>
<br>
</br>



<%
	BookVO bvo=(BookVO)request.getAttribute("bvo");
    String subid=(String)request.getAttribute("subid");
%>

 
 <form action="/projectGDMS/jsp/setbookgift.jsp" method="get">
 <table align="center">
 <tr>
 <td>
 <h3 style="color:white">
 Gift Sub-ID
 </h3>
 </td>
 <td>
  <input align="middle" style="background-color:#FAFAD2" type="text" name="subid" value="<%=subid%>" readonly="readonly"/>
 </td>
 <td>
 </td>
   </tr>
   <tr>
   <td>
   <h3 style="color:white">
   Cost of Gift
   </h3>
   </td>
   <td>
   <input align="middle" style="background-color:#FAFAD2" type="text" name="cost" value="<%=bvo.getCost()%>" readonly="readonly"/>
   </td>
   <td></td>
   </tr>
   <tr>
   <td>
   <h3 style="color:white">
 Available Quantity
 </h3>
 </td>
 <td>
  <input align="middle" style="background-color:#FAFAD2" type="text" id="avail" value="<%=bvo.getAmount()%>" readonly="readonly" />
  </td>
  <td></td>
  </tr>
  <tr>
  <td>
  <h3 style="color:white">
 Number of Quantity Required
 </h3>
 </td>
 <td>
 <input type="text" style="background-color:#FAFAD2" name="noofQuant" id="req" onblur="return quant();" onkeyup="clearspan1()"/>
 </td>
 <td width=300>
 <span id="noquant" style="color: white" ></span>
 </td>
 </tr>
 <tr>
 <td>
 <%  if(bvo.getAmount()>0) {%>
<h3 style="color:white">
 In Stock/Out of Stock
 </h3>
 </td>
 <td><input style="background-color:#FAFAD2" type="text" value="instock" readonly="readonly"/>
 </td>
 </tr>
 <%
 }
 else
 {
 %>
 <tr>
 <td>
 <h3 style="color:white">
 In Stock/Out of Stock
 </h3>
 </td>
 <td>
 <input type="text" style="background-color:#FAFAD2" value="out of stock" id="out of stock" readonly="readonly"/>
 </td>
</tr>
 <%
}
 %>
 </tr>
 <tr>
 <td align="justify">
 <h3 style="color:white">
To-Address
</h3>
</td>
<td>
 
 <textarea  style="background-color:#FAFAD2" name="toAddress" id="toAddress" onblur="return validaddress();" onkeyup="clearspan2()"
								rows="3" cols="16"></textarea>
 
 </td>
 <td>
 <span id="add" style="color: white"></span>
 </td>

 </tr>
 <tr>
 <td>
 <h3 style="color:white">
Expected Date of Delivery 
</h3>
</td>
<td>
<% Date d1;
Calendar cal=new GregorianCalendar();
cal.add(Calendar.DATE,3);
d1=cal.getTime();
SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
String sdate=sdf.format(d1);

%>
 <input align="middle" style="background-color:#FAFAD2" type="text" value="<%=sdate%>"  name="expDateofDel" readonly="readonly"/>
 </td>
 <td>
 </td>
 </tr>
 <tr>
 <td>
 <h3 style="color:white">
Phone-Number
</h3>
</td>
<td>
 <input align="middle" type="text" style="background-color:#FAFAD2" name="phoneNo" id="phoneNo" onblur="return validphone();" onkeyup="clearspan1()"/>
 </td>
 <td>
 <span id="phne" style="color: white"></span>
 </td>
 </tr>
 <tr>
 </tr>
 <tr>
 </tr>



 <tr>
 </tr>
</table>
<br>
</br>
<br>
</br>
<table align="center">
 
 <tr>
 <td>
 <input style="height:35px; width:150px" type="submit" value="Book Gift" id="submit" onclick="return vaildformm();"/>
 </td>
 <td>
 </td>
 <td>
 </td>
 <td>
 
 </td>
<td>
</td>
<td>

</td>
 <td>
 <input style="height:35px; width:150px" type="reset"  value="Reset"/>
 </td>
 </tr>
 </table>
 
 </form>
 
 </div>
 </div>
		</div>
	</div>

	<div id="footerbg">
		<div id="footerblank">
			<div id="footer">
				<div id="footerlinks">
					<a href="/projectGDMS/jsp/gdmshome.jsp" class="footerlinks">Home</a> | <a href="/projectGDMS/jsp/aboutus.jsp"
						class="footerlinks">About Us</a> | <a href="/projectGDMS/jsp/contactus.jsp" class="footerlinks">Contact
						Us</a>
				</div>
				<div id="copyrights">© GDMS. All Rights Reserved.</div>

			</div>
		</div>
	</div>
		
	 
</body>
</html>
     
         