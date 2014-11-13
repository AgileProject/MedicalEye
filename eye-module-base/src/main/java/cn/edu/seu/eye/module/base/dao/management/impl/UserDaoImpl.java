
package cn.edu.seu.eye.module.base.dao.management.impl;

import cn.edu.seu.eye.module.base.dao.management.IUserDao;
import cn.edu.seu.eye.module.base.entity.management.User;
import com.iron.fast.beans.Criteria;
import com.iron.fast.repository.AbstractDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl extends AbstractDao<User> implements IUserDao {

	@Override
	public List<Map<String, Object>> getUserRoleMapListByUser(String loginName) {
		String sql = "SELECT * FROM SYS_USER_ROLE where LOGIN_NAME = '" + loginName + "'";
		return getMapList(sql, new Criteria());
	}
}