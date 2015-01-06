package cn.edu.seu.eye.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.seu.eye.module.base.service.management.IAlarm;
import cn.edu.seu.eye.module.base.service.management.impl.AlarmImpl;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.io.IOException;

public class MyServlet extends HttpServlet {
//    private IAlarm alarm;
    private java.util.Timer timer;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init() throws ServletException {

        timer = new Timer(true);
        // TODO Auto-generated method stub
        super.init();

        timer.schedule(
                new java.util.TimerTask() {
                    public void run() {
                        //todo
//                        System.out.println("自动加载启动.");
//                            alarm.sendAlarm();
                    }
                }, 0, 10 * 1000);//10秒钟执行一次


//        System.out.println("自动加载启动.");
//        System.out.println("自动加载启动.");
//        for(int i = 0; i < 10; i++){
//
//            System.out.println(i + "、 自动加载启动.");
//        }


    }
}
