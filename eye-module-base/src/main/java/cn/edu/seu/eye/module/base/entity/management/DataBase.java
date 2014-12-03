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
 */
@Entity
@Table(name = "SYS_DATABASE")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataBase implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "UpdataID",columnDefinition = "Integer|UpdataID",length = 4,nullable = false)
	private Integer updataid;

	@Column(name ="ComputerName", columnDefinition = "varchar|主机名", length = 20,nullable = false)
	private String computername;

	@Column(name = "DatabaseName", columnDefinition = "varchar|数据库名称",length = 50,nullable = false)
	private String databasename;

	@Column(name = "UpDataTime", columnDefinition = "smalldatetime|更新时间",length = 4,nullable = false)
	private Timestamp updatatime;

	@Column(name = "LinkNumb", columnDefinition = "Integer|数据库连接数",length = 4,nullable = true)
	private Integer linknumb;

	@Column(name = "DatabaseSize", columnDefinition = "Integer|数据库大小",length = 4,nullable = true)
	private Integer databasesize;

	@Column(name = "RAM_Utilization", columnDefinition = "Float|数据库占用内存大小",length = 8,nullable = true)
	private Float ram_utilization;

	public Integer getUpdataid() {
		return this.updataid;
	}

	public void setUpdataid(Integer updataid) {
		this.updataid = updataid;
	}

	public String getComputername() {
		return this.computername;
	}

	public void setComputername(String computername) {
		this.computername= computername;
	}

	public String getDatabasename() {
		return this.databasename;
	}

	public void setDatabasename(String databasename) {
		this.databasename = databasename;
	}

	public Timestamp getUpdatatime() {
		return this.updatatime;
	}

	public void setUpdatatime(Timestamp updatatime) {
		this.updatatime = updatatime;
	}

	public Integer getLinknumb() {
		return this.linknumb;
	}

	public void setLinknumb(Integer linknumb) {
		this.linknumb = linknumb;
	}

	public Integer getDatabasesize() {
		return this.databasesize;
	}

	public void setDatabasesize(Integer databasesize) {
		this.databasesize = databasesize;
	}

	public Float getRam_utilization() {
		return ram_utilization;
	}

	public void setRam_utilization(Float ram_utilization) {
		this.ram_utilization=ram_utilization;
	}

	public static final String UpdataID = "updataid";

	public static final String ComputerName="computername";

	public static final String DatabaseName="databasename";

	public static final String UpDataTime="updatatime";

	public static final String LinkNumb="linknumb";

	public static final String DatabaseSize="databasesize";

	public static final String RAM_Utilization="ram_utilization";

	public static final String[] All_FIELDS = new String[] {UpdataID,ComputerName, DatabaseName,UpDataTime, LinkNumb,DatabaseSize, RAM_Utilization};
}
