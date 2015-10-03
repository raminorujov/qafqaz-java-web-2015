package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

/**
 * Created by raminorujov on 9/26/15.
 */
@WebServlet(name = "SessionServlet", urlPatterns = {"/session"})
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        out.println("Session id = " + session.getId());
        out.println("Session creation time = " + new Date(session.getCreationTime()));
        out.println("Session last access time = " + new Date(session.getLastAccessedTime()));
        out.println("Session expiration period = " + session.getMaxInactiveInterval());


        if (request.getParameter("action") != null) {
            String action = request.getParameter("action");
            if (action.equals("logoff")) {
                session.invalidate();
            } else if (action.equals("remove") && request.getParameter("name") != null) {
                session.removeAttribute(request.getParameter("name"));
            } else if (action.equals("add") &&
                    request.getParameter("name") != null && request.getParameter("value") != null)
                session.setAttribute(request.getParameter("name"), request.getParameter("value"));
        }

        out.println("\nSession attributes");
        Enumeration<String> attributes = session.getAttributeNames();
        while(attributes.hasMoreElements()) {
            String name = attributes.nextElement();
            out.println( name + " = " + session.getAttribute(name));
        }
    }
}
