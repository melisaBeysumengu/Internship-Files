import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RelationalModel {
    String connectionString;
    String username;
    String password;
    Connection connection;

    public RelationalModel(String connectionString, String username, String password) throws SQLException, ClassNotFoundException {
        this.connectionString = connectionString;
        this.username = username;
        this.password = password;
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection = DriverManager.getConnection(connectionString, username, password);
    }

    void insertEmployee(Employee e) throws SQLException {
        /*Statement stmt = connection.createStatement();
        String query = "insert into employee values("+e.id+",\""+e.name+"\",\""+e.surname+"\",\""+e.title+"\","+e.birthYear+");";
        stmt.executeUpdate(query);*/

        String query2 = " insert into employee (id, name, surname, title, birthYear) values (?, ?, ?, ?, ?)";

        PreparedStatement preparedStmt = connection.prepareStatement(query2);
        preparedStmt.setInt    (1, e.id);
        preparedStmt.setString (2, e.name);
        preparedStmt.setString (3, e.surname);
        preparedStmt.setString   (4, e.title);
        preparedStmt.setInt(5, e.birthYear);

        preparedStmt.execute();

    }

    List<Employee> listEmployee(OrderField of) throws SQLException {
        Statement stmt = connection.createStatement();
        String query = "select name,surname,title from employee order by "+of;

        ResultSet rs = stmt.executeQuery(query);
        ArrayList<Employee> el= new ArrayList<>();
        while (rs.next()){
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String title = rs.getString("title");
            el.add(new Employee(name,surname,title));
        }
        return el;
    }

}
