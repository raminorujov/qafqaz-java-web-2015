package authenticationdemo;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by raminorujov on 10/3/15.
 */
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession();
        if(session.getAttribute("username") != null && session.getAttribute("loginTime") != null) {
            System.out.println("User " + session.getAttribute("username") + " is authenticated, allow processing.");
            chain.doFilter(request, response);
        } else {
            System.out.println("User is not authenticated, redirect to login page");
            response.sendRedirect("login.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
