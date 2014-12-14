package cn.edu.seu.eye.core.common;

/**
 * Hello world!
 *
 */


import java.io.IOException;//用于发短信

import org.apache.commons.httpclient.HttpException;//用于发短信

public class App
{

    private static String PHONE = "13655175392";
    private static String PWD = "dl871213";
    private static String TO = "15150423480";
    private static String MSG = "你好：Hello World!";
    public static void main( String[] args ) throws HttpException, IOException
    {
        System.out.println( "Hello World!" );
        System.out.println("This is a try ");

//        String smtp = "smtp.qq.com";// smtp服务器
//        String from = "2689583045@qq.com";// 邮件显示名称
//        String to = "dinglei871213@sina.com";// 收件人的邮件地址，必须是真实地址
////        String copyto = "";// 抄送人邮件地址
//        String subject = "测试邮件";// 邮件标题
//        String content = "你好！哈哈！";// 邮件内容           10
//        String username = "2689583045";// 发件人真实的账户名
//        String password = "dl13655175392";// 发件人密码
//
//        Mail.send(smtp, from, to, subject, content, username, password);


       Fetion.sendMsg(PHONE, PWD, TO, MSG);
        }

    }


