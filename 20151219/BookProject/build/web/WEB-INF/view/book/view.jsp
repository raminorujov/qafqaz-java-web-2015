<%-- 
    Document   : view
    Created on : Dec 5, 2015, 10:06:13 AM
    Author     : student
--%>

<%@page import="bookproject.domain.Author"%>
<%@page import="bookproject.domain.Book"%>
<%@page import="bookproject.web.WebConstants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Page</title>
    </head>
    <body>
        <h1>Book info page</h1>

        <%
            Book book = (Book) request.getAttribute(WebConstants.ATTR_BOOK);
        %>

        <%
            if (book != null) {
        %>
        <table border="1">
            <tr>
                <td>Id</td><td><%=book.getId()%></td>
            </tr>
            <tr>    
                <td>Title</td><td><%=book.getTitle()%></td>
            </tr>
            <tr>
                <td>Price</td><td><%=book.getPrice()%></td>
            </tr>
            <tr>
                <td>Page count</td><td><%=book.getPageCount()%></td>
            </tr>
            <tr>
                <td>Description</td><td><%=book.getDescription()%></td>
            </tr>
            <tr>   
                <td>Publish date</td><td><%=book.getPublishDate()%></td>
            </tr>
            <tr>
                <td>Publisher</td>
                <td>
                    <a href="cs?action=viewPublisher&id=<%=book.getPublisher().getId()%>"> <%=book.getPublisher().getName()%> </a>
                </td>
            </tr>
            <tr>
                <td>Authors</td>
                <td>
                    <%
                        for (Author a : book.getAuthorList()) {
                    %>
                    <a href="cs?action=viewAuthor&id=<%=a.getId()%>"> <%=a.getName()%> &nbsp; <%=a.getSurname()%>  </a> &nbsp;                            
                    <% }

                    %>
                </td>
            </tr>      

        </tr>              
    </table>       

    <% } else {
    %>

    <p>Book not found</p>
    <%
        }
    %>
</body>
</html>
