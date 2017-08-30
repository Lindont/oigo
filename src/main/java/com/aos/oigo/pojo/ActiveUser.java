package com.aos.oigo.pojo;

import java.io.Serializable;

public class ActiveUser implements Serializable
{
    private int id;//用户ID
    private String username;//用户名
    private String nickname;//用户昵称

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

    public String getNickname()
    {
        return nickname;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }
}
