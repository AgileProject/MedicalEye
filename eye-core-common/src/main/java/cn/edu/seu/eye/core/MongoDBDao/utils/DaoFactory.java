package cn.edu.seu.eye.core.MongoDBDao.utils;

import cn.edu.seu.eye.core.MongoDBDao.dao.IDao;
import cn.edu.seu.eye.core.MongoDBDao.dao.impl.AbstractDao;
import cn.edu.seu.eye.core.MongoDBDao.entity.Computer;

import java.lang.reflect.Constructor;

/**
 * Created by Administrator on 14-12-2.
 */
public class DaoFactory {
    public static IDao getInstance(String entityName,String dbName,String address,int port){

        Class clazz = null;
        Constructor constructor = null;
        IDao iDao = null;

        String classPath = (new AbstractDao<Computer>()).getClass().getName();
        classPath = classPath.substring(0,classPath.length()-11);
        entityName = entityName.substring(0,1).toUpperCase()+entityName.substring(1);
        String className = classPath+entityName+"DaoImpl";

        try {
            clazz = Class.forName(className);
            constructor = clazz.getConstructor(String.class,String.class,String.class,int.class);
            iDao = (IDao)constructor.newInstance(entityName,dbName,address,port);
        }catch (Exception e){
            e.printStackTrace();
        }

        return iDao;
    }

}
