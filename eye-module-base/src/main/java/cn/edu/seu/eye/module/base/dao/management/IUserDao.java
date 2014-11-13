package cn.edu.seu.eye.module.base.dao.management;

import cn.edu.seu.eye.module.base.entity.management.User;
import com.iron.fast.repository.IDao;

import java.util.List;
import java.util.Map;

public interface IUserDao extends IDao<User> {

	List<Map<String, Object>> getUserRoleMapListByUser(String loginName);
}