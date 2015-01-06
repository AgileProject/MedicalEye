package cn.edu.seu.eye.core.data_transform;

/**
 * Created by acer-pc on 2014/12/7.
 */
public class DataTransform {
    public static void main(String[] args){
        GetMongoDBData getMongoDBData = new GetMongoDBData();
        //初始化COMPUTER表和ALARMINDEX表，解决外键冲突。
        getMongoDBData.initComData();
        //从Mongodb获取数据并插入SQL Server.
        getMongoDBData.getMongoDBData();
    }
}
