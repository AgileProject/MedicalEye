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
public class Hardware implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID",  columnDefinition = "Integer|UpdataID", length = 5,nullable = false)
	private Integer id;

	@Column(name = "COMPUTER_NAME",columnDefinition = "VARCHAR2|主机名", length = 20, nullable = false)
	private String computerName;

	@Column(name = "UPDATA_TIME",columnDefinition = "timestamp|更新时间", nullable = false)
	private Timestamp updataTime;

	@Column(name = "CPU_UTILZATION",columnDefinition = "float|CPU使用率",length = 8,nullable = true)
	private Float cpuUtilzation;

	@Column(name = "CPU_RUNTIME" , columnDefinition = "float|CPU正常运行时间",length = 8,nullable = true)
	private Float cpuRuntime;

	@Column(name = "PROCESSES", columnDefinition = "Integer|进程数",length = 4,nullable = true)
	private Integer processes;

	@Column(name = "RAM_USEDPERCENT", columnDefinition = "float|内存使用率", length = 8,nullable = true)
	private Float ramUsedpercent;

	@Column(name = "DISK_UTILZATION", columnDefinition = "float|硬盘使用率", length = 8, nullable = true)
	private Float diskUtilzation;



	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComputerName() {
		return this.computerName;
	}

	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}

	public Timestamp getUpdataTime() {
		return this.updataTime;
	}

	public void setUpdataTime(Timestamp updataTime) {
		this.updataTime = updataTime;
	}

	public Float getCpuUtilzation() {
		return this.cpuUtilzation;
	}

	public void setCpuUtilzation(Float cpuUtilization) {
		this.cpuUtilzation = cpuUtilization;
	}

	public Float getCpuRuntime() {
		return this.cpuRuntime;
	}

	public void setCpuRuntime(Float cpuRuntime) {
		this.cpuRuntime = cpuRuntime;
	}

	public Integer getProcesses() {
		return this.processes;
	}

	public void setProcesses(Integer processes) {
		this.processes = processes;
	}

	public Float getRamUsedpercent() {
		return this.ramUsedpercent;
	}

	public void setRamUsedpercent(Float ramUsedpercent) {
		this.ramUsedpercent = ramUsedpercent;
	}

	public Float getDiskUtilzation() {
		return this.diskUtilzation;
	}

	public void setDiskUtilzation(Float diskUtilzation) {
		this.diskUtilzation = diskUtilzation;
	}

	public static final String ID = "id";

	public static final String COMPUTER_NAME = "computerName";

	public static final String UPDATA_TIME = "updataTime";

	public static final String CPU_UTILZATION = "cpuUtilzation";

	public static final String CPU_RUNTIME = "cpuRuntime";

	public static final String PROCESSES = "processes";

	public static final String RAM_USEDPERCENT = "ramUsedpercent";

	public static final String DISK_UTILZATION = "diskUtilzation";

	public static final String[] All_FIELDS = new String[] { ID, COMPUTER_NAME, UPDATA_TIME, CPU_UTILZATION, CPU_RUNTIME, PROCESSES, RAM_USEDPERCENT, DISK_UTILZATION};




}
