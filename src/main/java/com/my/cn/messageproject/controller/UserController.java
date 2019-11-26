package com.my.cn.messageproject.controller;

import com.my.cn.messageproject.pojo.Result;
import com.my.cn.messageproject.pojo.StatusCode;
import com.my.cn.messageproject.pojo.User;
import com.my.cn.messageproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /*** 发送短信验证码 * @param mobile
     * @return*/
    @RequestMapping(value = "/sendsms/{mobile}", method = RequestMethod.POST,consumes = "application/json")
    public Result<String> sendsms(@PathVariable String mobile) {
        System.out.println("进入UserController.sendsms发送短息:啊哈哈哈哈哈哈哈哈哈或或或！！！！");
        userService.sendSms(mobile);
        return new Result<String>(true, StatusCode.OK, "发送成功");
    }

    /*** 用户注册 * @param user */
    @RequestMapping(value = "/register/{code}", method = RequestMethod.POST)
    public Result register(@RequestBody User user,
                           @PathVariable String code) {
        userService.add(user, code);
        return new Result(true, StatusCode.OK, "注册成功");
    }
}
