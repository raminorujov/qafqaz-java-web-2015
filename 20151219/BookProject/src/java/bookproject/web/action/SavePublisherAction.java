/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookproject.web.action;

import bookproject.domain.Publisher;
import bookproject.web.WebConstants;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.validator.GenericValidator;

/**
 *
 * @author student
 */
public class SavePublisherAction extends BaseAction {
    
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String publisherName = request.getParameter("name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        
        if(!GenericValidator.isBlankOrNull(publisherName) 
                && !GenericValidator.isBlankOrNull(address)
                && GenericValidator.isEmail(email)) {
            
            Publisher publisher = new Publisher();
            publisher.setName(publisherName);
            publisher.setAddress(address);
            publisher.setEmail(email);
            boolean success = dbHelper.savePublisher(publisher);
//            page = WebConstants.PAGE_PUBLISHER_LIST;
            page = "cs?action=showPublisherList";
            forward = false;
        } else {
            this.errorList.clear();
            this.errorList.add("Name, address and email can not empty");
            request.setAttribute(WebConstants.ATTR_ERROR_LIST, errorList);
            page = WebConstants.PAGE_ADD_PUBLISHER;
            forward = true;
        }
        
        
        
    }
    
}
