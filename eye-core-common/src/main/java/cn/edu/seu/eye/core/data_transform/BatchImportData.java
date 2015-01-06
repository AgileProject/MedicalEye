package cn.edu.seu.eye.core.data_transform;

import cn.edu.seu.eye.core.MongoDBDao.entity.Computer;
import cn.edu.seu.eye.core.MongoDBDao.entity.Database;
import cn.edu.seu.eye.core.MongoDBDao.entity.Hardware;

import java.sql.*;
import java.util.List;

/**
 * Created by acer-pc on 2014/12/7.
 */
public class BatchImportData
{
    private String url;
    private String username;
    private String password;
    private String driver;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //初始化数据库jdbc驱动
    public Connection init(){
        BatchImportData bi = new BatchImportData();
//        bi.setDriver("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        bi.setUrl("jdbc:sqlserver://localhost:1433;databaseName=DB_eye");
//        bi.setUsername("user");
//        bi.setPassword("123456");
        bi.setDriver("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        bi.setUrl("jdbc:sqlserver://10.6.12.15:1433;databaseName=test");
        bi.setUsername("SEUXTYXJG");
        bi.setPassword("SEUXTYXJG");
        Connection con = null;
        try {
            Class.forName(bi.getDriver());
            con = DriverManager.getConnection(bi.getUrl(), bi.getUsername(), bi
                    .getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }

    //导入Computer
    public void importDataCom(List<Computer> list)
    {
        Connection con = init();
          try
          {
              con.setAutoCommit(false);
              String insertSqlCom = "insert into SYS_COMPUTERS(COMPUTER_NAME,COMPUTER_IP,COMPUTER_OS,COMPUTER_CPU,COMPUTER_RAM,COMPUTER_DISK,COMPUTER_DB) values(?,?,?,?,?,?,?)";
              PreparedStatement ps = con.prepareStatement(insertSqlCom);

              for ( Computer computer: list) {
                  ps.setString(1,computer.getComputerName());
                  ps.setString(2,computer.getComputerIP());
                  ps.setString(3,computer.getComputerOS());
                  ps.setString(4,computer.getProInfo());
                  ps.setString(5,computer.getMemInfo());
                  ps.setString(6,computer.getDiskInfo());
                  ps.setString(7,computer.getDbInfo());
                  ps.addBatch();
              }
              ps.executeBatch();
              con.commit();
              System.out.println("Computer OK");
          }
          catch (SQLException e)
          {
                    e.printStackTrace();
                    try {
                        con.rollback();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
          } finally
          {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
          }
    }

    //导入Hardware
    public void importDataHard(List<Hardware> list) {
        Connection con = init();
        try {
            con.setAutoCommit(false);
            String insertSqlHard = "insert into SYS_HARDWARE(COMPUTER_NAME,UPDATA_TIME,CPU_UTILZATION,CPU_RUNTIME,PROCESSES,RAM_USEDPERCENT,DISK_UTILZATION) values(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(insertSqlHard);

            for (Hardware hardware : list) {
                ps.setString(1, hardware.getComputerName());
                ps.setTimestamp(2, new Timestamp(hardware.getTime().getTime()));
                ps.setFloat(3, hardware.getCpuUtilization());
                ps.setFloat(4, hardware.getCpuRunTime());
                ps.setInt(5, hardware.getProcess());
                ps.setFloat(6, hardware.getMemUsedPercent());
                ps.setFloat(7, hardware.getDiskUtilization());
                ps.addBatch();
            }
            ps.executeBatch();
            con.commit();
            System.out.println("Hardware OK");
            System.out.println(list);
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //导入Database
    public void importDataDB(List<Database> list)
    {
        Connection con = init();
        try
        {
            con.setAutoCommit(false);
            String insertSqlDB = "insert into SYS_DATABASE(COMPUTER_NAME,DATABASE_NAME,UPDATA_TIME,LINK_NUMB,DATABASE_SIZE,RAM_UTILIZATION) values(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(insertSqlDB);
            for (Database database : list) {
                ps.setString(1,database.getComputerName());
                ps.setString(2,database.getDbInfo());
                ps.setTimestamp(3,new Timestamp(database.getTime().getTime()));
                ps.setInt(4,database.getLinkNumb());
                ps.setInt(5,database.getSize());
                ps.setFloat(6,database.getRamUtilization());
                ps.addBatch();
            }
            ps.executeBatch();
            con.commit();
            System.out.println("Database OK");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    //导入报警信息
    public void importAlarmTable(List<Alarm> list)
    {
        Connection con = init();
        try
        {
            con.setAutoCommit(false);
            String insertSqlDB = "insert into SYS_ALARMS(COMPUTER_NAME,ALARM_TIME,ALARM_MESSAGE,ALARM_LEVEL) values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(insertSqlDB);
            for (Alarm alarm : list) {
                ps.setString(1,alarm.getComputerName());
                ps.setTimestamp(2,new Timestamp(alarm.getTime().getTime()));
                ps.setString(3,alarm.getMessage());
                ps.setInt(4,alarm.getLevel());
                ps.addBatch();
            }
            ps.executeBatch();
            con.commit();
            System.out.println("Alarm OK");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //初始化报警指标
    public void initAlarmIndex(List<Computer>list)
    {
        Alarm alarm = new Alarm();
        alarm.setCpuLowAlarm(60.0f);
        alarm.setCpuHighAlarm(80.0f);
        alarm.setRamLowAlarm(60.0f);
        alarm.setRamHighAlarm(80.0f);
        alarm.setDiskLowAlarm(60.0f);
        alarm.setDiskHighAlarm(80.0f);
        alarm.setLinkNumLowAlarm(30);
        alarm.setLinkNumHighAlarm(50);
        alarm.setDatabaseSizeLowAlarm(1024);
        alarm.setDatabaseSizeHighAlarm(512);
        alarm.setDatabaseRamLowAlarm(512.0f);
        alarm.setDatabaseRamHighAlarm(256.0f);
        Connection con = new BatchImportData().init();
        try {
            con.setAutoCommit(false);
            String insertSqlCom = "insert into SYS_ALARMINDEXS(COMPUTER_NAME,CPU_LOWALARM,CPU_HIGHALARM,RAM_LOWALARM,RAM_HIGHALARM," +
                    "DISK_LOWALARM,DISK_HIGHALARM,DATABASE_NAME,LINK_NUMB_LOWALARM,LINK_NUMB_HIGHALARM," +
                    "DATABASE_SIZE_LOWALARM,DATABASE_SIZE_HIGHALARM,DATABASE_RAM_LOWALARM,DATABASE_RAM_HIGHALARM) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(insertSqlCom);
            for ( Computer computer: list) {
                ps.setString(1,computer.getComputerName());
                ps.setFloat(2, alarm.getCpuLowAlarm());
                ps.setFloat(3, alarm.getCpuHighAlarm());
                ps.setFloat(4, alarm.getRamLowAlarm());
                ps.setFloat(5, alarm.getRamHighAlarm());
                ps.setFloat(6, alarm.getDiskLowAlarm());
                ps.setFloat(7, alarm.getDiskHighAlarm());
                ps.setString(8, computer.getDbInfo());
                ps.setInt(9, alarm.getLinkNumLowAlarm());
                ps.setInt(10,alarm.getLinkNumHighAlarm());
                ps.setInt(11,alarm.getDatabaseSizeLowAlarm());
                ps.setInt(12,alarm.getDatabaseSizeHighAlarm());
                ps.setFloat(13, alarm.getDatabaseRamLowAlarm());
                ps.setFloat(14,alarm.getDatabaseRamHighAlarm());
                ps.addBatch();
            }
            ps.executeBatch();
            con.commit();
            System.out.println("AlarmIndex OK");
        }catch (SQLException e)
        {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally
        {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    //重新导入COMPUTER表
        public void reImportCom(List<Computer>list)
        {
            Connection con = init();
            try {
                String sql = "delete  from SYS_COMPUTERS";
                Statement statement = con.createStatement();
                statement.executeUpdate(sql);
                statement.close();
                con.close();
                System.out.println("Delete Computer OK");
            }catch (SQLException e) {
                e.printStackTrace();
            }
            importDataCom(list);
        }



}

