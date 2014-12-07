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
public class Database implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID",columnDefinition = "Integer|UpdataID",length = 4,nullable = false)
	private Integer id;

	@Column(name ="COMPUTER_NAME", columnDefinition = "varchar|主机名", length = 20,nullable = false)
	private String computerName;

	@Column(name = "DATABASE_NAME", columnDefinition = "varchar|数据库名称",length = 50,nullable = false)
	private String databaseName;

	@Column(name = "UPDATA_TIME", columnDefinition = "smalldatetime|更新时间",length = 4,nullable = false)
	private Timestamp updataTime;

	@Column(name = "LINK_NUMB", columnDefinition = "Integer|数据库连接数",length = 4,nullable = true)
	private Integer linkNumb;

	@Column(name = "DATABASE_SIZE", columnDefinition = "Integer|数据库大小",length = 4,nullable = true)
	private Integer databaseSize;

	@Column(name = "RAM_UTILIZATION", columnDefinition = "Float|数据库占用内存大小",length = 8,nullable = true)
	private Float ramUtilization;

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
		this.computerName= computerName;
	}

	public String getDatabaseName() {
		return this.databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public Timestamp getUpdataTime() {
		return this.updataTime;
	}

	public void setUpdataTime(Timestamp updataTime) {
		this.updataTime = updataTime;
	}

	public Integer getLinkNumb() {
		return this.linkNumb;
	}

	public void setLinkNumb(Integer linkNumb) {
		this.linkNumb = linkNumb;
	}

	public Integer getDatabaseSize() {
		return this.databaseSize;
	}

	public void setDatabaseSize(Integer databaseSize) {
		this.databaseSize = databaseSize;
	}

	public Float getRamUtilization() {
		return ramUtilization;
	}

	public void setRamUtilization(Float ramUtilization) {
		this.ramUtilization=ramUtilization;
	}

	public static final String ID = "updataid";

	public static final String COMPUTER_NAME="computerName";

	public static final String DATABASE_NAME="databaseName";

	public static final String UPDATA_TIME="updataTime";

	public static final String LINK_NUMB="linkNumb";

	public static final String DATABASE_SIZE="databaseSize";

	public static final String RAM_UTILIZATION="ramUtilization";

	public static final String[] All_FIELDS = new String[] { ID, COMPUTER_NAME, DATABASE_NAME, UPDATA_TIME, LINK_NUMB, DATABASE_SIZE, RAM_UTILIZATION};
}
