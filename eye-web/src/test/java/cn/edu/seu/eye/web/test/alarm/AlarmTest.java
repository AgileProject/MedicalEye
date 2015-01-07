package cn.edu.seu.eye.web.test.alarm;

import cn.edu.seu.eye.module.base.entity.management.User;
import cn.edu.seu.eye.module.base.service.management.IUser;
import cn.edu.seu.eye.web.test.BaseTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Jacky on 2015/1/7.
 */
public class AlarmTest extends BaseTestCase {

    @Autowired
    IUser user;

    @Test
    public void testAlarm(){
        user.updateUser(new User());
    }
}
