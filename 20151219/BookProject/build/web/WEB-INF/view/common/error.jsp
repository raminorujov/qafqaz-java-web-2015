<%-- 
    Document   : error
    Created on : Dec 5, 2015, 9:36:58 AM
    Author     : student
--%>

<%@page import="java.util.List"%>
<%@page import="bookproject.web.WebConstants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1>Errors</h1>
        
         <%
            List<String> list = (List<String>)request.getAttribute(WebConstants.ATTR_ERROR_LIST);
        %>
        
       <% for(String error : list) {
           %>
           <p><%=error%></p>           
            <% 
            }      
            %>
    </body>
</html>
