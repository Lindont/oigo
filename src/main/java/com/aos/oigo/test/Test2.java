package com.aos.oigo.test;

import com.aos.oigo.utils.MD5Util;
import com.aos.oigo.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2017-11-10
 */
@Slf4j
public class Test2 {
    @Test
    public void test1() {
        int count = 3;
        System.out.println(MessageFormat.format("count:{0}", count));
        log.info("count: {}, message: {}", count, count + 2);
    }


    @Test
    public void test2() {
        String pass1 = MD5Utils.getMD5Code("黄浩新很帅黄浩新很帅黄浩新很帅黄浩新很帅黄浩新很帅黄浩新很帅");
        String pass2 = MD5Utils.getMD5Code("黄浩新很帅黄浩新很帅黄浩新很帅黄浩新很帅黄浩新很帅黄浩新很帅", "UTF-8");
        String pass3 = MD5Util.getMd5("黄浩新很帅黄浩新很帅黄浩新很帅黄浩新很帅黄浩新很帅黄浩新很帅");
        System.out.println(pass1);
        System.out.println(pass2);
        System.out.println(pass3);
    }

    @Test
    public void test3() {
        List list = new ArrayList();

        if (CollectionUtils.isEmpty(list)) {
            System.out.println("null");
        }
    }
}
