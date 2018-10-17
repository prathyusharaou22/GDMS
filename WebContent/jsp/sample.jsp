<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="addgift" method="post">
	
	
	Gift Type<select name="giftType">
	<option>--select--</option>
	<%
	
	List<String> gifttype=(List<String>)request.getAttribute("giftType");
	
	for(String s:gifttype)
	{
	%>
	
<option value=<%=s%>><%=s%></option>
<%} %>
	<option value="other">others</option>
	
	
	
	</select><br>
	description<input type="text" name="giftDiscription"/><br>
	
	<input type="text" name="otherType"/><a><br>
	
	occasionType<select name="occasion">
	<option>--select--</option>
	
	<%
	
	List<String> occasiontype=(List<String>)request.getAttribute("occasionType");
	for(String s:occasiontype)
	{
	%>
	
<option <%=s%>><%=s%></option>
	<%
	}
	%>
	<option value="other">other</option>
	
	
	</select><br>
	<input type="text" name="otherOcasion"/>
	
	Quatity<input type="text" name="quantity"/>
	
	Cost<input type="text" name="cost"/>
	
	<input type="submit" value="insert"/>
	
	<input type="hidden" name="add" value="add"/>
	</form>

</body>
</html>