package cn.edu.seu.eye.core.data_transform;

import cn.edu.seu.eye.core.MongoDBDao.dao.IComputerDao;
import cn.edu.seu.eye.core.MongoDBDao.dao.IDatabaseDao;
import cn.edu.seu.eye.core.MongoDBDao.dao.IHardwareDao;
import cn.edu.seu.eye.core.MongoDBDao.entity.Computer;
import cn.edu.seu.eye.core.MongoDBDao.entity.Database;
import cn.edu.seu.eye.core.MongoDBDao.entity.Hardware;
import cn.edu.seu.eye.core.MongoDBDao.utils.DaoFactory;

import java.util.*;

/**
 * Created by acer-pc on 2014/12/7.
 */
public class GetMongoDBData {
    //间隔1分钟从MongoDB获取数据
    public void getMongoDBData()
    {

        IComputerDao computerDao = (IComputerDao)DaoFactory.getInstance("Computer","filetest","ee-lab");
        List<Computer> computerList = new ArrayList<>();
        computerList = computerDao.getAllComputers();
        final int size = computerList.size();
        GetSQLServerRec getSQLServerRec = new GetSQLServerRec().getLastRec();
        //Date date1,date2;

        //检查表中是否已有数据，防止重复插入数据
        if (getSQLServerRec.getHardRec()!=0) {
            IHardwareDao hardwareDao = (IHardwareDao) DaoFactory.getInstance("Hardware", "filetest", "ee-lab");
            hardwareDao.setLastQueryTime(getSQLServerRec.getHardDate());
        }
        if (getSQLServerRec.getDbRec()!=0) {
            IDatabaseDao databaseDao = (IDatabaseDao) DaoFactory.getInstance("Database", "filetest", "ee-lab");
            databaseDao.setLastQueryTime(getSQLServerRec.getDbDate());
        }
        //获取Hardware
        new Timer().schedule(new TimerTask() {
            IHardwareDao hardwareDao = (IHardwareDao)DaoFactory.getInstance("Hardware", "filetest", "ee-lab");
            List<Hardware> list = new ArrayList<>();
            int len = 0;


            @Override
            public void run() {

                 len = hardwareDao.storeNRecordToListAfter(size, list);
                if (len!=0) {
                    checkComTable();//检查Computer是否增加
                    new Alarm().alarmCheckHard(list);//检查是否含有报警数据
                    new BatchImportData().importDataHard(list);//导入Hardware表到SQL Server
                }
            }
        },0,1000*60);

        //获取Database
        new Timer().schedule(new TimerTask() {
            IDatabaseDao databaseDao = (IDatabaseDao) DaoFactory.getInstance("Database","filetest","ee-lab");
            List<Database> list = new ArrayList<>();
            int len = 0;

            @Override
            public void run() {
                 len = databaseDao.storeNRecordToListAfter(size, list);
                if (len!=0) {
                    checkComTable();
                    new Alarm().alarmCheckDB(list);//检查是否含有报警数据
                    new BatchImportData().importDataDB(list);//导入Database表到SQL Server
                }
            }
        },0,1000*60);
    }

    //初始化Computer
    public void initComData(){
        GetSQLServerRec getSQLServerRec = new GetSQLServerRec().checkRec();//检查Computer中是否有记录
        if (getSQLServerRec.getComRec()==0) {
            IComputerDao computerDao = (IComputerDao) DaoFactory.getInstance("Computer", "filetest", "ee-lab");
            List<Computer> list = new ArrayList<>();
            int len = 0;
            list = computerDao.getAllComputers();
            len = list.size();
            new BatchImportData().importDataCom(list);
            new BatchImportData().initAlarmIndex(list);
        }

    }

    //检查Computer是否增加
    public void checkComTable()
    {
        IComputerDao computerDao = (IComputerDao)DaoFactory.getInstance("Computer", "filetest", "ee-lab");
        List<Computer> list = new ArrayList<>();
        int len = 0;
        list = computerDao.getAllComputers();
        len = list.size();
        BatchImportData bi = new BatchImportData();
        GetSQLServerRec getSQLServerRec = new GetSQLServerRec().checkRec();
        int j =getSQLServerRec.getComRec();
        if (len!=j)
        {
            bi.reImportCom(list);
        }
    }
}
