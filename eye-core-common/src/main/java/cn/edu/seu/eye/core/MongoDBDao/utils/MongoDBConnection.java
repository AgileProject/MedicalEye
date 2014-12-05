package cn.edu.seu.eye.core.MongoDBDao.utils;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;


/**
 * Created by Administrator on 14-11-28.
 */
public class MongoDBConnection {

    private String mongo_db_address = "ee-lab";
    private int mongo_db_port = 27017;
    private String mongo_db_dbname = "mydb";

    private MongoClient mongoClient = null;
    private DB db = null;
    private DBCollection collection= null;

    public MongoDBConnection(String mongo_db_address,int mongo_db_port,String mongo_db_dbname) {

        this.mongo_db_address = mongo_db_address;
        this.mongo_db_port =mongo_db_port;
        this.mongo_db_dbname = mongo_db_dbname;

        try {
            this.mongoClient = new MongoClient(mongo_db_address,mongo_db_port);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public MongoClient getMongoClient(){
        if(mongoClient ==null){
            try {
                mongoClient = new MongoClient(mongo_db_address,mongo_db_port);
            }catch(UnknownHostException e){
                e.printStackTrace();
            }
        }
        return mongoClient;
    }

    public  DB getDB(){
        if (db == null)
        {
            if (mongoClient == null)
            {
                getMongoClient();
            }

            db = mongoClient.getDB(mongo_db_dbname);

        }
        return db;
    }

    public DBCollection getCollection(String collectionName){
        if (collection == null)
        {
            if (db == null)
            {
                getDB();
            }
            collection = db.getCollection(collectionName);
        }
        return collection;
    }



}
