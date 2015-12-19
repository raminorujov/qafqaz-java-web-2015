/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookproject.web.action;

import bookproject.db.BookDatabaseHelper;
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
public class ShowPublisherList extends BaseAction {

    private BookDatabaseHelper dbHelper;
    
    
    public ShowPublisherList() {
        this.name=WebConstants.ACTION_SHOW_PUBLISHER_LIST;
        this.page = WebConstants.PAGE_PUBLISHER_LIST;
        this.forward = true;
        this.output = false;
        this.dbHelper = null;
    }

    public void setDbHelper(BookDatabaseHelper dbHelper) {
        this.dbHelper = dbHelper;
    }
      
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         // get publisher list from database
        List<Publisher> publisherList = dbHelper.getPublisherList();

        // save publisher list in request attribute
        request.setAttribute(WebConstants.ATTR_PUBLISHER_LIST, publisherList);
                
    }
    
}
