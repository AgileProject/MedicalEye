package cn.edu.seu.eye.core.MongoDBDao.utils;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;


/**
 * Created by Administrator on 14-11-28.
 */
public class MongoDBConnection {

    private static MongoClient mongoClient = null;
    private static DB db = null;
    private static DBCollection collection= null;

    private static  String MONGODB_DB_ADDRESS = "ee-lab";
    private static  int MONGO_DB_PORT = 27017;

    public static String getMONGODB_DB_ADDRESS() {
        return MONGODB_DB_ADDRESS;
    }

    public static void setMONGODB_DB_ADDRESS(String MONGODB_DB_ADDRESS) {
        MongoDBConnection.MONGODB_DB_ADDRESS = MONGODB_DB_ADDRESS;
    }

    public static int getMONGO_DB_PORT() {
        return MONGO_DB_PORT;
    }

    public static void setMONGO_DB_PORT(int MONGO_DB_PORT) {
        MongoDBConnection.MONGO_DB_PORT = MONGO_DB_PORT;
    }

    public static String getMONGO_DB_DBNAME() {
        return MONGO_DB_DBNAME;
    }

    public static void setMONGO_DB_DBNAME(String MONGO_DB_DBNAME) {
        MongoDBConnection.MONGO_DB_DBNAME = MONGO_DB_DBNAME;
    }

    private static String MONGO_DB_PASSWORD = "root";
    private static String MONGO_DB_DBNAME = "mydb";

    static{
        try {
            mongoClient = new MongoClient(MONGODB_DB_ADDRESS,MONGO_DB_PORT);
        }catch(UnknownHostException e){
            e.printStackTrace();
        }
    }

    public static MongoClient getMongoClient(){
        if(mongoClient ==null){
            try {
                mongoClient = new MongoClient(MONGODB_DB_ADDRESS,MONGO_DB_PORT);
            }catch(UnknownHostException e){
                e.printStackTrace();
            }
        }
        return mongoClient;
    }

    public static DB getDB(){
        if (db == null)
        {
            if (mongoClient == null)
            {
                getMongoClient();
            }
            db = mongoClient.getDB(MONGO_DB_DBNAME);

        }
        return db;
    }

    public static DBCollection getCollection(String collectionName){
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
