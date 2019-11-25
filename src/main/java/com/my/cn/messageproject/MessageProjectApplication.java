package com.my.cn.messageproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication/*(exclude= {DataSourceAutoConfiguration.class})*/
@ComponentScan(basePackages = "com.my.cn")
public class MessageProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageProjectApplication.class, args);
    }

}
