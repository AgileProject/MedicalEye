package cn.edu.seu.eye.core.MongoDBDao.dao;



import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 14-11-23.
 */
public interface IDao <T> {

    int insert(T t);

    int batchInsert(List<T> list);

    int delete (String key,Object value,Object...keyValue);

    int update(String criteriaKey, Object criteriaValue,
               String setKey, Object setValue, Object... setKeyValue) ;


    List<T> get(String key,Object value,Object...keyValue);

    List<T> getLastNRecord(int number,String key,Object value,Object...keyValue);

    List<T> getRecordAfter(Date time,Object...keyValue);

    int storeNRecordToListAfter(int number,List<T> list, Date time,Object...keyValue);

    List<T> getNRecordAfter(int number,Date time,Object...keyValue);

    public Date getLastQueryTime();

    public void setLastQueryTime(Date lastQueryTime);



}
