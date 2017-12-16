package com.aos.oigo.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2017-12-14
 */
public class Test3 {
    @Test
    public void test() {
        Long time = 432000000L;
        System.out.println(time);
    }

    @Test
    public void test2() {
        Map map = new HashMap();
        map.put("a", "huang");
        map.put("b", "hao");
        map.put("c", "xin");

        map.forEach((a, b) -> {
            System.out.println("a: " + a + " b: " + b);
        });
    }
}
