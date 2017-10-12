package com.aos.oigo.weixin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aos.oigo.utils.HttpUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2017-10-12
 */
public class GetUsers
{
    @Test
    public void getUsers()
    {
        String AccessToken = "cI28pQZ338gbbtf0tTaD0npp84hS1rQSYLf7gSwjyj9Z0Gtx25C9ogXebHWAYEN3gM4g8VVyfQpNzR4QkaRrUmk8bexqMwJ-x8TxcxPFRjh8o9QpDYQ-4ic51XD37hnNr9opgyfCSxD4ZInkIglTqM4YVt1x58YaaaQbA7OY_aoN-tN5jXtf1gnX81wVZaPrAFBocJpKPH6GO6dk56ivLQ";
        String url = "https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?access_token="+AccessToken+"&department_id="+1+"&fetch_child="+1;

        Map<String ,String> mapHeaders = new HashMap<String,String>();
        mapHeaders.put("Content-Type","application/x-www-form-urlencoded;charset=utf-8");


        String str = HttpUtils.getResultEntity(url,mapHeaders,null,HttpUtils.GET);

        JSONObject jo = JSON.parseObject(str);
        String errcode = jo.getString("errcode");
        System.out.println(errcode);
        String errmsg = jo.getString("errmsg");
        System.out.println(errmsg);
        List lists = jo.getJSONArray("userlist");


        //lists.forEach(o -> System.out.println(o));

        //System.out.println("");


        for (int i=0 ; i<lists.size() ; i++)
        {
            System.out.println(lists.get(i));
            String sss = lists.get(i).toString();
            JSONObject jsn = JSON.parseObject(sss);
            String name = jsn.getString("name");
            System.out.println(name);
            String userid = jsn.getString("userid");
            System.out.println(userid);
        }

    }
}
