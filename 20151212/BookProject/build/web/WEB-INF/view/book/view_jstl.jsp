<%-- 
    Document   : view
    Created on : Dec 5, 2015, 10:06:13 AM
    Author     : student
--%>

<%@page import="bookproject.domain.Author"%>
<%@page import="bookproject.domain.Book"%>
<%@page import="bookproject.web.WebConstants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Page</title>
    </head>
    <body>
        <h1>Book info page</h1>

        <c:choose>
            <c:when test="${!empty requestScope.book}">
                <table border="1">
                    <tr>
                        <td>Id</td><td>${book.id}</td>
                    </tr>
                    <tr>    
                        <td>Title</td><td>${book.title}</td>
                    </tr>
                    <tr>
                        <td>Price</td><td>${book.price}</td>
                    </tr>
                    <tr>
                        <td>Page count</td><td>${book.pageCount}</td>
                    </tr>
                    <tr>
                        <td>Description</td><td>${book.description}</td>
                    </tr>
                    <tr>   
                        <td>Publish date</td><td>${book.publishDate}</td>
                    </tr>
                    <tr>
                        <td>Publisher</td>
                        <td>
                            <a href="cs?action=viewPublisher&id=${book.publisher.id}"> ${book.publisher.name} </a>
                        </td>
                    </tr>
                    <tr>
                        <td>Authors</td>
                        <td>
                            <c:forEach items="${book.authorList}" var="a">
                               <a href="cs?action=viewAuthor&id=${a.id}"> ${a.name} &nbsp; ${a.surname} </a> &nbsp;
                            </c:forEach>                                                      
                        </td>
                    </tr>      

                </tr>              
            </table>  
        </c:when>
        <c:otherwise>
            <p>Book not found</p>  
        </c:otherwise>

    </c:choose>

</body>
</html>
