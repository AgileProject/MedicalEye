package cn.edu.seu.eye.core.data_transform;

import cn.edu.seu.eye.core.MongoDBDao.entity.Database;
import cn.edu.seu.eye.core.MongoDBDao.entity.Hardware;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by acer-pc on 2014/12/10.
 */
public class Alarm {
    private float cpuLowAlarm;
    private float cpuHighAlarm;
    private float ramLowAlarm;
    private float ramHighAlarm;
    private float diskLowAlarm;
    private float diskHighAlarm;
    private int linkNumLowAlarm;
    private int linkNumHighAlarm;
    private int databaseSizeLowAlarm;
    private int databaseSizeHighAlarm;
    private float databaseRamLowAlarm;
    private float databaseRamHighAlarm;
    private String computerName;
    private String message;
    private int level;
    private Date time;
    public void setCpuLowAlarm(float cpuLowAlarm) {
        this.cpuLowAlarm = cpuLowAlarm;
    }

    public void setCpuHighAlarm(float cpuHighAlarm) {
        this.cpuHighAlarm = cpuHighAlarm;
    }

    public void setRamLowAlarm(float ramLowAlarm) {
        this.ramLowAlarm = ramLowAlarm;
    }

    public void setRamHighAlarm(float ramHighAlarm) {
        this.ramHighAlarm = ramHighAlarm;
    }

    public void setDiskLowAlarm(float diskLowAlarm) {
        this.diskLowAlarm = diskLowAlarm;
    }

    public void setDiskHighAlarm(float diskHighAlarm) {
        this.diskHighAlarm = diskHighAlarm;
    }

    public void setLinkNumLowAlarm(int linkNumLowAlarm) {
        this.linkNumLowAlarm = linkNumLowAlarm;
    }

    public void setLinkNumHighAlarm(int linkNumHighAlarm) {
        this.linkNumHighAlarm = linkNumHighAlarm;
    }

    public void setDatabaseSizeLowAlarm(int databaseSizeLowAlarm) {
        this.databaseSizeLowAlarm = databaseSizeLowAlarm;
    }

    public void setDatabaseSizeHighAlarm(int databaseSizeHighAlarm) {
        this.databaseSizeHighAlarm = databaseSizeHighAlarm;
    }

    public void setDatabaseRamLowAlarm(float databaseRamLowAlarm) {
        this.databaseRamLowAlarm = databaseRamLowAlarm;
    }

