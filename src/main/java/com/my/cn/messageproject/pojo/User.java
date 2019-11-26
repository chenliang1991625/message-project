package com.my.cn.messageproject.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

/*
* 另外@Data注解的作用相当于 @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode的合集。
  另外@Log 省去了在LombokTest中添加 getLogger的如下代码：
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)//使用lombok自动生成链式调用,比如new User().get().set()
@Entity //声明实体类
@Table(name="user") //建立实体类和表的映射关系
public class User {
    @Id//声明当前私有属性为主键
//    @GeneratedValue(strategy= GenerationType.IDENTITY) //配置主键的生成策略 //由IdWorker.idWorker.nextId()生成，不用自增
    @Column(name="uid") //指定和表中cust_id字段的映射关系
    private Integer uid;
    private String userName;
    private String password;
    private String mobile;

}
