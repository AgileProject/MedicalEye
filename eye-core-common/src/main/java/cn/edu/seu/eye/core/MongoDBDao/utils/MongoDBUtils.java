package cn.edu.seu.eye.core.MongoDBDao.utils;

import cn.edu.seu.eye.core.MongoDBDao.dao.IComputerDao;
import cn.edu.seu.eye.core.MongoDBDao.dao.IDao;
import cn.edu.seu.eye.core.MongoDBDao.dao.IDatabaseDao;
import cn.edu.seu.eye.core.MongoDBDao.dao.IHardwareDao;
import cn.edu.seu.eye.core.MongoDBDao.entity.Computer;
import cn.edu.seu.eye.core.MongoDBDao.entity.Database;
import cn.edu.seu.eye.core.MongoDBDao.entity.Hardware;
import cn.edu.seu.eye.core.MongoDBDao.utils.DaoFactory;
import net.sf.json.JSONObject;

import java.util.*;

/**
 * Created by Administrator on 14-12-7.
 */
public class MongoDBUtils {

//    List<String> keyList = Arrays.asList("computerName", "computerIP","computerOS","proInfo",
//            "memInfo","diskInfo","dbInfo","linkNumb","size","ramUtilization","time",
//            "cpuUtilization","cpuRunTime","process","memUsedPercent","diskUtilization");


    private static IComputerDao computerDao =
            (IComputerDao) DaoFactory.getInstance("Computer","jsontest","ee-lab");
    private static IDatabaseDao databaseDao =
            (IDatabaseDao) DaoFactory.getInstance("Database","jsontest","ee-lab");
    private static IHardwareDao hardwareDao =
            (IHardwareDao) DaoFactory.getInstance("Hardware","jsontest","ee-lab");

    @SuppressWarnings("all")
    public static int insertIntoMongoDB(String data){

        JSONObject jsonObject = JSONObject.fromObject(data);

        Computer computer = getComputer(jsonObject);
        Database database = getDatabase(jsonObject);
        Hardware hardware = getHardware(jsonObject);


        if ( computer != null){
            computerDao.insert(computer);
        }
        if ( database != null){
            databaseDao.insert(database);
        }
        if ( hardware != null){
            hardwareDao.insert(hardware);
        }

        return 0;
    }


    private static Computer getComputer(JSONObject jsonObject){

        if(jsonObject.getString("computerName").equals("")){return null;}
        if(jsonObject.getString("computerIP").equals("")){return null;}
        if(jsonObject.getString("computerOS").equals("")){return null;}
        if(jsonObject.getString("proInfo").equals("")){return null;}
        if(jsonObject.getString("memInfo").equals("")){return null;}
        if(jsonObject.getString("diskInfo").equals("")){return null;}
        if(jsonObject.getString("dbInfo").equals("")){return null;}
        if(jsonObject.getString("time").equals("")){return null;}

        Computer computer = new Computer();

        computer.setComputerName(jsonObject.getString("computerName"));
        computer.setComputerIP(jsonObject.getString("computerIP"));
        computer.setComputerOS(jsonObject.getString("computerOS"));
        computer.setProInfo(jsonObject.getString("proInfo"));
        computer.setMemInfo(jsonObject.getString("memInfo"));
        computer.setDiskInfo(jsonObject.getString("diskInfo"));
        computer.setDbInfo(jsonObject.getString("dbInfo"));
        computer.setTime(new Date(Long.parseLong(jsonObject.getString("time"))));

        return computer;

    }

    private static Database getDatabase(JSONObject jsonObject){

        if (jsonObject.getString("computerName").equals("")){return null;}
        if (jsonObject.getString("dbInfo").equals("")){return null;}
        if (jsonObject.getString("time").equals("")){return null;}
        if (jsonObject.getString("linkNumb").equals("")){return null;}
        if (jsonObject.getString("size").equals("")){return null;}
        if (jsonObject.getString("ramUtilization").equals("")){return null;}

        Database database = new Database();

        database.setComputerName(jsonObject.getString("computerName"));
        database.setDbInfo(jsonObject.getString("dbInfo"));
        database.setTime(new Date(Long.parseLong(jsonObject.getString("time"))));
        database.setLinkNumb(Integer.parseInt(jsonObject.getString("linkNumb")));
        database.setSize(Integer.parseInt(jsonObject.getString("size")));
        database.setRamUtilization(Float.parseFloat(jsonObject.getString("ramUtilization")));

        return database;
    }

    private static Hardware getHardware(JSONObject jsonObject){

        if (jsonObject.getString("computerName").equals("")){return null;}
        if (jsonObject.getString("time").equals("")){return null;}
        if (jsonObject.getString("cpuUtilization").equals("")){return null;}
        if (jsonObject.getString("cpuRunTime").equals("")){return null;}
        if (jsonObject.getString("process").equals("")){return null;}
        if (jsonObject.getString("memUsedPercent").equals("")){return null;}
        if (jsonObject.getString("diskUtilization").equals("")){return null;}

        Hardware hardware = new Hardware();

        hardware.setComputerName(jsonObject.getString("computerName"));
        hardware.setTime(new Date(Long.parseLong(jsonObject.getString("time"))));
        hardware.setCpuUtilization(Float.parseFloat(jsonObject.getString("cpuUtilization")));
        hardware.setCpuRunTime(Float.parseFloat(jsonObject.getString("cpuRunTime")));
        hardware.setProcess(Integer.parseInt(jsonObject.getString("process")));
        hardware.setMemUsedPercent(Float.parseFloat(jsonObject.getString("memUsedPercent")));
        hardware.setDiskUtilization(Float.parseFloat(jsonObject.getString("diskUtilization")));

        return hardware;
    }
}
