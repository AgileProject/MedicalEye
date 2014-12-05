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

    List<T> getRecordAfter(Date time,Object...keyValeu);

    List<T> getNRecordAfter(int number,Date time,Object...keyValeu);

    List<T> getNRecordBefore(int number,Date time,Object...keyValeu);





}
