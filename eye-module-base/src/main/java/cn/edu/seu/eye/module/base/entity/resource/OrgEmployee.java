package cn.edu.seu.eye.module.base.entity.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 机构人员
 */
@Entity
@Table(name = "R_ORG_EMPLOYEE")
@JsonInclude(Include.NON_NULL)
public class OrgEmployee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "VARCHAR2|ID", length = 36, nullable = false)
	private String id;

	@Column(name = "ORG_ID", columnDefinition = "VARCHAR2|医疗机构ID", length = 36, nullable = true)
	private String orgId;

	@Column(name = "ORG_NAME", columnDefinition = "VARCHAR2|医疗机构名称", length = 100, nullable = true)
	private String orgName;

	@Column(name = "DEPT_ID", columnDefinition = "VARCHAR2|科室ID", length = 36, nullable = true)
	private String deptId;

	@Column(name = "DEPT_NAME", columnDefinition = "VARCHAR2|科室名称", length = 100, nullable = true)
	private String deptName;

	@Column(name = "CATEGORY_ID", columnDefinition = "VARCHAR2|人员类别ID", length = 36, nullable = true)
	private String categoryId;

	@Column(name = "CATEGORY_NAME", columnDefinition = "VARCHAR2|人员类别", length = 10, nullable = true)
	private String categoryName;

	@Column(name = "WORK_NO", columnDefinition = "VARCHAR2|工号", length = 30, nullable = true)
	private String workNo;

	@Column(name = "IC_CARD_NO", columnDefinition = "VARCHAR2|IC卡号", length = 30, nullable = true)
	private String icCardNo;

	@Column(name = "NAME", columnDefinition = "VARCHAR2|姓名", length = 50, nullable = true)
	private String name;

	@Column(name = "GENDER", columnDefinition = "VARCHAR2|性别", length = 18, nullable = true)
	private String gender;

	@Column(name = "BIRTHDAY", columnDefinition = "DATE|出生日期", nullable = true)
	private Date birthday;

	@Column(name = "ID_NO", columnDefinition = "VARCHAR2|身份证件号", length = 18, nullable = true)
	private String idNo;

	@Column(name = "TELEPHONE", columnDefinition = "VARCHAR2|联系电话", length = 30, nullable = true)
	private String telephone;

	@Column(name = "EMAIL", columnDefinition = "VARCHAR2|电子邮箱", length = 100, nullable = true)
	private String email;

	@Column(name = "PERSONAL_WEBSITE", columnDefinition = "VARCHAR2|个人网站", length = 100, nullable = true)
	private String personalWebsite;

	@Column(name = "PERSONAL_INTRODUCTION", columnDefinition = "VARCHAR2|个人简介", length = 1000, nullable = true)
	private String personalIntroduction;

	@Column(name = "HOME_DISTRICT", columnDefinition = "VARCHAR2|住址-区县码", length = 20, nullable = true)
	private String homeDistrict;

	@Column(name = "HOME_STREET", columnDefinition = "VARCHAR2|住址-街道", length = 50, nullable = true)
	private String homeStreet;

	@Column(name = "HOME_ZIP_CODE", columnDefinition = "VARCHAR2|住址-邮编", length = 10, nullable = true)
	private String homeZipCode;

	@Column(name = "EMERGENCY_CONTACT_NAME", columnDefinition = "VARCHAR2|紧急联系人姓名", length = 50, nullable = true)
	private String emergencyContactName;

	@Column(name = "EMERGENCY_CONTACT_TELEPHONE", columnDefinition = "VARCHAR2|紧急联系人电话", length = 30, nullable = true)
	private String emergencyContactTelephone;

	@Column(name = "NATIONALITY_CODE", columnDefinition = "VARCHAR2|国家代码", length = 18, nullable = true)
	private String nationalityCode;

	@Column(name = "NATIONALITY_NAME", columnDefinition = "VARCHAR2|国家名称", length = 50, nullable = true)
	private String nationalityName;

	@Column(name = "NATION_CODE", columnDefinition = "VARCHAR2|民族代码", length = 18, nullable = true)
	private String nationCode;

	@Column(name = "NATION_NAME", columnDefinition = "VARCHAR2|民族名称", length = 10, nullable = true)
	private String nationName;

	@Column(name = "GRADUATE_SCHOOL", columnDefinition = "VARCHAR2|毕业学校名称", length = 100, nullable = true)
	private String graduateSchool;

	@Column(name = "MAJOR_CODE", columnDefinition = "VARCHAR2|专业代码", length = 18, nullable = true)
	private String majorCode;

	@Column(name = "MAJOR_NAME", columnDefinition = "VARCHAR2|专业名称", length = 100, nullable = true)
	private String majorName;

	@Column(name = "DEGREE_CODE", columnDefinition = "VARCHAR2|学历代码", length = 18, nullable = true)
	private String degreeCode;

	@Column(name = "DEGREE_NAME", columnDefinition = "VARCHAR2|学历名称", length = 100, nullable = true)
	private String degreeName;

	@Column(name = "TITLE_LEVEL_CODE", columnDefinition = "VARCHAR2|专业职称级别代码", length = 18, nullable = true)
	private String titleLevelCode;

	@Column(name = "TITLE_LEVEL_NAME", columnDefinition = "VARCHAR2|专业职称级别名称", length = 50, nullable = true)
	private String titleLevelName;

	@Column(name = "TITLE_CODE", columnDefinition = "VARCHAR2|专业职称代码", length = 18, nullable = true)
	private String titleCode;

	@Column(name = "TITLE_NAME", columnDefinition = "VARCHAR2|专业职称名称", length = 50, nullable = true)
	private String titleName;

	@Column(name = "JOB_CODE", columnDefinition = "VARCHAR2|职务代码", length = 18, nullable = true)
	private String jobCode;

	@Column(name = "JOB_NAME", columnDefinition = "VARCHAR2|职务名称", length = 50, nullable = true)
	private String jobName;

	@Column(name = "POSITION_CODE", columnDefinition = "VARCHAR2|职业工种(岗位)编码", length = 18, nullable = true)
	private String positionCode;

	@Column(name = "POSITION_NAME", columnDefinition = "VARCHAR2|职业工种(岗位)名称", length = 50, nullable = true)
	private String positionName;

	@Column(name = "ENTRY_DATE", columnDefinition = "DATE|入职日期", nullable = true)
	private Date entryDate;

	@Column(name = "DIMISSION_FLAG", columnDefinition = "NUMBER|离职标识", length = 1, nullable = true)
	private Integer dimissionFlag;

	@Column(name = "SORT_NO", columnDefinition = "NUMBER|显示顺序号", length = 11, nullable = true)
	private Integer sortNo;

	@Column(name = "STATUS", columnDefinition = "NUMBER|状态", length = 1, nullable = true)
	private Integer status;

	@Column(name = "DELIVERY_AREA", columnDefinition = "VARCHAR2|配送区域", length = 200, nullable = true)
	private String deliveryArea;

	@Column(name = "LOGIN_NAME", columnDefinition = "VARCHAR2|系统账号", length = 50, nullable = true)
	private String loginName;

    @Column(name = "CAN_PRESCRIPTION", columnDefinition = "Number|处方权", length = 1, nullable = true)
    private Integer canPrescription;
    @Column(name = "CAN_NARCOTIC", columnDefinition = "Number|麻醉药处方权", length = 1, nullable = true)
    private Integer canNarcotic;
    @Column(name = "CAN_PSYCHOTROPIC", columnDefinition = "Number|精神类药物处方权", length = 1, nullable = true)
    private Integer canPsychotropic;
    @Column(name = "CAN_ANTIBIOTICS", columnDefinition = "Number|抗生素处方权", length = 1, nullable = true)
    private Integer canAntibiotics;

    @Column(name = "CLINICAL_DEPT_ID", columnDefinition = "VARCHAR2|临床科室ID", length = 36, nullable = true)
    private String clinicalDeptId;

    @Column(name = "CLINICAL_DEPT_NAME", columnDefinition = "VARCHAR2|临床科室名称", length = 100, nullable = true)
    private String clinicalDeptName;

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

	public String getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getWorkNo() {
		return this.workNo;
	}

	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}

	public String getIcCardNo() {
		return this.icCardNo;
	}

	public void setIcCardNo(String icCardNo) {
		this.icCardNo = icCardNo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdNo() {
		return this.idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPersonalWebsite() {
		return this.personalWebsite;
	}

	public void setPersonalWebsite(String personalWebsite) {
		this.personalWebsite = personalWebsite;
	}

	public String getPersonalIntroduction() {
		return this.personalIntroduction;
	}

	public void setPersonalIntroduction(String personalIntroduction) {
		this.personalIntroduction = personalIntroduction;
	}

	public String getHomeDistrict() {
		return this.homeDistrict;
	}

	public void setHomeDistrict(String homeDistrict) {
		this.homeDistrict = homeDistrict;
	}

	public String getHomeStreet() {
		return this.homeStreet;
	}

	public void setHomeStreet(String homeStreet) {
		this.homeStreet = homeStreet;
	}

	public String getHomeZipCode() {
		return this.homeZipCode;
	}

	public void setHomeZipCode(String homeZipCode) {
		this.homeZipCode = homeZipCode;
	}

	public String getEmergencyContactName() {
		return this.emergencyContactName;
	}

	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}

	public String getEmergencyContactTelephone() {
		return this.emergencyContactTelephone;
	}

	public void setEmergencyContactTelephone(String emergencyContactTelephone) {
		this.emergencyContactTelephone = emergencyContactTelephone;
	}

	public String getNationalityCode() {
		return this.nationalityCode;
	}

	public void setNationalityCode(String nationalityCode) {
		this.nationalityCode = nationalityCode;
	}

	public String getNationalityName() {
		return this.nationalityName;
	}

	public void setNationalityName(String nationalityName) {
		this.nationalityName = nationalityName;
	}

	public String getNationCode() {
		return this.nationCode;
	}

	public void setNationCode(String nationCode) {
		this.nationCode = nationCode;
	}

	public String getNationName() {
		return this.nationName;
	}

	public void setNationName(String nationName) {
		this.nationName = nationName;
	}

	public String getGraduateSchool() {
		return this.graduateSchool;
	}

	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}

	public String getMajorCode() {
		return this.majorCode;
	}

	public void setMajorCode(String majorCode) {
		this.majorCode = majorCode;
	}

	public String getMajorName() {
		return this.majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getDegreeCode() {
		return this.degreeCode;
	}

	public void setDegreeCode(String degreeCode) {
		this.degreeCode = degreeCode;
	}

	public String getDegreeName() {
		return this.degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

	public String getTitleLevelCode() {
		return this.titleLevelCode;
	}

	public void setTitleLevelCode(String titleLevelCode) {
		this.titleLevelCode = titleLevelCode;
	}

	public String getTitleLevelName() {
		return this.titleLevelName;
	}

	public void setTitleLevelName(String titleLevelName) {
		this.titleLevelName = titleLevelName;
	}

	public String getTitleCode() {
		return this.titleCode;
	}

	public void setTitleCode(String titleCode) {
		this.titleCode = titleCode;
	}

	public String getTitleName() {
		return this.titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getJobCode() {
		return this.jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getPositionCode() {
		return this.positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	public String getPositionName() {
		return this.positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public Date getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Integer getDimissionFlag() {
		return this.dimissionFlag;
	}

	public void setDimissionFlag(Integer dimissionFlag) {
		this.dimissionFlag = dimissionFlag;
	}

	public Integer getSortNo() {
		return this.sortNo;
	}

	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDeliveryArea() {
		return this.deliveryArea;
	}

	public void setDeliveryArea(String deliveryArea) {
		this.deliveryArea = deliveryArea;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

    public Integer getCanPrescription()
    {
        return canPrescription;
    }

    public void setCanPrescription(Integer canPrescription)
    {
        this.canPrescription = canPrescription;
    }

    public Integer getCanNarcotic()
    {
        return canNarcotic;
    }

    public void setCanNarcotic(Integer canNarcotic)
    {
        this.canNarcotic = canNarcotic;
    }

    public Integer getCanPsychotropic()
    {
        return canPsychotropic;
    }

    public void setCanPsychotropic(Integer canPsychotropic)
    {
        this.canPsychotropic = canPsychotropic;
    }

    public Integer getCanAntibiotics()
    {
        return canAntibiotics;
    }

    public void setCanAntibiotics(Integer canAntibiotics)
    {
        this.canAntibiotics = canAntibiotics;
    }

    public String getClinicalDeptId()
    {
        return clinicalDeptId;
    }

    public void setClinicalDeptId(String clinicalDeptId)
    {
        this.clinicalDeptId = clinicalDeptId;
    }

    public String getClinicalDeptName()
    {
        return clinicalDeptName;
    }

    public void setClinicalDeptName(String clinicalDeptName)
    {
        this.clinicalDeptName = clinicalDeptName;
    }


    /**
	 * ID
	 */
	public static final String ID = "id";
	/**
	 * 医疗机构ID
	 */
	public static final String ORG_ID = "orgId";
	/**
	 * 医疗机构名称
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
	 * 人员类别ID
	 */
	public static final String CATEGORY_ID = "categoryId";
	/**
	 * 人员类别
	 */
	public static final String CATEGORY_NAME = "categoryName";
	/**
	 * 工号
	 */
	public static final String WORK_NO = "workNo";
	/**
	 * IC卡号
	 */
	public static final String IC_CARD_NO = "icCardNo";
	/**
	 * 姓名
	 */
	public static final String NAME = "name";
	/**
	 * 性别
	 */
	public static final String GENDER = "gender";
	/**
	 * 出生日期
	 */
	public static final String BIRTHDAY = "birthday";
	/**
	 * 身份证件号
	 */
	public static final String ID_NO = "idNo";
	/**
	 * 联系电话
	 */
	public static final String TELEPHONE = "telephone";
	/**
	 * 电子邮箱
	 */
	public static final String EMAIL = "email";
	/**
	 * 个人网站
	 */
	public static final String PERSONAL_WEBSITE = "personalWebsite";
	/**
	 * 个人简介
	 */
	public static final String PERSONAL_INTRODUCTION = "personalIntroduction";
	/**
	 * 住址-区县码
	 */
	public static final String HOME_DISTRICT = "homeDistrict";
	/**
	 * 住址-街道
	 */
	public static final String HOME_STREET = "homeStreet";
	/**
	 * 住址-邮编
	 */
	public static final String HOME_ZIP_CODE = "homeZipCode";
	/**
	 * 紧急联系人姓名
	 */
	public static final String EMERGENCY_CONTACT_NAME = "emergencyContactName";
	/**
	 * 紧急联系人电话
	 */
	public static final String EMERGENCY_CONTACT_TELEPHONE = "emergencyContactTelephone";
	/**
	 * 国家代码
	 */
	public static final String NATIONALITY_CODE = "nationalityCode";
	/**
	 * 国家名称
	 */
	public static final String NATIONALITY_NAME = "nationalityName";
	/**
	 * 民族代码
	 */
	public static final String NATION_CODE = "nationCode";
	/**
	 * 民族名称
	 */
	public static final String NATION_NAME = "nationName";
	/**
	 * 毕业学校名称
	 */
	public static final String GRADUATE_SCHOOL = "graduateSchool";
	/**
	 * 专业代码
	 */
	public static final String MAJOR_CODE = "majorCode";
	/**
	 * 专业名称
	 */
	public static final String MAJOR_NAME = "majorName";
	/**
	 * 学历代码
	 */
	public static final String DEGREE_CODE = "degreeCode";
	/**
	 * 学历名称
	 */
	public static final String DEGREE_NAME = "degreeName";
	/**
	 * 专业职称级别代码
	 */
	public static final String TITLE_LEVEL_CODE = "titleLevelCode";
	/**
	 * 专业职称级别名称
	 */
	public static final String TITLE_LEVEL_NAME = "titleLevelName";
	/**
	 * 专业职称代码
	 */
	public static final String TITLE_CODE = "titleCode";
	/**
	 * 专业职称名称
	 */
	public static final String TITLE_NAME = "titleName";
	/**
	 * 职务代码
	 */
	public static final String JOB_CODE = "jobCode";
	/**
	 * 职务名称
	 */
	public static final String JOB_NAME = "jobName";
	/**
	 * 职业工种(岗位)编码
	 */
	public static final String POSITION_CODE = "positionCode";
	/**
	 * 职业工种(岗位)名称
	 */
	public static final String POSITION_NAME = "positionName";
	/**
	 * 入职日期
	 */
	public static final String ENTRY_DATE = "entryDate";
	/**
	 * 离职标识
	 */
	public static final String DIMISSION_FLAG = "dimissionFlag";
	/**
	 * 显示顺序号
	 */
	public static final String SORT_NO = "sortNo";
	/**
	 * 状态
	 */
	public static final String STATUS = "status";
	/**
	 * 配送区域
	 */
	public static final String DELIVERY_AREA = "deliveryArea";
	/**
	 * 系统账号
	 */
	public static final String LOGIN_NAME = "loginName";

    /**
    * 处方权
    */
    public static final String CAN_PRESCRIPTION = "canPrescription";

    /**
    *  麻醉药品处方权
    */
    public static final String CAN_NARCOTIC = "canNarcotic";

    /**
    *  精神类药品处方权
    */
    public static final String CAN_PSYCHOTROPIC = "canPsychotropic";

    /**
    *  抗生素处方权
    */
    public static final String CAN_ANTIBIOTICS = "canAntibiotics";

    /**
     *  临床科室ID
     */
    public static final String CLINICAL_DEPT_ID = "clinicalDeptId";

    /**
     *  临床科室名称
     */
    public static final String CLINICAL_DEPT_NAME = "clinicalDeptName";

	public static final String[] All_FIELDS = new String[] { ID, ORG_ID,
			ORG_NAME, DEPT_ID, DEPT_NAME, CATEGORY_ID, CATEGORY_NAME, WORK_NO,
			IC_CARD_NO, NAME, GENDER, BIRTHDAY, ID_NO, TELEPHONE, EMAIL,
			PERSONAL_WEBSITE, PERSONAL_INTRODUCTION, HOME_DISTRICT,
			HOME_STREET, HOME_ZIP_CODE, EMERGENCY_CONTACT_NAME,
			EMERGENCY_CONTACT_TELEPHONE, NATIONALITY_CODE, NATIONALITY_NAME,
			NATION_CODE, NATION_NAME, GRADUATE_SCHOOL, MAJOR_CODE, MAJOR_NAME,
			DEGREE_CODE, DEGREE_NAME, TITLE_LEVEL_CODE, TITLE_LEVEL_NAME,
			TITLE_CODE, TITLE_NAME, JOB_CODE, JOB_NAME, POSITION_CODE,
			POSITION_NAME, ENTRY_DATE, DIMISSION_FLAG, SORT_NO, STATUS,
			DELIVERY_AREA , LOGIN_NAME,CAN_PRESCRIPTION,CAN_NARCOTIC,CAN_PSYCHOTROPIC,CAN_ANTIBIOTICS,
            CLINICAL_DEPT_ID,CLINICAL_DEPT_NAME};
}
