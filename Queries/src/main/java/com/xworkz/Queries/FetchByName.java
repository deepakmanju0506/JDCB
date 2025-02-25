package com.xworkz.Queries;

import java.sql.*;

public class FetchByName {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/product";
            String userName = "root";
            String password = "Xworkzodc@123";
            connection = DriverManager.getConnection(url,userName,password);
statement= connection.createStatement();
            String query = "select * from p_info where p_nmae='Mobile'";
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                int productId = resultSet.getInt(1);
                String productName = resultSet.getString(2);
                double productPrice = resultSet.getDouble(3);

                System.out.println("product ID :"+ productId+"product Name :"+productName+"product price :"+productPrice);
            }
        }catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try{
                if(connection != null){
                    connection.close();
                } else if (statement != null) {
                    connection.close();
                }
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }
}
