package cn.edu.seu.eye.module.base.service.management.impl;

import cn.edu.seu.eye.module.base.dao.management.IComputersDao;
import cn.edu.seu.eye.module.base.entity.management.Computers;
import cn.edu.seu.eye.module.base.resource.AbstractService;
import cn.edu.seu.eye.module.base.service.management.IComputers;
import com.iron.fast.repository.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ling on 2014/12/4.
 */
@Service
public class ComputersImpl extends AbstractService<Computers> implements IComputers {

	@Autowired
	private IComputersDao computersDao;

	@Override
	public IDao<Computers> getIDao() {
		return computersDao;
	}



//	@Override
//	@Transactional
//	public Computers insertComputers(Computers computers) {
//		//computers.setComputerID(1);
//		computersDao.insert(computers);
//		//userRoleDao.batchInsert(user.getUserRoleList());
//		return computers;
//		//return null;
//	}
//
//	@Override
//	@Transactional
//	public void deleteComputers(Criteria criteria, Criteria criteria2) {
//		computersDao.delete(criteria);
//		//userRoleDao.delete(criteria2);
//	}



}
