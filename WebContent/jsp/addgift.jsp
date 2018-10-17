<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1

-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>TemplateWorld - Shape</title>
<link href="/projectGDMS/css/style1.css" rel="stylesheet"
	type="text/css" />
<link rel="icon" href="images/icon.ico" />
<script type="text/javascript" src="/projectGDMS/js/addgift.js""></script>
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

					<div><h2 style="color:white;margin-top: 85px;" align="center">Add New Gift</h2></div>

				<div style="margin-left: 300px;margin-right: 10px;">
				
					<form id="form1" name="form1" method="post" action="/projectGDMS/addgift">
						<table align="center" style="margin-top: 80px">
							<tr id="oTypeRow">
								<td><font style="color: white;">Gift Type</font>
								</td>
								<td><select name="giftType" onchange="visible1();" onfocus="clearSpan('giftType1')">

										<option value="--select--">--select--</option>
										<%
											List<String> gifttype = (List<String>) request.getAttribute("giftType");

											for (String s : gifttype) {
										%>
										<option value=<%=s%>><%=s%></option>

										<%
											}
										%>
										<option value="other">others</option>

								</select></td>
								<td width=300><span id="giftType1" style="color: white"></span></td>
							</tr>
							<tr><td></td><td></td></tr>
							<tr><td></td><td></td></tr>
							<tr id="Type" >
								<td><font style="color: white;"><label id="otherlbl" style="display:none;">New Type</label></font></td>
								<td><input type="text" name="otherType" style="display: none;" onkeyup="return ischar(this)" onkeypress="clearSpan('otherType1')"/></td>
								<td width=300><span id="otherType1" style="color: red"></span></td>
								
								
							</tr>	
							<tr><td></td><td></td></tr>
							<tr><td></td><td></td></tr>						
							<tr>
								<td><font style="color: white;">Description</font>
								</td>
								<td><input type="text" name="giftDescription" onfocus="clearSpan('giftDescription1')" /><br />
								</td>
								<td width=300><span id="giftDescription1" style="color: red"></span></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td><font style="color: white;">OccasionType</font>
								</td>
								<td><select name="occasion" onchange="visible2();" onfocus="clearSpan('occasion1')">
										<option  value="--select--">--select--</option>

										<%
											List<String> occasiontype = (List<String>) request.getAttribute("occasionType");
											for (String s : occasiontype) {
										%>
										<option value=<%=s%>><%=s%></option>

										<%
											}
										%>

										<option value="other">other</option>
								</select>
								</td>
								<td width=300><span id="occasion1" style="color: red"></span></td>
							</tr>
							<tr><td></td><td></td></tr>
							<tr><td></td><td></td></tr>
							<tr id="occasion1">
								<td><font style="color: white;"><label id="otherlb2" style="display: none;">New Occasion</label></font></td>
								<td><input type="text" name="otherOcasion" style="display: none;" onkeyup="return ischar1(this)" onkeypress="clearSpan('otherOcasion1')" />
								</td>
								<td width=300><span id="otherOcasion1" style="color: red"></span></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr><td></td><td></td></tr>
							<tr>
								<td><font style="color: white;">Quantity</font>
								</td>
								<td><input type="text" name="quantity"  onkeypress="clearSpan('quantity1')" onkeyup="isNumeric1(this)" />
								</td>
								<td width=300><span id="quantity1" style="color: red"></span></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr><td></td><td></td></tr>
							<tr>
								<td><font style="color: white;" >Cost</font>
								</td>
								<td><input type="text" name="cost" onkeypress="clearSpan('cost1')" onkeyup="isNumeric2(this)"/>
								</td>
								<td width=300><span id="cost1" style="color: red"></span></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr><td></td><td></td></tr>
							
							</table>
							<div style="margin-left: 100px;margin-top: 20px;"><table>
							
							<tr>
								<td width=100 align="center"><input type="submit" value="Update" onclick="return formvalidation()"/>
								</td>
								<td width=100 align="center"><input type="reset" value="clear" />
								</td>
								<td><input type="button" name="back" value="back" onclick="window.location='/projectGDMS/jsp/cradminpage.jsp';"/></td>
							</tr>
							</table></div>

						<input type="hidden" name="add" value="add" />

					</form>
				</div>
				<div style="margin-top: 80px;margin-left: 700px;">
				
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