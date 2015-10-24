<%--
  Created by IntelliJ IDEA.
  User: raminorujov
  Date: 10/24/15
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" %>
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


  </body>
</html>
