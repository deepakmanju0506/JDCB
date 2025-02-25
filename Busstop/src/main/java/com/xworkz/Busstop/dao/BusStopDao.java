package com.xworkz.Busstop.dao;

import java.sql.ResultSet;

public interface BusStopDao {
    int save(String busstop_name,String location,int noOfBus,String starting,String destination);
    ResultSet getAllData();
    ResultSet getDataById(int id);
    int updateByField(int id,String busstop_name,String location,int noOfBus,String starting,String destination);
    int updateByAnd(int id,String busstop_name,String location,int noOfBus,String starting,String destination);
    int updateByOr(int id,String busstop_name,String location,int noOfBus,String starting,String destination);
}
