package cn.edu.seu.eye.module.base.entity.management;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 系统用户
 */
@Entity
@Table(name = "SYS_USER")
@JsonInclude(Include.NON_NULL)
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "VARCHAR2|ID", length = 36, nullable = false)
	private String id;

	@Column(name = "ORG_ID", columnDefinition = "VARCHAR2|机构ID", length = 36, nullable = true)
	private String orgId;

	@Column(name = "ORG_NAME", columnDefinition = "VARCHAR2|机构名称", length = 100, nullable = true)
	private String orgName;

	@Column(name = "EMPLOYEE_ID", columnDefinition = "VARCHAR2|员工ID", length = 36, nullable = true)
	private String employeeId;

	@Column(name = "EMPLOYEE_NAME", columnDefinition = "VARCHAR2|员工姓名", length = 50, nullable = true)
	private String employeeName;

	@Column(name = "LOGIN_NAME", columnDefinition = "VARCHAR2|用户名", length = 50, nullable = true)
	private String loginName;

	@Column(name = "PASSWORD", columnDefinition = "VARCHAR2|密码", length = 20, nullable = true)
	private String password;

	@Column(name = "STATUS", columnDefinition = "NUMBER|状态", length = 1, nullable = true)
	private Integer status;

	@OneToMany(targetEntity = UserRole.class)
	@JoinColumn(name = "loginName", referencedColumnName = "loginName")
	private List<UserRole> userRoleList;
	
	//修改密码
	private String ModifyPassword;

	public String getModifyPassword() {
		return ModifyPassword;
	}

	public void setModifyPassword(String modifyPassword) {
		ModifyPassword = modifyPassword;
	}

	public List<UserRole> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<UserRole> userRoleList) {
		this.userRoleList = userRoleList;
	}
	
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

	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<String> getUserPermissions() {
		return userPermissions;
	}

	public void setUserPermissions(List<String> userPermissions) {
		this.userPermissions = userPermissions;
	}

	private List<String> userPermissions;

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
	 * 员工ID
	 */
	public static final String EMPLOYEE_ID = "employeeId";
	/**
	 * 员工姓名
	 */
	public static final String EMPLOYEE_NAME = "employeeName";
	/**
	 * 用户名
	 */
	public static final String LOGIN_NAME = "loginName";
	/**
	 * 密码
	 */
	public static final String PASSWORD = "password";
	/**
	 * 状态
	 */
	public static final String STATUS = "status";

	public static final String[] All_FIELDS = new String[] { ID, ORG_ID, ORG_NAME, EMPLOYEE_ID, EMPLOYEE_NAME, LOGIN_NAME, PASSWORD, STATUS };

}