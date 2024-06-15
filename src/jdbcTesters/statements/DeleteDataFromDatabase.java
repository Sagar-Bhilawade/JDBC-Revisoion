package jdbcTesters.statements;

import dao.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDataFromDatabase {
    public static void main(String[] args) {
        try (Connection connection= DBUtils.fetchConnection()){
            String deleteQuery="Delete from employees where id=11";
            Statement statement=connection.createStatement();
            int rowsUpdated= statement.executeUpdate(deleteQuery);
            System.out.println("Data got updated : No of rows updated "+rowsUpdated);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
