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

    public String getMongo_db_address() {
        return mongo_db_address;
    }

    public void setMongo_db_address(String mongo_db_address) {
        this.mongo_db_address = mongo_db_address;
    }

    public int getMongo_db_port() {
        return mongo_db_port;
    }

    public void setMongo_db_port(int mongo_db_port) {
        this.mongo_db_port = mongo_db_port;
    }

    public String getMongo_db_dbName() {
        return mongo_db_dbName;
    }

    public void setMongo_db_dbName(String mongo_db_dbName) {
        this.mongo_db_dbName = mongo_db_dbName;
    }

    public String getMongo_db_collectionName() {
        return mongo_db_collectionName;
    }

    public void setMongo_db_collectionName(String mongo_db_collectionName) {
        this.mongo_db_collectionName = mongo_db_collectionName;
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

    @Override
    public int insert(T t) {

        BasicDBObject basicDBObject = null;



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
    public int update(String criteriaKey, Object criteriaValue, String key, Object value, Object... keyValue) {

        BasicDBObject criteria = new BasicDBObject(criteriaKey,criteriaValue);
        BasicDBObject updataValue = new BasicDBObject(key,value);
        for (int i = 0; i<keyValue.length;i+=2){
            updataValue.append((String) keyValue[i],keyValue[i+1]);
        }

        WriteResult writeResult =collection.update(criteria,new BasicDBObject("$set",updataValue),true,true);

        return writeResult.getN();
    }

    @Override
    public List<T> get(String key,Object value,Object...keyValue) {

        List<T> list = new ArrayList<>();

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
    public List<T> getLastNRecord(int number,String key, Object value, Object... keyValue) {

        List<T> list = new ArrayList<>();


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

        if (cursor.count()<number)
        {
            for(int i=0;i<number-cursor.count();i++){
                list.add(null);
            }

            for (int i=number-cursor.count();i<number;i++){
                try {
                    Object entity = Class.forName(classType).newInstance();
                    list.add(
                            (T)  EntityUtil.basicDBObjectToEntity((BasicDBObject) cursor.next(),entity)
                    );
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }



        if (cursor.count()>number)
        {
            DBCursor cookedCursor = collection.find(criteria)
                    .sort(new BasicDBObject("time",1).append("_id",1)).skip(cursor.count()-number);
            for (int i=0;i<number;i++){
                try {
                    Object entity = Class.forName(classType).newInstance();
                    list.add(
                            (T)  EntityUtil.basicDBObjectToEntity((BasicDBObject) cookedCursor.next(),entity)
                    );
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        return list;
    }

    @Override
    public List<T> getRecordAfter(Date time, Object... keyValeu) {

        List<T> list = new ArrayList<>();

        BasicDBObject criteria = new BasicDBObject("time",new BasicDBObject("$gte",time));
        if (keyValeu.length%2 ==1)
        {
            return null;
        }
        for (int i=0; i<keyValeu.length;i+=2){
            criteria.append((String) keyValeu[i],keyValeu[i+1]);
        }



        DBCursor cursor = collection.find(criteria).sort(new BasicDBObject("time",1).append("_id",1));

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

    @Override
    public List<T> getNRecordAfter(int number, Date time, Object... keyValeu) {

        List<T> list = new ArrayList<>();

        BasicDBObject criteria = new BasicDBObject("time",new BasicDBObject("$gte",time));


        if (keyValeu.length%2 ==1)
        {
            return null;
        }
        for (int i=0; i<keyValeu.length;i+=2){
            criteria.append((String) keyValeu[i],keyValeu[i+1]);
        }



        DBCursor cursor = collection.find(criteria).limit(number).sort(new BasicDBObject("time", 1).append("_id", 1));


        if (cursor.count()<number)
        {
            for(int i=0;i<number-cursor.count();i++){
                list.add(null);
            }

        }

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

    @Override
    public List<T> getNRecordBefore(int number, Date time, Object... keyValeu) {

        List<T> list = new ArrayList<>();

        BasicDBObject criteria = new BasicDBObject("time",new BasicDBObject("$lte",time));

        if (keyValeu.length%2 ==1)
        {
            return null;
        }
        for (int i=0; i<keyValeu.length;i+=2){
            criteria.append((String) keyValeu[i],keyValeu[i+1]);
        }

        DBCursor cursor = collection.find(criteria).limit(number).sort(new BasicDBObject("time", 1).append("_id", 1));

        if (cursor.count()<number)
        {
            for(int i=0;i<number-cursor.count();i++){
                list.add(null);
            }

        }

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



}
