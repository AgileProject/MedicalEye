package cn.edu.seu.eye.core.MongoDBDao.dao;

import cn.edu.seu.eye.core.MongoDBDao.entity.Database;

import java.util.List;

/**
 * Created by Administrator on 14-12-1.
 */
public interface IDatabaseDao extends IDao<Database> {

    int storeNRecordToListAfterLastQuery(int number,List<Database> list, Object...keyValue);

}
