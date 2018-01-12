package com.aos.oigo.weixin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aos.oigo.utils.HttpUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2017-10-11
 */
public class WeixinTag {
    /**
     * 创建标签
     */
    @Test
    public void createTag() {
        String AccessToken = "sDI6WCfucy20OE8TwhubgJMFKLwgYMrPGYSjDKbzaQqqMBdvOjFt1gvyxvJ1lPei-AoEZggapvYyry6ktsZu88FE0DEBM9gVi0o-efFwCL_nPyopChtexeWnplIzvqcZRWF78u11YsM97L6cgAuRZ0HoRpkP3uMECTq21EgwNXhygjYaO6hEadHpQjqgYPtG9zZmbqAFGQS4v9dOds2EOw";
        String url = "https://qyapi.weixin.qq.com/cgi-bin/tag/create?access_token=" + AccessToken;

        Map<String, String> mapHeaders = new HashMap<String, String>();
        mapHeaders.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tagname", "test");
        jsonObject.put("tagid", "900000");

        String str = HttpUtils.getResultEntity(url, mapHeaders, jsonObject, HttpUtils.POST);

        JSONObject jo = JSON.parseObject(str);
        String errcode = jo.getString("errcode");
        System.out.println(errcode);
        String errmsg = jo.getString("errmsg");
        System.out.println(errmsg);
        String tagid = jo.getString("tagid");
        System.out.println(tagid);
    }

    /**
     * 修改标签名字
     */
    @Test
    public void changeTagName() {
        String AccessToken = "zYxC0XgjZBFCQdPQ3Aj8UWEu_heC4Lkk0bhc6u6nyVJBDrIIsOilAnUAd7iMwPQqa3J0SLEX8pROPKMI9KRaKg_6_Hn7XxTO3YDGfRwFRZyDX2lTKahKrUHcGLxdeF5K5hM2T8BJPKLX_C5QztaKolVkIcrEaWM1RFU-XHNVrY_jmdm-sKSDflOi8O6WWADjo1abMCkEqeg4ATiJOmjMCA";
        String url = "https://qyapi.weixin.qq.com/cgi-bin/tag/update?access_token=" + AccessToken;

        Map<String, String> mapHeaders = new HashMap<String, String>();
        mapHeaders.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tagid", "900001");
        jsonObject.put("tagname", "Daily");

        String str = HttpUtils.getResultEntity(url, mapHeaders, jsonObject, HttpUtils.POST);

        JSONObject jo = JSON.parseObject(str);
        String errcode = jo.getString("errcode");
        System.out.println(errcode);
        String errmsg = jo.getString("errmsg");
        System.out.println(errmsg);
    }

    /**
     * 增加标签成员
     */
    @Test
    public void addTagUsers() {
        String AccessToken = "jad5zHyC0QEmNErBi99LW8wCFPi6jz7kgtxGkZwBypJrmr_WhKe0m5fXrlUy6hCVI9cAPai007iZSL6rwvgNkm7jJq6pHc5-1JKw_iLhkV5fexjZ3Ql29f-B1BerH4ey15MaTqhJViMSCTTVKQAIEalg_nxGSbwXprGOFAhq6HaJzoRm-5wvDyAO_Jo6EbdgdUEVv-j45FLoz5jnJcJZhg";
        String url = "https://qyapi.weixin.qq.com/cgi-bin/tag/addtagusers?access_token=" + AccessToken;

        Map<String, String> mapHeaders = new HashMap<String, String>();
        mapHeaders.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        List<String> user = new ArrayList<>();
        user.add("LongFuQuan");


        System.out.println(user);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tagid", "900001");
        jsonObject.put("userlist", user);

        String str = HttpUtils.getResultEntity(url, mapHeaders, jsonObject, HttpUtils.POST);

        JSONObject jo = JSON.parseObject(str);
        String errcode = jo.getString("errcode");
        System.out.println(errcode);
        String errmsg = jo.getString("errmsg");
        System.out.println(errmsg);
    }

    /**
     * 删除标签成员
     */
    @Test
    public void deleteTagUsers() {
        String AccessToken = "cI28pQZ338gbbtf0tTaD0npp84hS1rQSYLf7gSwjyj9Z0Gtx25C9ogXebHWAYEN3gM4g8VVyfQpNzR4QkaRrUmk8bexqMwJ-x8TxcxPFRjh8o9QpDYQ-4ic51XD37hnNr9opgyfCSxD4ZInkIglTqM4YVt1x58YaaaQbA7OY_aoN-tN5jXtf1gnX81wVZaPrAFBocJpKPH6GO6dk56ivLQ";
        String url = "https://qyapi.weixin.qq.com/cgi-bin/tag/deltagusers?access_token=" + AccessToken;

        Map<String, String> mapHeaders = new HashMap<String, String>();
        mapHeaders.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        List<String> users = new ArrayList<String>();
        users.add("WangZhenGang");
        users.add("liuchenglong");
        users.add("Chenyuanyuan");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tagid", "900001");
        jsonObject.put("userlist", users);

        String str = HttpUtils.getResultEntity(url, mapHeaders, jsonObject, HttpUtils.POST);
        JSONObject jo = JSON.parseObject(str);
        String errcode = jo.getString("errcode");
        System.out.println(errcode);
        String errmsg = jo.getString("errmsg");
        System.out.println(errmsg);
    }

    /**
     * 获取标签成员
     */
    @Test
    public void getTagUsers() {
        String AccessToken = "cI28pQZ338gbbtf0tTaD0npp84hS1rQSYLf7gSwjyj9Z0Gtx25C9ogXebHWAYEN3gM4g8VVyfQpNzR4QkaRrUmk8bexqMwJ-x8TxcxPFRjh8o9QpDYQ-4ic51XD37hnNr9opgyfCSxD4ZInkIglTqM4YVt1x58YaaaQbA7OY_aoN-tN5jXtf1gnX81wVZaPrAFBocJpKPH6GO6dk56ivLQ";
        String url = "https://qyapi.weixin.qq.com/cgi-bin/tag/get?access_token=" + AccessToken + "&tagid=900001";

        Map<String, String> mapHeaders = new HashMap<>();
        mapHeaders.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        String str = HttpUtils.getResultEntity(url, mapHeaders, null, HttpUtils.GET);

        System.out.println(str);

    }
}
