package com.aos.oigo.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2017-08-28
 */
public class TestList
{
    @Test
    public void testList()
    {
        List<String> list = new ArrayList<>();
        list.add("Huang");
        list.add("Hao");
        list.add("Xin");

        System.out.println("方法一");
        for (String str : list)
        {
            System.out.println(str);
        }


        System.out.println("方法二");
        for (int i =0 ; i<list.size() ; i++)
        {
            System.out.println(list.get(i));
        }


        System.out.println("方法三");
        Iterator<String> iter = list.iterator();
        while (iter.hasNext())
        {
            System.out.println(iter.next());
        }
    }
}
