import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DemoJdbc {

    private Connection connection;
    private Statement statement;

    public void setConnection() {
        try {
            // Create a connection
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "password";
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setStatement() {
        try {
            statement = connection.createStatement();

        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

    public Statement getStatement() {
        return statement;
    }

    public void getAllStudents() {
        try {
            String query = "SELECT * FROM public.\"Student\"";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.print(resultSet.getString(1) + " - ");
                System.out.print(resultSet.getString(2) + " - ");
                System.out.println(resultSet.getString(3));
            }

            connection.close();

        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

    public static void main(String[] args) {

        try {


        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
