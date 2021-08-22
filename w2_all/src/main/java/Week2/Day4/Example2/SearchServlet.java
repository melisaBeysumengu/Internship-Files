package Week2.Day4.Example2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "SearchServlet", value = "/SearchServlet")
public class SearchServlet extends HttpServlet {
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
        Pair<String, String> p ;
        try {
           p = relationalModel.selectContact(name);
            System.out.println(p);
           if(p != null){
               request.setAttribute("name", p.getFirst());
               request.setAttribute("tel_number", p.getSecond());
               request.getRequestDispatcher("editContact.jsp").forward(request, response);
           }
           else
           {
               PrintWriter pw = response.getWriter();
               pw.println("No match");
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
