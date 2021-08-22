package Week2.Day5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet(value = "/public/login")
public class LoginServlet extends HttpServlet {
    Connection con;
    PreparedStatement pst;

    @Override
    public void init() throws ServletException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "dbuser", "dbuser");

            // create prepared statement
            pst = con.prepareStatement("SELECT COUNT(username) from user WHERE username = ? and password = ?");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (isCredentialsCorrect(username, password)) {
            // create session
            HttpSession session = req.getSession(true);
            session.setAttribute("username", username);

            // forward to secured.jsp
            req.getRequestDispatcher("/private/secured.jsp").forward(req, resp);
        } else {
            resp.sendError(401, "Credentials are not correct");
        }
    }

    @Override
    public void destroy() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean isCredentialsCorrect(String username, String password) {
        try {
            // populate db check query with username password
            pst.setString(1, username);
            pst.setString(2, password);

            // execute db check query
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                // matching user count
                int count = rs.getInt(1);
                if (count > 0) {
                    // return true if there is 1 matching user
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // return false for anything else
        return false;
    }
}
