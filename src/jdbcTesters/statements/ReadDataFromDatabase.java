package jdbcTesters.statements;

import dao.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadDataFromDatabase {
    public static void main(String[] args) {
        try (Connection connection= DBUtils.fetchConnection()){
            String readQuery="SELECT  *  from employees";
            Statement statement=connection.createStatement();
           ResultSet resultSet= statement.executeQuery(readQuery);
           while (resultSet.next()){
               System.out.println(resultSet.getInt(1)+resultSet.getString(2)+resultSet.getString(3)+resultSet.getDouble(4));
           }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
