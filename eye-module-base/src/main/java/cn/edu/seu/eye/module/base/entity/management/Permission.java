package cn.edu.seu.eye.module.base.entity.management;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 系统权限
 */
@Entity
@Table(name = "SYS_PERMISSION")
@JsonInclude(Include.NON_NULL)
public class Permission implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "VARCHAR2|ID", length = 36, nullable = false)
	private String id;

	@Column(name = "PERMISSION_NAME", columnDefinition = "VARCHAR2|权限名称", length = 200, nullable = true)
	private String permissionName;

	@Column(name = "PERMISSION_VALUE", columnDefinition = "VARCHAR2|内部名称，唯一值", length = 200, nullable = true)
	private String permissionValue;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPermissionName() {
		return this.permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getPermissionValue() {
		return this.permissionValue;
	}

	public void setPermissionValue(String permissionValue) {
		this.permissionValue = permissionValue;
	}

	/**
	 * ID
	 */
	public static final String ID = "id";
	/**
	 * 权限名称
	 */
	public static final String PERMISSION_NAME = "permissionName";
	/**
	 * 内部名称，唯一值
	 */
	public static final String PERMISSION_VALUE = "permissionValue";

	public static final String[] All_FIELDS = new String[] { ID, PERMISSION_NAME, PERMISSION_VALUE };

}