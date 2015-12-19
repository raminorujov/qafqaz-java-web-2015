<%-- 
    Document   : list
    Created on : Nov 21, 2015, 12:10:25 PM
    Author     : student
--%>

<%@page import="java.util.List"%>
<%@page import="bookproject.domain.Publisher"%>
<%@page import="bookproject.web.WebConstants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Publisher list</title>
    </head>
    <body>
        <h1>Publisher list</h1>
        <%
            List<Publisher> list = (List<Publisher>)request.getAttribute(WebConstants.ATTR_PUBLISHER_LIST);
        %>
        
        <table border="1">
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Address</td>
                <td>Email</td>
                <td>Action</td>
            </tr>
            <%
                for(Publisher p : list) {
                %>
                <tr>
                    <td><%=p.getId()%></td>
                    <td><%=p.getName()%></td>
                    <td><%=p.getAddress()%></td>
                    <td><%=p.getEmail()%></td>
                    <td><a href="cs?action=viewPublisher&id=<%=p.getId()%>">View publisher</a></td>
                <tr/>
                <%
                }
            %>
        </table>
    </body>
</html>
