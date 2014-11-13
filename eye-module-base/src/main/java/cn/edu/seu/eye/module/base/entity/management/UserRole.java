package cn.edu.seu.eye.module.base.entity.management;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 用户角色关系
 */
@Entity
@Table(name = "SYS_USER_ROLE")
@JsonInclude(Include.NON_NULL)
public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "LOGIN_NAME", columnDefinition = "VARCHAR2|用户名", length = 50, nullable = true)
	private String loginName;

	@Column(name = "ROLE_ID", columnDefinition = "VARCHAR2|角色ID", length = 36, nullable = true)
	private String roleId;

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * 用户名
	 */
	public static final String LOGIN_NAME = "loginName";
	/**
	 * 角色ID
	 */
	public static final String ROLE_ID = "roleId";

	public static final String[] All_FIELDS = new String[] { LOGIN_NAME, ROLE_ID };

}