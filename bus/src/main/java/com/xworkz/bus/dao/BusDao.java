package com.xworkz.bus.dao;

import java.sql.ResultSet;

public interface BusDao {
    int save(String busStop,String location,int noOfBus,String starting,String destination,String status);
    ResultSet getAllData();
    ResultSet getDataById(int id);
    int updateByField(int id,String busStop,String location,int noOfBus,String starting,String destination,String status);
    int updateByAnd(int id,String busStop,String location,int noOfBus,String starting,String destination,String status);
    int updateByOr(int id,String busStop,String location,int noOfBus,String starting,String destination,String status);
    ResultSet activeBus();
    ResultSet deleteById(int id);

}

