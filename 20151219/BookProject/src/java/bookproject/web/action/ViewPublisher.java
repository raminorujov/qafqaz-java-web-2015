/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookproject.web.action;

import bookproject.db.BookDatabaseHelper;
import bookproject.db.Database;
import bookproject.domain.Book;
import bookproject.domain.Publisher;
import bookproject.web.WebConstants;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author student
 */
public class ViewPublisher extends BaseAction {

    public ViewPublisher() {
        this.name = WebConstants.ACTION_VIEW_PUBLISHER;
        this.page = WebConstants.PAGE_PUBLISHER;
    }   
    
    private BookDatabaseHelper dbHelper;

    public void setDbHelper(BookDatabaseHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int publisherId = 0;

        try {
            if (request.getParameter("id") != null) {
                publisherId = Integer.parseInt(request.getParameter("id"));
            }

            Publisher publisher = dbHelper.getPublisher(publisherId);
            request.setAttribute(WebConstants.ATTR_PUBLISHER, publisher);

            List<Book> bookList = dbHelper.getBookListByPublisher(publisherId);
            request.setAttribute(WebConstants.ATTR_PUBLISHER_BOOKS, bookList);

            page = WebConstants.PAGE_PUBLISHER;
            forward = true;
        } catch (NumberFormatException nfe) {
            errorList.add("Invalid publisher id");
            request.setAttribute(WebConstants.ATTR_ERROR_LIST, errorList);
            page = WebConstants.PAGE_ERROR;
            forward = true;
        }
    }

}
