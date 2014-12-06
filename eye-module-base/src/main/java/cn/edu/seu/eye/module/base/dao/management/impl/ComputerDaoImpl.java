package cn.edu.seu.eye.module.base.dao.management.impl;

/**
 * Created by DL on 2014/12/2.
 */
import cn.edu.seu.eye.module.base.dao.management.IComputerDao;
import cn.edu.seu.eye.module.base.entity.management.Computer;
import com.iron.fast.beans.Criteria;
import com.iron.fast.repository.AbstractDao;
import org.springframework.stereotype.Repository;

@Repository
public class ComputerDaoImpl  extends AbstractDao<Computer> implements IComputerDao{
}
