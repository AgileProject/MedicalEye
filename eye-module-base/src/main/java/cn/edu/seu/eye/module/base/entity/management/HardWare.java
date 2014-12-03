package cn.edu.seu.eye.module.base.entity.management;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by ling on 2014/12/1.
 * 硬件监控数据。需要不断更新。
 */
@Entity
@Table(name = "SYS_HARDWARE")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HardWare  implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "UpDataID",  columnDefinition = "Integer|UpdataID", length = 5,nullable = false)
	private Integer updataid;

	@Column(name = "ComputerName",columnDefinition = "VARCHAR2|主机名", length = 20, nullable = false)
	private String computername;

	@Column(name = "UpdataTime",columnDefinition = "smalldatatime|更新时间", nullable = false)
	private  Timestamp updatatime;

	@Column(name = "cpuUtilization",columnDefinition = "float|CPU使用率",length = 8,nullable = true)
	private Float cpuutilization;

	@Column(name = "cpuRunTime" , columnDefinition = "float|CPU正常运行时间",length = 8,nullable = true)
	private Float cpuruntime;

	@Column(name = "Processes", columnDefinition = "Integer|进程数",length = 4,nullable = true)
	private Integer processes;

	@Column(name = "memUsedPercent", columnDefinition = "float|内存使用率", length = 8,nullable = true)
	private Float memusedpercent;

	@Column(name = "diskUtilization", columnDefinition = "float|硬盘使用率", length = 8, nullable = true)
	private Float diskutilization;

	public Integer getUpDataid() {
		return this.updataid;
	}

	public void setUpDataid(Integer updataid) {
		this.updataid = updataid;
	}

	public String getComputerName() {
		return this.computername;
	}

	public void setComputername(String computername) {
		this.computername = computername;
	}

	public Timestamp getUpdataTime() {
		return this.updatatime;
	}

	public void setUpdataTime(Timestamp time) {
		this.updatatime =time;
	}

	public Float getCpuutilization() {
		return this.cpuutilization;
	}

	public void setCpuutilization(Float cpuutilization) {
		this.cpuutilization = cpuutilization;
	}

	public Float getCpuruntime() {
		return this.cpuruntime;
	}

	public void setCpuruntime(Float cpuruntime) {
		this.cpuruntime = cpuruntime;
	}

	public Integer getProcesses() {
		return this.processes;
	}

	public void setProcesses(Integer processes) {
		this.processes = processes;
	}

	public Float getMemusedpercent() {
		return this.memusedpercent;
	}

	public void setMemusedpercent(Float memusedpercent) {
		this.memusedpercent = memusedpercent;
	}

	public Float getDiskutilization() {
		return this.diskutilization;
	}

	public void setDiskutilization(Float diskutilization) {
		this.diskutilization = diskutilization;
	}

	public static final String UpDataID = "updataid";

	public static final String ComputerName = "computername";

	public static final String UpdataTime = "updatatime";

	public static final String cpuUtilization = "cpuutilization";

	public static final String cpuRunTime = "cpuruntime";

	public static final String Processes = "processes";

	public static final String memUsedPercent = "memusedpercent";

	public static final String diskUtilization = "diskutilization";

	public static final String[] All_FIELDS = new String[] {UpDataID, ComputerName, UpdataTime, cpuUtilization, cpuRunTime, Processes, memUsedPercent, diskUtilization};




}
