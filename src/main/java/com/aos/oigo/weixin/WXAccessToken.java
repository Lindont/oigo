package com.aos.oigo.weixin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aos.oigo.config.WeixinConfig;
import com.aos.oigo.utils.HttpUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2017-10-11
 */
public class WXAccessToken
{
    @Test
    public void getToken()
    {
        String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid="+WeixinConfig.CORPID+"&corpsecret="+WeixinConfig.SECRET;

        Map<String ,String> mapHeaders = new HashMap<String,String>();
        mapHeaders.put("Content-Type","application/x-www-form-urlencoded;charset=utf-8");

        String str = HttpUtils.getResultEntity(url,mapHeaders,null,HttpUtils.GET);

        JSONObject jo = JSON.parseObject(str);
        String errcode = jo.getString("errcode");
        System.out.println(errcode);
        String errmsg = jo.getString("errmsg");
        System.out.println(errmsg);
        String access_token = jo.getString("access_token");
        System.out.println(access_token);
        String expires_in = jo.getString("expires_in");
        System.out.println(expires_in);
    }
}
