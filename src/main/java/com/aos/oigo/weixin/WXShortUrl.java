package com.aos.oigo.weixin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aos.oigo.utils.HttpUtils;
import com.aos.oigo.utils.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : HuangHaoXin
 * @Description : 把微信长链接转换成短链接
 * @Date : Create in 2017-08-24
 */

public class WXShortUrl {
    public String getShortUrl(String token, String url) {
        if (StringUtil.isNullorBlank(token) && StringUtil.isNullorBlank(url)) {
            return "Token or URL is Null !";
        }

        String posturl = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=" + token;
        Map<String, String> mapHeaders = new HashMap<String, String>();
        mapHeaders.put("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("action", "long2short");
        jsonObject.put("long_url", "http://weixin.qq.com/q/02o2IuNwOe8xT10000w03b");

        String result = HttpUtils.getResultEntity(url, mapHeaders, jsonObject, HttpUtils.POST);

        JSONObject jo = JSON.parseObject(result);
        String short_url = jo.getString("short_url");
        return short_url;
    }
}
