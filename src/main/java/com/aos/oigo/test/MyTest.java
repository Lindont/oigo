package com.aos.oigo.test;

import org.junit.Test;

import java.util.*;

/**
 * @Author : HuangHaoXin
 * @Description :
 * @Date : Create in 2017-08-28
 */
public class MyTest
{
    @Test
    public void testMap1()
    {
        Map<String ,String> maps = new HashMap<String,String>();
        maps.put("key1","Huang");
        maps.put("key2","Hao");
        maps.put("key3","Xin");

        System.out.println("方法一");
        for (Object o : maps.keySet())
        {
            String val = maps.get(o);
            System.out.println("key: "+o+" value: "+val);
        }


        System.out.println("方法二");
        for (Map.Entry<String ,String> entry : maps.entrySet())
        {
            String keys = entry.getKey();
            String values = entry.getValue();
            System.out.println("key: "+keys+" value: "+values);
        }


        System.out.println("方法三");
        Iterator iter = maps.entrySet().iterator();
        while (iter.hasNext())
        {
            Map.Entry entry = (Map.Entry) iter.next();
            Object keys = entry.getKey();
            Object values = entry.getValue();
            System.out.println("key: "+keys+" value: "+values);
        }


        System.out.println("方法四");

    }

    @Test
    public void testlistMap()
    {
        Map<String,List> maps = new HashMap<String,List>();
        List<String> list1 = new ArrayList<>();
        list1.add("H");
        list1.add("U");
        list1.add("A");
        list1.add("N");
        list1.add("G");

        List<String> list2 = new ArrayList<>();
        list2.add("H");
        list2.add("A");
        list2.add("O");

        List<String> list3 = new ArrayList<>();
        list3.add("X");
        list3.add("I");
        list3.add("N");

        maps.put("key1",list1);
        maps.put("key2",list2);
        maps.put("key3",list3);

        for (Object o : maps.keySet())
        {
            System.out.println(o);
            List<String> olist = maps.get(o);
            Iterator<String> iter = olist.iterator();
            while (iter.hasNext())
            {
                System.out.println(iter.next());
            }
        }
        System.out.println(maps.containsKey("key1"));
        System.out.println(maps.containsValue("list2"));
    }
}
