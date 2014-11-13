package cn.edu.seu.eye.module.base.service.management.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.seu.eye.module.base.dao.management.IRoleDao;
import cn.edu.seu.eye.module.base.dao.management.IRolePermissionDao;
import cn.edu.seu.eye.module.base.dao.management.IUserRoleDao;
import cn.edu.seu.eye.module.base.entity.management.Role;
import cn.edu.seu.eye.module.base.entity.management.RolePermission;
import cn.edu.seu.eye.module.base.entity.management.UserRole;
import cn.edu.seu.eye.module.base.resource.AbstractService;
import cn.edu.seu.eye.module.base.service.management.IRole;
import com.iron.fast.beans.Criteria;
import com.iron.fast.repository.IDao;

@Service
public class RoleImpl extends AbstractService<Role> implements IRole {

	@Autowired
	private IRoleDao roleDao;
	
	@Autowired
	private IRolePermissionDao rolePermissionDao;
	
	@Autowired
	private IUserRoleDao userRoleDao;

	@Override
	public IDao<Role> getIDao() {
		return roleDao;
	}
	
	@Override
	@Transactional
	public Role insertRole(Role role) {
		role.setId(UUID.randomUUID().toString());
		roleDao.insert(role);
		List<RolePermission> rolePermissions = role.getRolePermissionList();
		if (rolePermissions != null && rolePermissions.size() > 0) {
			for (RolePermission rolePermission : rolePermissions) {
				rolePermission.setRoleId(role.getId());
			}
		}
		rolePermissionDao.batchInsert(rolePermissions);
		return role;
	}
	
	@Override
	@Transactional
	public void deleteRole(Criteria criteria,Criteria criteria2) {
		roleDao.delete(criteria);
		rolePermissionDao.delete(criteria2);
	}
	
	@Override
	@Transactional
	public void deleteRole(List<Role> roles) {
		if (roles != null && roles.size() > 0) {
			for (Role role : roles) {
				role.setStatus(2);
				roleDao.update(role, Role.STATUS);
				Criteria criteria1 = new Criteria();
				criteria1.add(RolePermission.ROLE_ID, role.getId());
				rolePermissionDao.delete(criteria1);
				Criteria criteria2 = new Criteria();
				criteria2.add(UserRole.ROLE_ID, role.getId());
				userRoleDao.delete(criteria2);
			}
		}
		
	}
	
	@Override
	@Transactional
	public void updateRole(Role role) {
		Criteria criteria1 = new Criteria();
		criteria1.add(RolePermission.ROLE_ID, role.getId());
		rolePermissionDao.delete(criteria1);
		roleDao.update(role);
		rolePermissionDao.batchInsert(role.getRolePermissionList());
	}
	
}
