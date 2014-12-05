package cn.edu.seu.eye.core.MongoDBDao.dao.impl;

import com.mongodb.*;
import cn.edu.seu.eye.core.MongoDBDao.dao.IDao;
import cn.edu.seu.eye.core.MongoDBDao.utils.MongoDBConnection;
import cn.edu.seu.eye.core.MongoDBDao.utils.EntityUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 14-11-28.
 */
public class AbstractDao<T> implements IDao<T>{

    protected String mongo_db_address = "ee-lab";
    protected int mongo_db_port = 27017;
    protected String mongo_db_dbName ="mydb";
    protected String mongo_db_collectionName = "testData";

    protected MongoDBConnection mongoDBConnection = null;
    protected MongoClient mongoClient = null;
    protected DB db = null;
    protected DBCollection collection = null;


    public AbstractDao() {
    }

    public AbstractDao(String mongo_db_collectionName,String mongo_db_dbName,String mongo_db_address,int mongo_db_port) {
        this.mongo_db_collectionName = mongo_db_collectionName;
        this.mongo_db_dbName = mongo_db_dbName;
        this.mongo_db_address = mongo_db_address;
        this.mongo_db_port =mongo_db_port;
        init();
    }

    private void init(){
        mongoDBConnection = new MongoDBConnection(mongo_db_address ,mongo_db_port,mongo_db_dbName);
        mongoClient = mongoDBConnection.getMongoClient();
        db = mongoDBConnection.getDB();
        collection = mongoDBConnection.getCollection(mongo_db_collectionName);
    }

    private BasicDBObject entityToBasicDBObject(T t){

        BasicDBObject basicDBObject = null;
        try {
            basicDBObject = EntityUtil.entityToBasicDBObject(t);
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }

        return basicDBObject;
    }

