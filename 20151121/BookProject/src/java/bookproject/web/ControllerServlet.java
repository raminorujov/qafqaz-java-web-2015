/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookproject.web;

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
                Publisher p1 = new Publisher(1, "Apress", "USA", "San Francisco");
                Publisher p2 = new Publisher(2, "Oxford Press", "UK", "London");
                Publisher p3 = new Publisher(3, "OReilly", "USA", "New York");
                List<Publisher> publisherList = new ArrayList<Publisher>();
                publisherList.add(p1);
                publisherList.add(p2);
                publisherList.add(p3);
                
                // save publisher list in request attribute
                request.setAttribute(WebConstants.ATTR_PUBLISHER_LIST, publisherList);
                                
                //page="/WEB-INF/view/publisher/list.jsp";
                page = WebConstants.PAGE_PUBLISHER_LIST;
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
