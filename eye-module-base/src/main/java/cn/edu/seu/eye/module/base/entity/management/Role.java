package cn.edu.seu.eye.module.base.entity.management;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 系统角色
 */
@Entity
@Table(name = "SYS_ROLE")
@JsonInclude(Include.NON_NULL)
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "VARCHAR2|ID", length = 36, nullable = false)
	private String id;

	@Column(name = "ORG_ID", columnDefinition = "VARCHAR2|机构ID", length = 36, nullable = true)
	private String orgId;

	@Column(name = "ORG_NAME", columnDefinition = "VARCHAR2|机构名称", length = 100, nullable = true)
	private String orgName;

	@Column(name = "DEPARTMENT_CODE", columnDefinition = "VARCHAR2|部门ID", length = 36, nullable = true)
	private String departmentCode;

	@Column(name = "DEPARTMENT_NAME", columnDefinition = "VARCHAR2|部门名称", length = 100, nullable = true)
	private String departmentName;

	@Column(name = "ROLE_NAME", columnDefinition = "VARCHAR2|角色名称", length = 100, nullable = true)
	private String roleName;

	@Column(name = "STATUS", columnDefinition = "NUMBER|状态", length = 1, nullable = true)
	private Integer status;
	
	@OneToMany(targetEntity = RolePermission.class)
	@JoinColumn(name = "id", referencedColumnName = "roleId")
	private List<RolePermission> rolePermissionList;

	public List<RolePermission> getRolePermissionList() {
		return rolePermissionList;
	}

	public void setRolePermissionList(List<RolePermission> rolePermissionList) {
		this.rolePermissionList = rolePermissionList;
	}

	private List<Permission> SysPermission;

	public List<Permission> getSysPermission() {
		return SysPermission;
	}

	public void setSysPermission(List<Permission> sysPermission) {
		SysPermission = sysPermission;
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

	public String getDepartmentCode() {
		return this.departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
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
	 * 部门ID
	 */
	public static final String DEPARTMENT_CODE = "departmentCode";
	/**
	 * 部门名称
	 */
	public static final String DEPARTMENT_NAME = "departmentName";
	/**
	 * 角色名称
	 */
	public static final String ROLE_NAME = "roleName";
	/**
	 * 状态
	 */
	public static final String STATUS = "status";

	public static final String[] All_FIELDS = new String[] { ID, ORG_ID, ORG_NAME, DEPARTMENT_CODE, DEPARTMENT_NAME, ROLE_NAME, STATUS };

}