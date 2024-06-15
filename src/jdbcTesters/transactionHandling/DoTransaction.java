package jdbcTesters.transactionHandling;

import dao.DBUtils;
import org.sqlite.core.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DoTransaction {
    public static void main(String[] args) {
        String withdrawQuery="UPDATE accounts set balance=balance-? where account=?";
        String depositQuery="UPDATE accounts set balance=balance+? where account=?";

        try(Connection connection=DBUtils.fetchConnection();)
        {

            connection.setAutoCommit(false);
            PreparedStatement withDrawStatement=connection.prepareStatement(withdrawQuery);
            PreparedStatement depositStatement=connection.prepareStatement(depositQuery);
            withDrawStatement.setDouble(1,500);
            withDrawStatement.setString(2,"ACC0987654321");
            depositStatement.setString(2,"12");
            depositStatement.setInt(1,500);
            int withDrawDone=withDrawStatement.executeUpdate();
            int depositDone=depositStatement.executeUpdate();
            if(withDrawDone>0 &&depositDone>0) {
                connection.commit();
                System.out.println("Transaction successfull");
            }
            else {
                connection.rollback();
                System.out.println("Transaction rolled back successfully !");
            }


        } catch (SQLException | ClassNotFoundException e) {

            throw new RuntimeException(e);
        }
    }
}
