package com.aos.oigo.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable
{
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

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getSalt()
    {
        return salt;
    }

    public void setSalt(String salt)
    {
        this.salt = salt;
    }

    public String getHead()
    {
        return head;
    }

    public void setHead(String head)
    {
        this.head = head;
    }

    public String getNickname()
    {
        return nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public int getSex()
    {
        return sex;
    }

    public void setSex(int sex)
    {
        this.sex = sex;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public int getPhone()
    {
        return phone;
    }

    public void setPhone(int phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getLocked()
    {
        return locked;
    }

    public void setLocked(int locked)
    {
        this.locked = locked;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", head='" + head + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", locked=" + locked +
                '}';
    }
}
