import java.sql.*;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        Connection conn = null;
        Statement ps = null;
        ResultSet rs = null;
        ArrayList<String> surnames = new ArrayList<>();


        try {
                String url = "jdbc:mysql://localhost:3306/newdb";
                String user = "developer1";
                String password = "password";
                conn = DriverManager.getConnection(url, user, password);
                ps = conn.createStatement();
                String query = "SELECT first_name, last_name FROM develhope_test";
                rs = ps.executeQuery(query);

                while (rs.next()) {
                    String name = rs.getString("first_name");
                    String surname = rs.getString("last_name");
                    System.out.println("Name: " + name);
                    surnames.add(surname);
                }

        } catch (SQLException e) {

                    System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println("Surnames: " + surnames);


    }
}