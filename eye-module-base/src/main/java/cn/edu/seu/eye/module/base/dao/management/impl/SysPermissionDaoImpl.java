package cn.edu.seu.eye.module.base.dao.management.impl;

import cn.edu.seu.eye.module.base.dao.management.ISysPermissionDao;
import cn.edu.seu.eye.module.base.entity.management.Permission;
import com.iron.fast.beans.Criteria;
import com.iron.fast.repository.AbstractDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SysPermissionDaoImpl extends AbstractDao<Permission> implements
		ISysPermissionDao {

	@Override
	public List<Map<String, Object>> getRolePermissionMapList(Criteria criteria) {
		String sql = "SELECT * FROM SYS_ROLE_PERMISSION";
		return getMapList(sql, criteria);
	}
}
