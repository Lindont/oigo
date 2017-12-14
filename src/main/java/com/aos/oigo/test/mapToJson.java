package com.aos.oigo.test;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2017-12-13
 */
public class mapToJson {

    @Test
    public void testJson() {
        Map map = new HashMap();
        map.put("msg", "yes");//map里面装有yes
        String jsonObject = JSONObject.toJSONString(map);
        System.out.println("输出的结果是：" + jsonObject);
        //3、将json对象转化为json字符串
        /*String result = jsonObject.toString();
        System.out.println(result);*/
    }
}
