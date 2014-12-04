package cn.edu.seu.eye.core.MongoDBDao.dao.impl;

import cn.edu.seu.eye.core.MongoDBDao.dao.IDao;
import cn.edu.seu.eye.core.MongoDBDao.entity.Computer;

/**
 * Created by Administrator on 14-12-1.
 */
public class ComputerDaoImpl extends AbstractDao<Computer> implements IDao<Computer>{
    public ComputerDaoImpl(String mongo_db_collectionName) {
        super(mongo_db_collectionName);
    }

    public ComputerDaoImpl(String mongo_db_collectionName, String mongo_db_address) {
        super(mongo_db_collectionName, mongo_db_address);
    }

    public ComputerDaoImpl(String mongo_db_collectionName, String mongo_db_address, int mongo_db_port) {
        super(mongo_db_collectionName, mongo_db_address, mongo_db_port);
    }

    public ComputerDaoImpl(String mongo_db_collectionName, String mongo_db_dbName, String mongo_db_address, int mongo_db_port) {
        super(mongo_db_collectionName, mongo_db_dbName, mongo_db_address, mongo_db_port);
    }
}
