package jdbcTesters.imageHandling;

import dao.DBUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrivingImage {
    public static void main(String[] args) {
        String folder_path="C:\\Sagar\\other\\downloadshagie.jpg";
        String readImageQuery="Select image_data from image_table where image_id=?";
        try(Connection connection= DBUtils.fetchConnection())
        {
            PreparedStatement preparedStatement=connection.prepareStatement(readImageQuery);
            preparedStatement.setInt(1,2);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                byte[] image_data=resultSet.getBytes(1);
                FileOutputStream fileOutputStream=new FileOutputStream(folder_path);
                fileOutputStream.write(image_data);
                System.out.println("Image retored successfully !!!");
            }
            else {
                System.out.println("Image not found");
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
