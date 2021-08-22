package Week2.Day3.Example3;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "destinationServlet2", value = "/destination-servlet2")
public class DestinationServlet2 extends HttpServlet {

    private String message;

    public void init() {
        message = "Destination Servlet";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        ServletContext context = request.getServletContext();
        PrintWriter out = response.getWriter();
        Object attributeValue = context.getAttribute("time");

        if(context.getAttribute("isFinished")!=null && (boolean) context.getAttribute("isFinished")){

            out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>is Successful : " + context.getAttribute("isFinished") + "</h1>");
            out.println("</body></html>");

        }else{

            context.setAttribute("isFinished", true);

            RequestDispatcher rd = request.getRequestDispatcher("/origin-servlet2");
            rd.forward(request, response);

        }



    }

}
