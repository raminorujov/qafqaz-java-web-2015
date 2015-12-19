/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookproject.web.action;

import bookproject.domain.Role;
import bookproject.domain.User;
import bookproject.web.WebConstants;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author student
 */
public class DashboardAction extends BaseAction {

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession();
       User user = (User) session.getAttribute(WebConstants.ATTR_USER);
       for(Role role : user.getUserRoles()) {
           if(role.getName().equals("admin")) {
               page = WebConstants.PAGE_ADMIN_DASHBOARD;
               break;
           } else if(role.getName().equals("user")) {
               page = WebConstants.PAGE_USER_DASHBOARD;
           }
       
       }
           
    }
        
}