    public void setDatabaseRamHighAlarm(float databaseRamHighAlarm) {
        this.databaseRamHighAlarm = databaseRamHighAlarm;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public float getCpuLowAlarm() {
        return cpuLowAlarm;
    }

    public float getCpuHighAlarm() {
        return cpuHighAlarm;
    }

    public float getRamLowAlarm() {
        return ramLowAlarm;
    }

    public float getRamHighAlarm() {
        return ramHighAlarm;
    }

    public float getDiskLowAlarm() {
        return diskLowAlarm;
    }

    public float getDiskHighAlarm() {
        return diskHighAlarm;
    }

    public int getLinkNumLowAlarm() {
        return linkNumLowAlarm;
    }

    public int getLinkNumHighAlarm() {
        return linkNumHighAlarm;
    }

    public int getDatabaseSizeLowAlarm() {
        return databaseSizeLowAlarm;
    }

    public int getDatabaseSizeHighAlarm() {
        return databaseSizeHighAlarm;
    }

    public float getDatabaseRamLowAlarm() {
        return databaseRamLowAlarm;
    }

    public float getDatabaseRamHighAlarm() {
        return databaseRamHighAlarm;
    }

    public String getComputerName() {
        return computerName;
    }

    public String getMessage() {
        return message;
    }

    public int getLevel() {
        return level;
    }

    public Date getTime() {
        return time;
    }

    //检查Hardware中的报警数据
   public void alarmCheckHard(List<Hardware> list)
   {
       List<Alarm> alarmList = new ArrayList<>();
       List<Alarm> li = readAlarmIndexs();

       for (Alarm alarm:li) {
           for (Hardware hardware : list) {
               if (alarm.getComputerName().equals(hardware.getComputerName()) ) {
                   Float hard = hardware.getCpuUtilization();
                   Float alarmdata = alarm.getCpuLowAlarm();
                   Float alarmdata1 = alarm.getCpuHighAlarm();
                   if (hard > alarmdata) {
                       Alarm al = new Alarm();
                       al.setComputerName(hardware.getComputerName());
                       al.setTime(hardware.getTime());
                       al.setMessage("CPU使用率为" + hardware.getCpuUtilization());
                       if (hard > alarmdata1) {
                           al.setLevel(1);
                       } else {
                           al.setLevel(0);
                       }
                       alarmList.add(al);
                   }
                   Float hard1 = hardware.getMemUsedPercent();
                   Float ala1 = alarm.getRamLowAlarm();
                   Float ala11 = alarm.getRamHighAlarm();
                   if (hard1 > ala1) {
                       Alarm al = new Alarm();
                       al.setComputerName(hardware.getComputerName());
                       al.setTime(hardware.getTime());
                       al.setMessage("RAM使用率为" + hardware.getMemUsedPercent());
                       if (hard1 > ala11) {
                           al.setLevel(1);
                       } else {
                           al.setLevel(0);
                       }
                       alarmList.add(al);
                   }
                   Float hard2 = hardware.getDiskUtilization();
                   Float ala2 = alarm.getDiskLowAlarm();
                   Float ala22 =alarm.getDiskHighAlarm();
                   if (hard2 > ala2) {
                       Alarm al = new Alarm();
                       al.setComputerName(hardware.getComputerName());
                       al.setTime(hardware.getTime());
                       al.setMessage("硬盘使用率为" + hardware.getDiskUtilization());
                       if (hard2 > ala22) {
                           al.setLevel(1);
                       } else {
                           al.setLevel(0);
                       }
                       alarmList.add(al);
                   }
               }
           }
       }
       if (alarmList.size()!=0)
       {
           new BatchImportData().importAlarmTable(alarmList);
       }

   }
    //检查Database中的报警数据
   public void alarmCheckDB(List<Database> list)
   {
       List<Alarm> alarmList = new ArrayList<>();
       List<Alarm> li = readAlarmIndexs();

       for (Alarm alarm:li) {
           for (Database database : list) {
               if (alarm.getComputerName().equals(database.getComputerName()) ) {
                   Integer db = database.getLinkNumb();
                   Integer ala1 = alarm.getLinkNumLowAlarm();
                   Integer ala11 = alarm.getLinkNumHighAlarm();
                   if (db > ala1) {
                       Alarm al = new Alarm();
                       al.setComputerName(database.getComputerName());
                       al.setTime(database.getTime());
                       al.setMessage("数据库连接数" + database.getLinkNumb());
                       if (db > ala11) {
                           al.setLevel(1);
                       } else {
                           al.setLevel(0);
                       }
                       alarmList.add(al);
                   }
                   Integer db1 = database.getSize();
                   Integer ala2 = alarm.getDatabaseSizeLowAlarm();
                   Integer ala22 = alarm.getDatabaseSizeHighAlarm();
                   if (db1 > ala2) {
                       Alarm al = new Alarm();
                       al.setComputerName(database.getComputerName());
                       al.setTime(database.getTime());
                       al.setMessage("数据库使用大小为" + database.getSize());
                       if (db1 > ala22) {
                           al.setLevel(1);
                       } else {
                           al.setLevel(0);
                       }
                       alarmList.add(al);
                   }
                   Float db3 = database.getRamUtilization();
                   Float ala3 = alarm.getDatabaseRamLowAlarm();
                   Float ala33 = alarm.getDatabaseRamHighAlarm();
                   if (db3 > ala3) {
                       Alarm al = new Alarm();
                       al.setComputerName(database.getComputerName());
                       al.setTime(database.getTime());
                       al.setMessage("数据库RAM使用率为" + database.getRamUtilization());
                       if (db3 > ala33) {
                           al.setLevel(1);
                       } else {
                           al.setLevel(0);
                       }
                       alarmList.add(al);
                   }
               }
           }
       }
       if (alarmList.size()!=0)
       {
           new BatchImportData().importAlarmTable(alarmList);
       }
   }

    //读取报警指标
    public List<Alarm> readAlarmIndexs()
    {
        Connection con = new BatchImportData().init();
        List list = new ArrayList();
        try
        {
            String sql = "select * from SYS_ALARMINDEXS";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next())
            {
                Alarm alarm = new Alarm();
                alarm.setComputerName(resultSet.getString("COMPUTER_NAME"));
                alarm.setCpuLowAlarm(resultSet.getFloat("CPU_LOWALARM"));
                alarm.setCpuHighAlarm(resultSet.getFloat("CPU_HIGHALARM"));
                alarm.setRamLowAlarm(resultSet.getFloat("RAM_LOWALARM"));
                alarm.setRamHighAlarm(resultSet.getFloat("RAM_HIGHALARM"));
                alarm.setDiskLowAlarm(resultSet.getFloat("DISK_LOWALARM"));
                alarm.setDiskHighAlarm(resultSet.getFloat("DISK_HIGHALARM"));
                alarm.setLinkNumLowAlarm(resultSet.getInt("LINK_NUMB_LOWALARM"));
                alarm.setLinkNumHighAlarm(resultSet.getInt("LINK_NUMB_HIGHALARM"));
                alarm.setDatabaseSizeLowAlarm(resultSet.getInt("DATABASE_SIZE_LOWALARM"));
                alarm.setDatabaseSizeHighAlarm(resultSet.getInt("DATABASE_SIZE_HIGHALARM"));
                alarm.setDatabaseRamLowAlarm(resultSet.getFloat("DATABASE_RAM_LOWALARM"));
                alarm.setDatabaseRamHighAlarm(resultSet.getFloat("DATABASE_RAM_HIGHALARM"));
                list.add(alarm);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    //删除Alarm
    public void deleteAlarm()
    {
        Connection con = new BatchImportData().init();
        try {
            String sql = "delete  from SYS_ALARMS";
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            con.close();
            System.out.println("Delete OK");
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
