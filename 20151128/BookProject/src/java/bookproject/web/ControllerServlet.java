/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookproject.web;

import bookproject.db.BookDatabaseHelper;
import bookproject.db.Database;
import bookproject.domain.Book;
import bookproject.domain.Publisher;
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
        String page = "";
        boolean forward = true;
        Database db = new Database();
        BookDatabaseHelper dbHelper = new BookDatabaseHelper(db);
        
        try {
            // check action
            if(request.getParameter("action") != null) {
                action = request.getParameter("action").trim();
            } else {
                action = "default";
            }
            
            // process action
            if(action.equals("test")) {
                page = "/WEB-INF/view/test.jsp";
                forward = true;
            } else if(action.equals("showPublisherList")) {
                // get publisher list from database
                List<Publisher> publisherList = dbHelper.getPublisherList();
                
                // save publisher list in request attribute
                request.setAttribute(WebConstants.ATTR_PUBLISHER_LIST, publisherList);
                                
                //page="/WEB-INF/view/publisher/list.jsp";
                page = WebConstants.PAGE_PUBLISHER_LIST;
                forward = true;
            } else if(action.equals("viewPublisher")) {
                int publisherId = 0;
                
                if(request.getParameter("id") != null) {
                    publisherId = Integer.parseInt(request.getParameter("id"));
                }
                
                Publisher publisher = dbHelper.getPublisher(publisherId);
                request.setAttribute("publisher", publisher);
                
                List<Book> bookList = dbHelper.getBookListByPublisher(publisherId);
                request.setAttribute("publisherBooks", bookList);
                
                page = "/WEB-INF/view/publisher/view.jsp";
                forward = true;                            
            } else { 
                // process default action
                page="index.jsp";
                forward = false;
            }
            
            
            // process redirect/forward logic
            if(forward) {
                RequestDispatcher rd = request.getRequestDispatcher(page);
                rd.forward(request, response);
            } else {
                response.sendRedirect(page);
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
