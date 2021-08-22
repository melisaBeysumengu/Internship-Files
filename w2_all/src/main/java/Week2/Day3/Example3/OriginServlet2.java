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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "originServlet2", value = "/origin-servlet2")
public class OriginServlet2 extends HttpServlet {

    private String message;

    public void init() {
        message = "Origin Servlet2!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext context = request.getServletContext();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));


        if(context.getAttribute("isFinished")!=null && (boolean) context.getAttribute("isFinished")){
            Object attributeValue = context.getAttribute("isFinished");

            context.setAttribute("isFinished", true);

            RequestDispatcher rd = request.getRequestDispatcher("/destination-servlet2");
            rd.forward(request, response);
            //response.sendRedirect("/destination-servlet2");

        }else{
            context.setAttribute("time", dtf.format(now));
            RequestDispatcher rd = request.getRequestDispatcher("/destination-servlet2");
            rd.forward(request, response);
        }

    }

}
