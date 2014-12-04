package cn.edu.seu.eye.core.MongoDBDao.dao.impl;

import com.mongodb.*;
import cn.edu.seu.eye.core.MongoDBDao.dao.IDao;
import cn.edu.seu.eye.core.MongoDBDao.utils.MongoDBConnection;
import cn.edu.seu.eye.core.MongoDBDao.utils.EntityUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 14-11-28.
 */
public class AbstractDao<T> implements IDao<T>{
    protected String mongo_db_address = "ee-lab";
    protected int mongo_db_port = 27017;
    protected String mongo_db_dbName ="mydb";
    protected String mongo_db_collectionName = "testData";


    protected MongoClient mongoClient = null;
    protected DB db = null;
    protected DBCollection collection = null;

    private void init(){
        MongoDBConnection.setMONGODB_DB_ADDRESS(this.mongo_db_address);
        MongoDBConnection.setMONGO_DB_PORT(this.mongo_db_port);
        MongoDBConnection.setMONGO_DB_DBNAME(this.mongo_db_dbName);
        this.mongoClient = MongoDBConnection.getMongoClient();
        this.db = MongoDBConnection.getDB();
        this.collection =MongoDBConnection.getCollection(this.mongo_db_collectionName);
    }

    public AbstractDao() {
    }

    public AbstractDao(String mongo_db_collectionName) {
        this.mongo_db_collectionName = mongo_db_collectionName;
        init();
    }

    public AbstractDao(String mongo_db_collectionName,String mongo_db_address) {
        this.mongo_db_collectionName = mongo_db_collectionName;
        this.mongo_db_address = mongo_db_address;
        init();

    }

    public AbstractDao(String mongo_db_collectionName,String mongo_db_address,int mongo_db_port) {
        this.mongo_db_collectionName = mongo_db_collectionName;
        this.mongo_db_address = mongo_db_address;
        this.mongo_db_port =mongo_db_port;
        init();
    }

    public AbstractDao(String mongo_db_collectionName,String mongo_db_dbName,String mongo_db_address,int mongo_db_port) {
        this.mongo_db_collectionName = mongo_db_collectionName;
        this.mongo_db_dbName = mongo_db_dbName;
        this.mongo_db_address = mongo_db_address;
        this.mongo_db_port =mongo_db_port;
        init();
    }

    @Override
    public int insert(T t) {

        BasicDBObject basicDBObject = null;
        try {
            basicDBObject = EntityUtil.entityToBasicDBObject(t);
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }

        WriteResult writeResult = collection.insert(basicDBObject);

        return writeResult.getN();
    }

    @Override
    public int batchInsert(List<T> list) {

        int count = 0;

        BasicDBObject basicDBObject = null;

        for (T t :list){
            try {
                basicDBObject = EntityUtil.entityToBasicDBObject(t);
            }catch (IllegalAccessException e){
                e.printStackTrace();
            }
            WriteResult writeResult = collection.insert(basicDBObject);
            count += writeResult.getN();

        }

        return count;
    }

    @Override
    public int delete(String key, Object value, Object... keyValue) {

        BasicDBObject criteria = new BasicDBObject(key,value);
        for (int i = 0; i<keyValue.length; i+=2){
            criteria.append((String) keyValue[i],keyValue[i+1]);
        }

        WriteResult writeResult =collection.remove(criteria);

        return writeResult.getN();
    }

    @Override
    public int update(String ID, Object IDValue, String key, Object value, Object... keyValue) {
        BasicDBObject criteria = new BasicDBObject(ID,IDValue);
        BasicDBObject updataValue = new BasicDBObject(key,value);
        for (int i = 0; i<keyValue.length;i+=2){
            updataValue.append((String) keyValue[i],keyValue[i+1]);
        }
        WriteResult writeResult =collection.update(criteria,new BasicDBObject("$set",updataValue),true,true);

        return writeResult.getN();
    }

    @Override
    public <T> List<T> get(String key,Object value,Object...keyValue) {

        List<T> list = new ArrayList<T>();

        BasicDBObject criteria = new BasicDBObject(key,value);
        if (keyValue.length%2 ==1)
        {
            return null;
        }
        for (int i=0; i<keyValue.length;i+=2){
            criteria.append((String) keyValue[i],keyValue[i+1]);
        }

        String className = this.getClass().getName();
        String classType = className.substring(0,className.length()-7).replaceFirst("dao.impl","entity");


        DBCursor cursor = collection.find(criteria).sort(new BasicDBObject("time",1).append("_id",1));
        while (cursor.hasNext()){
            try {
                Object entity = Class.forName(classType).newInstance();
                list.add(
                         (T)  EntityUtil.basicDBObjectToEntity((BasicDBObject) cursor.next(),entity)
                        );
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return list;
    }

    @Override
    public <T> List<T> getLastNRecord(int number,String key, Object value, Object... keyValue) {

        List<T> rawList = get(key,value,keyValue);
        Iterator<T> iterator = rawList.iterator();
        List<T> cookedList = new ArrayList<T>();

        if (rawList.size()<number)
        {
            for (int i=0;i<number-rawList.size();i++){
                cookedList.add(null);
            }

            for (int i=number-rawList.size();i<number;i++){
                cookedList.add(iterator.next());
            }

        }

        if (rawList.size()>number)
        {
            for (int i=rawList.size()-number;i<rawList.size();i++){
                cookedList.add(rawList.get(i));
            }
        }

        return cookedList;
    }

}
