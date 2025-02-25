package com.xworkz.Busstop.runner;

import com.xworkz.Busstop.dao.BusStopDao;
import com.xworkz.Busstop.daoImpl.BusStopDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class getIdRunner {
    private static BusStopDao busStopDaoDao = new BusStopDaoImpl();
    private static boolean isEmpty = true;

    public static void main(String[] args) {
        ResultSet resultSet = busStopDaoDao.getDataById(3);
        try {

            while (resultSet.next()) {
                isEmpty = false;
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String location = resultSet.getString(3);
                int noOfBus = resultSet.getInt(4);
                String  bus_starting = resultSet.getString(5);
                String destination = resultSet.getString(6);
                System.out.println("id: " + id + " name: " + name + " BusStop Name: " + name + " Location:  " + location + "  noOfBus:  " + noOfBus + "Bus Starting :  " +  bus_starting + "  Bus destination :  " + destination);
            }
            if (isEmpty) {
                System.out.println("Data is not found..");
            }
        }

        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
