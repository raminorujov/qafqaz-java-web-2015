package filterdemo;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by raminorujov on 10/3/15.
 */
public class TestFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        System.out.println("Filtering " + request.getRequestURI() + " at " + new Date());
        chain.doFilter(req, resp);


    }

    public void init(FilterConfig config) throws ServletException {
        String ipList = config.getInitParameter("ipList");
        System.out.println("IP list from config " + ipList);
        //List<String> ipList.split(",");
    }

}
