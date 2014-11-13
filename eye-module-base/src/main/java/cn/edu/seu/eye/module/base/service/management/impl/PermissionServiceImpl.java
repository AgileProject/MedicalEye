package cn.edu.seu.eye.module.base.service.management.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.seu.eye.module.base.dao.management.ISysPermissionDao;
import cn.edu.seu.eye.module.base.entity.management.Permission;
import cn.edu.seu.eye.module.base.resource.AbstractService;
import cn.edu.seu.eye.module.base.service.management.IPermission;
import com.iron.fast.beans.Criteria;
import com.iron.fast.repository.IDao;

@Service
public class PermissionServiceImpl extends AbstractService<Permission>
		implements IPermission {

	@Autowired
	private ISysPermissionDao sysPermissionDao;

	@Override
	public IDao<Permission> getIDao() {
		return sysPermissionDao;
	}

	@Override
	public List<Map<String, Object>> getRolePermissionMapList(Criteria criteria) {
		return sysPermissionDao.getRolePermissionMapList(criteria);
	}

}
