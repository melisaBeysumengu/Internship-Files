package Week2.Day4.Example2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "CreateContactServlet", value = "/CreateContactServlet")
public class CreateContactServlet extends HttpServlet  {
    RelationalModel relationalModel;
    @Override
    public void init() throws ServletException {
        try {
            relationalModel = new RelationalModel("root", "admin1234", "jdbc:mysql://localhost/Information");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String tel_number = request.getParameter("tel_number");
        try {
            int check =relationalModel.insertInformation(name,tel_number);
            if(check>0)
            {
                PrintWriter out = response.getWriter();
                out.println("Contact Creation successful");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void destroy() {
        try {
            relationalModel.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
