package cn.edu.seu.eye.module.base.dao.management;

import cn.edu.seu.eye.module.base.entity.management.Permission;
import com.iron.fast.beans.Criteria;
import com.iron.fast.repository.IDao;

import java.util.List;
import java.util.Map;

public interface ISysPermissionDao extends IDao<Permission> {

	List<Map<String, Object>> getRolePermissionMapList(Criteria criteria);
}
