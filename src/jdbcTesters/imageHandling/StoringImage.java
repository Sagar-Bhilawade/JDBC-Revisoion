package jdbcTesters.imageHandling;

import dao.DBUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoringImage {
    public static void main(String[] args) {
        String image_path="C:\\Sagar\\other\\download.png";
        try(Connection connection= DBUtils.fetchConnection();
            FileInputStream fileInputStream=new FileInputStream(image_path)) {

            byte[] imageData=new byte[fileInputStream.available()];
            fileInputStream.read(imageData);
            String insertQuery="Insert into image_table(image_data,image_id) Values(?,?)";
            PreparedStatement statement=connection.prepareStatement(insertQuery);
            statement.setBytes(1,imageData);
            statement.setInt(2,2);
            int rowsUpdated= statement.executeUpdate();
            System.out.println("Image inserted successfully : No of rows added "+rowsUpdated);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
