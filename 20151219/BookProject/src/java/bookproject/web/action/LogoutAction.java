package bookproject.web.action;

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
public class LogoutAction extends BaseAction {

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute(WebConstants.ATTR_USER);
        session.removeAttribute(WebConstants.ATTR_LOGIN_TIME);
        session.invalidate();
        page = WebConstants.PAGE_LOGIN;
        forward = false;
    }
    
}
