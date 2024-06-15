package jdbcTesters.preparedStatements;

import dao.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
    public static void main(String[] args) {
        try (Connection connection= DBUtils.fetchConnection()){
            String insertQuery="INSERT INTO employees (id, name, job_title, salary) VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1,11);
            preparedStatement.setString(2,"Sagar");
            preparedStatement.setString(3,"Full Stack developer");
            preparedStatement.setDouble(4,300000.00);
            int rowsUpdated= preparedStatement.executeUpdate();
            System.out.println("Data got inserted : No of rows added "+rowsUpdated);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
