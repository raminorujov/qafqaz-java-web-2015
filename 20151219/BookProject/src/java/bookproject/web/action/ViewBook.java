/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookproject.web.action;

import bookproject.domain.Book;
import bookproject.web.WebConstants;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author student
 */
public class ViewBook extends BaseAction {

    public ViewBook() {
        this.name = WebConstants.ACTION_VIEW_BOOK;
        this.page = WebConstants.PAGE_BOOK;        
    }    
    
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = 0;

        try {
            if (request.getParameter("id") != null) {
                bookId = Integer.parseInt(request.getParameter("id"));
            }

            Book book = dbHelper.getBook(bookId);
            request.setAttribute(WebConstants.ATTR_BOOK, book);

            page = WebConstants.PAGE_BOOK;
            forward = true;
        } catch (NumberFormatException nfe) {
            errorList.add("Invalid book id");
            request.setAttribute(WebConstants.ATTR_ERROR_LIST, errorList);
            page = WebConstants.PAGE_ERROR;
            forward = true;
        }
    }

}
