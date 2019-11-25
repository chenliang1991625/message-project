package com.my.cn.messageproject.dao;

import com.my.cn.messageproject.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

@Component
//@Repository
public interface UserDao  extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

//    public User save(User user);
}
