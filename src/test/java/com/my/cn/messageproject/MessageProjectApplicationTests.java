package com.my.cn.messageproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class MessageProjectApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
    }
//    redis test
   @Test
    public void redisTest(){
        redisTemplate.opsForValue().set("chenlaing", 5);
        Object o = redisTemplate.opsForValue().get("chenlaing");
        System.out.println("value="+o.toString());
    }
   /* @Test
    void redisGet(){
        Integer v = (Integer) redisTemplate.opsForValue().get("a");
        System.out.println("存入的值="+v);

    }*/
}
