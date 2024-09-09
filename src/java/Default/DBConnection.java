package Default;

import java.sql.*;
import java.util.List;
import model.Store;

public class DBConnection {

    public boolean insertNewStore(Store store) {
        boolean result = false;
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydatabase",
                    "root", "");

            statement = connection.createStatement();

            // แปลง array ของตัวกรองเป็น String ที่คั่นด้วย semicolon
            String filter = String.join(";", store.getFilter());

            String query = "INSERT INTO store "
                    + "(name, Type, Filter, Popularity, price) "
                    + "VALUES('" + store.getName() + "', '"
                    + store.getType() + "', '"
                    + filter + "', '"
                    + store.getPopularity() + "', "
                    + store.getPrice() + ")";
            System.out.println("........SQL: " + query);

            int i = statement.executeUpdate(query);
            if (i != 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // ปิด statement และ connection
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public Store getStore(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Store> getAllStore() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
