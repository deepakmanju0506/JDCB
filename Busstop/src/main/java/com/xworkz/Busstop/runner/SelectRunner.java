package com.xworkz.Busstop.runner;

import java.sql.*;

public class SelectRunner {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/busstop";
            String userName = "root";
            String password = "Xworkodc@123";
            connection = DriverManager.getConnection(url, userName, password);
            statement = connection.createStatement();
            String query = "select *from Busstop";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int ID = resultSet.getInt(1);
                String busstop_name = resultSet.getString(2);
                String location = resultSet.getString(3);
                int noOfBus = resultSet.getInt(4);
                String starting = resultSet.getString(5);
                String destination = resultSet.getString(6);
                System.out.println(" ID:  " + ID + "   Name:  " + busstop_name + "  BusStop Location:  " + location + "   NoOfBus:  " + noOfBus + "  Bus Starting: " + starting + "   Bus Destination: " + destination);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                } else if (statement != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
