package cn.edu.seu.eye.module.base.entity.management;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 系统配置
 */
@Entity
@Table(name = "SYS_CONFIGURATION")
@JsonInclude(Include.NON_NULL)
public class Configuration implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "VARCHAR2|ID", length = 36, nullable = false)
	private String id;

	@Column(name = "CONFIG_LEVEL", columnDefinition = "NUMBER|级别（1：全局，2：机构，3：科室，4：员工，5：用户）", length = 1, nullable = true)
	private Integer configLevel;

	@Column(name = "OWNER_ID", columnDefinition = "VARCHAR2|所属对象ID", length = 36, nullable = true)
	private String ownerId;

	@Column(name = "OWNER_NAME", columnDefinition = "VARCHAR2|所属对象名称", length = 100, nullable = true)
	private String ownerName;

	@Column(name = "DESCRIPTION", columnDefinition = "VARCHAR2|说明", length = 1000, nullable = true)
	private String description;

	@Column(name = "ITEM_KEY", columnDefinition = "VARCHAR2|键", length = 100, nullable = true)
	private String itemKey;

	@Column(name = "ITEM_VALUE", columnDefinition = "VARCHAR2|值", length = 200, nullable = true)
	private String itemValue;

	@Column(name = "CONFIG_NAME", columnDefinition = "VARCHAR2|配置名称", length = 100, nullable = true)
	private String configName;

	@Column(name = "VALUE_TYPE", columnDefinition = "NUMBER|值类型（1：文本，2：单选，3：多选）", length = 1, nullable = true)
	private Integer valueType;

	@Column(name = "VALUE_DIC", columnDefinition = "VARCHAR2|值域", length = 500, nullable = true)
	private String valueDic;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getConfigLevel() {
		return this.configLevel;
	}

	public void setConfigLevel(Integer configLevel) {
		this.configLevel = configLevel;
	}

	public String getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return this.ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItemKey() {
		return this.itemKey;
	}

	public void setItemKey(String itemKey) {
		this.itemKey = itemKey;
	}

	public String getItemValue() {
		return this.itemValue;
	}

	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}

	public String getConfigName() {
		return this.configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public Integer getValueType() {
		return this.valueType;
	}

	public void setValueType(Integer valueType) {
		this.valueType = valueType;
	}

	public String getValueDic() {
		return this.valueDic;
	}

	public void setValueDic(String valueDic) {
		this.valueDic = valueDic;
	}

	/**
	 * ID
	 */
	public static final String ID = "id";
	/**
	 * 级别（1：全局，2：机构，3：科室，4：员工，5：用户）
	 */
	public static final String CONFIG_LEVEL = "configLevel";
	/**
	 * 所属对象ID
	 */
	public static final String OWNER_ID = "ownerId";
	/**
	 * 所属对象名称
	 */
	public static final String OWNER_NAME = "ownerName";
	/**
	 * 说明
	 */
	public static final String DESCRIPTION = "description";
	/**
	 * 键
	 */
	public static final String ITEM_KEY = "itemKey";
	/**
	 * 值
	 */
	public static final String ITEM_VALUE = "itemValue";
	/**
	 * 配置名称
	 */
	public static final String CONFIG_NAME = "configName";
	/**
	 * 值类型（1：文本，2：单选，3：多选）
	 */
	public static final String VALUE_TYPE = "valueType";
	/**
	 * 值域
	 */
	public static final String VALUE_DIC = "valueDic";
	public static final String[] All_FIELDS = new String[] { ID, CONFIG_LEVEL, OWNER_ID, OWNER_NAME, DESCRIPTION, ITEM_KEY, ITEM_VALUE , CONFIG_NAME, VALUE_TYPE, VALUE_DIC};

}
