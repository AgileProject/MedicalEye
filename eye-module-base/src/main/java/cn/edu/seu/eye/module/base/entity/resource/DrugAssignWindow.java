package cn.edu.seu.eye.module.base.entity.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 发药窗口
 */
@Entity
@Table(name = "R_DRUG_ASSIGN_WINDOW")
@JsonInclude(Include.NON_NULL)
public class DrugAssignWindow implements Serializable {

	private static final long serialVersionUID = 1L;

	public enum WindowType {
		/**
		 * 未定义
		 */
		undefinition,
		/**
		 * 直发
		 */
		automatic,

        /**
		 * 混发
		 */
        manual
	}

	public enum WindowStatus {
		/**
		 * 未定义
		 */
		undefinition,
		/**
		 * 正常
		 */
		working,

        /**
		 * 暂停
		 */
        notWorking
	}

	@Id
	@Column(name = "ID", columnDefinition = "VARCHAR2|ID", length = 36, nullable = false)
	private String id;

	@Column(name = "ORG_ID", columnDefinition = "VARCHAR2|机构ID", length = 36, nullable = true)
	private String orgId;

	@Column(name = "ORG_NAME", columnDefinition = "VARCHAR2|机构名称", length = 100, nullable = true)
	private String orgName;

	@Column(name = "DEPT_ID", columnDefinition = "VARCHAR2|科室ID", length = 36, nullable = true)
	private String deptId;

	@Column(name = "DEPT_NAME", columnDefinition = "VARCHAR2|科室名称", length = 100, nullable = true)
	private String deptName;

	@Column(name = "WINDOW_TYPE", columnDefinition = "NUMBER|窗口类型（1：直发；2：混发）", length = 1, nullable = true)
	private WindowType windowType;

	@Column(name = "WINDOW_NO", columnDefinition = "VARCHAR2|窗口编号", length = 30, nullable = true)
	private String windowNo;

	@Column(name = "STATUS", columnDefinition = "NUMBER|状态", length = 1, nullable = true)
	private WindowStatus status;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrgId() {
		return this.orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public WindowType getWindowType() {
		return this.windowType;
	}

	public void setWindowType(WindowType windowType) {
		this.windowType = windowType;
	}

	public String getWindowNo() {
		return this.windowNo;
	}

	public void setWindowNo(String windowNo) {
		this.windowNo = windowNo;
	}

	public WindowStatus getStatus() {
		return this.status;
	}

	public void setStatus(WindowStatus status) {
		this.status = status;
	}

	/**
	 * ID
	 */
	public static final String ID = "id";
	/**
	 * 机构ID
	 */
	public static final String ORG_ID = "orgId";
	/**
	 * 机构名称
	 */
	public static final String ORG_NAME = "orgName";
	/**
	 * 科室ID
	 */
	public static final String DEPT_ID = "deptId";
	/**
	 * 科室名称
	 */
	public static final String DEPT_NAME = "deptName";
	/**
	 * 窗口类型（1：直发；2：混发）
	 */
	public static final String WINDOW_TYPE = "windowType";
	/**
	 * 窗口编号
	 */
	public static final String WINDOW_NO = "windowNo";
	/**
	 * 状态
	 */
	public static final String STATUS = "status";

	public static final String[] All_FIELDS = new String[] { ID, ORG_ID, ORG_NAME, DEPT_ID, DEPT_NAME, WINDOW_TYPE, WINDOW_NO, STATUS };

}
