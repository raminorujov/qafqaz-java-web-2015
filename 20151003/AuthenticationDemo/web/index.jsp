<%--
  Created by IntelliJ IDEA.
  User: raminorujov
  Date: 10/3/15
  Time: 10:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Main page</title>
  </head>
  <body>
        Welcome, <%=session.getAttribute("username")%> <br/>
        You're logged in <%=session.getAttribute("loginTime")%> <br/>
        Remote addr: <%=request.getRemoteAddr()%> <br/>
        Remote host: <%=request.getRemoteHost()%> <br/>

        <a href="logout">Logout</a>
  </body>
</html>
