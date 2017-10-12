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
        String AccessToken = "20oZPpwnwwWtasORXIc8A_s6MRDzWZNRiM2o-zdWhttA4lfd0K7WhXDgS7LEfWJsfMMad6eXN-qoOm9YNyQZMrm8WgFZt-2ah_Ppmb5vdPZmVrxE-QqP1AQF6HWdahaZVck3XtnLk-TMP1sy6PGuBG8uaaec5d2RAWZIYj9NO2dNb5F3MhffXzkr3X3F4PH5SVy0oyBtQDFHZGiGQXSJag";
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
