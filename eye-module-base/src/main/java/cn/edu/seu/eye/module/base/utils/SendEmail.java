package cn.edu.seu.eye.module.base.utils;


public class SendEmail {
    private String to;// 收件人的邮件地址，必须是真实地址
    private String content;// 邮件内容


    private String smtp = "smtp.qq.com";// smtp服务器
    private String from = "2689583045@qq.com";// 邮件显示名称
//        String to = "dinglei871213@sina.com";// 收件人的邮件地址，必须是真实地址
//        String copyto = "";// 抄送人邮件地址
    private String subject = "监控报警";// 邮件标题
//        String content = "你好！哈哈！";// 邮件内容           10
    private String username = "2689583045";// 发件人真实的账户名
    private String password = "dl13655175392";// 发件人密码


    //构造函数
    public SendEmail(String to, String content) {
        this.to = to;
        this.content = content;
    }


    public void sendEml() {
        Mail.send(smtp, from, to, subject, content, username, password);
    }

}
