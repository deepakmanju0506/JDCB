package com.xworkz.Busstop.runner;

import com.xworkz.Busstop.dao.BusStopDao;
import com.xworkz.Busstop.daoImpl.BusStopDaoImpl;

public class UpdateByFieldsRunner {
    private static BusStopDao busStopDao=new BusStopDaoImpl();
    public static void main(String[] args) {
        int update=busStopDao.updateByField(3,"nagasandra","banglore",45,"Rajajinagar","peenya");
        System.out.println(update+": 3rd Row updated");

        int updatedBy2Field=busStopDao.updateByAnd(4,"hasaan","banglore",45,"malleshwaram","vijaynagar");
        System.out.println(updatedBy2Field+": 4th Row updated by using AND operation");

        int updateOr=busStopDao.updateByOr(2,"Bus Nildana","banglore",90,"peenya","rajajinagar");
        System.out.println(updateOr+": 2nd Row updated by using OR operation ");

    }
}
