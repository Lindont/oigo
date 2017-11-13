package com.aos.oigo.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2017-11-10
 */
public class Test2 {
    @Test
    public void test1() {
        int count = 3;
        for (int i = 1; i<=count; i++) {
            if (i == 2) {
                break;
            }
            System.out.println(i);
        }
        System.out.println("asd");
    }


    @Test
    public void test2() {
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");


//        int size = 0;
//        for (int i = 0;i<list.size();i++) {
//            size++;
//        }
//        System.out.println(size);
        for (int i=0;i<list.size();i++) {
            if (i+1<list.size()) {
                if ( i == 2) {

                }
                System.out.println(list.get(i)+" + "+list.get(i+1));
            }
        }
    }
}
