package cn.edu.seu.eye.module.base.dao.management.impl;

import cn.edu.seu.eye.module.base.dao.management.IConfigurationDao;
import cn.edu.seu.eye.module.base.entity.management.Configuration;
import com.iron.fast.repository.AbstractDao;
import org.springframework.stereotype.Repository;

@Repository
public class ConfigurationDaoImpl extends AbstractDao<Configuration> implements IConfigurationDao {

}