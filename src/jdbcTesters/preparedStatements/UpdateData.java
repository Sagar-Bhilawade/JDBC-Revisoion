package jdbcTesters.preparedStatements;

import dao.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {
    public static void main(String[] args) {
        try (Connection connection= DBUtils.fetchConnection()){
            String updateQuery="Update employees set name=? where id=?";
            PreparedStatement statement=connection.prepareStatement(updateQuery);
            statement.setString(1,"King");
            statement.setInt(2,11);
            int rowsUpdated= statement.executeUpdate();
            System.out.println("Data got updated : No of rows updated "+rowsUpdated);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
