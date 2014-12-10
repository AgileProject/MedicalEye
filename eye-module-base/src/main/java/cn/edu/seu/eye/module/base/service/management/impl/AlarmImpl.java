package cn.edu.seu.eye.module.base.service.management.impl;

import cn.edu.seu.eye.module.base.dao.management.IAlarmDao;
import cn.edu.seu.eye.module.base.entity.management.Alarm;
import cn.edu.seu.eye.module.base.resource.AbstractService;
import cn.edu.seu.eye.module.base.service.management.IAlarm;
import com.iron.fast.repository.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by DL on 2014/12/7.
 */
@Service
public class AlarmImpl extends AbstractService<Alarm> implements IAlarm{

    @Autowired
    private IAlarmDao alarmDao;

    @Override
    public IDao<Alarm> getIDao() {
        return alarmDao;
    }
}