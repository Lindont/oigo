package com.aos.oigo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : HuangHaoXin
 * @Description :测试解析JSON数据
 * @Date : Create in 2017-08-28
 */
public class JsonTest
{

    @Test
    public void testJson()
    {
        String data = "{\"username\":\"HuangHX\",\"password\":\"123456\"}";
        JSONObject jo = JSON.parseObject(data);
        String result = jo.getString("password");
        System.out.println(result);
    }

    @Test
    public void testJson2()
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username","HuangHX");
        jsonObject.put("password","123456");

        JSONObject jsotext = new JSONObject();
        jsotext.put("content","你的快递已到，请携带工卡前往邮件中心领取。\\n出发前可查看<a href=\"http://work.weixin.qq.com\">邮件中心视频实况</a>，聪明避开排队。");

        jsonObject.put("text",jsotext);
        System.out.println(jsonObject);
    }

    @Test
    public void testJson3()
    {
        List<NameValuePair> nvl = new ArrayList<>();
        nvl.add(new BasicNameValuePair("username","HuangHX"));
        nvl.add(new BasicNameValuePair("url","http://weixin.qq.com/q/02o2IuNwOe8xT10000w03b"));
    }
}
