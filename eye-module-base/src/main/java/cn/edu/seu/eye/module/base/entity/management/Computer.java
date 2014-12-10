package cn.edu.seu.eye.module.base.entity.management;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by DL on 2014/12/1.
 */
@Entity
@Table(name = "SYS_COMPUTERS")
@JsonInclude(Include.NON_NULL)
public class Computer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "COMPUTER_ID", columnDefinition = "INT|电脑ID", nullable = false)
    private int computerId;
    @Column(name = "COMPUTER_NAME", columnDefinition = "VARCHAR2|电脑名称", length = 20, nullable = false)
    private String computerName;
    @Column(name = "COMPUTER_IP", columnDefinition = "VARCHAR2|电脑IP", length = 20, nullable = false)
    private String computerIp;
    @Column(name = "COMPUTER_OS", columnDefinition = "VARCHAR2|电脑系统信息", length = 30, nullable = true)
    private String computerOs;
    @Column(name = "COMPUTER_CPU", columnDefinition = "VARCHAR2|电脑CPU信息", length = 50, nullable = true)
    private String computerCpu;
    @Column(name = "COMPUTER_RAM", columnDefinition = "VARCHAR2|电脑RAM信息", length = 50, nullable = true)
    private String computerRam;
    @Column(name = "COMPUTER_DISK", columnDefinition = "VARCHAR2|电脑硬盘信息", length = 50, nullable = true)
    private String computerDisk;
    @Column(name = "COMPUTER_DB", columnDefinition = "VARCHAR2|电脑数据库信息", length = 20, nullable = true)
    private String computerDb;
    @Column(name = "ALARM_CPU", columnDefinition = "float|CPU报警指标", length = 8, nullable = true)
    private float alarmCpu;
    @Column(name = "ALARM_RAM", columnDefinition = "float|RAM报警指标", length = 8, nullable = true)
    private float alarmRam;
    @Column(name = "ALARM_Disk", columnDefinition = "float|硬盘报警指标", length = 8, nullable = true)
    private float alarmDisk;



    public void setComputerId(int computerId) {
        this.computerId = computerId;
    }

    public int getComputerId() {
        return computerId;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getComputerIp() {
        return computerIp;
    }

    public void setComputerIp(String computerIp) {
        this.computerIp = computerIp;
    }

    public String getComputerOs() {
        return computerOs;
    }

    public void setComputerOs(String computerOs) {
        this.computerOs = computerOs;
    }

    public String getComputerCpu() {
        return computerCpu;
    }

    public void setComputerCpu(String computerCpu) {
        this.computerCpu = computerCpu;
    }

    public String getComputerRam() {
        return computerRam;
    }

    public void setComputerRam(String computerRam) {
        this.computerRam = computerRam;
    }

    public String getComputerDisk() {
        return computerDisk;
    }

    public void setComputerDisk(String computerDisk) {
        this.computerDisk = computerDisk;
    }

    public String getComputerDb() {
        return computerDb;
    }

    public void setComputerDb(String computerDb) {
        this.computerDb = computerDb;
    }

    public float getAlarmCpu() {
        return alarmCpu;
    }

    public void setAlarmCpu(float alarmCpu) {
        this.alarmCpu = alarmCpu;
    }

    public float getAlarmRam() {
        return alarmRam;
    }

    public void setAlarmRam(float alarmRam) {
        this.alarmRam = alarmRam;
    }

    public float getAlarmDisk() {
        return alarmDisk;
    }

    public void setAlarmDisk(float alarmDisk) {
        this.alarmDisk = alarmDisk;
    }

    public static final String COMPUTER_ID="computerId";
    public static final String COMPUTER_NAME="computerName";
    public static final String COMPUTER_IP="computerIp";
    public static final String COMPUTER_OS="computerOs";
    public static final String COMPUTER_CPU="computerCpu";
    public static final String COMPUTER_RAM="computerRam";
    public static final String COMPUTER_DISK="computerDisk";
    public static final String COMPUTER_DB="computerDb";
    public static final String ALARM_CPU="alarmCpu";
    public static final String ALARM_RAM="alarmRam";
    public static final String ALARM_DISK="alarmDisk";

    public static final String[] All_FIELDS = new String[] { COMPUTER_ID, COMPUTER_NAME, COMPUTER_IP, COMPUTER_OS, COMPUTER_CPU, COMPUTER_RAM, COMPUTER_DISK, COMPUTER_DB, ALARM_CPU, ALARM_RAM, ALARM_DISK};

}
