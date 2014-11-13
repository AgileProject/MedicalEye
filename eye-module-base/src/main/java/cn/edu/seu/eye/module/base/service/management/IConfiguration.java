package cn.edu.seu.eye.module.base.service.management;

import cn.edu.seu.eye.module.base.entity.management.Configuration;
import cn.edu.seu.eye.module.base.resource.IService;

public interface IConfiguration extends IService<Configuration>{
	
	final static String IS_IN_TASK_ENABLED = "IsInTaskEnabled";
	
	final static String IS_OUT_TASK_ENABLED = "IsOutTaskEnabled";

}
