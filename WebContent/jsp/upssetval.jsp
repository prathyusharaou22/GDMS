<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <jsp:useBean id="update" class="cts.gdms.vo.UpdateBokkingVo" scope="session"></jsp:useBean>
    <jsp:setProperty property="*" name="update"/>
    
    <%
    response.sendRedirect("../updatecontrol");
    
    %>