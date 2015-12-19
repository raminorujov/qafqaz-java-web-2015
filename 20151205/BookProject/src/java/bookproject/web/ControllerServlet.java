package bookproject.web;

import bookproject.db.BookDatabaseHelper;
import bookproject.db.Database;
import bookproject.domain.Author;
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
        List<String> errorList = new ArrayList<>();
        
        try {
            // check action
            if(request.getParameter("action") != null) {
                action = request.getParameter("action").trim();
            } else {
                action = "default";
            }
            
            // process action
            if(action.equals(WebConstants.ACTION_TEST)) {
                page = WebConstants.PAGE_TEST;
                forward = true;
            } else if(action.equals(WebConstants.ACTION_SHOW_PUBLISHER_LIST)) {
                // get publisher list from database
                List<Publisher> publisherList = dbHelper.getPublisherList();
                
                // save publisher list in request attribute
                request.setAttribute(WebConstants.ATTR_PUBLISHER_LIST, publisherList);
                                
                //page="/WEB-INF/view/publisher/list.jsp";
                page = WebConstants.PAGE_PUBLISHER_LIST;
                forward = true;
            } else if(action.equals(WebConstants.ACTION_VIEW_PUBLISHER)) {
                int publisherId = 0;
                
                try {
                    if(request.getParameter("id") != null) {
                        publisherId = Integer.parseInt(request.getParameter("id"));
                    }

                    Publisher publisher = dbHelper.getPublisher(publisherId);
                    request.setAttribute(WebConstants.ATTR_PUBLISHER, publisher);

                    List<Book> bookList = dbHelper.getBookListByPublisher(publisherId);
                    request.setAttribute(WebConstants.ATTR_PUBLISHER_BOOKS, bookList);
                
                    page = WebConstants.PAGE_PUBLISHER;
                    forward = true;                            
                } catch(NumberFormatException nfe) {
                    errorList.add("Invalid publisher id");
                    request.setAttribute(WebConstants.ATTR_ERROR_LIST, errorList);
                    page = WebConstants.PAGE_ERROR;
                    forward = true;
                }
                
            } else if(action.equals(WebConstants.ACTION_VIEW_BOOK)) {
                int bookId = 0;
                
                try {
                    if(request.getParameter("id") != null) {
                        bookId = Integer.parseInt(request.getParameter("id"));
                    }

                    Book book = dbHelper.getBook(bookId);
                    request.setAttribute(WebConstants.ATTR_BOOK, book);
                   
                    page = WebConstants.PAGE_BOOK;
                    forward = true;                            
                } catch(NumberFormatException nfe) {
                    errorList.add("Invalid book id");
                    request.setAttribute(WebConstants.ATTR_ERROR_LIST, errorList);
                    page = WebConstants.PAGE_ERROR;
                    forward = true;
                }
            }else if(action.equals(WebConstants.ACTION_VIEW_AUTHOR)){
                int authorId=0;
                try{
                    if(request.getParameter("id") != null)
                        authorId=Integer.parseInt(request.getParameter("id"));
                    Author author=dbHelper.getAuthor(authorId);
                    request.setAttribute(WebConstants.ATTR_AUTHOR, author);
                    page = WebConstants.PAGE_AUTHOR;
                    forward=true;
                }catch(NumberFormatException nfe){
                    errorList.add("Invalid author id");
                    request.setAttribute(WebConstants.ATTR_ERROR_LIST,errorList);
                    page=WebConstants.PAGE_ERROR;
                    forward=true;
                }
                
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
