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
        <title>Author Page</title>
    </head>
    <body>
        <h1>Author info page</h1>

        <c:choose>
            <c:when test="${!empty requestScope.author}">
                <table>
                    <tr>
                        <td>
                            Name
                        </td>
                        <td>
                            ${requestScope.author.name}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Surname
                        </td>
                        <td>
                            ${requestScope.author.surname}
                        </td>
                    </tr>
                                    
                    <tr>
                        <td>
                            About
                        </td>
                        <td>
                            ${requestScope.author.about}
                        </td>
                    </tr>
                                     
                    <tr>
                        <td>
                            Email
                        </td>
                        <td>
                            ${requestScope.author.email}
                        </td>
                    </tr>
                </table>
        </c:when>
        <c:otherwise>
            <p>Author not found</p>  
        </c:otherwise>

    </c:choose>

</body>
</html>
