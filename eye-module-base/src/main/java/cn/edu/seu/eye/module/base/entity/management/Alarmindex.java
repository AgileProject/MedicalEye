package cn.edu.seu.eye.module.base.entity.management;

/**
 * Created by DL on 2014/12/10.
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 系统用户
 */
@Entity
@Table(name = "SYS_ALARMINDEXS")
@JsonInclude(Include.NON_NULL)
public class Alarmindex implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "int|指标编号", length = 4, nullable = false)
    private int id;

    @Column(name = "COMPUTER_NAME", columnDefinition = "VARCHAR2|主机名", length = 20, nullable = true)
    private String computerName;

    @Column(name = "CPU_LOWALARM", columnDefinition = "float|服务器CPU低级报警", length = 8, nullable = true)
    private float cpuLowalarm;

    @Column(name = "CPU_HIGHALARM", columnDefinition = "float|服务器CPU高级报警", length = 8, nullable = true)
    private float cpuHighalarm;

    @Column(name = "RAM_LOWALARM", columnDefinition = "float|服务器RAM低级报警", length = 8, nullable = true)
    private float ramLowalarm;

    @Column(name = "RAM_HIGHALARM", columnDefinition = "float|服务器RAM高级报警", length = 8, nullable = true)
    private float ramHighalarm;

    @Column(name = "DISK_LOWALARM", columnDefinition = "float|服务器DISK低级报警", length = 8, nullable = true)
    private float diskLowalarm;

    @Column(name = "DISK_HIGHALARM", columnDefinition = "float|服务器DISK高级报警", length = 8, nullable = true)
    private float diskHighalarm;

    @Column(name = "DATABASE_NAME", columnDefinition = "VARCHAR2|数据库名称", length = 25, nullable = true)
    private String databaseName;

    @Column(name = "LINK_NUMB_LOWALARM", columnDefinition = "int|数据库连接数低级报警", length = 4, nullable = true)
    private int linkNumbLowalarm;

    @Column(name = "LINK_NUMB_HIGHALARM", columnDefinition = "int|数据库连接数高级报警", length = 4, nullable = true)
    private int linkNumbHighalarm;

    @Column(name = "DATABASE_SIZE_LOWALARM", columnDefinition = "int|数据库容量低级报警", length = 4, nullable = true)
    private int databaseSizeLowalarm;

    @Column(name = "DATABASE_SIZE_HIGHALARM", columnDefinition = "int|数据库容量高级报警", length = 4, nullable = true)
    private int databaseSizeHighalarm;

    @Column(name = "DATABASE_RAM_LOWALARM", columnDefinition = "float|数据库内存低级报警", length = 8, nullable = true)
    private float databaseRamLowalarm;

    @Column(name = "DATABASE_RAM_HIGHALARM", columnDefinition = "float|数据库内存高级报警", length = 8, nullable = true)
    private float databaseRamHighalarm;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public float getCpuLowalarm() {
        return cpuLowalarm;
    }

    public void setCpuLowalarm(float cpuLowalarm) {
        this.cpuLowalarm = cpuLowalarm;
    }

    public float getCpuHighalarm() {
        return cpuHighalarm;
    }

    public void setCpuHighalarm(float cpuHighalarm) {
        this.cpuHighalarm = cpuHighalarm;
    }

    public float getDiskLowalarm() {
        return diskLowalarm;
    }

    public void setDiskLowalarm(float diskLowalarm) {
        this.diskLowalarm = diskLowalarm;
    }

    public float getDiskHighalarm() {
        return diskHighalarm;
    }

    public void setDiskHighalarm(float diskHighalarm) {
        this.diskHighalarm = diskHighalarm;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public int getLinkNumbLowalarm() {
        return linkNumbLowalarm;
    }

    public void setLinkNumbLowalarm(int linkNumbLowalarm) {
        this.linkNumbLowalarm = linkNumbLowalarm;
    }

    public int getLinkNumbHighalarm() {
        return linkNumbHighalarm;
    }

    public void setLinkNumbHighalarm(int linkNumbHighalarm) {
        this.linkNumbHighalarm = linkNumbHighalarm;
    }

    public int getDatabaseSizeLowalarm() {
        return databaseSizeLowalarm;
    }

    public void setDatabaseSizeLowalarm(int databaseSizeLowalarm) {
        this.databaseSizeLowalarm = databaseSizeLowalarm;
    }

    public int getDatabaseSizeHighalarm() {
        return databaseSizeHighalarm;
    }

    public void setDatabaseSizeHighalarm(int databaseSizeHighalarm) {
        this.databaseSizeHighalarm = databaseSizeHighalarm;
    }

    public float getDatabaseRamLowalarm() {
        return databaseRamLowalarm;
    }

    public void setDatabaseRamLowalarm(float databaseRamLowalarm) {
        this.databaseRamLowalarm = databaseRamLowalarm;
    }

    public float getDatabaseRamHighalarm() {
        return databaseRamHighalarm;
    }

    public void setDatabaseRamHighalarm(float databaseRamHighalarm) {
        this.databaseRamHighalarm = databaseRamHighalarm;
    }

    public float getRamLowalarm() {
        return ramLowalarm;
    }

    public void setRamLowalarm(float ramLowalarm) {
        this.ramLowalarm = ramLowalarm;
    }

    public float getRamHighalarm() {
        return ramHighalarm;
    }

    public void setRamHighalarm(float ramHighalarm) {
        this.ramHighalarm = ramHighalarm;
    }


    public static final String ID="id";
    public static final String COMPUTER_NAME="computerName";
    public static final String CPU_LOWALARM="cpuLowalarm";
    public static final String CPU_HIGHALARM="cpuHighalarm";
    public static final String RAM_LOWALARM="ramLowalarm";
    public static final String RAM_HIGHALARM="ramHighalarm";
    public static final String DISK_LOWALARM="diskLowalarm";
    public static final String DISK_HIGHALARM="diskHighalarm";
    public static final String DATABASE_NAME="databaseName";
    public static final String LINK_NUMB_LOWALARM="linkNumbLowalarm";
    public static final String LINK_NUMB_HIGHALARM="linkNumbHighalarm";
    public static final String DATABASE_SIZE_LOWALARM="databaseSizeLowalarm";
    public static final String DATABASE_SIZE_HIGHALARM="databaseSizeHighalarm";
    public static final String DATABASE_RAM_LOWALARM="databaseRamLowalarm";
    public static final String DATABASE_RAM_HIGHALARM="databaseRamHighalarm";

    public static final String[] All_FIELDS = new String[] { ID, COMPUTER_NAME, CPU_LOWALARM, CPU_HIGHALARM, RAM_LOWALARM, RAM_HIGHALARM, DISK_LOWALARM, DISK_HIGHALARM, DATABASE_NAME, LINK_NUMB_LOWALARM, LINK_NUMB_HIGHALARM, DATABASE_SIZE_LOWALARM, DATABASE_SIZE_HIGHALARM, DATABASE_RAM_LOWALARM,DATABASE_RAM_HIGHALARM };
    public static final String[] UPDATA_FIELDS = new String[] { COMPUTER_NAME, CPU_LOWALARM, CPU_HIGHALARM, RAM_LOWALARM, RAM_HIGHALARM, DISK_LOWALARM, DISK_HIGHALARM, DATABASE_NAME, LINK_NUMB_LOWALARM, LINK_NUMB_HIGHALARM, DATABASE_SIZE_LOWALARM, DATABASE_SIZE_HIGHALARM, DATABASE_RAM_LOWALARM,DATABASE_RAM_HIGHALARM };


}
