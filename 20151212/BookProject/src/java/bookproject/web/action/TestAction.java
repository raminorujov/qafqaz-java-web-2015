/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookproject.web.action;

import bookproject.web.WebConstants;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author student
 */
public class TestAction extends BaseAction {

    public TestAction() {
        this.name=WebConstants.ACTION_TEST;
        this.page = WebConstants.PAGE_TEST;
        this.forward = true;
    }

    
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // no specific business logic
    }
    
}
