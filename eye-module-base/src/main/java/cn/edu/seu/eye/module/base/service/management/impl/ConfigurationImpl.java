package cn.edu.seu.eye.module.base.service.management.impl;

import cn.edu.seu.eye.module.base.dao.management.IConfigurationDao;
import cn.edu.seu.eye.module.base.entity.management.Configuration;
import cn.edu.seu.eye.module.base.resource.AbstractService;
import cn.edu.seu.eye.module.base.service.management.IConfiguration;
import com.iron.fast.repository.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationImpl extends AbstractService<Configuration> implements IConfiguration {

	@Autowired
	private IConfigurationDao configurationDao;

	@Override
	public IDao<Configuration> getIDao() {
		return configurationDao;
	}

}
