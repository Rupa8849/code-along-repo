<%-- 
    Document   : mastertask
    Created on : Jun 23, 2023, 1:04:24 AM
    Author     : dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%@page import="java.sql.ResultSet"%>--%>

<c:if test="${process eq 'insertstudents'}">
    <input type="hidden" id="status" value="${status}">
    
</c:if>
    
<c:if test="${process eq 'updatestudents'}">
    <input type="text" id="update" value="${result}">
    <%-- 
        out.print(request.getAttribute("result"));
    --%>
</c:if>
        
<div id="deleteInput"></div> 



