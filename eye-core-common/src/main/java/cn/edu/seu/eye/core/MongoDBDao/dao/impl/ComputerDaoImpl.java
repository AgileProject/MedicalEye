package cn.edu.seu.eye.core.MongoDBDao.dao.impl;

import cn.edu.seu.eye.core.MongoDBDao.dao.IComputerDao;
import cn.edu.seu.eye.core.MongoDBDao.entity.Computer;

import java.util.List;

/**
 * Created by Administrator on 14-12-1.
 */
public class ComputerDaoImpl extends AbstractDao<Computer> implements IComputerDao {

    public ComputerDaoImpl(String mongo_db_collectionName, String mongo_db_dbName, String mongo_db_address, int mongo_db_port) {
        super(mongo_db_collectionName, mongo_db_dbName, mongo_db_address, mongo_db_port);
    }

    @Override
    public List<Computer> getAllComputers(String computerName) {

        return get("computerName",computerName);

    }


}
