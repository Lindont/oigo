package com.aos.oigo.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private int id;//用户信息表主键
    private String username;//用户名,唯一
    private String password;//密码
    private String salt;//盐 :辅助MD5加密
    private String head;//头像地址
    private String nickname;//昵称
    private int age;//年龄
    private int sex;//性别: 0女  1男
    private Date birthday;//生日
    private int phone;//手机号
    private String email;//邮箱
    private int locked;//账号是否被锁定
}
