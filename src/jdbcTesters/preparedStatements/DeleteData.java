package jdbcTesters.preparedStatements;

import dao.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {
    public static void main(String[] args) {
        try (Connection connection= DBUtils.fetchConnection()){
            String deleteQuery="Delete from employees where id=?";
            PreparedStatement statement=connection.prepareStatement(deleteQuery);
            statement.setInt(1,11);
            int rowsUpdated= statement.executeUpdate();
            System.out.println("Data got updated : No of rows updated "+rowsUpdated);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
