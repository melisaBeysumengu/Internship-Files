package Week2.Day4.Example2;

import java.sql.*;

class RelationalModel {
    private String connectionString;
    private String username;
    private String password;
    Connection conn;

    public RelationalModel(String username, String password, String connStr) throws SQLException, ClassNotFoundException {
        this.connectionString = connStr;
        this.username = username;
        this.password = password;
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(connectionString, username, password);
    }

    public int insertInformation(String name , String tel_number) throws SQLException {
        String insert = "INSERT INTO Contacts(name,tel_number) VALUE (?,?)";
        PreparedStatement state = conn.prepareStatement(insert);
        state.setString(1,name);
        state.setString(2,tel_number);
        int updates = state.executeUpdate();
        return updates;
    }

    public Pair<String,String> selectContact(String rName) throws SQLException {
        Statement state = conn.createStatement();

        ResultSet rs = state.executeQuery(" Select * FROM Contacts Where name = \""+rName+"\" ;");
        Pair<String, String> p = null;
        if(rs.next()) {
            String requestedName = rs.getString("name");
            String tel_number = rs.getString("tel_number");
            p = new Pair<>(requestedName, tel_number);
        }
        return p;
    }

    public int updateInformation(String name,String tel_number ) throws SQLException {
        String insert ="UPDATE Contacts Set tel_number = ? Where name = ?";
        PreparedStatement state = conn.prepareStatement(insert);
        state.setString(1,tel_number);
        state.setString(2,name);
        int updates = state.executeUpdate();
        return updates;
    }

}
