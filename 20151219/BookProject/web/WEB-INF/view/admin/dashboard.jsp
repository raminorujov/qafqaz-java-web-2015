<%-- 
    Document   : dashboard
    Created on : Dec 12, 2015, 11:56:05 AM
    Author     : student
--%>

<%@page import="bookproject.web.WebConstants"%>
<%@page import="bookproject.domain.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h1>Hello, <%=((User)session.getAttribute(WebConstants.ATTR_USER)).getName()%>!</h1>
        
        <h1>Welcome, ${sessionScope.user.name}!</h1>
        
        <p>
            User: ${sessionScope.user.username} <br/>
            Login time: <fmt:formatDate type="both" value="${sessionScope.loginTime}"/> <br/>
            Login time: <fmt:formatDate pattern="dd.MM.yyyy HH:mm:ss" value="${sessionScope.loginTime}"/> <br/>
        </p>
        
        <a href="cs?action=logout">Logout</a> <br/>        
        
        <a href="cs?action=showPublisherList">Show Publisher list</a>
    </body>
</html>
