package com.xworkz.Busstop.runner;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRunner {
    public static void main(String[] args) {

        System.out.println("running the main method..");
        Connection connection=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("connection successful");
            String url = "jdbc:mysql://localhost:3306/busstop";
            String userName = "root";
            String pass = "Xworkodc@123";
            connection= DriverManager.getConnection(url,userName,pass);
            System.out.println("Jdbc connection done");

            String insert1="insert into  Busstop(busstop_name,location,noofbus,bus_starting,destination) values ('HAL','Tumkur',30,'Banglore','Tiptur')";
            String insert2="insert into  Busstop(busstop_name,location,noofbus,bus_starting,destination) values ('Bus Nildana','Shivmogga',78,'Arsikere','Banglore')";
            String insert3="insert into  Busstop(busstop_name,location,noofbus,bus_starting,destination) values ('Mejastic','Rajajinagar',300,'Yeswanthpur','Kengeri')";
            String insert4="insert into  Busstop(busstop_name,location,noofbus,bus_starting,destination) values ('Hassan','Hassan',47,'Haranahalli','Alur')";
            String insert5="insert into  Busstop(busstop_name,location,noofbus,bus_starting,destination) values ('Bellur','Chickmangalore',200,'Halebidu','Hassan')";
            String insert6="insert into  Busstop(busstop_name,location,noofbus,bus_starting,destination) values ('Kempegowda','Mejastic',300,'Mejastic ','Shivmogga')";


            Statement statement=connection.createStatement();
            statement.addBatch(insert1);
            statement.addBatch(insert2);
            statement.addBatch(insert3);
            statement.addBatch(insert4);
            statement.addBatch(insert5);
            statement.addBatch(insert6);
            int[] row=statement.executeBatch();
            System.out.println("no of row inserted: "+row.length);
        } catch (ClassNotFoundException | SQLException classNotFoundException) {
            System.out.println("JDBC class not found:" + classNotFoundException.getMessage());
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("message"+e.getMessage());
            }
        }
    }


}