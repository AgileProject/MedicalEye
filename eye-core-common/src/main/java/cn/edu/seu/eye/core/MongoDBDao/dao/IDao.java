package cn.edu.seu.eye.core.MongoDBDao.dao;


import java.util.List;

/**
 * Created by Administrator on 14-11-23.
 */
public interface IDao <T> {

    int insert(T t);

    int batchInsert(List<T> list);

    int delete(String key,Object value,Object...keyValue);

    int update(String ID,Object IDValue,String key,Object value,Object...keyValue);


    <T> List<T> get(String key,Object value,Object...keyValue);

    <T> List<T> getLastNRecord(int number,String key,Object value,Object...keyValue);





}
