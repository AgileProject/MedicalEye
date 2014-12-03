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
	@Column(name = "ComputerID" , columnDefinition = "Integer|ComputerID", length = 4, nullable = false)
	private Integer computerid;

	@Column(name = "ComputerName",columnDefinition = "VARCHAR2|主机名",length = 20,nullable = false)
	private String computername;

	@Column(name = "ComputerIP",columnDefinition = "VARCHAR2|IP地址",length = 20,nullable = false)
	private String computerip;

	@Column(name = "ComputerOS",columnDefinition = "VARCHAR2|操作系统",length = 30,nullable = true)
	private String computeros;

	@Column(name = "proInfo",columnDefinition = "VARCHAR2|CPU信息",length = 50,nullable = true)
	private String proinfo;

	@Column(name = "memInfo",columnDefinition = "VARCHAR2|内存信息",length = 50,nullable = true)
	private String meminfo;

	@Column(name = "disInfo",columnDefinition = "VARCHAR2|硬盘信息",length = 50,nullable = true)
	private String disinfo;

	@Column(name = "databaseInfo",columnDefinition = "VARCHAR2|数据库信息",length = 20,nullable = true)
	private String databaseinfo;

	public Integer getComputerID() {
		return this.computerid;
	}

	public void setComputerID(Integer ComputerID) {
		this.computerid = ComputerID;
	}

	public String getComputerName() {
		return this.computername;
	}

	public void setComputerName(String computerName) {
		this.computername=computerName;
	}

	public String getComputerIP() {
		return this.computerip;
	}

	public void setComputerIP(String computerIP) {
		this.computerip=computerIP;
	}

	public String getComputerOS() {
		return this.computeros;
	}

	public void setComputerOS(String computerOS) {
		this.computeros=computerOS;
	}

	public String getproInfo() {
		return this.proinfo;
	}

	public void setproInfo(String proInfo) {
		this.proinfo=proInfo;
	}

	public String getmemInfo() {
		return this.meminfo;
	}

	public void setmemInfo(String memInfo) {
		this.meminfo=memInfo;
	}

	public String getdisInfo() {
		return this.disinfo;
	}

	public void setdisInfo(String disInfo) {
		this.disinfo=disInfo;
	}

	public String getdatabaseInfo() {
		return this.databaseinfo;
	}

	public void setdatabaseInfo(String databaseInfo) {
		this.databaseinfo=databaseInfo;
	}

	public static final String ComputerID = "computerid";

	public static final String ComputerName = "computername";

	public static final String ComputerIP = "computerip";

	public static final String ComputerOS = "computeros";

	public static final String proInfo = "proinfo";

	public static final String memInfo = "meminfo";

	public static final String disInfo = "disinfo";

	public static final String databaseInfo = "databaseinfo";

	public static final String[] All_FIELDS = new String[] {ComputerID, ComputerName,  ComputerIP, ComputerOS, proInfo,memInfo,disInfo, databaseInfo };
}
