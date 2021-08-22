package Week2.Day2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dispatchExample", value = "/dispatch-example")
public class DispatchExample extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html;charset=UTF-8");

        request.getRequestDispatcher(request.getParameter("path")+".jsp").forward(request, response);

        String _de = "";
        String $des = "";
    }

    public void destroy() {
    }
}