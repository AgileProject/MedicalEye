package cn.edu.seu.eye.core.MongoDBDao.entity;

import java.util.Date;

/**
 * Created by Administrator on 14-12-1.
 */
public class Database {
    private String computerName;
    private String databaseName;
    private Date time;
    private int linkNumb;
    private int size;
    private float ramUtilization;

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getLinkNumb() {
        return linkNumb;
    }

    public void setLinkNumb(int linkNumb) {
        this.linkNumb = linkNumb;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public float getRamUtilization() {
        return ramUtilization;
    }

    public void setRamUtilization(float ramUtilization) {
        this.ramUtilization = ramUtilization;
    }
}
