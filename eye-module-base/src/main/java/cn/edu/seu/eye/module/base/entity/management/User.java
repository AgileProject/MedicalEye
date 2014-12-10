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

    @Column(name = "EMAIL", columnDefinition = "VARCHAR2|邮箱", length = 50, nullable = true)
    private String email;

    @Column(name = "TELEPHONE", columnDefinition = "VARCHAR2|手机", length = 50, nullable = true)
    private String telephone;

    @Column(name = "SEND_EMAIL", columnDefinition = "BIT|发送邮件", length = 1, nullable = true)
    private boolean sendEmail;

    @Column(name = "SEND_MESSAGE", columnDefinition = "BIT|发送邮件", length = 1, nullable = true)
    private boolean sendMessage;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(boolean sendEmail) {
        this.sendEmail = sendEmail;
    }

    public boolean isSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(boolean sendMessage) {
        this.sendMessage = sendMessage;
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
    /**
     * 手机
     */
    public static final String TELEPHONE = "telephone";
    /**
     * 邮箱
     */
    public static final String EMAIL = "email";
    /**
     * 发送邮箱
     */
    public static final String SEND_EMAIL = "sendEmail";
    /**
     * 发送短信
     */
    public static final String SEND_MESSAGE = "sendMssage";


	public static final String[] All_FIELDS = new String[] { ID, ORG_ID, ORG_NAME, EMPLOYEE_ID, EMPLOYEE_NAME, LOGIN_NAME, PASSWORD, STATUS, TELEPHONE, EMAIL, SEND_EMAIL, SEND_MESSAGE};

}