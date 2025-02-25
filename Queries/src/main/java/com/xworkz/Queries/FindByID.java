package com.xworkz.Queries;

import java.sql.*;

public class FindByID {
    public static void main(String[] args) {
        Connection connection = null;
        Statement  statement = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Dervier Found");
            String url = "jdbc:mysql://localhost:3306/product";
            String userName = "root";
            String password = "Xworkzodc@123";
            connection = DriverManager.getConnection(url,userName,password);
            System.out.println("Connection Successful");
            statement = connection.createStatement();

            String query = "select * from p_info where productID=4 ";
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                Double productPrice = resultSet.getDouble(1);
                int productID = resultSet.getInt(3);
                String productName = resultSet.getString(2);


                System.out.println("ProductId :"+ productID+"Product Name :"+productName+"product Price :"+productPrice);
            }

        }catch (ClassNotFoundException | SQLException e){
            System.out.println("JDBC not Found :"+e.getMessage());
        }finally{
            try{
                if(connection != null){
                connection.close();

            } else if (statement != null ) {
                    connection.close();
                }

                } catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }
}
