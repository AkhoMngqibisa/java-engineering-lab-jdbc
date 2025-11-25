import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DemoJdbc {

    private static Connection connection;
    private static Statement statement;

    private static void setConnection() {
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

    private static Connection getConnection() {
        return connection;
    }

    private static void setStatement() {
        try {
            statement = getConnection().createStatement();

        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

    private static Statement getStatement() {
        return statement;
    }

    public static void getAllStudents() {
        try {
            String query = "SELECT * FROM public.\"Student\"";
            ResultSet resultSet = getStatement().executeQuery(query);

            System.out.println("######## Getting all students");
            while (resultSet.next()) {
                System.out.print(resultSet.getString(1) + " - ");
                System.out.print(resultSet.getString(2) + " - ");
                System.out.println(resultSet.getString(3));
            }

        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

    public static void insertStudent() {
        String query = "INSERT INTO public.\"Student\" VALUES ('126', 'Bob', 'Ndzoto')";

        try {
            boolean status = getStatement().execute(query);
            System.out.println("####### Inserting student into table: " + status);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

    public static void updateStudent() {
        String query = "UPDATE public.\"Student\" SET name = 'Uminathi' WHERE \"studentNumber\" = '126'";

        try {
            boolean status = getStatement().execute(query);
            System.out.println("####### Updating student into table: " + status);
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

    public static void main(String[] args) {

        try {
            setConnection();
            setStatement();
            getAllStudents();
            //insertStudent();
            updateStudent();

            getConnection().close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
