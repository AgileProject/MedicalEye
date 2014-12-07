package cn.edu.seu.eye.module.base.entity.management;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by ling on 2014/11/27.
 * 监控电脑信息
 */

@Entity
@Table(name="SYS_COMPUTERS")
@JsonInclude(Include.NON_NULL)
public class Computers implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COMPUTER_ID", columnDefinition = "Integer|COMPUTER_ID", length = 4, nullable = false)
	private Integer computerId;

	@Column(name = "COMPUTER_NAME", columnDefinition = "VARCHAR2|主机名", length = 20, nullable = false)
	private String computerName;

	@Column(name = "COMPUTER_IP", columnDefinition = "VARCHAR2|IP地址", length = 20, nullable = false)
	private String computerIp;

	@Column(name = "COMPUTER_OS", columnDefinition = "VARCHAR2|操作系统", length = 30, nullable = true)
	private String computerOs;

	@Column(name = "COMPUTER_CPU", columnDefinition = "VARCHAR2|CPU信息", length = 50, nullable = true)
	private String computerCpu;

	@Column(name = "COMPUTER_RAM", columnDefinition = "VARCHAR2|内存信息", length = 50, nullable = true)
	private String computerRam;

	@Column(name = "COMPUTER_DISK", columnDefinition = "VARCHAR2|硬盘信息", length = 50, nullable = true)
	private String computerDisk;

	@Column(name = "COMPURER_DB", columnDefinition = "VARCHAR2|数据库信息", length = 20, nullable = true)
	private String computerDb;


	public Integer getComputerId() {
		return this.computerId;
	}

	public void setComputerId(Integer computerId) {
		this.computerId = computerId;
	}

	public String getComputerName() {
		return this.computerName;
	}

	public void setComputerName(String computerName) {
		this.computerName=computerName;
	}

	public String getComputerIp() {
		return this.computerIp;
	}

	public void setComputerIp(String computerIp) {
		this.computerIp=computerIp;
	}

	public String getComputerOs() {
		return this.computerOs;
	}

	public void setComputerOs(String computerOs) {
		this.computerOs=computerOs;
	}

	public String getComputerCpu() {
		return this.computerCpu;
	}

	public void setComputerCpu(String computerCpu) {
		this.computerCpu=computerCpu;
	}

	public String getComputerRam() {
		return this.computerRam;
	}

	public void setComputerRam(String computerRam) {
		this.computerRam=computerRam;
	}

	public String getComputerDisk() {
		return this.computerDisk;
	}

	public void setComputerDisk(String computerDisk) {
		this.computerDisk=computerDisk;
	}

	public String getComputerDb() {
		return this.computerDb;
	}

	public void setComputerDb(String computerDb) {
		this.computerDb=computerDb;
	}



	public static final String COMPUTER_ID = "computerId";

	public static final String COMPUTER_NAME = "computerName";

	public static final String COMPUTER_IP = "computerIp";

	public static final String COMPUTER_OS = "computerOs";

	public static final String COMPUTER_CPU = "computerCpu";

	public static final String COMPUTER_RAM = "computerRam";

	public static final String COMPUTER_DISK = "computerDisk";

	public static final String COMPURER_DB = "computerDb";

	public static final String[] All_FIELDS = new String[] { COMPUTER_ID, COMPUTER_NAME, COMPUTER_IP, COMPUTER_OS, COMPUTER_CPU, COMPUTER_RAM, COMPUTER_DISK, COMPURER_DB};
}
