<%-- 
    Document   : view
    Created on : Nov 28, 2015, 12:00:34 PM
    Author     : student
--%>

<%@page import="java.util.List"%>
<%@page import="bookproject.domain.Book"%>
<%@page import="bookproject.domain.Publisher"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Publisher profile</title>
    </head>
    <body>
        <h1>Publisher profile</h1>
        
        <% Publisher publisher = (Publisher)request.getAttribute("publisher");%>
        
        
        <%if(publisher != null) {%>
            <table border="1">
                <tr>
                    <td>Publisher id</td>
                    <td><%=publisher.getId()%></td>
                </tr>
                <tr>
                    <td>Publisher name</td>
                    <td><%=publisher.getName()%></td>
                </tr>
                <tr>
                    <td>Publisher address</td>
                    <td><%=publisher.getAddress()%></td>
                </tr>
                <tr>
                    <td>Publisher email</td>
                    <td><%=publisher.getEmail()%></td>
                </tr>                        
            </table>

                <p>     
                    <a href="cs?action=showPublisherList">Publisher list</a>
                </p>

            <%
                List<Book> list = (List<Book>)request.getAttribute("publisherBooks");
            %>
            

            <table border="1">
                <tr>
                    <td>Id</td>
                    <td>Title</td>
                    <td>Price</td>
                    <td>Page count</td>
                    <td>Action</td>
                </tr>
                <%
                    for(Book p : list) {
                    %>
                    <tr>
                        <td><%=p.getId()%></td>
                        <td><%=p.getTitle()%></td>
                        <td><%=p.getPrice()%></td>
                        <td><%=p.getPageCount()%></td>
                        <td><a href="cs?action=viewBook&id=<%=p.getId()%>">View book</a></td>
                    <tr/>
                    <%
                    }
                %>
            </table>
       
        
        <%} else {%>
            <p>Publisher not found</p>
        <%}%>
       
    </body>
</html>
