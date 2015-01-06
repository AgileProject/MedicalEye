package cn.edu.seu.eye.module.base.dao.management;

import cn.edu.seu.eye.module.base.entity.management.Alarm;
import com.iron.fast.repository.IDao;

import java.util.List;

/**
 * Created by DL on 2014/12/7.
 */
public interface IAlarmDao extends IDao<Alarm>{
    public List<Alarm> getAlarmList();
}
