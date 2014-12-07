package cn.edu.seu.eye.core.Httpserver;

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

    public static int insertIntoMongoDB(String data){

        JSONObject jsonObject = JSONObject.fromObject(data);

        int computerInsertFlag = checkComputerEmpty(jsonObject);
        int databaseInsertFlag = checkDatabaseEmpty(jsonObject);
        int hardwareInsertFlag = checkHardwareEmpty(jsonObject);

        List<Object> list = jsonParse(jsonObject);

        if (computerInsertFlag == 1){
            while ( (computerDao.insert( (Computer) list.get(0))) != 1){}
        }
        if (databaseInsertFlag == 1){
            while ( (databaseDao.insert( (Database) list.get(1))) != 1){}
        }
        if (hardwareInsertFlag == 1){
            while ( (hardwareDao.insert( (Hardware) list.get(2))) != 1){}
        }

        return 0;
    }



    public static int checkComputerEmpty(JSONObject jsonObject){

        if(jsonObject.getString("computerName").equals("")){return 0;}
        if(jsonObject.getString("computerIP").equals("")){return 0;}
        if(jsonObject.getString("computerOS").equals("")){return 0;}
        if(jsonObject.getString("proInfo").equals("")){return 0;}
        if(jsonObject.getString("menInfo").equals("")){return 0;}
        if(jsonObject.getString("diskInfo").equals("")){return 0;}
        if(jsonObject.getString("databaseInfo").equals("")){return 0;}
        if(jsonObject.getString("time").equals("")){return 0;}

        return 1;
    }

    public static int checkDatabaseEmpty(JSONObject jsonObject){

        if (jsonObject.getString("computerName").equals("")){return 0;}
        if (jsonObject.getString("databaseName").equals("")){return 0;}
        if (jsonObject.getString("time").equals("")){return 0;}
        if (jsonObject.getString("linkNumb").equals("")){return 0;}
        if (jsonObject.getString("size").equals("")){return 0;}
        if (jsonObject.getString("ramUtilization").equals("")){return 0;}

        return 1;
    }

    public static int checkHardwareEmpty(JSONObject jsonObject){

        if (jsonObject.getString("computerName").equals("")){return 0;}
        if (jsonObject.getString("time").equals("")){return 0;}
        if (jsonObject.getString("cpuUtilization").equals("")){return 0;}
        if (jsonObject.getString("cpuRunTime").equals("")){return 0;}
        if (jsonObject.getString("process").equals("")){return 0;}
        if (jsonObject.getString("memUsedPercent").equals("")){return 0;}
        if (jsonObject.getString("diskUtilization").equals("")){return 0;}

        return 1;
    }


    public static List<Object> jsonParse(JSONObject jsonObject){

        List<Object> list = new ArrayList<>();

        list.add(getComputer(jsonObject));
        list.add(getDatabase(jsonObject));
        list.add(getHardware(jsonObject));

        return list;
    }

    public static Computer getComputer(JSONObject jsonObject){

        Computer computer = new Computer();

        computer.setComputerName(jsonObject.getString("computerName"));
        computer.setComputerIP(jsonObject.getString("computerIP"));
        computer.setComputerOS(jsonObject.getString("computerOS"));
        computer.setProInfo(jsonObject.getString("proInfo"));
        computer.setMemInfo(jsonObject.getString("memInfo"));
        computer.setDiskInfo(jsonObject.getString("diskInfo"));
        computer.setDatabaseInfo(jsonObject.getString("databaseInfo"));
        computer.setTime(new Date(Long.parseLong(jsonObject.getString("hdTime"))));

        return computer;

    }

    public static Database getDatabase(JSONObject jsonObject){

        Database database = new Database();

        database.setComputerName(jsonObject.getString("computerName"));
        database.setDatabaseName(jsonObject.getString("databaseName"));
        database.setTime(new Date(Long.parseLong(jsonObject.getString("time"))));
        database.setLinkNumb(Integer.parseInt(jsonObject.getString("linkNumb")));
        database.setSize(Integer.parseInt(jsonObject.getString("size")));
        database.setRamUtilization(Float.parseFloat(jsonObject.getString("ramUtilization")));

        return database;
    }

    public static Hardware getHardware(JSONObject jsonObject){

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
