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

            System.out.println("--->>> Creating connection...");
            Connection connection = DriverManager.getConnection(url,user,password);

            System.out.println("--->>> Executing Statement...");
            Statement statement = connection.createStatement();

            System.out.println("--->>> Process result set...");
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();

            String studentNumber = resultSet.getString("studentNumber");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");

            System.out.println("\n=============  STUDENT DETAILS =============");
            System.out.println("Student number is: " + studentNumber);
            System.out.println("Name is: " + name);
            System.out.println("Surname is: " + surname);

            System.out.println("\n--->>> Closing connection...");
            connection.close();


        } catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
