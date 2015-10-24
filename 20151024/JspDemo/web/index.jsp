<%--
  Created by IntelliJ IDEA.
  User: raminorujov
  Date: 10/24/15
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title></title>
  </head>
  <body>
        <!-- HTML comment -->
        <%--JSP comment --%>

  <%!
    int a = 5;

    int sum(int a, int b) {
        return a + b;
    }
  %>

  <%
    int a = sum(5,8);
  %>

  <%= a %> <br/>

  <%= sum(9,10) %>

        <p>
  <%
    if(4 > 2) {
        out.println("block 1");
    } else {
        out.println("block 2");
    }
  %>
  </p>

  <%if(4 > 2) {%>
     block 1
  <%} else {%>
        block 2
  <%}%>

  <c:if test="${4 > 2}">
      html block 1
  </c:if>

  <c:choose>
      <c:when test="${4 > 2}">
          4 > 2
      </c:when>
      <c:when test="${4 == 2}">
          4 = 2
      </c:when>
      <c:otherwise>
          4 < 2
      </c:otherwise>
  </c:choose>

  </body>
</html>
