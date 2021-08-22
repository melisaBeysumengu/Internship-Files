package Week2.Day3.Example1;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

@WebServlet(name = "serviceExample", value = "/service-example")
public class ServiceServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, resp);

        StringBuilder requestURL = new StringBuilder(req.getRequestURL().toString());
        String queryString = req.getQueryString();

        if(requestURL.toString().toLowerCase(Locale.ROOT).contains("secured") ||
                requestURL.append('?').append(queryString).toString().contains("secured")){
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
        }
        else {
            resp.setContentType("text/html");

            // Hello
            PrintWriter out = resp.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + requestURL.toString()+requestURL.append('?').append(queryString).toString() + "</h1>");
            out.println("</body></html>");
        }

    }
}
