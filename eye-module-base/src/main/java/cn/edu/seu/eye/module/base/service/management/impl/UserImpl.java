package cn.edu.seu.eye.module.base.service.management.impl;

import cn.edu.seu.eye.module.base.dao.management.IUserDao;
import cn.edu.seu.eye.module.base.dao.management.IUserRoleDao;
import cn.edu.seu.eye.module.base.entity.management.User;
import cn.edu.seu.eye.module.base.entity.management.UserRole;
import cn.edu.seu.eye.module.base.resource.AbstractService;
import cn.edu.seu.eye.module.base.service.management.IUser;
import com.iron.fast.beans.Criteria;
import com.iron.fast.repository.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserImpl extends AbstractService<User> implements IUser {

	@Autowired
	private IUserDao userDao;

	@Autowired
	private IUserRoleDao userRoleDao;

	@Override
	public IDao<User> getIDao() {
		return userDao;
	}

	@Override
	public List<Map<String, Object>> getUserRoleMapListByUser(String userName) {
		return userDao.getUserRoleMapListByUser(userName);
	}
	
	@Override
	@Transactional
	public User insertUser(User user) {
		user.setId(UUID.randomUUID().toString());
		userDao.insert(user);
		userRoleDao.batchInsert(user.getUserRoleList());
		return user;
	}
	
	@Override
	@Transactional
	public void deleteUser(Criteria criteria,Criteria criteria2) {
		userDao.delete(criteria);
		userRoleDao.delete(criteria2);
	}
	
	@Override
	@Transactional
	public void deleteUser(List<User> users) {
		if (users != null && users.size() > 0) {
			for (User user : users) {
				user.setStatus(2);
				userDao.update(user, User.STATUS);
				Criteria criteria1 = new Criteria();
				criteria1.add(UserRole.LOGIN_NAME, user.getLoginName());
				userRoleDao.delete(criteria1);
			}
		}
	}
	
	@Override
	@Transactional
	public void updateUser(User user) {
		Criteria criteria1 = new Criteria();
		criteria1.add(UserRole.LOGIN_NAME, user.getLoginName());
		userRoleDao.delete(criteria1);
		userDao.update(user);
		userRoleDao.batchInsert(user.getUserRoleList());
	}
}
