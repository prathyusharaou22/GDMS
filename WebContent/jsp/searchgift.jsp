<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1
-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TemplateWorld - Shape</title>
<link href="/projectGDMS/css/style1.css" rel="stylesheet" type="text/css"  />
<link rel="icon" href="images/icon.ico" /> 
<script src="../js/checkstatus.js"></script>
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
				<div>
   <form action="/projectGDMS/jsp/setsearchGift.jsp" method="post"> 
   <br>
   </br>
   <br>
   </br>
    <h2 align="center" style="color:white" >GIFT DELIVERY MANAGEMENT SYSTEM</h2>
    
   <br>
   </br>
   <br>
   </br>
   <br>
   </br>
   <br>
   </br>
   <table align="center">
         <tr>
                 <td>
                     <h3 align="center" style="color: white" style="height:35px; width:150px">GiftType</h3>
                 </td>  
                 <td>
                 </td>
            
           
                 <td>
                     <select style="height:35px; width:150px" style="background-color:#FAFAD2" name="giftType">
                     <option value=" ">--Select--</option>
              <%
       HttpSession session1=request.getSession();
       List<String> gll=(List<String>)session1.getAttribute("gifttypes");
         
         for(String gil:gll)
                      {
               %>
                     <option value="<%=gil%>"><%=gil%></option>
                 <%
                      }
                 %>
                  </select>
           </td>
   </tr>
   <tr>
   </tr>
   <tr></tr>
   <tr>
           <td>
   <h3 align="center" style="color:white" style="height:35px; width:150px">OccassionType</h3>
           </td>
           <td>
           </td>
           
          
    <td>
   <select style="height:35px; width:150px" style="background-color:#FAFAD2" name="occassionType" >
   <option value=" ">--Select--</option>
   <%
     List<String> gl2=(List<String>)session1.getAttribute("occasiontypes");
     for(String gil:gl2)
    {
   %>
   <option value="<%=gil%>"><%=gil%></option>
   <%
     }
   %>
   </select>
   </td>
   </tr>
   
   
   </table>
   
   <br>
   </br>
   <br>
   </br>
   <table align="center">
         <tr>
                     <td width="10px">
                     
                     <input  style="height:35px; width:150px" align="middle" type="submit" value="Search Gifts"/>
                     </td>
                     <td>
                     </td>
                     <td></td>
                      <td></td>
                      <td>
                     <input style="height:35px; width:150px" align="middle" type="reset" value="Reset"/>
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
					<a href="/projectGDMS/jsp/gdmshome.jsp" class="footerlinks">Home</a> | <a href="#"
						class="/projectGDMS/jsp/aboutus.jsp">About Us</a> | <a href="/projectGDMS/jsp/contactus.jsp" class="footerlinks">Contact
						Us</a>
				</div>
				<div id="copyrights">© GDMS. All Rights Reserved.</div>

			</div>
		</div>
	</div>
</body>
</html>
