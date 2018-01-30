package com.aos.oigo.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aos.oigo.pojo.YouCardLogBean;
import org.junit.Test;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-01-30
 */
public class YouCardTest {
    @Test
    public void youCardTest() {
        Object jsondata = "{\"status\":\"failed\",\"desc\":\"账户余额不足\",\"code\":\"42\",\"serialno\":null,\"bizOrderId\":null,\"itemId\":null,\"itemName\":null,\"itemFacePrice\":null,\"price\":null,\"amount\":null,\"carrierType\":null,\"areaCode\":null,\"success\":false}";
        JSONObject jo = JSON.parseObject((String) jsondata);
        YouCardLogBean bean = JSONObject.toJavaObject(jo, YouCardLogBean.class);
        System.out.println(bean.getStatus());
        System.out.println(bean.getDesc());
        System.out.println(bean.getCode());
        System.out.println(bean.getSerialno());
        System.out.println(bean.getBizOrderId());
    }
}
