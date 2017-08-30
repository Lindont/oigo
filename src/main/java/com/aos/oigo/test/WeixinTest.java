package com.aos.oigo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aos.oigo.utils.HttpUtils;
import com.aos.oigo.utils.WeiXinUtil;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WeixinTest
{
    @Test
    public void getShotUrl()
    {
        String token = "3kASemVeIvmz_D7CzIfHFqmo1feUJN5JA2FavJ57Fau4igsUoRG9D-VecctufYhTRcJop75hVug32Dp1jnFmGd2QHN6vtzypQe1Ai0vSAEhnq9SN8EZ7KPrUG2IJZAX0OASiCFAJVN";
        String data = "{\"action\":\"long2short\",\"long_url\":\"http://weixin.qq.com/q/02o2IuNwOe8xT10000w03b\"}";
        String resStr = "";
        try
        {
            resStr = WeiXinUtil.httpsConn("https://api.weixin.qq.com/cgi-bin/shorturl?access_token=" + token, "POST", data);
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(resStr);
    }



    @Test
    public void getShotUrlAsny()
    {
        String token = "ic0QiON_yAStqi8SlNKqr9V1M7qSHB39d7CBN1OcEqsraquJ6LDkjlEp6UYqxBUdCMFqpK0IoMp_KXrNNKYDiXtW6SzA0jtGQTZz-bzSyUYzvuC2fe0ZeOqFbJYSgS7RLDKlCDAWOV";

        String url = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=" + token;

        Map<String ,String> mapHeaders = new HashMap<String,String>();
        mapHeaders.put("Content-Type","application/x-www-form-urlencoded;charset=utf-8");

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("action","long2short");
        jsonObject.put("long_url","http://weixin.qq.com/q/02o2IuNwOe8xT10000w03b");


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
        String str = HttpUtils.getResultEntity(url,mapHeaders,jsonObject,HttpUtils.POST);
        JSONObject jo = JSON.parseObject(str);
        String short_url = jo.getString("short_url");
        System.out.println(short_url);


    }
}
