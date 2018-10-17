<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="customer" class="cts.gdms.vo.CustomerRegVO"
	scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="customer" />
<%
	response.sendRedirect("../customer");
%>
<%-- <jsp:forward page="/customer"></jsp:forward>--%>