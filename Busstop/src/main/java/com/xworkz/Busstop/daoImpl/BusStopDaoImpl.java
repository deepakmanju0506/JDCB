package com.xworkz.Busstop.daoImpl;

import com.xworkz.Busstop.dao.BusStopDao;

import java.sql.*;

public class BusStopDaoImpl implements BusStopDao {

    String url = "jdbc:mysql://locslhost:3306/busstop";
    String userName = "root";
    String pass = "Xworkzodc@123";


    @Override
    public int save(String busstop_name, String location, int noOfBus, String bus_starting, String destination) {

        Connection connection = null;
        PreparedStatement preparedStatement =null;

        try{
            connection= DriverManager.getConnection(url,userName,pass);
            preparedStatement = connection.prepareStatement("insert into Busstop values(?,?,?,?,?,?)");
            preparedStatement.setInt(1,0);
            preparedStatement.setString(2,busstop_name);
            preparedStatement.setString(3,location);
            preparedStatement.setInt(4,noOfBus);
            preparedStatement.setString(5,bus_starting);
            preparedStatement.setString(6,destination);

            int row = preparedStatement.executeUpdate();
            System.out.println("no of rows inserted: "+row);


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            try{
                if(connection != null){
                    connection.close();
                } else if (preparedStatement != null) {
                    connection.close();
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }

        return 0;
    }

    @Override
    public ResultSet getAllData() {
        try{
            Connection connection = DriverManager.getConnection(url,userName,pass);
            PreparedStatement statement = connection.prepareStatement("select * from Busstop ");
            ResultSet resultSet  =statement.executeQuery();
            return resultSet;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ResultSet getDataById(int id) {

        try{
            Connection connection =DriverManager.getConnection(url,userName,pass);
            PreparedStatement statement = connection.prepareStatement("Select * from Busstop where id=?");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            return resultSet;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int updateByField(int id, String busstop_name, String location, int noOfBus, String bus_starting, String destination) {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url,userName,pass);
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("update Busstop set busstop_name=?,busstop_location=?,noobfbus=?,bus_starting=?,bus_destination=? where id=?" );
            statement.setInt(6,id);
            statement.setString(1,busstop_name);
            statement.setString(2,location);
            statement.setInt(3,noOfBus);
            statement.setString(4, bus_starting);
            statement.setString(5,destination);

            int row = statement.executeUpdate();
            connection.commit();
            return row;
        }catch(SQLException e){
            try{
                connection.rollback();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public int updateByAnd(int id, String busstop_name, String location, int noOfBus, String  bus_starting, String destination) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, pass);
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("update Busstop set  busstop_location=?,noofbus=?,bus_starting=?,bus_destination=? where id=? AND busstop_name=?");
            statement.setInt(5, id);
            statement.setString(6,busstop_name );
            statement.setString(1, location);
            statement.setInt(2,noOfBus);
            statement.setString(3, bus_starting);
            statement.setString(4,destination);
            int row = statement.executeUpdate();
            connection.commit();
            return row;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println(e.getMessage());
            }

            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public int updateByOr(int id, String busstop_name, String location, int noOfBus, String  bus_starting, String destination) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, pass);
            connection.setAutoCommit(false);
            PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM Busstop WHERE id=? OR busstop_name=?");
            PreparedStatement statement = connection.prepareStatement("update Busstop set  busstop_location=?,noofbus=?,bus_starting=?,bus_destination=? where id=? OR busstop_name=?");
            statement.setInt(5, id);
            statement.setString(6,busstop_name );
            statement.setString(1, location);
            statement.setInt(2,noOfBus);
            statement.setString(3, bus_starting);
            statement.setString(4,destination);
            selectStatement.setInt(1, id);
            selectStatement.setString(2, busstop_name);
            int row = statement.executeUpdate();
            connection.commit();
            return row;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                System.out.println(e.getMessage());
            }

            System.out.println(e.getMessage());
        }



        return 0;
    }
}
