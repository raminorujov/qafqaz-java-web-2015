<%-- 
    Document   : login
    Created on : Dec 12, 2015, 11:48:29 AM
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Please, enter user and password</h1>
        
        <form action="cs?action=login" method="post">
            User: <input type="text" name="username"/> <br/>
            Password: <input type="password" name="password"/> <br/>
            Role: <select name="role">
                <option value="1">Admin</option>
                <option value="2">Operator</option>
                <option value="3" selected="true">User</option>                
            </select> <br/>
            
            <p>
            <input type="submit" name="login" value="Login"/> &nbsp;
            <input type="reset" name="clear" value="Clear"/> &nbsp; <br/>
            </p>
            
            <a href="cs?action=register">Register</a> &nbsp;
            <a href="cs?action=forgotPassword">Forgot Password?</a>
            
        </form>
    </body>
</html>
