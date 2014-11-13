package cn.edu.seu.eye.module.base.service.management;

import cn.edu.seu.eye.module.base.entity.management.User;
import cn.edu.seu.eye.module.base.resource.IService;
import com.iron.fast.beans.Criteria;

import java.util.List;
import java.util.Map;

public interface IUser extends IService<User> {
	List<Map<String, Object>> getUserRoleMapListByUser(String userName);
	
	User insertUser(User user);
	
	void deleteUser(Criteria criteria,Criteria criteria2);
	
	void deleteUser(List<User> users);
	
	void updateUser(User user);
}
