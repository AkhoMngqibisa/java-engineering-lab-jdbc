import java.sql.*;

public class DemoJdbc {
    public static void main(String[] args) {

        try {
            // Load and register
            Class.forName("org.postgresql.Driver");

        } catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
