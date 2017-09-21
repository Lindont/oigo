package com.aos.oigo.youdao;

import com.aos.oigo.utils.HttpUtils;
import com.aos.oigo.utils.MD5Util;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2017-09-21
 */
public class YouDao
{

    @Test
    public void getYoudao()
    {
        String text = "Hello";

        String result = Youdao(text);

        System.out.println(result);
    }


    public String Youdao(String text)
    {
        String appKey = encode("72d5d35326dae5e9");
        String query = null;
        try
        {
            query = new String(text.getBytes(),"UTF-8");
            System.out.println(query);
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        String salt = encode(String.valueOf(System.currentTimeMillis()));
        String from = encode("auto");
        String to = encode("zh-CHS");
        String token = encode("x4ZDF6begy8yl8kKOkKWnE2JQD0bkgmF");

        String sign = MD5Util.getMd5(appKey + query + salt + token);

        List<NameValuePair> nvp = new ArrayList<>();
        nvp.add(new BasicNameValuePair("q",query));
        nvp.add(new BasicNameValuePair("from",from));
        nvp.add(new BasicNameValuePair("to",to));
        nvp.add(new BasicNameValuePair("sign",sign));
        nvp.add(new BasicNameValuePair("salt",salt));
        nvp.add(new BasicNameValuePair("appKey",appKey));

        String url = "https://openapi.youdao.com/api";

        Map<String ,String> mapHeaders = new HashMap<String,String>();
        mapHeaders.put("Content-Type","application/x-www-form-urlencoded;charset=utf-8");

        String str = HttpUtils.getResultEntityByFormData(url,null,nvp,HttpUtils.POST);

        return str;
    }


    /**
     * 进行URL编码
     *
     * @param input
     * @return
     */
    public static String encode(String input)
    {
        if (input == null)
        {
            return "";
        }

        try
        {
            return URLEncoder.encode(input, "utf-8");
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        return input;
    }
}
