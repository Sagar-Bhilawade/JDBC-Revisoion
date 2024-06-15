package jdbcTesters.statements;

import dao.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataIntoDatabase {
    public static void main(String[] args) {
        try (Connection connection= DBUtils.fetchConnection()){
            String insertQuery="INSERT INTO employees (id, name, job_title, salary) VALUES (11, 'Paul Takila', 'Kam ka na kaj ka', 5000.00);";
            Statement statement=connection.createStatement();
            int rowsUpdated= statement.executeUpdate(insertQuery);
            System.out.println("Data got inserted : No of rows added "+rowsUpdated);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
