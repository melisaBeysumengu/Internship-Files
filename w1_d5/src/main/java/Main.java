import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            RelationalModel rm = new RelationalModel("jdbc:mysql://localhost/empManagement", "root", "admin123");
            /*rm.insertEmployee(new Employee(2,"demet","adfslı","müdür yard",1987));
            rm.insertEmployee(new Employee(4,"aslı","asdgsslı","yazılımcı yard",1982));
            rm.insertEmployee(new Employee(5,"mehmet","sdfg","müdür yard",1950));
            rm.insertEmployee(new Employee(6,"selin","asgsfdlı","terzi",1985));
            rm.insertEmployee(new Employee(7,"dilara","dsf","bakkal yard",1986));
            rm.insertEmployee(new Employee(8,"mahmut","dsfg","müdür yard",1997));
            rm.insertEmployee(new Employee(9,"turgut","dfg","işsiz yard",2007));
            rm.insertEmployee(new Employee(10,"sidal","dfag","müdür yard",1988));*/
            rm.insertEmployee(new Employee(11,"Barney","Stinson","Please",1973));


            List<Employee> al = rm.listEmployee(OrderField.SURNAME);
            for (int i = 0; i <al.size() ; i++) {
                System.out.println(al.get(i).toString());
            }

            rm.connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
/*RelationalModel rm  = new RelationalModel("jdbc:mysql://localhost/empManagement","root","admin123");
            Connection conn = DriverManager.getConnection(rm.connectionString,rm.username, rm.password);
            Statement stmt = conn.createStatement();
            String query = "select * from employee";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int birthYear = rs.getInt("birthyear");

                System.out.println("id: "+ id +" name: " + name+ " surname: "+surname+" birth Year: "+birthYear);
            }conn.close();*/