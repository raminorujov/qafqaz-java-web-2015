package demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * Created by raminorujov on 9/26/15.
 */
@WebServlet(name = "Servlet4", urlPatterns = {"/Servlet4"})
public class Servlet4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Random r = new Random();
        int random = r.nextInt();
        System.out.println("Generated random int value = " + random);

        request.setAttribute("randomInt", random);
        RequestDispatcher rd = request.getRequestDispatcher("/Servlet1");
        rd.forward(request, response);
    }
}
