package kosev;

import java.sql.*;

public class Java2MySql {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "sakila";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "pocoio";
        try {
            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url + dbName, userName, password);
            // Query the student names
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("select id, item, likes, date from items LIMIT 20");
            // Print the name out
            // name is the 2nd attribute of Student
            while (rset.next()) {
                System.out.print("ID : " + rset.getString("id") + " ");
                System.out.println("/ First name : " + rset.getString("item") + " / Last name : "
                        + rset.getString("likes") + "]");
            }
            // close the result set, statement, and the connection
            rset.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}