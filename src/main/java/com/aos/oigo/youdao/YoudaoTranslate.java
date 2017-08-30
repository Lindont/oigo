package com.aos.oigo.youdao;

import com.alibaba.fastjson.JSONObject;
import com.aos.oigo.utils.MD5Util;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 * @Author : HuangHaoXin
 * @Description : 有道翻译Demo
 * @Date : Create in 2017-08-28
 */
public class YoudaoTranslate
{
    public Map<String, String> getParams(String text)
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
        System.out.println(sign);

        Map<String, String> params = new HashMap<String, String>();
        params.put("q", query);
        params.put("from", from);
        params.put("to", to);
        params.put("sign", sign);
        params.put("salt", salt);
        params.put("appKey", appKey);

        return params;
    }

    public static String requestForHttp(String url, Map<String, String> requestParams) throws Exception
    {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        /**HttpPost*/
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        Iterator<Map.Entry<String, String>> it = requestParams.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry<String, String> en = it.next();
            String key = en.getKey();
            String value = en.getValue();
            if (value != null)
            {
                params.add(new BasicNameValuePair(key, value));
            }
        }
        httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        /**HttpResponse*/
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        try
        {
            HttpEntity httpEntity = httpResponse.getEntity();
            result = EntityUtils.toString(httpEntity, "utf-8");
            EntityUtils.consume(httpEntity);
        } finally
        {
            try
            {
                if (httpResponse != null)
                {
                    httpResponse.close();
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return result;
    }


    /**
     * 根据api地址和参数生成请求URL
     *
     * @param url
     * @param params
     * @return
     */
    public static String getUrlWithQueryString(String url, Map<String, String> params)
    {
        if (params == null)
        {
            return url;
        }

        StringBuilder builder = new StringBuilder(url);
        if (url.contains("?"))
        {
            builder.append("&");
        } else
        {
            builder.append("?");
        }

        int i = 0;
        for (String key : params.keySet())
        {
            String value = params.get(key);
            if (value == null)
            { // 过滤空的key
                continue;
            }

            if (i != 0)
            {
                builder.append('&');
            }

            builder.append(key);
            builder.append('=');
            builder.append(encode(value));

            i++;
        }

        return builder.toString();
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


    public void getJsonText()
    {
        Map<String, String> params = getParams("今天天气怎么样");
        JSONObject jsonObject = new JSONObject();

    }



    @Test
    public void youDaoTranslate()
    {
        String url = "https://openapi.youdao.com/api";
        Map<String, String> params = getParams("released");
        try
        {
            String result = requestForHttp(url, params);
            System.out.println(result);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
