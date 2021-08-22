package Week2.Day3.Example3;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "destinationServlet", value = "/destination-servlet")
public class DestinationServlet extends HttpServlet {

    private String message;

    public void init() {
        message = "Destination Servlet";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        Object attributeValue = request.getAttribute("time");
        System.out.println("Value of Request-Attribute is : " + attributeValue);

        PrintWriter out = response.getWriter();

        if(request.getAttribute("isFinished")!=null && (boolean) request.getAttribute("isFinished")){

            out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>is Successful : " +request.getAttribute("isFinished") + "</h1>");
            out.println("</body></html>");

        }else{
            request.setAttribute("isFinished", true);

            RequestDispatcher rd = request.getRequestDispatcher("/origin-servlet");
            rd.forward(request, response);
        }


    }

}
