package cn.edu.seu.eye.module.base.service.management;

import cn.edu.seu.eye.module.base.entity.management.Alarm;
import cn.edu.seu.eye.module.base.resource.IService;
import org.apache.commons.httpclient.HttpException;

import java.io.IOException;

/**
 * Created by DL on 2014/12/7.
 */
public interface IAlarm extends IService<Alarm>{
    public void sendAlarm();
}
