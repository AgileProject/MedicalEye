package cn.edu.seu.eye.module.base.service.management;

/**
 * Created by DL on 2014/12/10.
 */
import cn.edu.seu.eye.module.base.entity.management.Alarmindex;
import cn.edu.seu.eye.module.base.resource.IService;

import java.util.List;

public interface IAlarmindex extends IService<Alarmindex> {


    void updateAlarmindex(List<Alarmindex> alarmindex);
}
