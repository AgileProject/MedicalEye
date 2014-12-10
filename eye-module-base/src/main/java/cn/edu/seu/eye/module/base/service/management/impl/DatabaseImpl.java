package cn.edu.seu.eye.module.base.service.management.impl;

import cn.edu.seu.eye.module.base.dao.management.IDatabaseDao;
import cn.edu.seu.eye.module.base.entity.management.Database;
import cn.edu.seu.eye.module.base.resource.AbstractService;
import cn.edu.seu.eye.module.base.service.management.IDatabase;
import com.iron.fast.repository.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ling on 2014/12/6.
 */

@Service
public class DatabaseImpl extends AbstractService<Database> implements IDatabase{

	@Autowired
	private IDatabaseDao databaseDao;

	@Override
	public IDao<Database> getIDao() {
		return databaseDao;
	}
}
