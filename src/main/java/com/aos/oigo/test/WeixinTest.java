package com.aos.oigo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aos.oigo.utils.HttpUtils;
import com.aos.oigo.utils.WeiXinUtil;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeixinTest {
    @Test
    public void getShotUrl() {
        String token = "3kASemVeIvmz_D7CzIfHFqmo1feUJN5JA2FavJ57Fau4igsUoRG9D-VecctufYhTRcJop75hVug32Dp1jnFmGd2QHN6vtzypQe1Ai0vSAEhnq9SN8EZ7KPrUG2IJZAX0OASiCFAJVN";
        String data = "{\"action\":\"long2short\",\"long_url\":\"http://weixin.qq.com/q/02o2IuNwOe8xT10000w03b\"}";
        String resStr = "";
        try {
            resStr = WeiXinUtil.httpsConn("https://api.weixin.qq.com/cgi-bin/shorturl?access_token=" + token, "POST", data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(resStr);
    }


    @Test
    public void getShotUrlEntity() {
        String token = "49DcpXTeTWKPiPyzdZMcj7zHDZITJZRtPr8fMcAIq39z6deTkXbAzl5NJ3iqkitxrw897FSbnLHP-XxjUM8bm0H-s9BPQ_c9A6nnqKTB_Myu93LV9-3D2XKft1Oj0tUUVOIiCEAPIC";

        String url = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=" + token;

        Map<String, String> mapHeaders = new HashMap<String, String>();
        mapHeaders.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("action", "long2short");
        jsonObject.put("long_url", "http://weixin.qq.com/q/02o2IuNwOe8xT10000w03b");


        /*List<NameValuePair> vps=new ArrayList<>();
        //vps.add(new BasicNameValuePair("access_token",token));
        vps.add(new BasicNameValuePair("action","long2short"));
        //vps.add(new BasicNameValuePair("long_url", URLEncoder.encode("http://weixin.qq.com/q/02o2IuNwOe8xT10000w03b")));
        vps.add(new BasicNameValuePair("long_url", "http://weixin.qq.com/q/02o2IuNwOe8xT10000w03b"));*/

        /*
        HttpUtils.getResultEntityByFormDataAsyn(url, null, vps, HttpUtils.GET, new HttpUtils.HttpCallBack()
        {
            @Override
            public void resultCallBack(Object result)
            {
                System.out.println(result);
            }

            @Override
            public void onException(Exception e)
            {

            }
        });
        */

        //String str = HttpUtils.getResultEntityByFormData(url,mapHeaders,vps,HttpUtils.GET);
        String str = HttpUtils.getResultEntity(url, mapHeaders, jsonObject, HttpUtils.POST);
        JSONObject jo = JSON.parseObject(str);
        String short_url = jo.getString("short_url");
        System.out.println(short_url);
    }


    @Test
    public void getSortUrlAnsy() {
        String token = "a_8a7cHao486dUrNTDamervxNAvGHKNuX7evRpyz2HjW8BubNZProPF0dGTM0_TN-dzQw7b6CNqsLT2oMnnG3VO2FYP_6LJ9xzPqhkuQ4vJh2PmlrCpbFHfhUXxHGKZTOUXlCDAJPS";

        String url = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=" + token;

        Map<String, String> mapHeaders = new HashMap<String, String>();
        mapHeaders.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        List<NameValuePair> vps = new ArrayList<>();
        //vps.add(new BasicNameValuePair("access_token",token));
        vps.add(new BasicNameValuePair("action", "long2short"));
        vps.add(new BasicNameValuePair("long_url", "http://weixin.qq.com/q/02o2IuNwOe8xT10000w03b"));
        //vps.add(new BasicNameValuePair("long_url", URLEncoder.encode("http://weixin.qq.com/q/02o2IuNwOe8xT10000w03b")));

        HttpUtils.getResultEntityByFormDataAsyn(url, mapHeaders, vps, HttpUtils.POST, new HttpUtils.HttpCallBack() {
            @Override
            public void resultCallBack(Object result) {
                JSONObject jo = JSON.parseObject((String) result);
                String short_url = jo.getString("short_url");
                System.out.println(short_url);
            }

            @Override
            public void onException(Exception e) {
                System.out.println(e);
            }
        });
    }


    @Test
    public void getSortUrlForm() {
        String token = "a_8a7cHao486dUrNTDamervxNAvGHKNuX7evRpyz2HjW8BubNZProPF0dGTM0_TN-dzQw7b6CNqsLT2oMnnG3VO2FYP_6LJ9xzPqhkuQ4vJh2PmlrCpbFHfhUXxHGKZTOUXlCDAJPS";

        String url = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=" + token;

        Map<String, String> mapHeaders = new HashMap<String, String>();
        mapHeaders.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        List<NameValuePair> vps = new ArrayList<>();
        //vps.add(new BasicNameValuePair("access_token",token));
        vps.add(new BasicNameValuePair("action", "long2short"));
        vps.add(new BasicNameValuePair("long_url", "http://weixin.qq.com/q/02o2IuNwOe8xT10000w03b"));

        String str = HttpUtils.getResultEntityByFormData(url, mapHeaders, vps, HttpUtils.POST);
        System.out.println(str);
        JSONObject jo = JSON.parseObject(str);
        String short_url = jo.getString("short_url");
        System.out.println(short_url);
    }
}
