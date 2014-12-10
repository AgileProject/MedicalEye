package cn.edu.seu.eye.module.base.dao.management.impl;

import cn.edu.seu.eye.module.base.dao.management.IAlarmDao;
import cn.edu.seu.eye.module.base.entity.management.Alarm;
import com.iron.fast.repository.AbstractDao;
import org.springframework.stereotype.Repository;
/**
 * Created by DL on 2014/12/7.
 */
@Repository
public class AlarmDaoImpl extends AbstractDao<Alarm> implements IAlarmDao {
}
