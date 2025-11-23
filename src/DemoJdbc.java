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
            String query = "SELECT * FROM public.\"Student\" WHERE \"studentNumber\" = 123 ";

            System.out.println("Creating connection...");
            Connection connection = DriverManager.getConnection(url,user,password);

            System.out.println("Executing Statement...");
            Statement statement = connection.createStatement();

            System.out.println("Process result set...");
            ResultSet resultSet = statement.executeQuery(query);

        } catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
