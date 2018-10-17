<%@page import="cts.gdms.addgift.vo.AddGiftVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="addgift" class="cts.gdms.addgift.vo.AddGiftVO"></jsp:useBean>

<jsp:setProperty property="*" name="addgift"/>



<%

String giftType=(String)request.getParameter("giftType");

%>

gift type:<%= giftType%>

