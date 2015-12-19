<%-- 
    Document   : add
    Created on : Dec 19, 2015, 10:18:45 AM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new publisher</title>
    </head>
    <body>
        <h1>Please, enter publisher details!</h1>

        <c:if test="${not empty requestScope.errorList}">
            <p>
                Please, fix the following error(s): <br/>
                <c:forEach items="${requestScope.errorList}" var="error">
                    ${error} <br/>
                </c:forEach>
            </p>
        </c:if>

        <form action="cs?action=savePublisher" method="post">
            Name: <input type="text" name="name" value="${param.name}"/> <br/>
            Address: <input type="text" name="address" value="${param.address}"/> <br/>
            Email: <input type="text" name="email" value="${param.email}"/> <br/>

            <input type="submit" name="save" value="Save"/> &nbsp;
            <input type="reset" name="clear" value="Clear"/>
        </form>

        <a href="cs?action=viewPublisherList">Return to publisher list</a>
    </body>
</html>
