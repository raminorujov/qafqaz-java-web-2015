package bookproject.web;

import bookproject.db.BookDatabaseHelper;
import bookproject.db.Database;
import bookproject.domain.Author;
import bookproject.domain.Book;
import bookproject.domain.Publisher;
import bookproject.web.action.BaseAction;
import bookproject.web.action.DefaultAction;
import bookproject.web.action.TestAction;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author student
 */
public class ControllerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String action = "";

        ArrayList<BaseAction> actionList = (ArrayList<BaseAction>) getServletContext().getAttribute("actionList");        
        BaseAction currentAction = null;
        
        try {
            // check action
            if (request.getParameter("action") != null) {
                action = request.getParameter("action").trim();
            } else {
                action = "default";
            }

            for (BaseAction a : actionList) {
                if (a.getName().equals(action)) {
                    currentAction = a;
                    System.out.println("Action = " + action + ", calling " + a.getClass().getSimpleName() + ".process()");
                    a.process(request, response);
                    break;
                }
            }

            // process redirect/forward logic
            if (currentAction.isForward()) {
                RequestDispatcher rd = request.getRequestDispatcher(currentAction.getPage());
                rd.forward(request, response);
            } else {
                response.sendRedirect(currentAction.getPage());
            }

        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
