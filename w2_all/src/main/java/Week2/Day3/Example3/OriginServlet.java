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

@WebServlet(name = "originServlet", value = "/origin-servlet")
public class OriginServlet extends HttpServlet {

    private String message;

    public void init() {
        message = "Origin Servlet!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if(request.getAttribute("isFinished")!=null && (boolean) request.getAttribute("isFinished")){

            request.setAttribute("isFinished",true );
            RequestDispatcher rd = request.getRequestDispatcher("/destination-servlet");
            rd.forward(request, response);
            //response.sendRedirect("/destination-servlet");
        }else{

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            System.out.println(dtf.format(now));

            request.setAttribute("time",dtf.format(now) );
            RequestDispatcher rd = request.getRequestDispatcher("/destination-servlet");
            rd.forward(request, response);
        }


    }

}
