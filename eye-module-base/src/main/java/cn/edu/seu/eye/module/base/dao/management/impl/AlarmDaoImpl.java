package cn.edu.seu.eye.module.base.dao.management.impl;

import cn.edu.seu.eye.module.base.dao.management.IAlarmDao;
import cn.edu.seu.eye.module.base.entity.management.Alarm;
import com.iron.fast.beans.Criteria;
import com.iron.fast.repository.AbstractDao;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by DL on 2014/12/7.
 */
@Repository
public class AlarmDaoImpl extends AbstractDao<Alarm> implements IAlarmDao {

    @Override
    public List<Alarm> getAlarmList() {
        String sql = "SELECT * FROM SYS_USER";
        return getList(sql, new Criteria());
    }
}
