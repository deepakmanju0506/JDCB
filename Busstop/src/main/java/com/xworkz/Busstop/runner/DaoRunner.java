package com.xworkz.Busstop.runner;

import com.xworkz.Busstop.dao.BusStopDao;
import com.xworkz.Busstop.daoImpl.BusStopDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoRunner {
    private  static BusStopDao busStopDaoDao=new BusStopDaoImpl();


    public static void main(String[] args) {
        busStopDaoDao.save("Javgal","Arsikere",78,"kargunda","Javgal");
        ResultSet resultSet= busStopDaoDao.getAllData();
        try {
            if(resultSet.isFirst()==false){

                while(resultSet.next()){
                    int ID=resultSet.getInt(1);
                    String busstop_name=resultSet.getString(2);
                    String location=resultSet.getString(3);
                    int noofbus=resultSet.getInt(4);
                    String  bus_starting=resultSet.getString(5);
                    String destination=resultSet.getString(6);
                    System.out.println(" ID:  " + ID + "   Name:  " + busstop_name + "  BusStop Location:  " + location + "   NoOfBus:  " +  noofbus + "  Bus Starting: " + bus_starting+ "   Bus Destination: " + destination);

                }
            }else {
                System.out.println("no data found");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
