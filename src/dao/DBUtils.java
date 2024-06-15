package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
  private static Connection connection;
    public  static Connection fetchConnection() throws ClassNotFoundException, SQLException {
        if(connection==null){
            Class.forName("org.sqlite.JDBC");
            String dbURL="jdbc:sqlite:sample.db";
            connection= DriverManager.getConnection(dbURL);
            System.out.println("New Connection got created"+connection);

        }
        return connection;
    }
}
