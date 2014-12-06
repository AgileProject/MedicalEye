package cn.edu.seu.eye.module.base.service.management.impl;



/**
 * Created by DL on 2014/12/2.
 */



import cn.edu.seu.eye.module.base.dao.management.IComputerDao;
import cn.edu.seu.eye.module.base.entity.management.Computer;
import cn.edu.seu.eye.module.base.resource.AbstractService;
import cn.edu.seu.eye.module.base.service.management.IComputer;
import com.iron.fast.beans.Criteria;
import com.iron.fast.repository.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ComputerImpl extends AbstractService<Computer> implements IComputer {
    @Autowired
    private IComputerDao computerDao;

    @Override
    public IDao<Computer> getIDao() {
        return computerDao;
    }




    public Computer insertComputer(Computer computer) {
        computerDao.insert(computer);
        return computer;
    }

    @Override
    @Transactional
    public void deleteComputer(Computer computer) {
        computerDao.delete(computer);
    }



    @Override
    @Transactional
    public void updateComputer(Computer computer) {
        computerDao.update(computer);
    }
}

