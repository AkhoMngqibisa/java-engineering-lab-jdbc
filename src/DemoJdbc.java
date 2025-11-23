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
            String query = "SELECT * FROM public.\"Student\"";

            System.out.println("--->>> Creating connection...");
            Connection connection = DriverManager.getConnection(url,user,password);

            System.out.println("--->>> Executing Statement...");
            Statement statement = connection.createStatement();

            System.out.println("--->>> Process result set...");
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                System.out.print(resultSet.getString(1)+ " - ");
                System.out.print(resultSet.getString(2)+ " - ");
                System.out.println(resultSet.getString(3));
            }

            System.out.println("\n--->>> Closing connection...");
            connection.close();


        } catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
