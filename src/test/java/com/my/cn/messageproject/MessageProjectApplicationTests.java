package com.my.cn.messageproject;

import com.my.cn.messageproject.pojo.User;
import com.my.cn.messageproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class MessageProjectApplicationTests {
    @Autowired
    UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
    }
//    redis test
   /*@Test
    public void redisTest(){
        redisTemplate.opsForValue().set("chenlaing", 5);
        Object o = redisTemplate.opsForValue().get("chenlaing");
        System.out.println("value="+o.toString());
    }*/
    /*@Test
    void redisGet(){
    Object v = redisTemplate.opsForValue().get("smscode_15096566185");
        System.out.println("存入的值="+v.toString());

    }*/
    @Test
    void testUserServiceAdd(){
        User user = new User();
//        user.setUid(1);
        user.setPassword("1234567");
        user.setUserName("我123");
        user.setMobile("15096566185");
        userService.add(user,"407861");
    }
}
