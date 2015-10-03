package authenticationdemo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * Created by raminorujov on 10/3/15.
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = "";
        String password = "";

        if(request.getParameter("username") != null) {
            username = request.getParameter("username").trim();
        }

        if(request.getParameter("password") != null) {
            password = request.getParameter("password").trim();
        }

        if(username != null && !username.isEmpty() &&
                password != null && !password.isEmpty()) {
            // check user password in database
            /*
            *   qalib - 123
            *   baloglan - asrafov
            *   viktor - parol
            * */

            HttpSession session = request.getSession();
            if( (username.equals("qalib") && password.equals("123"))
                || (username.equals("baloglan") && password.equals("asrafov"))
                || (username.equals("viktor") && password.equals("parol"))
            ) {
                System.out.println("User " + username + " successfully logged in.");
                session.setAttribute("username", username);
                session.setAttribute("loginTime", new Date());
                response.sendRedirect("index.jsp");
            } else {
                System.out.println("Username or password is invalid, redirect to login page.");
                session.setAttribute("message", "Username or password is invalid");
                response.sendRedirect("login.jsp");
            }

        } else {
            // username or password is empty
            response.sendRedirect("login.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }


}
