package cn.edu.seu.eye.core.MongoDBDao.dao.impl;

import cn.edu.seu.eye.core.MongoDBDao.dao.IComputerDao;
import cn.edu.seu.eye.core.MongoDBDao.entity.Computer;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

import java.util.ArrayList;
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

    @Override
    public List<Computer> getAllComputers() {

        List<Computer> list = new ArrayList<>();

        DBCursor cursor = collection.find().sort(new BasicDBObject("_id", 1));

        list = readDBCursorToEntityList(cursor,list);

        return list;
    }

    @Override
    public int insert(Computer computer) {
        super.update("computerName",computer.getComputerName(),
                "computerIP",computer.getComputerIP(),
                "computerOS",computer.getComputerOS(),
                "proInfo",computer.getProInfo(),
                "memInfo",computer.getMemInfo(),
                "diskInfo",computer.getDiskInfo(),
                "dbInfo",computer.getDbInfo(),
                "time",computer.getTime()
        );

        return 0;
    }
}
