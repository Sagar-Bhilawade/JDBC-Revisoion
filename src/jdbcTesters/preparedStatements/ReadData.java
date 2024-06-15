package jdbcTesters.preparedStatements;

import dao.DBUtils;

import java.sql.*;

public class ReadData {
    public static void main(String[] args) {
        try (Connection connection= DBUtils.fetchConnection()){
            String readQuery="SELECT  *  from employees where name=?";

            PreparedStatement statement=connection.prepareStatement(readQuery);
            statement.setString(1,"Bhura");
            ResultSet resultSet= statement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1)+resultSet.getString(2)+resultSet.getString(3)+resultSet.getDouble(4));
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
