package cn.edu.seu.eye.module.base.service.management.impl;

import cn.edu.seu.eye.module.base.dao.management.IAlarmDao;
import cn.edu.seu.eye.module.base.dao.management.impl.AlarmDaoImpl;
import cn.edu.seu.eye.module.base.dao.management.impl.UserDaoImpl;
import cn.edu.seu.eye.module.base.entity.management.Alarm;
import cn.edu.seu.eye.module.base.dao.management.IUserDao;
import cn.edu.seu.eye.module.base.entity.management.User;
import cn.edu.seu.eye.module.base.resource.AbstractService;
import cn.edu.seu.eye.module.base.service.management.IAlarm;
import com.iron.fast.repository.IDao;
import org.apache.commons.httpclient.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.seu.eye.module.base.utils.SendMessage;
import cn.edu.seu.eye.module.base.utils.SendEmail;
import java.text.SimpleDateFormat;


import java.util.List;

/**
 * Created by DL on 2014/12/7.
 */
@Service
public class AlarmImpl extends AbstractService<Alarm> implements IAlarm{

    @Autowired
    private IAlarmDao alarmDao;
    @Autowired
    private IUserDao userDao;

    private static int alarmNum=0;
    @Override
    public IDao<Alarm> getIDao() {
        return alarmDao;
    }



    @Override
    public void sendAlarm() {
        List<Alarm> alarms = alarmDao.getAlarmList();
        List<User> users = userDao.getUserList();
        if (alarms.size()>alarmNum){
            for(int i=alarmNum;i<alarms.size();i++){
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String str = df.format(alarms.get(alarmNum).getAlarmTime());
                String alarmMsg= str+alarms.get(alarmNum).getAlarmMessage();
                if(users.get(0).isSendEmail()) {
                    SendEmail sendEmail = new SendEmail(users.get(0).getEmail(), alarmMsg);
                    sendEmail.sendEml();
                }
                if(users.get(0).isSendMessage()) {
                    SendMessage sendMessage = new SendMessage(users.get(0).getTelephone(), alarmMsg);
                        sendMessage.sendMsg();

                }

            }
            alarmNum=alarms.size();
        }
    }
//    @Override
//    public IDao<User> getIDao() {
//        return userDao;
//    }






}