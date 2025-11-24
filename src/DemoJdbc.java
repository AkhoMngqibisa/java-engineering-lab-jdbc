import java.sql.*;

public class DemoJdbc {

    private Connection connection;

    public void setConnection() {
        try {
            // Create a connection
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "password";
            connection = DriverManager.getConnection(url,user,password);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {

        try {
            // Load and register

            String query = "SELECT * FROM public.\"Student\"";

            System.out.println("--->>> Creating connection...");

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
