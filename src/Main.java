import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try{
            Class.forName("org.sqlite.JDBC");
            Connection connection = null;
//	        Statement statement = null;


            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Establish a connection to the SQLite database
            String url = "jdbc:sqlite:C:\\Sagar\\Projects\\Database\\sample.db"; // SQLite database file (test.db)
            connection = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established."+connection);



        }

        catch (Exception e) {
            e.printStackTrace();

        }
    }

}
