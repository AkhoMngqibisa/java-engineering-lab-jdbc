import java.sql.*;

public class DemoJdbc {
    public static void main(String[] args) {

        try {
            // Load and register
            Class.forName("org.postgresql.Driver");

            // Create a connection
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "password";
            Connection connection = DriverManager.getConnection(url,user,password);

        } catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
