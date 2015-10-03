<%--
  Created by IntelliJ IDEA.
  User: raminorujov
  Date: 10/3/15
  Time: 12:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Access Denied</title>
</head>
<body>
  Sorry, <%=session.getAttribute("username")%> doesn't have access to admin page. <br/>
  Please, apply to application administrator.
</body>
</html>
