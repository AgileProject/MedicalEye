package cn.edu.seu.eye.core.MongoDBDao.dao;

import cn.edu.seu.eye.core.MongoDBDao.entity.Hardware;

import java.util.List;

/**
 * Created by Administrator on 14-12-1.
 */
public interface IHardwareDao extends IDao<Hardware> {

    int storeNRecordToListAfter(int number,List<Hardware> list, Object...keyValue);

}
