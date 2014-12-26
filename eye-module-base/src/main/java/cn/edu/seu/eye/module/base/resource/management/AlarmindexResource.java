package cn.edu.seu.eye.module.base.resource.management;

/**
 * Created by DL on 2014/12/10.
 */

import cn.edu.seu.eye.module.base.annotation.WithoutAuthentication;
import cn.edu.seu.eye.module.base.entity.management.Alarm;
import cn.edu.seu.eye.module.base.entity.management.Alarmindex;
import cn.edu.seu.eye.module.base.presentation.Result;
import cn.edu.seu.eye.module.base.resource.BaseResource;
import cn.edu.seu.eye.module.base.service.management.IAlarmindex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/system/alarmindexs")
@RestController
public class AlarmindexResource extends BaseResource {

    @Autowired
    private IAlarmindex sysAlarmindexService;


    @RequestMapping
    @WithoutAuthentication
    public Result getAllAlarmindex(HttpServletRequest request) {
        List<Alarmindex> alarmindexs = sysAlarmindexService.getList(buildCriteria(request, Alarmindex.All_FIELDS));
        Result result = new Result(alarmindexs);
        return result;
    }

    /**
     * 更新用户
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody List<Alarmindex> alarmindexs) {
        sysAlarmindexService.updateAlarmindex(alarmindexs);
    }

}
