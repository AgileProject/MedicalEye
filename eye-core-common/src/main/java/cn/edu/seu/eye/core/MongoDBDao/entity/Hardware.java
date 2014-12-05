package cn.edu.seu.eye.core.MongoDBDao.entity;

import java.util.Date;

/**
 * Created by Administrator on 14-12-1.
 */
public class Hardware {
    private String computerName;
    private Date time;
    private float cpuUtilization;
    private float cpuRunTime;
    private int processes;
    private float memUsedPercent;
    private float diskUtilization;

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public float getCpuUtilization() {
        return cpuUtilization;
    }

    public void setCpuUtilization(float cpuUtilization) {
        this.cpuUtilization = cpuUtilization;
    }

    public float getCpuRunTime() {
        return cpuRunTime;
    }

    public void setCpuRunTime(float cpuRunTime) {
        this.cpuRunTime = cpuRunTime;
    }

    public int getProcesses() {
        return processes;
    }

    public void setProcesses(int processes) {
        this.processes = processes;
    }

    public float getMemUsedPercent() {
        return memUsedPercent;
    }

    public void setMemUsedPercent(float memUsedPercent) {
        this.memUsedPercent = memUsedPercent;
    }

    public float getDiskUtilization() {
        return diskUtilization;
    }

    public void setDiskUtilization(float diskUtilization) {
        this.diskUtilization = diskUtilization;
    }

    @Override
    public String toString() {

        return "Hardware{" +
                "computerName='" + computerName + '\'' +
                ", time=" + time +
                ", cpuUtilization=" + cpuUtilization +
                ", cpuRunTime=" + cpuRunTime +
                ", processes=" + processes +
                ", memUsedPercent=" + memUsedPercent +
                ", diskUtilization=" + diskUtilization +
                '}';
    }
}
