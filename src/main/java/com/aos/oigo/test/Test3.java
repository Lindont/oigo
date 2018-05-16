package com.aos.oigo.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2018-04-30
 */
public class Test3 {
    @Test
    public void test() {
        Set s = new HashSet();
        s.add(3);
        s.add(1);
        s.add(2);

        List l = new ArrayList();
        l.addAll(s);

        System.out.println(l);
    }
}
