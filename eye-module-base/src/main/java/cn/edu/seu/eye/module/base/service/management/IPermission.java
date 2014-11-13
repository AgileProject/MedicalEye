package cn.edu.seu.eye.module.base.service.management;

import java.util.List;
import java.util.Map;

import cn.edu.seu.eye.module.base.entity.management.Permission;
import cn.edu.seu.eye.module.base.resource.IService;
import com.iron.fast.beans.Criteria;

public interface IPermission extends IService<Permission> {

	List<Map<String, Object>> getRolePermissionMapList(Criteria criteria);
}
