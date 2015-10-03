<%--
  Created by IntelliJ IDEA.
  User: raminorujov
  Date: 10/3/15
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
  <%=session.getAttribute("message")%> <br/>

  <form action="login" method="post">
        Username: <input type="text" name="username"/> <br/>
        Password: <input type="password" name="password"/> <br/>
        <input type="submit" value="Login"/> &nbsp;
        <input type="reset" value="Clear"/>
  </form>
</body>
</html>
