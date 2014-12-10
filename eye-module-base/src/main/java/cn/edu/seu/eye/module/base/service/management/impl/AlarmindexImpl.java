package cn.edu.seu.eye.module.base.service.management.impl;

/**
 * Created by DL on 2014/12/10.
 */

import cn.edu.seu.eye.module.base.dao.management.IAlarmindexDao;
import cn.edu.seu.eye.module.base.entity.management.Alarmindex;
import cn.edu.seu.eye.module.base.resource.AbstractService;
import cn.edu.seu.eye.module.base.service.management.IAlarmindex;
import com.iron.fast.repository.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlarmindexImpl extends AbstractService<Alarmindex> implements IAlarmindex{

    @Autowired
    private IAlarmindexDao alarmindexDao;

    @Override
    public IDao<Alarmindex> getIDao() {
        return alarmindexDao;
    }
}
