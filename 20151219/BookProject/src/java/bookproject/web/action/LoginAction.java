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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author student
 */
public class LoginAction extends BaseAction {

    public LoginAction() {
        this.name = "login";
//        this.page = "dashboard.jsp";

    }

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = "";
        String password = "";
        String roleStr = "";

        if (request.getParameter("username") != null
                && request.getParameter("password") != null
                && request.getParameter("role") != null) {
            username = request.getParameter("username").trim();
            password = request.getParameter("password").trim();

            User user = dbHelper.login(username, password);
            if (user != null) {
                // login success
                roleStr = request.getParameter("role");
                BigDecimal role = BigDecimal.valueOf(Integer.parseInt(roleStr));

                ArrayList<Role> userRoles = dbHelper.getUserRoles(user);
                for (Role r : userRoles) {
                    
                    if (r.getId().equals(role)) {
                        user.getUserRoles().add(r);
                        if (r.getName().equals("admin")
                                || r.getName().equals("operator")
                                || r.getName().equals("user")) {
                            this.page = "cs?action=dashboard";
                            this.forward = false;
                            
                            HttpSession session = request.getSession();
                            session.setAttribute(WebConstants.ATTR_USER, user);
                            session.setAttribute(WebConstants.ATTR_LOGIN_TIME, new Date());
                        } else {
                            this.page = "/WEB-INF/view/common/error.jsp";
                            this.forward = true;
                        }
                        break;
                    } 
                }
            }

        } else {
            errorList.add("Username or password is empty");
        }
    }

}
