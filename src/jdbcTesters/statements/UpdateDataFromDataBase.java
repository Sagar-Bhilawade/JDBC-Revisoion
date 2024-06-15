package jdbcTesters.statements;

import dao.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDataFromDataBase {
    public static void main(String[] args) {
        try (Connection connection= DBUtils.fetchConnection()){
            String updateQuery="Update employees set name='Bhura' where id=10";
            Statement statement=connection.createStatement();
            int rowsUpdated= statement.executeUpdate(updateQuery);
            System.out.println("Data got updated : No of rows updated "+rowsUpdated);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
