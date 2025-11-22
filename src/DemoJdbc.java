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
            String query = "select * from student where studentNumber = 123";

            Connection connection = DriverManager.getConnection(url,user,password);
            System.out.println("Connected to database successfully");

            Statement statement = connection.createStatement();
            statement.executeQuery(query);


        } catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