    @SuppressWarnings("unchecked")
    private List<T> readDBCursorToEntityList(DBCursor cursor,List<T> list){

        String className = this.getClass().getName();
        String classType = className.substring(0,className.length()-7).replaceFirst("dao.impl","entity");

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

    @SuppressWarnings("unchecked")
    private List<T> addEmptyEntityToList(int n,List<T> list){

        String className = this.getClass().getName();
        String classType = className.substring(0,className.length()-7).replaceFirst("dao.impl","entity");

        for(int i=0;i<n;i++){
            try {
                Object entity = Class.forName(classType).newInstance();
                list.add((T) entity);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return list;
    }

    private BasicDBObject createKeyValues(String key, Object value, Object... keyValue){

        BasicDBObject keyValues = new BasicDBObject(key,value);

        if (keyValue.length%2 ==1)
        {
            System.out.println("键值对不匹配");
        }

        for (int i = 0; i<keyValue.length; i+=2){
            keyValues.append((String) keyValue[i],keyValue[i+1]);
        }

        return keyValues;
    }

    @Override
    public int insert(T t) {
        return collection.insert(entityToBasicDBObject(t)).getN();
    }

    @Override
    public int batchInsert(List<T> list) {

        int count = 0;

        for (T t :list){
            count += collection.insert(entityToBasicDBObject(t)).getN();
        }

        return count;
    }

    @Override
    public int delete(String key, Object value, Object... keyValue){

        return collection.remove(createKeyValues(key,value,keyValue)).getN();

    }

    @Override
    public int update(String criteriaKey, Object criteriaValue,
                      String setKey, Object setValue, Object... setKeyValue){

        return collection.update(new BasicDBObject(criteriaKey,criteriaValue),
                new BasicDBObject("$set",createKeyValues(setKey,setValue,setKeyValue)),true,true).getN();

    }

    @Override
    public List<T> get(String key,Object value,Object...keyValue) {

        List<T> list = new ArrayList<>();

        DBCursor cursor = collection.find(createKeyValues(key,value,keyValue))
                .sort(new BasicDBObject("time",1).append("_id",1));

        list = readDBCursorToEntityList(cursor,list);

        return list;
    }

    @Override
    public List<T> getLastNRecord(int number,String key, Object value, Object... keyValue) {

        List<T> list = new ArrayList<>();

        BasicDBObject criteria = createKeyValues(key,value,keyValue);

        DBCursor cursor = collection.find(criteria)
                .sort(new BasicDBObject("time",1).append("_id",1));

        if (cursor.count()<number)
        {
            list = addEmptyEntityToList(number-cursor.count(),list);
        }else {
            cursor = collection.find(criteria).skip(cursor.count()-number)
                    .sort(new BasicDBObject("time", 1).append("_id", 1));
        }

        list = readDBCursorToEntityList(cursor,list);

        return list;
    }

    @Override
    public List<T> getRecordAfter(Date time, Object... keyValue) {

        List<T> list = new ArrayList<>();

        BasicDBObject criteria = new BasicDBObject("time",new BasicDBObject("$gte",time));

        if (keyValue.length%2 ==1)
        {
            System.out.println("键值对不匹配");
        }
        for (int i=0; i<keyValue.length;i+=2){
            criteria.append((String) keyValue[i],keyValue[i+1]);
        }

        DBCursor cursor = collection.find(criteria)
                .sort(new BasicDBObject("time", 1).append("_id", 1));

        list = readDBCursorToEntityList(cursor,list);

        return list;
    }

    @Override
    public List<T> getNRecordAfter(int number, Date time, Object... keyValeu) {

        List<T> list = new ArrayList<>();

        BasicDBObject criteria = new BasicDBObject("time",new BasicDBObject("$gte",time));
        if (keyValeu.length%2 ==1)
        {
            System.out.println("键值对不匹配");
            return null;
        }
        for (int i=0; i<keyValeu.length;i+=2){
            criteria.append((String) keyValeu[i],keyValeu[i+1]);
        }

        DBCursor cursor = collection.find(criteria).limit(number)
                .sort(new BasicDBObject("time", 1).append("_id", 1));
        list = readDBCursorToEntityList(cursor,list);

        if (cursor.count()<number)
        {
            list = addEmptyEntityToList(number-cursor.count(),list);
        }

        return list;

    }

    @Override
    public List<T> getNRecordBefore(int number, Date time, Object... keyValue) {

        List<T> list = new ArrayList<>();

        BasicDBObject criteria = new BasicDBObject("time",new BasicDBObject("$lte",time));

        if (keyValue.length%2 ==1)
        {
            System.out.println("键值对不匹配");
            return null;
        }
        for (int i=0; i<keyValue.length;i+=2){
            criteria.append((String) keyValue[i],keyValue[i+1]);
        }

        DBCursor cursor = collection.find(criteria)
                .sort(new BasicDBObject("time", 1).append("_id", 1));

        if (cursor.count()<number)
        {
            list = addEmptyEntityToList(number-cursor.count(),list);
        }else {
            cursor = collection.find(criteria).skip(cursor.count()-number)
                    .sort(new BasicDBObject("time", 1).append("_id", 1));
        }

        list = readDBCursorToEntityList(cursor,list);

        return list;
    }

    @Override
    public int storeNRecordToListAfter(int number, List<T> list, Date time, Object... keyValue) {

        BasicDBObject criteria = new BasicDBObject("time",new BasicDBObject("$gt",time));

        if (keyValue.length%2 ==1)
        {
            System.out.println("键值对不匹配");
            return 0;
        }
        for (int i=0; i<keyValue.length;i+=2){
            criteria.append((String) keyValue[i],keyValue[i+1]);
        }

        DBCursor cursor = collection.find(criteria)
                .sort(new BasicDBObject("time", 1).append("_id", 1));

        if (cursor.count()<number)
        {
            list = readDBCursorToEntityList(cursor,list);
            return cursor.count();
        }else {
            cursor = collection.find(criteria).limit(number)
                    .sort(new BasicDBObject("time", 1).append("_id", 1));
            list = readDBCursorToEntityList(cursor,list);
            return cursor.count();
        }
    }
}
