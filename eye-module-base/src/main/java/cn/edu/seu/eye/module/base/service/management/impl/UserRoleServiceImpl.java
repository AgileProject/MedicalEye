package cn.edu.seu.eye.module.base.service.management.impl;

import cn.edu.seu.eye.module.base.dao.management.IUserRoleDao;
import cn.edu.seu.eye.module.base.entity.management.UserRole;
import cn.edu.seu.eye.module.base.resource.AbstractService;
import cn.edu.seu.eye.module.base.service.management.IUserRoleService;
import com.iron.fast.repository.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends AbstractService<UserRole> implements IUserRoleService{
	
	@Autowired
	private IUserRoleDao userRoleDao;
	
	@Override
	public IDao<UserRole> getIDao() {
		return userRoleDao;
	}
}
