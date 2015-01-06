package cn.edu.seu.eye.core.MongoDBDao.exception;

/**
 * Created by Administrator on 14-12-5.
 */
public class KeyValueUnpairException extends Exception{

    protected String message ="键值对不匹配:";
    public KeyValueUnpairException(String message){
        this.message = this.message+message;
    }

    @Override
    public void printStackTrace() {
        System.out.println(message);
    }
}
