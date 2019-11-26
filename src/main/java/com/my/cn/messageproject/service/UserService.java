package com.my.cn.messageproject.service;

import com.my.cn.messageproject.dao.UserDao;
import com.my.cn.messageproject.pojo.User;
import com.my.cn.messageproject.utils.idWork.IdWorker;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/*发送短息的服务*/
@Service
public class UserService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private UserDao userDao;

    /*** 发送短信验证码 * @param mobile 手机号 */
    public void sendSms(String mobile) {
//1.生成6位短信验证码
        Random random = new Random();
        int max = 999999;//最大数
        int min = 100000;//最小数
        int code = random.nextInt(max);
//随机生成 if(code<min){
        code = code + min;
        System.out.println(mobile + "收到验证码是：" + code);
        //2.将验证码放入redis
        redisTemplate.opsForValue().set("smscode_"+mobile, code+"", 10, TimeUnit.MINUTES);
//五分钟过期 //3.将验证码和手机号发动到rabbitMQ中
        Map<String, String> map = new HashMap();
        map.put("mobile", mobile);
        map.put("code", code + "");
        System.out.println(map.toString());
        rabbitTemplate.convertAndSend("sms", map);
    }

    /*** 增加 * @param user 用户 * @param code 用户填写的验证码 */
    public void add(User user, String code) {
//判断验证码是否正确
        String syscode =(String) redisTemplate.opsForValue().get("smscode_"+ user.getMobile()); //提取系统正确的验证码
            if (syscode == null) {
                throw new RuntimeException("请点击获取短信验证码:" + syscode);
            }
            if (!syscode.equals(code)) {
                throw new RuntimeException("验证码输入不正确");
            }
            user.setUid((int) idWorker.nextId());
//        user.setUid(1223);
//最后登陆日期
            userDao.save(user);
        }
    }
