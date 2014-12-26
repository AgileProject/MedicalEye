package cn.edu.seu.eye.module.base.resource.management;

/**
 * Created by DL on 2014/12/7.
 */
import cn.edu.seu.eye.module.base.annotation.WithoutAuthentication;
import cn.edu.seu.eye.module.base.entity.management.Alarm;
import cn.edu.seu.eye.module.base.presentation.Result;
import cn.edu.seu.eye.module.base.resource.BaseResource;
import cn.edu.seu.eye.module.base.service.management.IAlarm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/system/alarms")
@RestController
public class AlarmsResource extends BaseResource {

    @Autowired
    private IAlarm sysAlarmService;

    @RequestMapping
    @WithoutAuthentication
    public Result getAllAlarm(HttpServletRequest request) {
        List<Alarm> alarms = sysAlarmService.getList(buildCriteria(request, Alarm.All_FIELDS));
        Collections.reverse(alarms);
        Result result = new Result(alarms);
        return result;
    }
}