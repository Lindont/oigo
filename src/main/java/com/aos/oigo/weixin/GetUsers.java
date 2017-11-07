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
        String AccessToken = "xp6LRRGt7ldHn5TnI3mM-nmkW7D_vhkOIhWwSrQth_B3ZXIRY_RE_vsrYziAcvQAN4b3PnsOzksqJeCkMyBvZRxSywLBkHT4c5ZUdWV_tWxEOnIAAOf-PdYRb6WvWwj_Sey2CwD2iezAtfVBvyYX2GHVeKQnzTeH4XodURvUeFBdHCutdWlO61TmBJ-ippQ9w5EcmOFiesjaqu4JaL7XPQ";
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
