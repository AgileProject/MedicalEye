package cn.edu.seu.eye.core.MongoDBDao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import cn.edu.seu.eye.core.MongoDBDao.dao.IDao;
import cn.edu.seu.eye.core.MongoDBDao.dao.impl.AbstractDao;
import cn.edu.seu.eye.core.MongoDBDao.dao.impl.ComputerDaoImpl;
import cn.edu.seu.eye.core.MongoDBDao.dao.impl.DatabaseDaoImpl;
import cn.edu.seu.eye.core.MongoDBDao.dao.impl.HardwareDaoImpl;
import cn.edu.seu.eye.core.MongoDBDao.entity.Computer;
import cn.edu.seu.eye.core.MongoDBDao.entity.Database;
import cn.edu.seu.eye.core.MongoDBDao.entity.Hardware;
import cn.edu.seu.eye.core.MongoDBDao.utils.DaoFactory;


import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 14-11-21.
 */
public class hello {
    public static void main(String[] args){
        /* ����json-lib  ok
        SystemInfo systemInfo = new SystemInfo();
        systemInfo.setID("ID");
        systemInfo.setSysInfo("sysinfo");
        systemInfo.setProInfo("proinfo");
        systemInfo.setMemInfo("memeinfo");
        systemInfo.setDisInfo("diskinfo");
        systemInfo.setFilInfo("fielinfo");

        JSONObject jsonObject = JSONObject.fromObject(systemInfo);
        System.out.println(jsonObject);
        System.out.println(jsonObject.toString());

        String jsonstring ="{\"ID\":\"jc\",\"disInfo\":\"diskjc\",\"filInfo\":\"fieljc\",\"memInfo\":\"memejc\",\"proInfo\":\"projc\",\"sysInfo\":\"sysjc\"}";
        jsonObject = JSONObject.fromObject(jsonstring);
        SystemInfo systeminfoget = (SystemInfo) JSONObject.toBean(jsonObject,SystemInfo.class);
        System.out.println(systeminfoget.getSysInfo());
        System.out.println(systeminfoget.getID());
        */


        /* ���� EntityUtil.entityToBasicDBObject()  ok
        SystemInfo systemInfo = new SystemInfo();
        systemInfo.setComputerName("PC");
        systemInfo.setComputerIP("192.168.1.1");
        systemInfo.setComputerOS("windows");
        systemInfo.setProInfo("core 2");
        systemInfo.setMemInfo("2g");
        systemInfo.setDisInfo("2t");
        systemInfo.setDatabaseInfo("sql server");

        BasicDBObject basicDBObject =new BasicDBObject();
        try {
            basicDBObject=EntityUtil.entityToBasicDBObject(systemInfo);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(basicDBObject);
        */


        /*���� insert����  ok
        IDao iDao = new ("testData");
        SystemInfo systemInfo = new SystemInfo();
        systemInfo.setComputerName("jc");
        systemInfo.setComputerIP("192.168.1.1");
        systemInfo.setComputerOS("windows");
        systemInfo.setProInfo("core 2");
        systemInfo.setMemInfo("2g");
        systemInfo.setDisInfo("2t");
        systemInfo.setDatabaseInfo("sql server");

        iDao.insert(systemInfo);
        */


        /*���� batchInsert()  ok
        IDao iDao = new ("testData");
        List<SystemInfo> list = new ArrayList<SystemInfo>();

        for (int i=1; i<=10; i++){
            SystemInfo systemInfo = new SystemInfo();
            systemInfo.setComputerName(((Integer) i).toString());
            systemInfo.setComputerIP("192.168.1.1");
            systemInfo.setComputerOS("windows");
            systemInfo.setProInfo("core 2");
            systemInfo.setMemInfo("2g");
            systemInfo.setDisInfo("2t");
            systemInfo.setDatabaseInfo("sql server");
            list.add(systemInfo);
        }

        iDao.batchInsert(list);
        */


        /* ���� get���� OK
        IDao iDao = new ("testData");
        SystemInfo systemInfo = (SystemInfo) iDao.get(new BasicDBObject("computerName","10"));
        System.out.println(systemInfo.getComputerIP());
        System.out.println(systemInfo.getComputerName());
        System.out.println(systemInfo.getComputerOS());
        System.out.println(systemInfo.getDatabaseInfo());
        System.out.println(systemInfo.getDisInfo());
        System.out.println(systemInfo.getProInfo());
        */


//        IDao iDao = new ComputerDaoImpl("testData");
//        Computer computer = new Computer();
//        computer.setComputerName("newcomputer");
//        computer .setComputerIP("192.168.1.100");
//        computer.setComputerOS("unix");
//        computer .setProInfo("core2");
//        computer .setMemInfo("2g");
//        computer .setDiskInfo("wd");
//        computer .setDatabaseInfo("mydb");
//        iDao.insert(computer);
//        ArrayList<Computer> list = (ArrayList<Computer>) iDao.get(new BasicDBObject("computerName","newcomputer"));
//        Computer computerback = list.get(0);

//        IDao iDao = new HardwareDaoImpl("testData");
//        Hardware hardware = new Hardware() ;
//        hardware.setComputerName("hardcomputer");
//        hardware.setTime(new Date());
//        hardware.setCpuUtilization((float) 11.5);
//        hardware.setCpuRunTime((float) 74.6);
//        hardware.setProcesses(45);
//        hardware.setMemUsedPercent((float) 45.8);
//        hardware.setDiskUtilization((float) 45.7);
//        iDao.insert(hardware);
//        List<Hardware> list = (List<Hardware>) iDao.get(new BasicDBObject("computerName","hardcomputer"));
//        Hardware hardwareback = list.get(0);
//        System.out.println(hardwareback.getTime());

//        IDao iDao = new DatabaseDaoImpl("testData");
//        Database database = new Database() ;
//        database.setComputerName("databasecomputer");
//        database.setDatabaseName("sqlserver2013");
//        database.setTime(new Date());
//        database .setLinkNumb(100);
//        database.setSize(190);
//        database.setRamUtilization((float) 18.5);
//        iDao.insert(database);
//        List<Database> list = (List<Database>) iDao.get("linkNumb",100,"size",190);
//        Database databaseback = list.get(0);
//        System.out.println(databaseback.getTime());

//        IDao iDao = new ComputerDaoImpl("testData");
//        ArrayList<Computer> list = (ArrayList<Computer>) iDao.getLastNRecord(10,"computerIP","192.168.1.1");

//        IDao iDao = new ComputerDaoImpl("testData");
//        int i = iDao.update("computerName","jc","computerIP","192.168.1.155");
//        System.out.println(i);

//        IDao iDao= new ComputerDaoImpl("testData");
//        int i = iDao.delete("type","food");
//        System.out.println(i);

        IDao iDao = DaoFactory.getInstance("computer","mydb","10.6.95.15",27017);
        Computer computer = new Computer();
        computer.setComputerName("this is a new computer");
        computer.setComputerIP("192.168.1.250");
        computer.setComputerOS("Lnix");
        computer.setProInfo("core5");
        computer.setMemInfo("18g");
        computer.setDiskInfo("wd");
        computer.setDatabaseInfo("mongodb");
        int i = iDao.insert(computer);
        System.out.println(i);









    }
}
