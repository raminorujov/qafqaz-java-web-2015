package authenticationdemo;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by raminorujov on 10/3/15.
 */
public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession();

        if(session.getAttribute("username") != null
                && session.getAttribute("username").equals("qalib")) {
            System.out.println("Qalib has access to admin page");
            chain.doFilter(request, response);
        } else {
            System.out.println("User " + session.getAttribute("username") + " does not have access to admin page");
            response.sendRedirect("accessDenied.jsp");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
