package com.my.cn.messageproject.utils.sentMseeageUtil;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/*** 短信监听类 */
//@Service
@Component
@RabbitListener(queues = "sms")
public class SmsListener {
    /*** 发送短信 * @param message */
    @Autowired
    SentMessageUtil sentMessageUtil;
    @Value("aliyun.sms.template_code")
    private String template_code;//模板编号
    @Value("aliyun.sms.sign_name")
    private String sign_name;//签名

    @RabbitHandler
    public void sendSms(Map<String, String> messageMap) {
        System.out.println("手机号：" +  messageMap.get("mobile"));
        System.out.println("验证码：" +  messageMap.get("code"));
        try {
            sentMessageUtil.sendSms( messageMap.get("mobile"), template_code, sign_name, " {\"code_number\":\"" +  messageMap.get("code") + "\"}");
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}