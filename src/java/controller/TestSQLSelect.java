/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author LENOVO
 */
public class TestSQLSelect {
    public static void main(String arg[])
    {
        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydatabase",
                    "root", "");
 
            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                "select * from store where name='Nike jordan'");
            String name, Type, Filter, Popularity, price;
            while (resultSet.next()) {
                name = resultSet.getString("name");
                Type = resultSet.getString("Type").trim();
                Filter = resultSet.getString("Filter").trim();
                Popularity = resultSet.getString("Popularity").trim();
                price = resultSet.getString("price").trim();
                System.out.println("Name : " + name
                                   + " Type : " + Type
                                   + " Filter : " + Filter
                                   + " Popularity : " + Popularity
                                   + " price : " + price
                                    );
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
