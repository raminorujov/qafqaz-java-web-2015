/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookproject.web.action;

import bookproject.domain.Author;
import bookproject.web.WebConstants;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author student
 */
public class ViewAuthor extends BaseAction {

    public ViewAuthor() {
        this.name = WebConstants.ACTION_VIEW_AUTHOR;
        this.page = WebConstants.PAGE_AUTHOR;
    }
    
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int authorId = 0;
        try {
            if (request.getParameter("id") != null) {
                authorId = Integer.parseInt(request.getParameter("id"));
            }
            Author author = dbHelper.getAuthor(authorId);
            request.setAttribute(WebConstants.ATTR_AUTHOR, author);
            page = WebConstants.PAGE_AUTHOR;
            forward = true;
        } catch (NumberFormatException nfe) {
            errorList.add("Invalid author id");
            request.setAttribute(WebConstants.ATTR_ERROR_LIST, errorList);
            page = WebConstants.PAGE_ERROR;
            forward = true;
        }
    }

}
