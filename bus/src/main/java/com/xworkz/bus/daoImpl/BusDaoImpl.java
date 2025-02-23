package com.xworkz.bus.daoImpl;

import com.xworkz.bus.dao.BusDao;

import java.sql.*;

public class BusDaoImpl implements BusDao {
    String url = "jdbc:mysql://localhost:3306/branch";
    String userName = "root";
    String password = "Xworkzodc@123";


    @Override
    public int save(String busStop, String location, int noOfBus, String starting, String destination, String status) {
        Connection connection = null;
        PreparedStatement preparedStatement= null;

        try{
            connection = DriverManager.getConnection(url,userName,password);
            preparedStatement = connection.prepareStatement("insert into Busstop values(?,?,?,?,?,?,?)");
            preparedStatement.setInt(1,0);
            preparedStatement.setString(2,busStop);
            preparedStatement.setString(3,location);
            preparedStatement.setInt(4,noOfBus);
            preparedStatement.setString(5,starting);
            preparedStatement.setString(6,destination);
            preparedStatement.setString(7,status);

            int row = preparedStatement.executeUpdate();
            System.out.println("no of rows inserted :"+row);


        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                } else if (preparedStatement != null) {
                    connection.close();
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
        return 0;
    }

    @Override
    public ResultSet getAllData() {
        return null;
    }

    @Override
    public ResultSet getDataById(int id) {
        return null;
    }

    @Override
    public int updateByField(int id, String busStop, String location, int noOfBus, String starting, String destination, String status) {
        return 0;
    }

    @Override
    public int updateByAnd(int id, String busStop, String location, int noOfBus, String starting, String destination, String status) {
        return 0;
    }

    @Override
    public int updateByOr(int id, String busStop, String location, int noOfBus, String starting, String destination, String status) {
        return 0;
    }

    @Override
    public ResultSet activeBus() {
        return null;
    }

    @Override
    public ResultSet deleteById(int id) {
        return null;
    }
}

//    @Override
//    public ResultSet getAllData() {
//        return null;
//    }
//
//    @Override
//    public ResultSet getDataById(int id) {
//        return null;
//    }
//
//    @Override
//    public int updateByField(int id, String busStop, String location, int noOfBus, String starting, String destination, String status) {
//        return 0;
//    }
//
//    @Override
//    public int updateByAnd(int id, String busStop, String location, int noOfBus, String starting, String destination, String status) {
//        return 0;
//    }
//
//    @Override
//    public int updateByOr(int id, String busStop, String location, int noOfBus, String starting, String destination, String status) {
//        return 0;
//    }
//
//    @Override
//    public ResultSet activeBus() {
//        return null;
//    }
//
//    @Override
//    public ResultSet deleteById(int id) {
//        return null;
//    }
//}
