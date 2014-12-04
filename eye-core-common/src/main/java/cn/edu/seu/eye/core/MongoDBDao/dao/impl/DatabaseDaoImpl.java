package cn.edu.seu.eye.core.MongoDBDao.dao.impl;

import cn.edu.seu.eye.core.MongoDBDao.dao.IDao;
import cn.edu.seu.eye.core.MongoDBDao.entity.Database;

/**
 * Created by Administrator on 14-12-1.
 */
public class DatabaseDaoImpl extends AbstractDao<Database> implements IDao<Database> {
    public DatabaseDaoImpl(String mongo_db_collectionName) {
        super(mongo_db_collectionName);
    }

    public DatabaseDaoImpl(String mongo_db_collectionName, String mongo_db_address) {
        super(mongo_db_collectionName, mongo_db_address);
    }

    public DatabaseDaoImpl(String mongo_db_collectionName, String mongo_db_address, int mongo_db_port) {
        super(mongo_db_collectionName, mongo_db_address, mongo_db_port);
    }

    public DatabaseDaoImpl(String mongo_db_collectionName, String mongo_db_dbName, String mongo_db_address, int mongo_db_port) {
        super(mongo_db_collectionName, mongo_db_dbName, mongo_db_address, mongo_db_port);
    }
}
