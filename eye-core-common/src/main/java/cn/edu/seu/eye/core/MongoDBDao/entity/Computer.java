package cn.edu.seu.eye.core.MongoDBDao.entity;

import java.util.Date;
import java.util.Timer;

/**
 * Created by Administrator on 14-12-1.
 */
public class Computer {
    private String computerName;
    private String computerIP;
    private String computerOS;
    private String proInfo;
    private String memInfo;
    private String diskInfo;
    private String databaseInfo;
    private Date time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getComputerIP() {
        return computerIP;
    }

    public void setComputerIP(String computerIP) {
        this.computerIP = computerIP;
    }

    public String getComputerOS() {
        return computerOS;
    }

    public void setComputerOS(String computerOS) {
        this.computerOS = computerOS;
    }

    public String getProInfo() {
        return proInfo;
    }

    public void setProInfo(String proInfo) {
        this.proInfo = proInfo;
    }

    public String getMemInfo() {
        return memInfo;
    }

    public void setMemInfo(String memInfo) {
        this.memInfo = memInfo;
    }

    public String getDiskInfo() {
        return diskInfo;
    }

    public void setDiskInfo(String diskInfo) {
        this.diskInfo = diskInfo;
    }

    public String getDatabaseInfo() {
        return databaseInfo;
    }

    public void setDatabaseInfo(String databaseInfo) {
        this.databaseInfo = databaseInfo;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "computerName='" + computerName + '\'' +
                ", computerIP='" + computerIP + '\'' +
                ", computerOS='" + computerOS + '\'' +
                ", proInfo='" + proInfo + '\'' +
                ", memInfo='" + memInfo + '\'' +
                ", diskInfo='" + diskInfo + '\'' +
                ", databaseInfo='" + databaseInfo + '\'' +
                ", time=" + time +
                '}';
    }
}
