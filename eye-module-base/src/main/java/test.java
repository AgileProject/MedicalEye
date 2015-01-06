import cn.edu.seu.eye.module.base.service.management.IAlarm;
import cn.edu.seu.eye.module.base.service.management.impl.AlarmImpl;

/**
 * Created by DL on 2015/1/6.
 */
public class test {


     public void testAlarm(){
         IAlarm alarm =new AlarmImpl();
         alarm.sendAlarm();
     }
    public static void main(String[] args){
        test t  = new test();
        t.testAlarm();
    }

}
