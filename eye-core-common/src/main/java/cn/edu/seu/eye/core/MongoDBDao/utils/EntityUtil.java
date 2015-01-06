package cn.edu.seu.eye.core.MongoDBDao.utils;

import com.mongodb.BasicDBObject;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;


/**
 * Created by Administrator on 14-11-29.
 */
public class EntityUtil {
    public static <T> BasicDBObject entityToBasicDBObject(T entity) throws IllegalArgumentException,IllegalAccessException{

        if(entity == null)
        {
            return null;
        }

        BasicDBObject basicDBObject = new BasicDBObject();
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields){
            String varName = field.getName();
            boolean accessFlag = field.isAccessible();
            if(!accessFlag){
                field.setAccessible(true);
            }
            Object param = field.get(entity);
            field.setAccessible(accessFlag);
            if(param == null)
            {
                continue;
            }else if(param instanceof  Integer){
                int value = ((Integer) param).intValue();
                basicDBObject.put(varName,value);
            }else if (param instanceof String){
                String value = (String) param;
                basicDBObject.put(varName,value);
            }else if (param instanceof Double){
                double value = ((Double) param).doubleValue();
                basicDBObject.put(varName,value);
            }else if (param instanceof Float){
                float value = ((Float) param).floatValue();
                basicDBObject.put(varName,value);
            }else if (param instanceof Long){
                long value = ((Long) param).longValue();
                basicDBObject.put(varName,value);
            }else if (param instanceof  Boolean){
                boolean value = ((Boolean) param).booleanValue();
                basicDBObject.put(varName,value);
            }else if (param instanceof Date){
                Date value = (Date) param;
                basicDBObject.put(varName,value);
            }


        }
return basicDBObject;
        }

public static <T> T basicDBObjectToEntity(BasicDBObject basicDBObject,T entity) throws IllegalAccessException,
        InvocationTargetException,NoSuchMethodException{
        if(basicDBObject == null)
        {
        return null;
        }
        Field[] fields = entity.getClass().getDeclaredFields();
        for(Field field : fields){
        String varName = field.getName();
        Object object = basicDBObject.get(varName);
        if(object != null)
        {
        BeanUtils.setProperty(entity,varName,object);
        }
        }
        return entity;
        }
        }
