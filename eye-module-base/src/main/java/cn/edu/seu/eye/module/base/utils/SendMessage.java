package cn.edu.seu.eye.module.base.utils;


import java.io.IOException;//用于发短信

import org.apache.commons.httpclient.HttpException;//用于发短信

public class SendMessage {
    private  String PHONE = "13655175392";
    private  String PWD = "dl871213";
    private  String TO;
    private  String MSG;
//    private  String TO = "15150423480";
//    private  String MSG = "你好：Hello World!";

    public SendMessage( String TO , String MSG){
        this.TO=TO;
        this.MSG=MSG;
    }

    public void sendMsg() {
        Fetion.sendMsg(PHONE, PWD, TO, MSG);
    }
}
