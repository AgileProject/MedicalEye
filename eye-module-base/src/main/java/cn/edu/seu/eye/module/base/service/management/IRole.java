package cn.edu.seu.eye.module.base.service.management;

import cn.edu.seu.eye.module.base.entity.management.Role;
import cn.edu.seu.eye.module.base.resource.IService;
import com.iron.fast.beans.Criteria;

import java.util.List;

public interface IRole extends IService<Role>{
	Role insertRole(Role role);
	
	void deleteRole(Criteria criteria,Criteria criteria2);
	
	void deleteRole(List<Role> roles);
	
	void updateRole(Role role);
}
