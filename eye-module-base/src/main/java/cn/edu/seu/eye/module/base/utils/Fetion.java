package cn.edu.seu.eye.module.base.utils;

/**
 * Created by DL on 2014/12/14.
 */

        import java.io.IOException;
        import org.apache.commons.httpclient.Header;
        import org.apache.commons.httpclient.HttpClient;
        import org.apache.commons.httpclient.HttpException;
        import org.apache.commons.httpclient.NameValuePair;
        import org.apache.commons.httpclient.methods.PostMethod;

/**
 * API2.1调用:f.php?phone=xxxxxx&pwd=xxx&to=xxxx&msg=xxxx&type=0
 *以上接口参数详细说明 VIP API
 *1.phone:手机号
 *2.pwd:飞信密码
 *3.to:发送给谁(手机号或飞信号)
 *4.msg:飞信内容
 *5.type:操作 0(空)发送短信 1检查好友 2添加好友
 *6.u:备用参数:当发送内容为乱码时 在最后加上&u=1
 */
public class Fetion {

    public static void sendMsg(String _phone,String _pwd,String _to,String _msg) {
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://3.ibtf.sinaapp.com/f.php");
        post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");//在头文件中设置转码
        NameValuePair[] data ={
                new NameValuePair("phone", _phone),
                new NameValuePair("pwd", _pwd),
                new NameValuePair("to",_to),
                new NameValuePair("msg",_msg),
                new NameValuePair("type","0")
        };
        post.setRequestBody(data);

        try {
            client.executeMethod(post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:"+statusCode);
        for(Header h : headers){
            System.out.println(h.toString());
        }
        //String result = new String(post.getResponseBodyAsString().getBytes("utf-8"));
        //System.out.println(result);
        System.out.println("ok!");
        post.releaseConnection();
    }
}
