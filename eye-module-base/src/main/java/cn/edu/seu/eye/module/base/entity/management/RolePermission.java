package cn.edu.seu.eye.module.base.entity.management;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 角色权限关系
 */
@Entity
@Table(name = "SYS_ROLE_PERMISSION")
@JsonInclude(Include.NON_NULL)
public class RolePermission implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "ROLE_ID", columnDefinition = "VARCHAR2|角色ID", length = 36, nullable = true)
	private String roleId;

	@Column(name = "PERMISSION_ID", columnDefinition = "VARCHAR2|权限ID", length = 36, nullable = true)
	private String permissionId;

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

	/**
	 * 角色ID
	 */
	public static final String ROLE_ID = "roleId";
	/**
	 * 权限ID
	 */
	public static final String PERMISSION_ID = "permissionId";

	public static final String[] All_FIELDS = new String[] { ROLE_ID, PERMISSION_ID };

}