package Week2.Day1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private String message;
    private String name;
    private String lastName;
    private boolean isRegistered;

    public void init() {
        message = "Hello World! Please register first!";
        isRegistered = false;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        if (isRegistered) {
            out.print("<h1>Hi. Thanks for registering.</h1>");
        } else {
            out.print("<a href=\"" + request.getContextPath() + "\">Hello Servlet</a>");
        }
        out.println("</body></html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        message = "User Registered";
        isRegistered = true;

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<html>");
        printWriter.print("<body>");
        printWriter.print("<h1>Registration Form Data</h1>");
        printWriter.print("<p> firstName :: " + firstName + "</p>");
        printWriter.print("<p> lastName :: " + lastName + "</p>");
        printWriter.print("<a href=\""+ req.getContextPath() +"/RegisterServlet\">Welcome Servlet</a>");
        printWriter.print("</body>");
        printWriter.print("</html>");
        printWriter.close();
    }

}
