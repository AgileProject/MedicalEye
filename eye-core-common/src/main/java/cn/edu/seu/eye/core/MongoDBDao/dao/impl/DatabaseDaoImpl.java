package cn.edu.seu.eye.core.MongoDBDao.dao.impl;

import cn.edu.seu.eye.core.MongoDBDao.dao.IDao;
import cn.edu.seu.eye.core.MongoDBDao.dao.IDatabaseDao;
import cn.edu.seu.eye.core.MongoDBDao.entity.Database;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

import java.util.List;

/**
 * Created by Administrator on 14-12-1.
 */
public class DatabaseDaoImpl extends AbstractDao<Database> implements IDatabaseDao {

    public DatabaseDaoImpl(String mongo_db_collectionName, String mongo_db_dbName, String mongo_db_address, int mongo_db_port) {
        super(mongo_db_collectionName, mongo_db_dbName, mongo_db_address, mongo_db_port);
    }

    @Override
    public int storeNRecordToListAfterLastQuery(int number, List<Database> list, Object... keyValue) {


            DBCursor cursor =
                    returnTimeQueryCursor(number,"gt",this.lastQueryTime,keyValue);

            list.clear();

            list = readDBCursorToEntityList(cursor,list);

            if (list.size() != 0){
                this.lastQueryTime = (list.get(cursor.size()-1)).getTime();
            }

            return cursor.size();

    }
}
