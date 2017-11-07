package com.aos.oigo.weixin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aos.oigo.common.WeixinMessageType;
import com.aos.oigo.config.WeixinConfig;
import com.aos.oigo.utils.HttpUtils;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2017-10-11
 */
public class WeixinSendMessage
{
    @Test
    public void sendMessage()
    {
        String access_token = "cI28pQZ338gbbtf0tTaD0npp84hS1rQSYLf7gSwjyj9Z0Gtx25C9ogXebHWAYEN3gM4g8VVyfQpNzR4QkaRrUmk8bexqMwJ-x8TxcxPFRjh8o9QpDYQ-4ic51XD37hnNr9opgyfCSxD4ZInkIglTqM4YVt1x58YaaaQbA7OY_aoN-tN5jXtf1gnX81wVZaPrAFBocJpKPH6GO6dk56ivLQ";

        String url = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token="+access_token;

        String message = "{\"content\":\"测试\n欢迎使用oigo\"}";

        Map<String ,String> mapHeaders = new HashMap<String,String>();
        mapHeaders.put("Content-Type","application/x-www-form-urlencoded;charset=utf-8");

        JSONObject text = JSON.parseObject(getMessage());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("totag","900001");
        jsonObject.put("msgtype",WeixinMessageType.TEXT);
        jsonObject.put("agentid",WeixinConfig.OIGO_AGENTID);
        jsonObject.put("text",text);
        jsonObject.put("safe",0);

        String str = HttpUtils.getResultEntity(url,mapHeaders,jsonObject,HttpUtils.POST);

        JSONObject jo = JSON.parseObject(str);
        String errcode = jo.getString("errcode");
        System.out.println(errcode);
        String errmsg = jo.getString("errmsg");
        System.out.println(errmsg);
        String invaliduser = jo.getString("invaliduser");
        System.out.println(invaliduser);
        String invalidparty = jo.getString("invalidparty");
        System.out.println(invalidparty);
        String invalidtag = jo.getString("invalidtag");
        System.out.println(invalidtag);

    }

    public String getMessage()
    {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("MM月dd日 HH点业绩更新:");
        String time = format.format(date);
        String message = "{\"content\":\""+time+"\n订购数量：××××件\n订购金额：××××××元\n\n各通路业绩:\nTV: ×××件××××××元；\nINT：×××件××××××元；\nOB: ×××件××××××元；\n搭售：×××件××××××元；\n\n当天累计销售TOP5商品:\n1.[红酒]:199件 12345元\n2.[红酒]:199件 12345元\n3.[红酒]:199件 12345元\n4.[红酒]:199件 12345元\n5.[红酒]:199件 12345元"+"\"}";
        return message;
    }
}
